package zork.models;

import java.util.ArrayList;
import java.util.List;
import zork.enums.EVerbs;
import zork.models.entities.base.Entity;
import zork.models.items.Item;

/**
 * Class describing a room object.
 *
 * @author d.peters
 * @version 1.1.0
 */
public class Room {
  /**
   * Name of this room.
   */
  private final String name;

  /**
   * Short description of the room.
   */
  private final String description;

  /**
   * Exit north of this room.
   */
  private Room north;

  /**
   * Exit east of this room.
   */
  private Room east;

  /**
   * Exit south of this room.
   */
  private Room south;

  /**
   * Exit west of this room.
   */
  private Room west;

  /**
   * Items in this room.
   */
  private List<Item> items;

  /**
   * Non player characters in this room.
   */
  private List<Entity> characters;

  /**
   * Default constructor. Sets the name and the description of the room
   *
   * @param name        name of the room
   * @param description description of the room
   */
  public Room(String name, String description) {
    this.name = name;
    this.description = description;
    this.items = new ArrayList<>();
    this.characters = new ArrayList<>();
  }

  /**
   * Sets all four exits of this rooms. Set to null if there should be no exit
   * on a side. The order of the exit params are north, east, south, west
   *
   * @param north Northern exit
   * @param east  Eastern exit.
   * @param south Southern exit
   * @param west  Western exit
   */
  public void setExits(Room north, Room east, Room south, Room west) {
    this.north = north;
    this.east = east;
    this.south = south;
    this.west = west;
    this.items = new ArrayList<>();
    this.characters = new ArrayList<>();
  }

  /**
   * Get the room to the specified direction.
   *
   * @param direction desired direction.
   * @return the room in the specified direction
   */
  public Room goToNextRoom(EVerbs direction) {
    Room room = this;

    switch (direction) {
      case NORTH:
        room = this.north;
        break;
      case EAST:
        room = this.east;
        break;
      case SOUTH:
        room = this.south;
        break;
      case WEST:
        room = this.west;
        break;
      default:
        System.out.println("Invalid Direction.");
        break;
    }

    return room;
  }

  /**
   * Get name of this room.
   *
   * @return name of this room
   */
  public String getName() {
    return name;
  }

  /**
   * Get description of this room.
   *
   * @return the description of this room
   */
  public String getDescription() {
    return description;
  }

  /**
   * Get the characters in this room.
   *
   * @return the NPC in this room
   */
  public List<Entity> getCharacters() {
    return characters;
  }

  /**
   * Get the available items in this room.
   *
   * @return the items in this room
   */
  public List<Item> getItems() {
    return items;
  }

  /**
   * Replace items in this room.
   *
   * @param items list of new items
   */
  public void setItems(List<Item> items) {
    this.items = items;
  }
}
