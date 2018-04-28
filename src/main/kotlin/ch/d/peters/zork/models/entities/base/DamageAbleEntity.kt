package ch.d.peters.zork.models.entities.base

import ch.d.peters.zork.enums.EStats
import ch.d.peters.zork.interfaces.IDamageable

/**
 * Defines entities who can take damage.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
 abstract class DamageAbleEntity(name: String, age: Int, health: Stat, armor: Stat) : Entity(name, age, Stat(20.0, 0.0, 1000.0)), IDamageable {
  /**
   * Check how much damage was given and factor in armor,
   * resistances etc. to calculate actual damage.
   *
   * @param damage damage taken
   */
  override fun takeDamage( damage: Double) {
    if (name != "Wood") {
      val actualDamage = damage - stats[EStats.ARMOR]!!.value

      stats[EStats.HEALTH]?.decrease(actualDamage)
      System.out.println("$name took $actualDamage damage")

      if (stats[EStats.HEALTH]!!.value <= 0) {
        die()
      }
    } else {
      System.out.println("I am Wood, stupid!")
    }
  }

  init {
    stats[EStats.HEALTH] =  health
    stats[EStats.ARMOR] =  armor
  }
}