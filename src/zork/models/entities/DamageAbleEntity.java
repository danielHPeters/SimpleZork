/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.models.entities;

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
        super(name, age);
        this.stats.put(EStats.HEALTH, health);
        this.stats.put(EStats.ARMOR, armor);
    }

    /**
     *
     * @param damage
     */
    @Override
    public void takeDamage(double damage) {
        
        this.stats.get(EStats.HEALTH).decrease(damage - this.stats.get(EStats.ARMOR).getValue());
        if (this.stats.get(EStats.HEALTH).getValue() <= 0){
            this.die();
        }

    }

}
