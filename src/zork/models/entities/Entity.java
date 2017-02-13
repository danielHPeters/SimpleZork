package zork.models.entities;

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
     */
    public Entity(String name, int age) {

        this.alive = true;
        this.name = name;
        this.age = age;
        this.stats = new EnumMap<>(EStats.class);

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
