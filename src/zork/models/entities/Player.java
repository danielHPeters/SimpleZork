/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.models.entities;

import java.util.ArrayList;
import java.util.List;
import zork.models.items.Item;

/**
 *
 * @author d.peters
 */
public class Player extends Entity {

    /**
     *
     */
    private List<Item> inventory;

    /**
     *
     * @param name
     * @param age
     */
    public Player(String name, int age) {

        super(name, age);
        this.inventory = new ArrayList<>();

    }

    /**
     *
     * @return
     */
    public List<Item> getInventory() {
        return inventory;
    }

    public void showInventory() {

        if (this.inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            this.inventory.forEach(item -> {
                System.out.println(
                        "Item: " + item.getName()
                        + " - " + item.getDescription()
                        + " - Price: " + item.getPrice()
                );
            });
        }
    }

}
