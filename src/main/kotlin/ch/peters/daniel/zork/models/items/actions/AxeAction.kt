package ch.peters.daniel.zork.models.items.actions

/**
 * Action for axes.
 *
 * @author Daniel Peters
 * @version 1.1
 */
class AxeAction : ItemAction {
  /**
   * Use method without any param if the object should not do something with any object.
   */
  override fun execute() {
    System.out.println("You swing the Axe around you. You almost killed yourself in the process.")
  }
}
