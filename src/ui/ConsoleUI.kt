package ui

import zork.interfaces.IUserInterface

/**
 * Terminal user interface.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class ConsoleUI: IUserInterface {
  override fun displayMessage(msg: String) {
    System.out.println(msg)
  }
}