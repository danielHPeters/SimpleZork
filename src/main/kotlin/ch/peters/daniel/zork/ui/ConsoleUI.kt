package ch.peters.daniel.zork.ui

/**
 * Terminal user interface.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class ConsoleUI : UserInterface {
  override fun displayMessage(msg: String) {
    System.out.println(msg)
  }
}