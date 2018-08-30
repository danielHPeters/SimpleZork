package ch.peters.daniel.zork.models.items

import ch.peters.daniel.zork.models.items.actions.ItemAction

/**
 * Definition of items. Items can have actions which should be defined in a
 * separate class which implements the ItemAction interface
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
class Item(var name: String, var description: String, var price: Double, private val action: ItemAction) {
  /**
   * Use method to call the execute method of the action.
   */
  fun use() {
    action.execute()
  }
}
