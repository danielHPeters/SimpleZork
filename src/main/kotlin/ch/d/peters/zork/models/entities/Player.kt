package ch.d.peters.zork.models.entities

import java.util.ArrayList
import ch.d.peters.zork.models.entities.base.DamageAbleEntity
import ch.d.peters.zork.models.entities.base.Stat
import ch.d.peters.zork.models.items.Item
import ch.d.peters.zork.interfaces.ITalkAble

/**
 * In game Representation of players.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class Player(name: String, age: Int) : DamageAbleEntity(name, age, Stat(100.0, 0.0, 200.0), Stat(5.0, 0.0, 100.0)), ITalkAble {
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

  override fun talkTo(to: ITalkAble) {
  }

  override fun greet(): String {
    return "Me: Hello there. I'm $name. How do you do?"
  }
}
