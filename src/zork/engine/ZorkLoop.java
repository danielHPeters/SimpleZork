package zork.engine;

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
     * Check if the loop has been ended.
     * @return 
     */
    public boolean isRunning() {
        return running;
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
    
    
}
