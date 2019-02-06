package ch.peters.daniel.zork.models.items.actions

import ch.peters.daniel.zork.ui.UserInterface

/**
 * Action for the nuke item. Yep it does what it sounds like it does.
 *
 * @author Daniel Peters
 * @version 1.1
 */
class NukeAction(private val ui: UserInterface) : ItemAction {
  /**
   * Only players with special names shall survive the ensuing fallout.
   */
  override fun execute() {
  }
}
