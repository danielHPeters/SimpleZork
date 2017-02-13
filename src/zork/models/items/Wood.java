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

        switch (player.getName()) {
            case "Chuck Norris":
                System.out.println("Well played, well played...");
                break;
            case "John Cena":
                System.out.println("Whatever. You win, stupid!");
                break;
            default:
                if (player.getName().equals("Wood")){
                    
                    System.out.println("Nice try, stupid!");
                } else {
                    System.out.println("You cannot use wood! Wood uses you, stupid!");
                }   this.player.die();
                break;
        }

    }

}
