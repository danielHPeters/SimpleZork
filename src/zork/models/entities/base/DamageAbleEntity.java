package zork.models.entities.base;

import zork.enums.EStats;
import zork.interfaces.IDamageable;

/**
 *
 * @author d.peters
 */
public abstract class DamageAbleEntity extends Entity implements IDamageable {

    /**
     *
     * @param name
     * @param age
     * @param health
     * @param armor
     */
    public DamageAbleEntity(String name, int age, Stat health, Stat armor) {
        super(name, age, new Stat(20, 0, 1000));
        this.stats.put(EStats.HEALTH, health);
        this.stats.put(EStats.ARMOR, armor);
    }

    /**
     *
     * @param damage
     */
    @Override
    public void takeDamage(double damage) {

        if (!this.getName().equals("Wood")) {
            
            double actualDamage = damage - this.stats.get(EStats.ARMOR).getValue();
            
            this.stats.get(EStats.HEALTH).decrease(actualDamage);
            System.out.println(this.getName() + " took " + actualDamage + " damage");

            if (this.stats.get(EStats.HEALTH).getValue() <= 0) {
                this.die();
            }
        } else {
            System.out.println("I am Wood, stupid!");
        }

    }

}
