package ch.d.peters.zork.interfaces

/**
 * Interface for user interfaces (graphical or commandline).
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
interface IUserInterface {
  /**
   * Display a message string.
   */
  fun displayMessage(msg: String)
}
