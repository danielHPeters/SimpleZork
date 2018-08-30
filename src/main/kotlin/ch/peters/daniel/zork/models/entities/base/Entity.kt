package ch.peters.daniel.zork.models.entities.base

import ch.peters.daniel.zork.models.entities.Moveable

/**
 * Basic Entity.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
abstract class Entity(var name: String, var age: Int, attack: Stat) : Moveable {
  var alive: Boolean
  var stats: MutableMap<StatType, Stat>

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
    stats = HashMap()
    stats[StatType.ATTACK] = attack
  }
}
