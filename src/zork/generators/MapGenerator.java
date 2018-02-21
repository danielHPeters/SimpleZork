package zork.generators;

import java.util.ArrayList;
import java.util.List;
import zork.enums.ENpc;
import zork.models.Room;
import zork.models.entities.Npc;
import zork.models.items.Item;
import zork.models.items.actions.AxeAction;
import zork.models.items.actions.NukeAction;
import zork.models.items.actions.ShovelAction;
import zork.models.items.actions.WoodAction;

/**
 * Generator for rooms. TODO make dynamic and procedurally generated or via
 * config file
 *
 * @author Daniel Peters
 * @version 1.0.4
 */
public class MapGenerator {
  /**
   * Create the rooms with all their contents.
   *
   * @return rooms
   */
  public List<Room> createRooms() {
    List<Room> rooms;

    Room garden = new Room("Garden", "The King's Garden. A very pleasant place.");
    Room throneRoom = new Room("Throne Room", "The kining is awaiting you.");
    Room armory = new Room("Armory", "The armory is filled with swords and muskets.");
    Room diningRoom = new Room("Dining Room", "You see a grand table with lots of chairs around it.");
    Room kitchen = new Room("Kitchen", "You smell a steak sizzling on a fire.");

    Item shovel = new Item("shovel", "A rusty shovel", 1, new ShovelAction());
    Item bucket = new Item("bucket", "It has a hole in it.", 0);
    Item axe = new Item("axe", "A dangerous looking weapon.", 10, new AxeAction());
    Item nuka = new Item("nuka", "!!!!!!!!!???????", 1111111111, new NukeAction());
    Item wood = new Item("wood", "???", 100000, new WoodAction());

    Npc king = new Npc("King", 40, ENpc.KING);
    Npc cook = new Npc("Cook", 27, ENpc.COOK);
    Npc wd = new Npc("Wood", 100, ENpc.WOOD);

    garden.setExits(null, null, throneRoom, null);
    throneRoom.setExits(garden, null, diningRoom, armory);
    armory.setExits(null, throneRoom, null, null);
    diningRoom.setExits(throneRoom, null, kitchen, null);
    kitchen.setExits(diningRoom, null, null, null);

    garden.getItems().add(shovel);
    garden.getItems().add(bucket);
    armory.getItems().add(axe);
    armory.getItems().add(nuka);
    throneRoom.getItems().add(wood);

    throneRoom.getCharacters().add(king);
    kitchen.getCharacters().add(cook);
    garden.getCharacters().add(wd);

    rooms = new ArrayList<>();
    rooms.add(garden);
    rooms.add(throneRoom);
    rooms.add(armory);
    rooms.add(diningRoom);
    rooms.add(kitchen);

    return rooms;
  }
}
