package zork;

import zork.engine.ZorkLoop;
import zork.enums.EItem;
import zork.enums.EVerbs;
import zork.utils.Parser;
import java.util.Queue;
import java.util.Scanner;
import zork.models.Room;
import zork.enums.EStats;
import zork.models.entities.Npc;
import zork.models.entities.base.DamageAbleEntity;

/**
 *
 * @author d.peters
 */
public class Zork {

    /**
     * Scanner to scan user input from console.
     */
    private final Scanner scanner;

    /**
     * The parser object to parse input commands.
     */
    private final Parser parser;

    /**
     * The loop that starts and ends the game.
     */
    private final ZorkLoop loop;

    /**
     *
     */
    private final GameState game;

    /**
     * Default constructor. Initializes the scanner object, the loop to start
     * and end the game as well the Parser and the actual game objects
     */
    public Zork() {

        this.scanner = new Scanner(System.in);
        this.loop = new ZorkLoop();
        this.parser = new Parser(this.scanner);
        this.game = new GameState(this.scanner);

    }

    /**
     *
     * @param commands
     */
    public void specifyDirection(Queue<EVerbs> commands) {
        EVerbs command;
        if (commands.isEmpty()) {

            System.out.println("\nWhere do you want to go?");
            commands = this.parser.getCommand();

        }
        command = commands.poll();
        Room nextRoom = this.game.getCurrentRoom().goToNextRoom(command);

        if (nextRoom != null) {
            this.game.setCurrentRoom(nextRoom);
        } else {
            System.out.println("\nYou walked into a wall...");
        }
    }

    /**
     *
     * @param commands
     */
    public void specifyObject(Queue<EVerbs> commands) {
        EVerbs command;

        if (commands.isEmpty()) {

            System.out.println("\nTake what?");
            commands = this.parser.getCommand();

        }
        command = commands.poll();

        if (command.equals(EVerbs.ALL)) {

            this.game.getCurrentRoom().getItems().forEach((item) -> {
                System.out.println(
                        "\n" + item.getName() + " added to your inventory."
                );

                this.game.getPlayer().getInventory().add(item);
            });
            this.game.getCurrentRoom().getItems().clear();
        }
    }

    public void specifyItem(Queue<EVerbs> commands) {
        EVerbs command;

        if (commands.isEmpty()) {

            System.out.println("\nUse what?");
            commands = this.parser.getCommand();

        }
        command = commands.poll();

        if (command.equals(EVerbs.ALL)) {

            this.game.getPlayer().getInventory().forEach(item -> {
                item.use();
            });
        } else {
            for (EItem item : EItem.values()) {
                if (EItem.valueOf(command.toString()).equals(item)) {
                    this.game.getPlayer().getInventory().forEach(itm -> {
                        if (itm.getName().toUpperCase().equals(item.toString())) {
                            itm.use();
                        }
                    });
                }
            }
        }
    }

    /**
     *
     */
    public void masochistAction() {
        double selfDamage = this.game.getPlayer().getStats().get(EStats.ATTACK).getValue();
        System.out.println("\nYou hit yourself with a bludgeon.");
        this.game.getPlayer().takeDamage(selfDamage);
    }

    /**
     *
     */
    public void attackAction() {
        if (!this.game.getCurrentRoom().getCharacters().isEmpty()) {
            if (this.game.getCurrentRoom().getCharacters().get(0) instanceof DamageAbleEntity) {

                DamageAbleEntity dmgChar = (DamageAbleEntity) this.game.getCurrentRoom().getCharacters().get(0);
                dmgChar.takeDamage(this.game.getPlayer().getStats().
                        get(EStats.ATTACK).getValue());
            }
        }
    }

    /**
     *
     */
    public void npcGreetings() {
        if (!this.game.getCurrentRoom().getCharacters().isEmpty()) {
            System.out.println("There is somebody in the room...");
            this.game.getCurrentRoom().getCharacters().forEach(character -> {
                if (character instanceof Npc) {
                    Npc ch = (Npc) character;
                    ch.salutation();
                }
            });
        }
    }

    /**
     *
     * @param commands
     */
    public void selectAction(Queue<EVerbs> commands) {
        EVerbs command = commands.poll();
        switch (command) {
            case HELP:
                showHelp();
                break;
            case QUIT:
                goodbyeMessage();
                this.loop.quit();
                break;
            case GO:
                specifyDirection(commands);
                break;
            case DESCRIBE:
                System.out.println(this.game.getCurrentRoom().getDescription());
                break;
            case TAKE:
                specifyObject(commands);
                break;
            case INVENTORY:
                this.game.getPlayer().showInventory();
                break;
            case USE:
                specifyItem(commands);
                break;
            case STATS:
                this.game.getPlayer().displayStats();
                break;
            case MASOCHIST:
                masochistAction();
                break;
            case ATTACK:
                attackAction();
                break;
            default:
                System.out.println("\nI don't understand that command.");

        }
    }

    /**
     * Main process that executes the command actions.
     */
    public void run() {

        welcomeMessage();

        this.loop.start();

        while (this.loop.isRunning() && this.game.getPlayer().isAlive()) {

            System.out.println("\nYou are in the " + this.game.getCurrentRoom().getName() + ".");

            npcGreetings();

            System.out.println("What do you want to do?");

            Queue<EVerbs> commands = parser.getCommand();

            while (!commands.isEmpty()) {

                selectAction(commands);

            }
        }

    }

    /**
     * Message printed when the player starts the game
     */
    public void welcomeMessage() {

        System.out.println("Hail brave " + this.game.getPlayer().getName() + ". Welcome to Zork.");

    }

    /**
     * Message printed when the player quits the game
     */
    public void goodbyeMessage() {
        System.out.println("\nSee you again soon " + this.game.getPlayer().getName() + "!");
    }

    /**
     * List the commands available
     */
    public void showHelp() {

        for (EVerbs c : EVerbs.values()) {
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
