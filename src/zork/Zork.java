package zork;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import zork.models.Room;
import zork.models.items.Item;

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

    public Zork() {

        this.loop = new ZorkLoop();
        this.parser = new Parser();

    }

    /**
     *
     */
    public void initRooms() {

        Room garden = new Room("Garden", "The King's Garden. A very pleasang Place.");
        Room throneRoom = new Room("Throne Room", "The King is awaiting you.");
        Room armory = new Room("Armory", "The armory is filled with Swords and Muskets.");
        Room diningRoom = new Room("Dining Room", "You see a grand table with lots of chairs around it.");
        Room kitchen = new Room("Kitchen", "You smell a Steak sizzling on a fire.");
        
        Item shovel = new Item("shovel", "A rusty shovel", 1);
        Item bucket = new Item("bucket", "It has a hole in it.", 0);

        garden.setExits(null, null, throneRoom, null);
        throneRoom.setExits(garden, null, diningRoom, armory);
        armory.setExits(null, throneRoom, null, null);
        diningRoom.setExits(throneRoom, null, kitchen, null);
        kitchen.setExits(diningRoom, null, null, null);
        
        garden.getItems().add(shovel);
        garden.getItems().add(bucket);

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
    public void run() {

        welcomeMessage();

        this.loop.start();

        while (this.loop.isRunning()) {

            System.out.println("You are in the " + this.currentRoom.getName());

            System.out.println("What do you want to do?");

            Queue<Command> commands = parser.getCommand();

            while (!commands.isEmpty()) {

                Command command = commands.poll();

                switch (command) {
                    case HELP:
                        showHelp();
                        break;
                    case QUIT:
                        this.loop.quit();
                        goodbyeMessage();
                        break;
                    case GO:
                        if (commands.isEmpty()) {

                            System.out.println("Where do you want to go?");
                            commands = this.parser.getCommand();

                        }
                        command = commands.poll();
                        Room nextRoom = this.currentRoom.goToNextRoom(command);

                        if (nextRoom != null) {
                            this.currentRoom = nextRoom;
                        } else {
                            System.out.println("You walked into a wall...");
                        }
                        break;
                    case DESCRIBE:
                        System.out.println(this.currentRoom.getDescription());
                        break;
                    case TAKE:
                        if (commands.isEmpty()) {

                            System.out.println("Take what?");
                            commands = this.parser.getCommand();

                        }
                        command = commands.poll();
                        if (command.equals(Command.ALL)){
                            List<Item> items = this.currentRoom.getItems();
                            this.currentRoom.getItems().forEach((item)->{
                                System.out.println("You picked up a " + item.getName() + ".");
                            });
                            this.currentRoom.getItems().clear();
                        }
                        break;
                        
                }

            }
        }

    }

    /**
     * Message printed when the player starts the game
     */
    public void welcomeMessage() {

        System.out.println("Hail brave adventurer. Welcome to Zork.");

    }

    /**
     * Message printed when the player quits the game
     */
    public void goodbyeMessage() {
        System.out.println("See you again soon Adventurer!");
    }
    
    /**
     * List the Command available
     */
    public void showHelp(){
        
        for (Command c : Command.values()){
            System.out.println(c + " - " + c.getDetails());
        }
        
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
