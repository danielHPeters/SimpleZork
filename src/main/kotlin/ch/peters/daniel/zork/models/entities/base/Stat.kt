package ch.peters.daniel.zork.models.entities.base

/**
 * Container object for player stat.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 *
 * @version 1.1.0
 */
class Stat(var value: Double, var minValue: Double, var maxValue: Double) {
  /**
   * Increase the current value of this object.
   *
   * @param add added amount
   */
  fun increase(add: Double) {
    if (value + add > maxValue) {
      value += add
    }
  }

  /**
   * Decrease the current value of this object.
   *
   * @param subtract reduced amount
   */
  fun decrease(subtract: Double) {
    // Check because armor could make damage negative (which would heal char)
    if (subtract > 0) {
      value -= subtract
    }
  }
}
