package zork.models.items.actions

import zork.interfaces.IItemAction

/**
 * Action for shovel items.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class ShovelAction: IItemAction {
  /**
   * Use method without any params.
   */
  override fun execute() {
    System.out.println("You try to dig a hole in the ground.")
  }
}
