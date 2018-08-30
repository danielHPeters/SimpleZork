package ch.peters.daniel.zork.utils

import ch.peters.daniel.zork.enums.Verb
import java.util.*

/**
 * This class contains parsing methods to handle user submitted input. Still
 * work in progress.
 *
 * @author d.peters
 * @version 1.0.1
 */
class Parser(private val scanner: Scanner) {
  /**
   * Get the user input words and match them with enum constants. Saves all
   * commands in a queue and returns the queue to the caller
   *
   * @return a queue of parsed commands
   */
  fun getCommand(): Queue<Verb> {
    val commands = LinkedList<Verb>()
    val foundWords = handleInput()

    foundWords.forEach { word ->
      val command = try {
        Verb.valueOf(word)
      } catch (e: IllegalArgumentException) {
        Verb.UNDEFINED
      }
      commands.add(command)
    }

    return commands
  }

  /**
   * Gets user input and turn all characters to uppercase for later checking
   * with enum constants Split up the words and save them in an array which
   * then is return to the caller.
   *
   * @return array of words submitted by the user
   */
  private fun handleInput(): List<String> {
    return scanner.nextLine().toUpperCase().split(" ")
  }
}
