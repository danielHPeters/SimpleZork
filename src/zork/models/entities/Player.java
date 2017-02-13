package zork.models.entities;

import java.util.ArrayList;
import java.util.List;
import zork.models.items.Item;

/**
 * Ingame Representation of players.
 *
 * @author d.peters
 */
public class Player extends DamageAbleEntity {

    /**
     * The inventory of the player.
     */
    private final List<Item> inventory;

    /**
     * Default constructor. Initializes name and age of player.
     * @param name player name
     * @param age age of the player
     */
    public Player(String name, int age) {
        super(name, age, new Stat(100, 0, 200), new Stat(5, 0, 100));
        this.inventory = new ArrayList<>();

    }

    /**
     * Getter for the player inventory.
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
            this.inventory.forEach(item -> {
                System.out.println(
                        "Item: " + item.getName()
                        + " - " + item.getDescription()
                        + " - Price: " + item.getPrice()
                );
            });
        }
    }

    /**
     * Display all stats of this player
     */
    public void displayStats() {
        this.stats.forEach((eStat, stat) -> {
            System.out.println(eStat + ": " + stat.getValue());
        });
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
