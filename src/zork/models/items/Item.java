/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package zork.models.items;

import zork.interfaces.IUseable;
import zork.models.entities.Player;

/**
 * Definition of items. Items can have actions which should be defined in a
 * spearate class which implements the IUseable interface
 *
 * @author d.peters
 * @version 1.1.0
 */
public class Item {

    /**
     * Action of item. Null by default
     */
    private final IUseable action;

    /**
     * Name of item
     */
    private String name;

    /**
     * Description of item
     */
    private String description;

    /**
     * Price of item
     */
    private double price;

    /**
     * Default constructor. Sets all atributes of the item object except the
     * action. Use this constructor for unusable items.
     *
     * @param name name of the item
     * @param description description text of the item
     * @param price price of the item
     */
    public Item(String name, String description, double price) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.action = null;

    }

    /**
     * Secondary constructor. Also sets the action of the item. Use for usable
     * items.
     *
     * @param name name of the item
     * @param description description text of the item
     * @param price price of the item
     * @param action action for item use
     */
    public Item(String name, String description, double price, IUseable action) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.action = action;
    }

    /**
     * Get name of item.
     *
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of item.
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description of item.
     *
     * @return description of this item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of this item.
     *
     * @param description new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get price of this item.
     *
     * @return price of this item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price of this item.
     *
     * @param price new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Use method to call the use method of the action. Check if the item is
     * usable.
     *
     * @param player the player object
     */
    public void use(Player player) {
        if (this.action == null) {
            System.out.println("You cannot use the " + this.name + ".");
        } else {
            this.action.use(player);
        }
    }

}
