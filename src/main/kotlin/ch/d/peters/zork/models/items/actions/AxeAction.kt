package ch.d.peters.zork.models.items.actions

import ch.d.peters.zork.interfaces.IItemAction

/**
 * Action for axes.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
 class AxeAction: IItemAction {
  /**
   * Use method without any param if the object should not do something with any object.
   */
  override fun execute () {
    System.out.println("You swing the Axe around you. You almost killed yourself in the process.")
  }
}
