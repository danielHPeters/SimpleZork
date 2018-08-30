package ch.peters.daniel.zork.application

import java.util.Queue
import ch.peters.daniel.zork.enums.ItemType
import ch.peters.daniel.zork.enums.NpcType
import ch.peters.daniel.zork.models.entities.base.StatType
import ch.peters.daniel.zork.enums.Verb
import ch.peters.daniel.zork.ui.UserInterface
import ch.peters.daniel.zork.models.Room
import ch.peters.daniel.zork.models.entities.Npc
import ch.peters.daniel.zork.utils.Parser

/**
 * Here the game actions are defined. Only this class should know the state of
 * the game objects
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class ZorkActions(private val parser: Parser, private val ui: UserInterface, private val game: GameState) {
  /**
   * Ask the user to specify if "go" was entered without any direction and/or
   * go towards the specified direction.
   *
   * @param commands the user command
   */
  fun specifyDirection(commands: Queue<Verb>) {
    var commandsList = commands
    if (commandsList.isEmpty()) {
      ui.displayMessage("Where do you want to go?")
      commandsList = parser.getCommand()
    }
    val command = commandsList.poll()
    val nextRoom = game.currentRoom.goToNextRoom(command)

    // Check for invalid directions
    if (nextRoom != Room.wall) {
      game.currentRoom = nextRoom
    } else {
      ui.displayMessage("You walked into a wall...")
    }
  }

  /**
   * Add item from room to inventory, if it exists. If no item was specified,
   * then ask user to specify.
   * TODO: Allow picking up single items instead of just all
   *
   * @param commands user commands
   */
  fun specifyObject(commands: Queue<Verb>) {
    var commandsList = commands

    if (commandsList.isEmpty()) {
      ui.displayMessage("Take what?")
      commandsList = parser.getCommand()
    }
    val command = commandsList.poll()

    if (command == Verb.ALL) {
      game.currentRoom.items.forEach({ item ->
        ui.displayMessage(item.name + " added to your inventory.")
        game.player.inventory.add(item)
      })
      game.currentRoom.items.clear()
    }
  }

  /**
   * Use item specified or ask user to name item to be used.
   *
   * @param commands parsed user commands
   */
  fun specifyItem(commands: Queue<Verb>) {
    var commandsList = commands
    if (commands.isEmpty()) {
      ui.displayMessage("Use what?")
      commandsList = parser.getCommand()
    }
    val command = commandsList.poll()

    if (command == Verb.ALL) {
      game.player.inventory.forEach { item -> item.use() }
    } else {
      ItemType.values().forEach { item ->
        if (ItemType.valueOf(command.toString()) == item) {
          game.player.inventory.forEach { itm ->
            if (itm.name.toUpperCase() == item.toString()) {
              itm.use()
            }
          }
        }
      }
    }
  }

  /**
   * Talk to an npc. Ask for dialog partner if none given.
   *
   * @param commands user submitted commands
   */
  fun talkToNpc(commands: Queue<Verb>) {
    var commandsList = commands
    if (commandsList.isEmpty()) {
      ui.displayMessage("To whom?")
      commandsList = parser.getCommand()
    }

    val command = commandsList.poll()
    if (!game.currentRoom.characters.isEmpty()) {
      val npcId = NpcType.values().filter { value -> value == NpcType.valueOf(command.toString()) }[0]
      val npc = game.currentRoom.characters.filter { entity -> (entity as Npc).npcTypeId == npcId }[0] as Npc
      ui.displayMessage(game.player.greet())
      ui.displayMessage(npc.greet())
    }
  }


  /**
   * Let the player hit himself if requested.
   */
  fun masochistAction() {
    val selfDamage = game.player.stats[StatType.ATTACK]!!.value
    ui.displayMessage("You hit yourself with a bludgeon.")
    game.player.takeDamage(selfDamage)
  }

  /**
   * Attack a character.
   *
   * @param commands user submitted commands
   */
  fun attackAction(commands: Queue<Verb>) {
    var commandsList = commands

    if (commandsList.isEmpty()) {
      ui.displayMessage("Attack what?")
      commandsList = parser.getCommand()

    }

    val command = commandsList.poll()

    if (!game.currentRoom.characters.isEmpty()) {
      NpcType.values().forEach { item ->
        if (NpcType.valueOf(command.toString()) == item) {
          val npcId = NpcType.valueOf(command.toString())
          game.currentRoom.characters.forEach({ character ->
            if (character is Npc) {
              if (character.npcTypeId == npcId) {
                character.takeDamage(game.player.stats[StatType.ATTACK]!!.value)
              }
            }
          })
        }
      }
    }
  }

  /**
   * Tell the player if there are any NPC around.
   */
  fun foundNpc() {
    if (!game.currentRoom.characters.isEmpty()) {
      game.currentRoom.characters.forEach({ character ->
        if (character.alive) {
          ui.displayMessage(character.name + " is in the room...")
        } else {
          ui.displayMessage("You sense the corpse of " + character.name)
        }
      })

    }
  }

  /**
   * Message printed when the player starts the game.
   */
  fun welcomeMessage() {
    ui.displayMessage("Hail brave " + game.player.name + ". Welcome to App.")
  }

  /**
   * Message printed when the player quits the game.
   */
  fun goodbyeMessage() {
    ui.displayMessage("See you again soon " + game.player.name + "!")
  }

  /**
   * List the commands available.
   */
  fun showHelp() {
    Verb.values().forEach { c -> ui.displayMessage(c.toString() + " - " + c.details) }
  }

  /**
   * Print the description of the room.
   */
  fun roomDescription() {
    ui.displayMessage(game.currentRoom.description)
  }

  /**
   * Tell the player his current location.
   */
  fun currentRoomMessage() {
    ui.displayMessage("You are in the " + game.currentRoom.name + ".")
  }

  /**
   * Send message if user gave an invalid command.
   */
  fun unknownCmdMsg() {
    ui.displayMessage("I don't understand that command.")
  }

  /**
   * Ask the player to do something.
   */
  fun askForAction() {
    ui.displayMessage("What do you want to do?")
  }

  /**
   * Get commands from parser.
   *
   * @return new command from parser
   */
  fun getCommand(): Queue<Verb> {
    return parser.getCommand()
  }

  /**
   * Print contents of the players inventory.
   */
  fun showPlayerInventory() {
    if (game.player.inventory.isEmpty()) {
      ui.displayMessage("Your inventory is empty.")
    } else {
      game.player.inventory.forEach { item -> ui.displayMessage("Item: " + item.name + " - " + item.description + " - Price: " + item.price) }
    }
  }

  /**
   * Print player stats.
   */
  fun showPlayerStats() {
    game.player.displayStats()
  }

  /**
   * Check if player is alive.
   *
   * @return boolean flag for alive
   */
  fun playerIsAlive(): Boolean {
    return game.player.alive
  }
}
