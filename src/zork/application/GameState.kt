package zork.application

import zork.models.Room
import zork.models.entities.Player

/**
 * Game state storage.
 *
 * @author d.peters
 * @version 1.0
 */
class GameState(val player: Player, val rooms: List<Room>, var currentRoom: Room)
