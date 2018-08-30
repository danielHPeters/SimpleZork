package ch.peters.daniel.zork.application

import java.util.Queue
import ch.peters.daniel.zork.enums.Verb

/**
 * This class contains the main loop an its relevant objects.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class ZorkLoop(private val actions: ZorkActions) {
  /**
   * Boolean flag to test if the game loop is to be ended.
   */
  private var running: Boolean = false

  /**
   * Selects an action depending on the first command in the queue
   *
   * @param commands queue of commands entered by the user
   */
  private fun selectAction(commands: Queue<Verb>) {
    val command = commands.poll()

    when (command) {
      Verb.HELP -> actions.showHelp()
      Verb.QUIT -> {
        actions.goodbyeMessage()
        running = false
      }
      Verb.GO -> actions.specifyDirection(commands)
      Verb.DESCRIBE -> actions.roomDescription()
      Verb.TAKE -> actions.specifyObject(commands)
      Verb.INVENTORY -> actions.showPlayerInventory()
      Verb.USE -> actions.specifyItem(commands)
      Verb.STATS -> actions.showPlayerStats()
      Verb.MASOCHIST -> actions.masochistAction()
      Verb.ATTACK -> actions.attackAction(commands)
      Verb.TALK -> actions.talkToNpc(commands)
      else -> {
        actions.unknownCmdMsg()
      }
    }
  }

  /**
   * Main process that executes the command actions.
   */
  fun run() {
    actions.welcomeMessage()
    running = true
    // Game last while the user is alive or until certain conditions are met
    while (running && actions.playerIsAlive()) {
      actions.currentRoomMessage()
      actions.foundNpc()
      actions.askForAction()

      val commands = actions.getCommand()

      // Process all parsed commands before asking user for new commands
      while (!commands.isEmpty()) {
        selectAction(commands)
      }
    }
  }
}
