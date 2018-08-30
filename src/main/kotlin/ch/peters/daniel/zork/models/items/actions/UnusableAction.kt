package ch.peters.daniel.zork.models.items.actions

import ch.peters.daniel.zork.ui.UserInterface

/**
 * Default action for items.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class UnusableAction(private val ui: UserInterface) : ItemAction {
  override fun execute() {
    ui.displayMessage("You cannot use this item.")
  }
}
