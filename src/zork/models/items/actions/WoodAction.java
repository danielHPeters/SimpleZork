package zork.models.items.actions;

import zork.interfaces.IUseable;
import zork.models.entities.Player;

/**
 *
 * @author d.peters
 */
public class WoodAction implements IUseable {

    /**
     *
     */
    private Player player;

    /**
     *
     * @param player
     */
    public WoodAction(Player player) {
        this.player = player;
    }

    /**
     *
     */
    @Override
    public void use() {

        switch (player.getName()) {
            case "Chuck Norris":
                System.out.println("\nWell played, well played...");
                break;
            case "John Cena":
                System.out.println("\nWhatever. You win, stupid!");
                break;
            default:
                if (player.getName().equals("Wood")){
                    
                    System.out.println("\nNice try, stupid!");
                } else {
                    System.out.println("\nYou cannot use wood! Wood uses you, stupid!");
                }   this.player.die();
                break;
        }

    }

}
