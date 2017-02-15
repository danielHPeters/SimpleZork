package zork;

import zork.engine.ZorkLoop;
import zork.utils.Parser;
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
     * 
     */
    private final ZorkLoop loop;

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
        this.loop = new ZorkLoop(this.game, this.actions);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Zork game = new Zork();
        game.loop.run();

    }

}
