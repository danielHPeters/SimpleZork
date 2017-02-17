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
 *
 * @author d.peters
 */
public class NukaAction implements IUseable {

    @Override
    public void use() {
    }

    @Override
    public void use(Player player) {

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
                player.die();
                break;
        }
    }

}
