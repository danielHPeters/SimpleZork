package zork.models.items.actions;

import zork.interfaces.IUseable;
import zork.models.entities.Player;

/**
 *
 * @author d.peters
 */
public class NukaAction implements IUseable {

    /**
     *
     */
    private final Player player;

    /**
     *
     * @param player
     */
    public NukaAction(Player player) {
        this.player = player;
    }

    @Override
    public void use() {

        switch (player.getName()) {
            case "Chuck Norris":
                System.out.println("\nThat nuclear fallout was just your fart. Nothing to worry about.");
                break;
            case "John Cena":
                System.out.println("\nAnd his name is JOHN CENA NUKER OF WORLDS!!!");
                break;
            case "Fallout Guy":
                System.out.println("\nAfter years of stasis, you finally wake up in Vault 81.");
                break;
            default:
                System.out.println("\nYou moron! You obliterated everything!");
                this.player.die();
                break;
        }
    }

}
