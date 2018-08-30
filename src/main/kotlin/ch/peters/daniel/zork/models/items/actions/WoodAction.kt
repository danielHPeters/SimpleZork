package ch.peters.daniel.zork.models.items.actions

import ch.peters.daniel.zork.ui.UserInterface

/**
 * Some fun class intended for special joke item. Don't take it too serious -).
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class WoodAction(private val ui: UserInterface) : ItemAction {
  /**
   * Only if the player has a certain name, will he be able to wield the
   * mighty wood.
   */
  override fun execute() {
  }
}
