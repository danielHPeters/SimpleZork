package zork;

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
     * Boolean flag to test if the game loop is to be ended.
     */
    private boolean running;

    /**
     * Scanner to scan user input from console.
     */
    private final Scanner scanner;

    /**
     * The parser object to parse input commands.
     */
    private final Parser parser;
    
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
        this.parser = new Parser(this.scanner);
        this.pGen = new PlayerGenerator(this.scanner);
        this.game = new GameState(this.pGen.createPlayer());
        this.mGen = new MapGenerator();
        this.game.setRooms(this.mGen.createRooms(this.game.getPlayer()));
        this.game.setCurrentRoom(this.game.getRooms().get(3));
        this.actions = new ZorkActions(this.parser, this.game);

    }

    /**
     * Start the loop and the game
     */
    public void start(){
        this.running = true;
    }
    
    /**
     * End the loop and the game
     */
    public void quit(){
        this.running = false;
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
                quit();
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
                this.actions.unknownCmdMsg();

        }
    }

    /**
     * Main process that executes the command actions.
     */
    public void run() {

        this.actions.welcomeMessage();

        start();

        while (this.running && this.game.getPlayer().isAlive()) {

            this.actions.currentRoomMessage();

            this.actions.npcGreetings();

            this.actions.askForAction();

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
