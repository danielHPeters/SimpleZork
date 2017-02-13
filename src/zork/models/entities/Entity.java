package zork.models.entities;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author d.peters
 */
public class Entity {

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
    

}
