package zork.models.items.actions;

import zork.interfaces.IUsable;
import zork.models.entities.Player;

/**
 * Action for shovel items.
 *
 * @author d.peters
 * @version 1.0.1
 */
public class ShovelAction implements IUsable {
  /**
   * Use method without any params.
   */
  @Override
  public void use() {
    System.out.println("You try to dig a hole in the ground.");
  }

  /**
   * Use method with param to do something with the player object.
   *
   * @param player the player object
   */
  @Override
  public void use(Player player) {
    use();
  }
}
