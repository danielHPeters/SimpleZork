package zork.generators

import zork.interfaces.IUserInterface
import java.util.Scanner
import zork.models.entities.Player

/**
 * Generator for player objects.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class PlayerGenerator(private val scanner: Scanner, private val ui: IUserInterface) {
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
    while (name == "") {
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
