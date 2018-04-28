package ch.d.peters.zork.application

import ch.d.peters.zork.models.Room
import ch.d.peters.zork.models.entities.Player

/**
 * Game state storage.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class GameState(val player: Player, val rooms: List<Room>, var currentRoom: Room)
