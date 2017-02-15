package zork.engine;

import java.util.Queue;
import zork.GameState;
import zork.ZorkActions;
import zork.enums.EVerbs;

/**
 *
 * @author d.peters
 */
public class ZorkLoop {
    
    /**
     * Boolean flag to test if the game loop is to be ended.
     */
    private boolean running;
    
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
     * @param game
     * @param actions 
     */
    public ZorkLoop(GameState game, ZorkActions actions){
        this.game = game;
        this.actions = actions;
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

            Queue<EVerbs> commands = actions.getCommand();

            while (!commands.isEmpty()) {

                selectAction(commands);

            }
        }

    }
    
}
