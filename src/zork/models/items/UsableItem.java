package zork.models.items;

import zork.interfaces.IUseable;

/**
 *
 * @author d.peters
 */
public class UsableItem extends Item implements IUseable{

    /**
     * 
     * @param name
     * @param description
     * @param price 
     */
    public UsableItem(String name, String description, double price) {
        super(name, description, price);
    }

    /**
     * 
     */
    @Override
    public void use() {
        
    }
    
}
