package zork.models.entities

import zork.enums.ENpc
import zork.enums.EStats
import zork.models.entities.base.DamageAbleEntity
import zork.models.entities.base.Stat
import zork.models.talk.ITalkAble

/**
 * Blueprint for Npc objects.
 *
 * @author d.peters
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
