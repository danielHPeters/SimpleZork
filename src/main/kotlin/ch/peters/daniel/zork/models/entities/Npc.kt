package ch.peters.daniel.zork.models.entities

import ch.peters.daniel.zork.enums.NpcType
import ch.peters.daniel.zork.models.entities.base.StatType
import ch.peters.daniel.zork.models.entities.base.DamageAbleEntity
import ch.peters.daniel.zork.models.entities.base.Stat
import ch.peters.daniel.zork.models.talk.Speaker

/**
 * Blueprint for Npc objects.
 *
 * @author Daniel Peters
 * @version 1.1
 */
class Npc(name: String, age: Int, val npcTypeId: NpcType) : DamageAbleEntity(name, age, Stat(100.0, 0.0, 200.0), Stat(0.0, 0.0, 80.0)), Speaker {
  init {
    stats[StatType.ATTACK] = Stat(20.0, 0.0, 150.0)
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
   * @param to other object that implements Speaker
   */
  override fun talkTo(to: Speaker) {
    throw UnsupportedOperationException("Not supported yet.")
  }
}
