package ch.peters.daniel.zork.models

import java.util.ArrayList
import ch.peters.daniel.zork.enums.Verb
import ch.peters.daniel.zork.models.entities.base.Entity
import ch.peters.daniel.zork.models.items.Item

/**
 * Class describing a room object.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class Room(var name: String, var description: String) {
  companion object {
    val wall = Room("Wall", "A Wall")
  }

  var north: Room = wall
  var east: Room = wall
  var south: Room = wall
  var west: Room = wall
  var items: MutableList<Item> = ArrayList()
  var characters: MutableList<Entity> = ArrayList()

  /**
   * Sets all four exits of this rooms. Set to null if there should be no exit
   * on a side. The order of the exit params are north, east, south, west
   *
   * @param no Northern exit
   * @param ea  Eastern exit.
   * @param so Southern exit
   * @param we  Western exit
   */
  fun setExits(no: Room, ea: Room, so: Room, we: Room) {
    north = no
    east = ea
    south = so
    west = we
  }

  /**
   * Get the room to the specified direction.
   *
   * @param direction desired direction.
   * @return the room in the specified direction
   */
  fun goToNextRoom(direction: Verb): Room {
    return when (direction) {
      Verb.NORTH -> north
      Verb.EAST -> east
      Verb.SOUTH -> south
      Verb.WEST -> west
      else -> {
        wall
      }
    }
  }
}
