package ch.peters.daniel.zork.models.items.actions

import ch.peters.daniel.zork.ui.UserInterface

/**
 * Default action for items.
 *
 * @author Daniel Peters
 * @version 1.1
 */
class UnusableAction(private val ui: UserInterface) : ItemAction {
  override fun execute() {
    ui.displayMessage("You cannot use this item.")
  }
}
