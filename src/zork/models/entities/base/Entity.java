package zork.models.entities.base;

import java.util.EnumMap;
import java.util.Map;
import zork.enums.EStats;
import zork.interfaces.IMoveable;

/**
 * Basic Entity.
 *
 * @author d.peters
 * @version 1.0
 */
public abstract class Entity implements IMoveable {
  private boolean alive;
  private String name;
  protected Map<EStats, Stat> stats;
  private int age;

  /**
   * Default constructor.
   *
   * @param name   name of the entity
   * @param age    age of the entity
   * @param attack attack value of the entity
   */
  public Entity(String name, int age, Stat attack) {
    this.alive = true;
    this.name = name;
    this.age = age;
    this.stats = new EnumMap<>(EStats.class);
    this.stats.put(EStats.ATTACK, attack);
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Map<EStats, Stat> getStats() {
    return stats;
  }

  public void die() {
    this.alive = false;
    System.out.println(this.name + " died.");
  }

  /**
   * Resurrect entity.
   */
  public void resurrect() {
    if (!alive) {
      alive = true;
      System.out.println(name + " resurrected.");
    } else {
      System.out.println("You can't resurrect an alive person you dummy!");
    }
  }

  public boolean isAlive() {
    return alive;
  }


}
