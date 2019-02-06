package ch.peters.daniel.zork

import ch.peters.daniel.zork.ui.ConsoleUI
import ch.peters.daniel.zork.application.GameState
import ch.peters.daniel.zork.application.ZorkActions
import ch.peters.daniel.zork.application.ZorkLoop
import ch.peters.daniel.zork.utils.Parser
import ch.peters.daniel.zork.generators.MapGenerator
import ch.peters.daniel.zork.generators.PlayerGenerator
import java.util.*

/**
 * Main application class.
 *
 * @author Daniel Peters
 * @version 1.0
 */
class App {
  private val scanner = Scanner(System.`in`)
  private val ui = ConsoleUI()
  private val parser = Parser(scanner)
  private val pGen = PlayerGenerator(scanner, ui)
  private val player = pGen.createPlayer()
  private val mGen = MapGenerator(ui)
  private val rooms = mGen.createRooms()
  private val game = GameState(player, rooms, rooms[3])
  private val actions = ZorkActions(parser, ui, game)
  private val loop = ZorkLoop(actions)

  fun start() {
    loop.run()
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val application = App()
      application.start()
    }
  }
}
