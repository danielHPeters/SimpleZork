/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork;

import java.util.ArrayList;
import java.util.List;
import zork.models.Room;

/**
 *
 * @author d.peters
 */
public class Zork {

    /**
     * 
     */
    private Parser parser;
    
    /**
     * Current location of the player
     */
    private Room currentRoom;
    
    /**
     * All the rooms
     */
    private List<Room> rooms;
    
    /**
     * 
     */
    private ZorkLoop loop;
    
    /**
     * 
     */
    public void initRooms(){
        
        Room garden = new Room("Garden", "The King's Garden. A very pleasang Place.");
        Room throneRoom = new Room("Throne Room", "The King is awaiting you.");
        Room armory = new Room("Armory", "The armory is filled with Swords and Muskets.");
        Room diningRoom = new Room("Dining Room", "You see a grand table with lots of chairs around it.");
        Room kitchen = new Room("Kitchen", "You smell a Steak sizzling on a fire.");
        
        garden.setExits(null, null, throneRoom, null);
        throneRoom.setExits(garden, null, diningRoom, armory);
        armory.setExits(null, throneRoom, null, null);
        diningRoom.setExits(throneRoom, null, kitchen, null);
        kitchen.setExits(diningRoom, null, null, null);
        
        this.rooms = new ArrayList<>();
        this.rooms.add(garden);
        this.rooms.add(throneRoom);
        this.rooms.add(armory);
        this.rooms.add(diningRoom);
        this.rooms.add(kitchen);
        
        this.currentRoom = rooms.get(3);
        
    }
    
    /**
     * 
     */
    public void run(){
        
        welcomeMessage();
        
        this.loop = new ZorkLoop();
        this.loop.start();
        
        while(this.loop.isRunning()){
            
            this.loop.quit();
            
        }
        
    }
    
    /**
     * 
     */
    public void welcomeMessage(){
        
        System.out.println("Hail brave adventurer. Welcome to Zork.");
        System.out.println("You start in the " + this.currentRoom.getName());
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Zork game = new Zork();
        game.initRooms();
        game.run();
        
        
    }
    
}
