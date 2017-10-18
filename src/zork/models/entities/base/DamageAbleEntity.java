package zork.models.entities.base;

import zork.enums.EStats;
import zork.interfaces.IDamageable;

/**
 * Defines entities who can take damage.
 *
 * @author d.peters
 * @version 1.0
 */
public abstract class DamageAbleEntity extends Entity implements IDamageable {
  /**
   * Default constructor.
   *
   * @param name   name of the entity
   * @param age    age of the entity
   * @param health initialize health
   * @param armor  initialize armor
   */
  public DamageAbleEntity(String name, int age, Stat health, Stat armor) {
    super(name, age, new Stat(20, 0, 1000));
    stats.put(EStats.HEALTH, health);
    stats.put(EStats.ARMOR, armor);
  }

  /**
   * Check how much damage was given and factor in armor,
   * resistances etc. to calculate actual damage.
   *
   * @param damage damage taken
   */
  @Override
  public void takeDamage(double damage) {
    if (!getName().equals("Wood")) {
      double actualDamage = damage - stats.get(EStats.ARMOR).getValue();

      stats.get(EStats.HEALTH).decrease(actualDamage);
      System.out.println(getName() + " took " + actualDamage + " damage");

      if (stats.get(EStats.HEALTH).getValue() <= 0) {
        die();
      }
    } else {
      System.out.println("I am Wood, stupid!");
    }
  }
}
