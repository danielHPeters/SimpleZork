package ch.peters.daniel.zork.application

import ch.peters.daniel.zork.models.Room
import ch.peters.daniel.zork.models.entities.Player

/**
 * Game state storage.
 *
 * @author Daniel Peters
 * @version 1.1
 */
class GameState(val player: Player, val rooms: List<Room>, var currentRoom: Room)
