package zork

import ui.ConsoleUI
import zork.application.GameState
import zork.application.ZorkActions
import zork.application.ZorkLoop
import zork.utils.Parser
import zork.generators.MapGenerator
import zork.generators.PlayerGenerator
import java.util.*


/**
 * Main method instantiates the game object and starts its loop.
 *
 * @param args the command line arguments
 */
fun main(args: Array<String>) {
  val scanner = Scanner(System.`in`)
  val ui = ConsoleUI()
  val parser = Parser(scanner)
  val pGen = PlayerGenerator(scanner, ui)
  val player = pGen.createPlayer()
  val mGen = MapGenerator(ui)
  val rooms = mGen.createRooms()
  val game = GameState(player, rooms, rooms[3])
  val actions = ZorkActions(parser, ui, game)
  val loop = ZorkLoop(actions)
  loop.run()
}
