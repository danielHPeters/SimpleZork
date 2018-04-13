package zork.models.entities

import java.util.ArrayList
import zork.models.entities.base.DamageAbleEntity
import zork.models.entities.base.Stat
import zork.models.items.Item
import zork.models.talk.ITalkAble

/**
 * In game Representation of players.
 *
 * @author d.peters
 * @version 1.1.0
 */
class Player(name: String, age: Int) : DamageAbleEntity(name, age, Stat(100.0, 0.0, 200.0), Stat(5.0, 0.0, 100.0)), ITalkAble {
  val inventory: MutableList<Item>

  init {
    inventory = ArrayList()
  }

  /**
   * List all items in this players inventory.
   */
  fun showInventory() {
    if (inventory.isEmpty()) {
      System.out.println("Your inventory is empty.")
    } else {
      inventory.forEach { item -> System.out.println("Item: " + item.name + " - " + item.description + " - Price: " + item.price) }
    }
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
    salutation()
    to.salutation()
  }

  override fun salutation() {
    System.out.println("Me: Hello there. I'm $name. How do you do?")
  }
}
