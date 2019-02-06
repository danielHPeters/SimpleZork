package ch.peters.daniel.zork.models.items.actions

/**
 * Action for shovel items.
 *
 * @author Daniel Peters
 * @version 1.1
 */
class ShovelAction : ItemAction {
  /**
   * Use method without any params.
   */
  override fun execute() {
    System.out.println("You try to dig a hole in the ground.")
  }
}
