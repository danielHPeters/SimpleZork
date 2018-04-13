package zork.models.entities.base

import zork.enums.EStats
import zork.interfaces.IMoveable

/**
 * Basic Entity.
 *
 * @author Daniel Peters
 * @version 1.0
 */
 abstract class Entity(var name: String, var age: Int, attack: Stat) : IMoveable {
  var  alive: Boolean
  var stats:  MutableMap<EStats, Stat>

  fun die() {
    alive = false
    System.out.println("$name died.")
  }

  /**
   * Resurrect entity.
   */
  fun resurrect() {
    if (!alive) {
      alive = true
      System.out.println("$name resurrected.")
    } else {
      System.out.println("You can't resurrect an alive person you dummy!")
    }
  }

  init {
    alive = true
    stats =  HashMap()
    stats[EStats.ATTACK] =  attack
  }
}
