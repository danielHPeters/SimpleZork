package ch.peters.daniel.zork.models.entities

/**
 * Interface for damageable objects.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
interface Damageable {
  /**
   * Function that specifies how the character takes damage.
   *
   * @param damage damage dealt to the character
   */
  fun takeDamage(damage: Double)
}
