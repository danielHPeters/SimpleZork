/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package zork.models.items.actions;

import zork.interfaces.IUseable;
import zork.models.entities.Player;

/**
 * Some fun class intended for special joke item. Don't take too serious ;-).
 *
 * @author d.peters
 * @version 1.0.1
 */
public class WoodAction implements IUseable {

    /**
     *
     */
    @Override
    public void use() {

    }

    /**
     * Only if the player has a certain name, will he be able to wield the
     * mighty wood.
     *
     * @param player the player object that is trying to use the item
     */
    @Override
    public void use(Player player) {

        switch (player.getName()) {

            case "Chuck Norris":
                System.out.println("\nWell played, well played...");
                break;
            case "John Cena":
                System.out.println("\nWhatever. You win, stupid!");
                break;
            case "Wood":
                System.out.println("\nNice try, stupid!");
                player.die();
                break;
            default:
                System.out.println("\nYou cannot use wood! Wood uses you, stupid!");
                player.die();
                break;
        }
    }

}
