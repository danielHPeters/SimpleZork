package ch.peters.daniel.zork.ui

/**
 * Terminal user interface.
 *
 * @author Daniel Peters
 * @version 1.1
 */
class ConsoleUI : UserInterface {
  override fun displayMessage(msg: String) {
    System.out.println(msg)
  }
}
