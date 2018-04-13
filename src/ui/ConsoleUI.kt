package ui

import zork.interfaces.IUserInterface

class ConsoleUI: IUserInterface {
  override fun displayMessage(msg: String) {
    System.out.println(msg)
  }
}