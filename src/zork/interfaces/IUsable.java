package zork.interfaces;

import zork.models.entities.Player;

/**
 * Interface for usable objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface IUsable {
  /**
   * Default use method.
   */
  void use();

  /**
   * Use on player.
   *
   * @param player player object
   */
  void use(Player player);
}
