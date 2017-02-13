package zork.models.items;

import zork.interfaces.IUseable;
import zork.models.entities.Player;

/**
 *
 * @author d.peters
 */
public class Wood implements IUseable {

    /**
     *
     */
    private Player player;

    /**
     *
     * @param player
     */
    public Wood(Player player) {
        this.player = player;
    }

    /**
     *
     */
    @Override
    public void use() {

        if (player.getName().equals("Chuck Norris")) {
            System.out.println("Well played, well played...");
        } else {
            System.out.println("You cannot use wood! Wood uses you, stupid!");
            this.player.die();
        }

    }

}
