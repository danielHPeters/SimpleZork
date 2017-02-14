package zork.models.entities;

import zork.enums.EStats;
import zork.models.entities.base.Stat;
import zork.models.entities.base.DamageAbleEntity;

/**
 *
 * @author d.peters
 */
public class Npc extends DamageAbleEntity {
    
    /**
     * 
     * @param name
     * @param age 
     */
    public Npc(String name, int age) {
        super(name, age, new Stat(100, 0, 200), new Stat(0, 0, 80));
        this.stats.put(EStats.ATTACK, new Stat(20, 0, 150));
    }
    
    /**
     * 
     */
    public void salutation(){
        if (this.getName().equals("Wood")){
            System.out.println(this.getName() + ": I am " + this.getName() + ", stupid!");
        } else {
            if (this.isAlive()){
                System.out.println(this.getName() + ": Hello, I am the " + this.getName() + ".");
            }
        }
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
