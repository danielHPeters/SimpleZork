package zork.application

import java.util.Queue
import zork.enums.EVerbs

/**
 * This class contains the main loop an its relevant objects.
 *
 * @author Daniel Peters
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
  private fun selectAction( commands: Queue<EVerbs>) {
    val command = commands.poll()

    when (command) {
      EVerbs.HELP -> actions.showHelp()
      EVerbs.QUIT -> {
        actions.goodbyeMessage()
        running = false
      }
      EVerbs.GO -> actions.specifyDirection(commands)
      EVerbs.DESCRIBE -> actions.roomDescription()
      EVerbs.TAKE -> actions.specifyObject(commands)
      EVerbs.INVENTORY -> actions.showPlayerInventory()
      EVerbs.USE -> actions.specifyItem(commands)
      EVerbs.STATS -> actions.showPlayerStats()
      EVerbs.MASOCHIST -> actions.masochistAction()
      EVerbs.ATTACK -> actions.attackAction(commands)
      EVerbs.TALK -> actions.talkToNpc(commands)
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
