package zork.interfaces;

/**
 * Interface for damageable objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface IDamageable {
  /**
   * Function that specifies how the character takes damage.
   *
   * @param damage damage dealt to the character
   */
  void takeDamage(double damage);
}
