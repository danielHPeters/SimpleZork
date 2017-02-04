package zork;

/**
 *
 * @author d.peters
 */
public class ZorkLoop {
    
    /**
     * 
     */
    private boolean running;

    /**
     * 
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
