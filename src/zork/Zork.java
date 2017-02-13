package zork;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import zork.models.Room;
import zork.models.entities.Player;
import zork.models.items.AxeAction;
import zork.models.items.Item;
import zork.models.items.ShovelAction;
import zork.models.items.Wood;

/**
 *
 * @author d.peters
 */
public class Zork {

    private Scanner scanner;

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
    private Player player;

    /**
     *
     */
    private ZorkLoop loop;

    /**
     *
     */
    public Zork() {

        this.scanner = new Scanner(System.in);
        this.loop = new ZorkLoop();
        this.parser = new Parser(this.scanner);
        initPlayer();
        initRooms();

    }

    private void initPlayer() {

        String name = null;
        int age = 0;

        System.out.println("What's your name?");

        while (name == null) {

            name = this.scanner.nextLine();

        }

        System.out.println("How Old are you?");
        while (age <= 0) {

            if (this.scanner.hasNextInt()) {
                age = this.scanner.nextInt();
            } else {
                System.out.println("You can only enter numbers for your age.");
                scanner.next();
            }

        }
        this.player = new Player(name, age);
    }

    /**
     *
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
        Item wood = new Item("wood", "???", 100000, new Wood(this.player));

        garden.setExits(null, null, throneRoom, null);
        throneRoom.setExits(garden, null, diningRoom, armory);
        armory.setExits(null, throneRoom, null, null);
        diningRoom.setExits(throneRoom, null, kitchen, null);
        kitchen.setExits(diningRoom, null, null, null);

        garden.getItems().add(shovel);
        garden.getItems().add(bucket);
        armory.getItems().add(axe);
        throneRoom.getItems().add(wood);

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

        while (this.loop.isRunning() && this.player.isAlive()) {

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

                        if (command.equals(Command.ALL)) {
                            this.currentRoom.getItems().forEach((item) -> {
                                System.out.println(item.getName() + " added to your inventory.");
                                this.player.getInventory().add(item);
                            });
                            this.currentRoom.getItems().clear();
                        }
                        break;
                    case INVENTORY:
                        this.player.showInventory();
                        break;
                    case USE:
                        if (commands.isEmpty()) {

                            System.out.println("Use what?");
                            commands = this.parser.getCommand();

                        }
                        command = commands.poll();

                        if (command.equals(Command.ALL)) {

                            this.player.getInventory().forEach(item -> {
                                this.player.useItem(item);
                            });
                        } else {

                            for (EItem item : EItem.values()) {
                                if (EItem.valueOf(command.toString()).equals(item)) {
                                    this.player.getInventory().forEach(itm->{
                                        if(itm.getName().toUpperCase().equals(item.toString())){
                                            itm.use();
                                        }
                                    });
                                }
                            } 
                        }
                        break;
                    case STATS:
                        this.player.displayStats();
                        break;
                    case MASOCHIST:
                        double selfDamage = 80;
                        System.out.println("You hit yourself with a bludgeon. You take " + selfDamage + " damage.");
                        this.player.takeDamage(selfDamage);
                        break;
                    default:
                        System.out.println("I don't understand that command.");

                }

            }
        }

    }

    /**
     * Message printed when the player starts the game
     */
    public void welcomeMessage() {

        System.out.println("Hail brave " + this.player.getName() + ". Welcome to Zork.");

    }

    /**
     * Message printed when the player quits the game
     */
    public void goodbyeMessage() {
        System.out.println("See you again soon " + this.player.getName() + "!");
    }

    /**
     * List the Command available
     */
    public void showHelp() {

        for (Command c : Command.values()) {
            System.out.println(c + " - " + c.getDetails());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Zork game = new Zork();
        game.run();

    }

}
