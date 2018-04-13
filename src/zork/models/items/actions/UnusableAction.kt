package zork.models.items.actions

import zork.interfaces.IItemAction
import zork.interfaces.IUserInterface

class UnusableAction(private val ui: IUserInterface) : IItemAction {
  override fun execute() {
    ui.displayMessage("You cannot use this item.")
  }
}
