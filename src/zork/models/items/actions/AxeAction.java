package zork.models.items.actions;

import zork.interfaces.IUseAble;
import zork.models.entities.Player;

/**
 * Action for axes.
 *
 * @author d.peters
 * @version 1.0
 */
public class AxeAction implements IUseAble {
  /**
   * Use method without any param if the object should not do something with any object.
   */
  @Override
  public void use() {
    System.out.println("You swing the Axe around you. You almost killed yourself in the process.");
  }

  /**
   * Use item on the player.
   *
   * @param player the player object.
   */
  @Override
  public void use(Player player) {
    use();
  }
}
