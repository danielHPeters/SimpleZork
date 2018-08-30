package ch.peters.daniel.zork.generators

import ch.peters.daniel.zork.ui.UserInterface
import java.util.Scanner
import ch.peters.daniel.zork.models.entities.Player

/**
 * Generator for player objects.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class PlayerGenerator(private val scanner: Scanner, private val ui: UserInterface) {
  /**
   * Creates and returns a player
   *
   * @return
   */
  fun createPlayer(): Player {
    var name = ""
    var age = 0

    ui.displayMessage("What's your name?")

    // Wait until user inserts a name.
    while (name.trim() == "") {
      name = scanner.nextLine()
    }

    ui.displayMessage("How Old are you?")

    do {
      // Check input is of type int.
      if (scanner.hasNextInt()) {
        age = scanner.nextInt()
      } else {
        ui.displayMessage("You can only enter numbers for your age.")
        scanner.next()
      }

    } while (age <= 0) // Check for invalid age.
    scanner.nextLine()

    return Player(name, age)
  }
}
