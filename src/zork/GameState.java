/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
    private final List<Room> rooms;

    /**
     * The player object
     */
    private final Player player;

    /**
     * Default constructor which initializes the game objects and the reference
     * to the scanner object.
     *
     * @param player
     * @param rooms
     */
    public GameState(Player player, List<Room> rooms) {
        this.player = player;
        this.rooms = rooms;
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

}
