package ch.peters.daniel.zork.models.entities.base

import ch.peters.daniel.zork.models.entities.Damageable

/**
 * Defines entities who can take damage.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
abstract class DamageAbleEntity(name: String, age: Int, health: Stat, armor: Stat) :
    Entity(name, age, Stat(20.0, 0.0, 1000.0)), Damageable {
  /**
   * Check how much damage was given and factor in armor,
   * resistances etc. to calculate actual damage.
   *
   * @param damage damage taken
   */
  override fun takeDamage(damage: Double) {
    if (name != "Wood") {
      val actualDamage = damage - stats[StatType.ARMOR]!!.value

      stats[StatType.HEALTH]?.decrease(actualDamage)
      System.out.println("$name took $actualDamage damage")

      if (stats[StatType.HEALTH]!!.value <= 0) {
        die()
      }
    } else {
      System.out.println("I am Wood, stupid!")
    }
  }

  init {
    stats[StatType.HEALTH] = health
    stats[StatType.ARMOR] = armor
  }
}
