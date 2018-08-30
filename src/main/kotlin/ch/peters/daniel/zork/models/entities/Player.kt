package ch.peters.daniel.zork.models.entities

import java.util.ArrayList
import ch.peters.daniel.zork.models.entities.base.DamageAbleEntity
import ch.peters.daniel.zork.models.entities.base.Stat
import ch.peters.daniel.zork.models.items.Item
import ch.peters.daniel.zork.models.talk.Speaker

/**
 * In game Representation of players.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class Player(name: String, age: Int) : DamageAbleEntity(name, age, Stat(100.0, 0.0, 200.0), Stat(5.0, 0.0, 100.0)), Speaker {
  val inventory: MutableList<Item>

  init {
    inventory = ArrayList()
  }

  /**
   * Display all stats of this player.
   */
  fun displayStats() {
    stats.forEach { enumStat, stat -> System.out.println(enumStat.toString() + ": " + stat.value) }
  }

  override fun move() {
    throw  UnsupportedOperationException("Not supported yet.")
  }

  override fun talkTo(to: Speaker) {
  }

  override fun greet(): String {
    return "Me: Hello there. I'm $name. How do you do?"
  }
}
