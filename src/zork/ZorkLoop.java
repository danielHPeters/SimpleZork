/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork;

/**
 *
 * @author d.peters
 */
public class ZorkLoop {
    
    /**
     * 
     */
    public boolean running;

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
