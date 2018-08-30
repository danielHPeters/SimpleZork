package ch.peters.daniel.zork.ui

/**
 * Interface for user interfaces (graphical or commandline).
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
interface UserInterface {
  /**
   * Display a message string.
   */
  fun displayMessage(msg: String)
}
