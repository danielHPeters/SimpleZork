package zork.models

import java.util.ArrayList
import zork.enums.EVerbs
import zork.models.entities.base.Entity
import zork.models.items.Item

/**
 * Class describing a room object.
 *
 * @author d.peters
 * @version 1.1.0
 */
class Room(var name: String, var description: String) {
  companion object {
    val wall = Room("Wall", "A Wall")
  }

  /**
   * Exit north of this room.
   */
  var north: Room = wall

  /**
   * Exit east of this room.
   */
  var east: Room = wall

  /**
   * Exit south of this room.
   */
  var south: Room = wall

  /**
   * Exit west of this room.
   */
  var west: Room = wall

  /**
   * Items in this room.
   */
  var items: MutableList<Item> = ArrayList()

  /**
   * Non player characters in this room.
   */
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
  fun goToNextRoom(direction: EVerbs): Room {
    return when (direction) {
      EVerbs.NORTH -> north
      EVerbs.EAST -> east
      EVerbs.SOUTH -> south
      EVerbs.WEST -> west
      else -> {
        wall
      }
    }
  }

}
