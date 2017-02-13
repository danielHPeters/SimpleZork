package zork.models.entities;

import java.util.ArrayList;
import java.util.List;
import zork.models.items.Item;
import zork.interfaces.IUseable;

/**
 *
 * @author d.peters
 */
public class Player extends DamageAbleEntity {

    /**
     *
     */
    private final List<Item> inventory;

    /**
     *
     * @param name
     * @param age
     */
    public Player(String name, int age) {
        super(name, age, new Stat(100, 0, 200), new Stat(5, 0, 100));
        this.inventory = new ArrayList<>();

    }

    /**
     *
     * @return
     */
    public List<Item> getInventory() {
        return inventory;
    }

    /**
     *
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
     * Use an item if it is of type Usable
     *
     * @param item
     */
    public void useItem(Item item) {

        if (item instanceof IUseable) {
            System.out.println(item.getName() + " used.");
        } else {
            System.out.println("You can't use the " + item.getName() + ".");
        }
    }
    
    /**
     * Display all stats of this player
     */
    public void displayStats(){
        this.stats.forEach((eStat, stat)->{
            System.out.println(eStat + ": " + stat.getValue());
        });
    }

}
