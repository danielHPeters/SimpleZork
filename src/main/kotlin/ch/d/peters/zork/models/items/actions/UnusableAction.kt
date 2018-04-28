package ch.d.peters.zork.models.items.actions

import ch.d.peters.zork.interfaces.IItemAction
import ch.d.peters.zork.interfaces.IUserInterface

/**
 * Default action for items.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class UnusableAction(private val ui: IUserInterface) : IItemAction {
  override fun execute() {
    ui.displayMessage("You cannot use this item.")
  }
}
