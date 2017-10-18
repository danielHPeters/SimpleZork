package zork.models.entities;

import java.util.ArrayList;
import java.util.List;
import zork.models.entities.base.DamageAbleEntity;
import zork.models.entities.base.Stat;
import zork.models.items.Item;
import zork.models.talk.ITalkAble;

/**
 * In game Representation of players.
 *
 * @author d.peters
 * @version 1.1.0
 */
public class Player extends DamageAbleEntity implements ITalkAble {
  /**
   * The inventory of the player.
   */
  private final List<Item> inventory;

  /**
   * Default constructor. Initializes name and age of player.
   *
   * @param name player name
   * @param age  age of the player
   */
  public Player(String name, int age) {
    super(name, age, new Stat(100, 0, 200), new Stat(5, 0, 100));
    this.inventory = new ArrayList<>();
  }

  /**
   * Getter for the player inventory.
   *
   * @return the players inventory
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
      inventory.forEach(
          item -> System.out.println(
              "Item: " + item.getName() + " - "
                  + item.getDescription() + " - Price: "
                  + item.getPrice()));
    }
  }

  /**
   * Display all stats of this player.
   */
  public void displayStats() {
    stats.forEach(
        (enumStat, stat) -> System.out.println(enumStat + ": " + stat.getValue())
    );
  }

  @Override
  public void move() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void talkTo(ITalkAble to) {
    salutation();
    to.salutation();
  }

  @Override
  public void salutation() {
    System.out.println("Me: Hello there. I'm " + this.getName() + ". How do you do?");
  }
}
