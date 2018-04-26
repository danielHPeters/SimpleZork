package zork.models.items.actions

import zork.interfaces.IItemAction
import zork.interfaces.IUserInterface

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
