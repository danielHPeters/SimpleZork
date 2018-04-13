package zork.interfaces

/**
 * Interface for damageable objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
interface IDamageable {
  /**
   * Function that specifies how the character takes damage.
   *
   * @param damage damage dealt to the character
   */
  fun takeDamage(damage: Double)
}
