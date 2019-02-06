package ch.peters.daniel.zork.generators

import ch.peters.daniel.zork.enums.NpcType
import ch.peters.daniel.zork.ui.UserInterface
import ch.peters.daniel.zork.models.Room
import ch.peters.daniel.zork.models.entities.Npc
import ch.peters.daniel.zork.models.items.Item
import ch.peters.daniel.zork.models.items.actions.*

/**
 * Generator for rooms. TODO make dynamic and procedurally generated or via
 * config file
 *
 * @author Daniel Peters
 * @version 1.1
 */
class MapGenerator(private val ui: UserInterface) {
  /**
   * Create the rooms with all their contents.
   *
   * @return rooms
   */
  fun createRooms(): List<Room> {
    val rooms = ArrayList<Room>()

    val garden = Room("Garden", "The King's Garden. A very pleasant place.")
    val throneRoom = Room("Throne Room", "The King is awaiting you.")
    val armory = Room("Armory", "The armory is filled with swords and muskets.")
    val diningRoom = Room("Dining Room", "You see a grand table with lots of chairs around it.")
    val kitchen = Room("Kitchen", "You smell a steak sizzling on a fire.")

    val shovel = Item("shovel", "A rusty shovel", 1.0, ShovelAction())
    val bucket = Item("bucket", "It has a hole in it.", 0.0, UnusableAction(ui))
    val axe = Item("axe", "A dangerous looking weapon.", 10.0, AxeAction())
    val nuka = Item("nuka", "!!!!!!!!!???????", 1111111111.0, NukeAction(ui))
    val wood = Item("wood", "???", 100000.0, WoodAction(ui))

    val king = Npc("King", 40, NpcType.KING)
    val cook = Npc("Cook", 27, NpcType.COOK)
    val wd = Npc("Wood", 100, NpcType.WOOD)

    garden.south = throneRoom
    throneRoom.setExits(garden, Room.wall, diningRoom, armory)
    armory.west = throneRoom
    diningRoom.setExits(throneRoom, Room.wall, kitchen, Room.wall)
    kitchen.north = diningRoom

    garden.items.add(shovel)
    garden.items.add(bucket)
    armory.items.add(axe)
    armory.items.add(nuka)
    throneRoom.items.add(wood)

    throneRoom.characters.add(king)
    kitchen.characters.add(cook)
    garden.characters.add(wd)

    rooms.add(garden)
    rooms.add(throneRoom)
    rooms.add(armory)
    rooms.add(diningRoom)
    rooms.add(kitchen)

    return rooms
  }
}
