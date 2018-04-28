package ch.d.peters.zork.models.entities

import ch.d.peters.zork.enums.ENpc
import ch.d.peters.zork.enums.EStats
import ch.d.peters.zork.models.entities.base.DamageAbleEntity
import ch.d.peters.zork.models.entities.base.Stat
import ch.d.peters.zork.interfaces.ITalkAble

/**
 * Blueprint for Npc objects.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class Npc(name: String, age: Int, val npcId: ENpc) : DamageAbleEntity(name, age, Stat(100.0, 0.0, 200.0), Stat(0.0, 0.0, 80.0)), ITalkAble {
  init {
    stats[EStats.ATTACK] = Stat(20.0, 0.0, 150.0)
  }

  /**
   * Greet the player.
   */
  override fun greet(): String {
    return if (name == "Wood") "$name: I am $name, stupid!" else "$name: Hello, I am the $name"
  }

  /**
   * Not supported at the moment.
   */
  override fun move() {
    throw UnsupportedOperationException("Not supported yet.")
  }

  /**
   * Not supported at the moment.
   *
   * @param to other object that implements ITalkAble
   */
  override fun talkTo(to: ITalkAble) {
    throw UnsupportedOperationException("Not supported yet.")
  }
}
