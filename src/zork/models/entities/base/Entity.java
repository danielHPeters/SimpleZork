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
import java.util.EnumMap;
import java.util.Map;
import zork.interfaces.IMoveable;

/**
 *
 * @author d.peters
 */
public abstract class Entity implements IMoveable{
    
    /**
     * 
     */
    private boolean alive;

    /**
     *
     */
    private String name;
    
    /**
     * 
     */
    protected Map<EStats,Stat> stats;

    /**
     *
     */
    private int age;

    /**
     *
     * @param name
     * @param age
     * @param attack
     */
    public Entity(String name, int age, Stat attack) {

        this.alive = true;
        this.name = name;
        this.age = age;
        this.stats = new EnumMap<>(EStats.class);
        this.stats.put(EStats.ATTACK, attack);

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * 
     * @return 
     */
    public Map<EStats, Stat> getStats() {
        return stats;
    }
    
    /**
     * 
     */
    public void die(){
        this.alive = false;
        System.out.println(this.name + " died.");
    }
    
    public void resurrect(){
        if (!this.alive){
            this.alive = true;
            System.out.println(this.name + " resurrected.");
        } else {
            System.out.println("You can't resurrect an alive person you dummy!");
        }
    }

    public boolean isAlive() {
        return alive;
    }
    
    

}
