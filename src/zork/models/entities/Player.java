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
package zork.models.entities;

import zork.models.entities.base.Stat;
import zork.models.entities.base.DamageAbleEntity;
import java.util.ArrayList;
import java.util.List;
import zork.models.items.Item;
import zork.models.talk.ITalkable;

/**
 * Ingame Representation of players.
 *
 * @author d.peters
 * @version 1.1.0
 */
public class Player extends DamageAbleEntity implements ITalkable {

    /**
     * The inventory of the player.
     */
    private final List<Item> inventory;

    /**
     * Default constructor. Initializes name and age of player.
     *
     * @param name player name
     * @param age age of the player
     */
    public Player(String name, int age) {
        super(name, age, new Stat(100, 0, 200), new Stat(5, 0, 100));
        this.inventory = new ArrayList<>();

    }

    /**
     * Getter for the player inventory.
     *
     * @return
     */
    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * List all items in this players inventory.
     */
    public void showInventory() {

        if (this.inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            this.inventory.forEach(
                    item -> System.out.println("Item: " + item.getName()
                            + " - " + item.getDescription()
                            + " - Price: " + item.getPrice()));
        }
    }

    /**
     * Display all stats of this player
     */
    public void displayStats() {
        this.stats.forEach(
                (eStat, stat) -> System.out.println(eStat + ": " + stat.getValue())
        );
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void talkTo(ITalkable to) {
        salutation();
        to.salutation();
    }

    @Override
    public void salutation() {
        System.out.println("Me: Hello there. I'm " + this.getName() + ". How do you do?");
    }

}
