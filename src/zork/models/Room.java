package zork.models;

import java.util.ArrayList;
import java.util.List;
import zork.Command;
import zork.models.items.Item;

/**
 *
 * @author d.peters
 */
public class Room {

    /**
     * Name of this room
     */
    private final String name;

    /**
     * Short description of the room
     */
    private final String description;

    /**
     * Exit north of this room
     */
    private Room north;

    /**
     * Exit east of this room
     */
    private Room east;

    /**
     * Exit south of this room
     */
    private Room south;

    /**
     * Exit west of this room
     */
    private Room west;
    
    /**
     * 
     */
    private List<Item> items;

    /**
     * Default constructor. Sets the name and the description of the room
     *
     * @param name
     * @param description
     */
    public Room(String name, String description) {

        this.name = name;
        this.description = description;

    }

    /**
     * Sets all four exits of this rooms. Set to null if there should be no exit
     * on a side. The order of the exit params are north, east, south, west
     *
     * @param north Northern exit
     * @param east Eastern exit.
     * @param south Southern exit
     * @param west Western exit
     */
    public void setExits(Room north, Room east, Room south, Room west) {

        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.items = new ArrayList<>();
        
    }
    
    /**
     * 
     * @param direction 
     * @return  
     */
    public Room goToNextRoom(Command direction){
        
        Room room = this;
        
        switch(direction){
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
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @return 
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items 
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    
    
}
