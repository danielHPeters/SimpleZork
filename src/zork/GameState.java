package zork;

import java.util.List;
import zork.models.Room;
import zork.models.entities.Player;

/**
 * Game state storage.
 *
 * @author d.peters
 * @version 1.0
 */
public class GameState {
  private Room currentRoom;
  private final List<Room> rooms;
  private final Player player;

  /**
   * Default constructor which initializes the game objects and the reference
   * to the scanner object.
   *
   * @param player player
   * @param rooms  list of all rooms
   */
  public GameState(Player player, List<Room> rooms) {
    this.player = player;
    this.rooms = rooms;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public Player getPlayer() {
    return player;
  }

  public List<Room> getRooms() {
    return rooms;
  }
}
