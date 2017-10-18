package zork.models.items.actions;

import zork.interfaces.IUseAble;
import zork.models.entities.Player;

/**
 * Action for the nuke item. Yep it does what it sounds like it does.
 *
 * @author d.peters
 */
public class NukeAction implements IUseAble {
  /**
   * Use without params. Not supported.
   */
  @Override
  public void use() {
    throw new UnsupportedOperationException();
  }

  /**
   * Only players with special names shall survive the ensuing fallout.
   *
   * @param player the player object
   */
  @Override
  public void use(Player player) {

    switch (player.getName()) {
      case "Chuck Norris":
        System.out.println("\nThat nuclear fallout was just your fart. Nothing to worry about.");
        break;
      case "John Cena":
        System.out.println("\nAnd his name is JOHN CENA, NUKER OF WORLDS!!!");
        break;
      case "Fallout Guy":
        System.out.println("\nAfter years of stasis, you finally wake up in Vault 81.");
        break;
      default:
        System.out.println("\nYou moron! You obliterated everything!");
        player.die();
        break;
    }
  }
}
