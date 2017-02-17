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
