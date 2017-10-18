package zork.models.entities;

import zork.enums.ENpc;
import zork.enums.EStats;
import zork.models.entities.base.DamageAbleEntity;
import zork.models.entities.base.Stat;
import zork.models.talk.ITalkAble;

/**
 * Blueprint for Npc objects.
 *
 * @author d.peters
 * @version 1.1.0
 */
public class Npc extends DamageAbleEntity implements ITalkAble {

  /**
   * Enum constant of this npc.
   */
  private final ENpc npcId;

  /**
   * Default constructor. Initializes all Attributes of this object.
   *
   * @param name  name of the npc
   * @param age   age of the npc
   * @param npcId enum constant of the npc
   */
  public Npc(String name, int age, ENpc npcId) {
    super(name, age, new Stat(100, 0, 200), new Stat(0, 0, 80));
    this.stats.put(EStats.ATTACK, new Stat(20, 0, 150));
    this.npcId = npcId;
  }

  /**
   * Greet the player.
   */
  @Override
  public void salutation() {
    if (this.getName().equals("Wood")) {
      System.out.println(this.getName() + ": I am " + this.getName() + ", stupid!");
    } else {
      if (this.isAlive()) {
        System.out.println(this.getName() + ": Hello, I am the " + this.getName() + ".");
      }
    }
  }

  /**
   * Not supported at the moment.
   */
  @Override
  public void move() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * Not supported at the moment.
   *
   * @param to other object that implements ITalkAble
   */
  @Override
  public void talkTo(ITalkAble to) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * Get the enum constant of this npc.
   *
   * @return the enum constant of this npc
   */
  public ENpc getId() {
    return this.npcId;
  }

}
