package ch.d.peters.zork

import ch.d.peters.zork.ui.ConsoleUI
import ch.d.peters.zork.application.GameState
import ch.d.peters.zork.application.ZorkActions
import ch.d.peters.zork.application.ZorkLoop
import ch.d.peters.zork.utils.Parser
import ch.d.peters.zork.generators.MapGenerator
import ch.d.peters.zork.generators.PlayerGenerator
import java.util.*


class Zork {
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
    val scanner = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
      val zork = Zork()
      zork.start()
    }
  }
}
