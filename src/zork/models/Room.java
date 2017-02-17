/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package zork.models;

import java.util.ArrayList;
import java.util.List;
import zork.enums.EVerbs;
import zork.models.entities.base.Entity;
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
     * 
     */
    private List<Entity> characters;

    /**
     * Default constructor. Sets the name and the description of the room
     *
     * @param name
     * @param description
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
        this.characters = new ArrayList<>();
        
    }
    
    /**
     * 
     * @param direction 
     * @return  
     */
    public Room goToNextRoom(EVerbs direction){
        
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
    public List<Entity> getCharacters() {
        return characters;
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
