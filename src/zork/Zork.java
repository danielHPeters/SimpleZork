package zork;

import zork.engine.ZorkLoop;
import zork.enums.EVerbs;
import zork.utils.Parser;
import java.util.Queue;
import java.util.Scanner;
import zork.generators.MapGenerator;
import zork.generators.PlayerGenerator;

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
    private final PlayerGenerator pGen;
    
    /**
     * 
     */
    private final MapGenerator mGen;

    /**
     *
     */
    private final GameState game;
    
    /**
     * 
     */
    private final ZorkActions actions;

    /**
     * Default constructor. Initializes the scanner object, the loop to start
     * and end the game as well the Parser and the actual game objects
     */
    public Zork() {

        this.scanner = new Scanner(System.in);
        this.loop = new ZorkLoop();
        this.parser = new Parser(this.scanner);
        this.pGen = new PlayerGenerator(this.scanner);
        this.game = new GameState(this.pGen.createPlayer());
        this.mGen = new MapGenerator();
        this.game.setRooms(this.mGen.createRooms(this.game.getPlayer()));
        this.game.setCurrentRoom(this.game.getRooms().get(3));
        this.actions = new ZorkActions(this.parser, this.game);

    }

    

    /**
     *
     * @param commands
     */
    public void selectAction(Queue<EVerbs> commands) {
        EVerbs command = commands.poll();
        switch (command) {
            case HELP:
                this.actions.showHelp();
                break;
            case QUIT:
                this.actions.goodbyeMessage();
                this.loop.quit();
                break;
            case GO:
                this.actions.specifyDirection(commands);
                break;
            case DESCRIBE:
                this.actions.roomDescription();
                break;
            case TAKE:
                this.actions.specifyObject(commands);
                break;
            case INVENTORY:
                this.game.getPlayer().showInventory();
                break;
            case USE:
                this.actions.specifyItem(commands);
                break;
            case STATS:
                this.game.getPlayer().displayStats();
                break;
            case MASOCHIST:
                this.actions.masochistAction();
                break;
            case ATTACK:
                this.actions.attackAction();
                break;
            default:
                System.out.println("\nI don't understand that command.");

        }
    }

    /**
     * Main process that executes the command actions.
     */
    public void run() {

        this.actions.welcomeMessage();

        this.loop.start();

        while (this.loop.isRunning() && this.game.getPlayer().isAlive()) {

            this.actions.currentRoomMessage();

            this.actions.npcGreetings();

            System.out.println("What do you want to do?");

            Queue<EVerbs> commands = parser.getCommand();

            while (!commands.isEmpty()) {

                selectAction(commands);

            }
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
