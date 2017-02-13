package zork.models.entities;

/**
 *
 * @author d.peters
 */
public class Npc extends DamageAbleEntity {
    
    /**
     * 
     * @param name
     * @param age
     * @param health 
     * @param armor 
     */
    public Npc(String name, int age, Stat health, Stat armor) {
        super(name, age, health, armor);
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
