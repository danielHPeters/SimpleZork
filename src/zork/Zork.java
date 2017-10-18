package zork;

import zork.engine.ZorkLoop;
import zork.utils.Parser;
import java.util.Scanner;
import zork.generators.MapGenerator;
import zork.generators.PlayerGenerator;

/**
 * Main class which instantiates the core Objects of the Program like the parser,
 * the generators, the game state etc.
 *
 * @author d.peters
 * @version 1.0
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
   * Generator for player objects.
   */
  private final PlayerGenerator pGen;

  /**
   * Generator for maps (currently all the none player objects are also
   * created here).
   */
  private final MapGenerator mGen;

  /**
   * State of the game (all game objects and their data are stored here).
   */
  private final GameState game;

  /**
   * Game actions.
   */
  private final ZorkActions actions;

  /**
   * This object contains the main program loop.
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
    this.mGen = new MapGenerator();
    this.game = new GameState(this.pGen.createPlayer(), this.mGen.createRooms());
    this.game.setCurrentRoom(this.game.getRooms().get(3));
    this.actions = new ZorkActions(this.parser, this.game);
    this.loop = new ZorkLoop(this.actions);
  }

  /**
   * Main method instantiates the game object and starts its loop.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Zork game = new Zork();
    game.loop.run();
  }
}
