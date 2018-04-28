package ch.d.peters.zork.models.items.actions

import ch.d.peters.zork.interfaces.IItemAction
import ch.d.peters.zork.interfaces.IUserInterface

/**
 * Some fun class intended for special joke item. Don't take it too serious -).
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class WoodAction(private val ui: IUserInterface) : IItemAction {
  /**
   * Only if the player has a certain name, will he be able to wield the
   * mighty wood.
   */
  override fun execute() {
   /* when (player.name) {
      "Chuck Norris" -> ui.displayMessage("Well played, well played...")
      "John Cena" -> ui.displayMessage("Whatever. You win, stupid!")
      "Wood" -> {
        ui.displayMessage("Nice try, stupid!")
        player.die()
      }
      else -> {
        System.out.println("\nYou cannot execute wood! Wood uses you, stupid!")
        player.die()
      }
    }*/
  }
}
