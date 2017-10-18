package zork.models.items.actions;

import zork.interfaces.IUseAble;
import zork.models.entities.Player;

/**
 * Some fun class intended for special joke item. Don't take it too serious ;-).
 *
 * @author d.peters
 * @version 1.0.1
 */
public class WoodAction implements IUseAble {
  @Override
  public void use() {
  }

  /**
   * Only if the player has a certain name, will he be able to wield the
   * mighty wood.
   *
   * @param player the player object that is trying to use the item
   */
  @Override
  public void use(Player player) {

    switch (player.getName()) {

      case "Chuck Norris":
        System.out.println("\nWell played, well played...");
        break;
      case "John Cena":
        System.out.println("\nWhatever. You win, stupid!");
        break;
      case "Wood":
        System.out.println("\nNice try, stupid!");
        player.die();
        break;
      default:
        System.out.println("\nYou cannot use wood! Wood uses you, stupid!");
        player.die();
        break;
    }
  }
}
