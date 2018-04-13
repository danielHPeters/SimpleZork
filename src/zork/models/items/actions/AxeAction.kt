package zork.models.items.actions;

import zork.interfaces.IItemAction

/**
 * Action for axes.
 *
 * @author d.peters
 * @version 1.0
 */
 class AxeAction: IItemAction {
  /**
   * Use method without any param if the object should not do something with any object.
   */
  override fun execute () {
    System.out.println("You swing the Axe around you. You almost killed yourself in the process.")
  }
}
