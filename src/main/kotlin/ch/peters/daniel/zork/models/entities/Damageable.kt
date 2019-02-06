package ch.peters.daniel.zork.models.entities

/**
 * Interface for damageable objects.
 *
 * @author Daniel Peters
 * @version 1.1
 */
interface Damageable {
  /**
   * Function that specifies how the character takes damage.
   *
   * @param damage damage dealt to the character
   */
  fun takeDamage(damage: Double)
}
