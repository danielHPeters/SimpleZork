package zork.models.items.actions;

import zork.interfaces.IUseable;

/**
 *
 * @author d.peters
 */
public class AxeAction implements IUseable {

    @Override
    public void use() {
        System.out.println("You swing the Axe around you. You almost killed yourself in the process.");
    }
    
}
