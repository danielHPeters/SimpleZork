package zork.models.items;

import zork.interfaces.Useable;

/**
 *
 * @author d.peters
 */
public class UsableItem extends Item implements Useable{

    public UsableItem(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public void use() {
        
    }
    
}
