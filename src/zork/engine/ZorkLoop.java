package zork.engine;

import java.util.Queue;
import zork.ZorkActions;
import zork.enums.EVerbs;

/**
 * This class contains the main loop an its relevant objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class ZorkLoop {

  /**
   * Boolean flag to test if the game loop is to be ended.
   */
  private boolean running;

  /**
   * Game actions.
   */
  private final ZorkActions actions;

  /**
   * @param actions
   */
  public ZorkLoop(ZorkActions actions) {
    this.actions = actions;
  }

  /**
   * Start the loop and the game
   */
  public void start() {
    this.running = true;
  }

  /**
   * End the loop and the game
   */
  public void quit() {
    this.running = false;
  }

  /**
   * Selects an action depending on the first command in the queue
   *
   * @param commands queue of commands entered by the user
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
        this.actions.showPlayerInventory();
        break;
      case USE:
        this.actions.specifyItem(commands);
        break;
      case STATS:
        this.actions.showPlayerStats();
        break;
      case MASOCHIST:
        this.actions.masochistAction();
        break;
      case ATTACK:
        this.actions.attackAction(commands);
        break;
      case TALK:
        this.actions.talkToNpc(commands);
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

    // Game last while the user is alive or until certain conditions are met
    while (this.running && this.actions.playerIsAlive()) {

      this.actions.currentRoomMessage();

      this.actions.foundNpc();

      this.actions.askForAction();

      Queue<EVerbs> commands = actions.getCommand();

      // Process all parsed commands before asking user for new commands
      while (!commands.isEmpty()) {
        selectAction(commands);
      }
    }
  }

}
