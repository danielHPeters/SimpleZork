package ch.d.peters.zork.models.items

import ch.d.peters.zork.interfaces.IItemAction

/**
 * Definition of items. Items can have actions which should be defined in a
 * separate class which implements the IItemAction interface
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class Item(var name: String, var description: String, var price: Double, private val action: IItemAction) {
  /**
   * Use method to call the execute method of the action.
   */
  fun use() {
    action.execute()
  }
}
