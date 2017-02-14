/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork;

import java.util.List;
import zork.models.Room;
import zork.models.entities.Player;

/**
 *
 * @author d.peters
 */
public class GameState {

    /**
     * Current location of the player
     */
    private Room currentRoom;

    /**
     * All the rooms
     */
    private List<Room> rooms;

    /**
     * The player object
     */
    private Player player;

    /**
     * Default constructor which initializes the game objects and the reference
     * to the scanner object.
     *
     * @param player
     */
    public GameState(Player player) {
        this.player = player;
    }

    /**
     *
     * @return
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     *
     * @param currentRoom
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * 
     * @return 
     */
    public List<Room> getRooms() {
        return rooms;
    }
    

    /**
     * 
     * @param rooms 
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    

}
