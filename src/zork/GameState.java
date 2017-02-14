/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import zork.models.Room;
import zork.models.entities.Npc;
import zork.models.entities.Player;
import zork.models.items.Item;
import zork.models.items.actions.AxeAction;
import zork.models.items.actions.NukaAction;
import zork.models.items.actions.ShovelAction;
import zork.models.items.actions.WoodAction;

/**
 *
 * @author d.peters
 */
public class GameState {
    
    /**
     * Current location of the player
     */
    private Room currentRoom;

    /**
     * All the rooms
     */
    private List<Room> rooms;

    /**
     * The player object
     */
    private Player player;
    
    private final Scanner scanner;
    
    public GameState(Scanner scanner){
        this.scanner = scanner;
        initPlayer();
        initRooms();
    }
    
    /**
     * Initializes the player object. Asks the user to submit name and age.
     */
    private void initPlayer() {

        String name = null;
        int age = 0;

        System.out.println("What's your name?");

        while (name == null) {

            name = this.scanner.nextLine();

        }

        System.out.println("How Old are you?");
        do {

            if (this.scanner.hasNextInt()) {
                age = this.scanner.nextInt();
            } else {
                System.out.println("You can only enter numbers for your age.");
                this.scanner.next();
            }

        } while (age <= 0);
        this.scanner.nextLine();
        this.player = new Player(name, age);
    }

    /**
     * Initializes all the rooms and the items in them.
     */
    private void initRooms() {

        Room garden = new Room("Garden", "The King's Garden. A very pleasant place.");
        Room throneRoom = new Room("Throne Room", "The kining is awaiting you.");
        Room armory = new Room("Armory", "The armory is filled with swords and muskets.");
        Room diningRoom = new Room("Dining Room", "You see a grand table with lots of chairs around it.");
        Room kitchen = new Room("Kitchen", "You smell a steak sizzling on a fire.");

        Item shovel = new Item("shovel", "A rusty shovel", 1, new ShovelAction());
        Item bucket = new Item("bucket", "It has a hole in it.", 0);
        Item axe = new Item("axe", "A dangerous looking weapon.", 10, new AxeAction());
        Item nuka = new Item("nuka", "!!!!!!!!!???????", 1111111111, new NukaAction(this.player));
        Item wood = new Item("wood", "???", 100000, new WoodAction(this.player));

        Npc king = new Npc("King", 40);
        Npc cook = new Npc("Cook", 27);
        Npc wd = new Npc("Wood", 100);

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
     * @return 
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 
     * @param currentRoom 
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * 
     * @return 
     */
    public Player getPlayer() {
        return player;
    }
    
    
    
    
}
