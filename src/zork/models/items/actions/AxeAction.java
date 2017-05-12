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
 * Action for axes
 *
 * @author d.peters
 */
public class AxeAction implements IUseable {

    /**
     * Use method without any param if the object should not do something with
     * any object.
     */
    @Override
    public void use() {
        System.out.println("You swing the Axe around you. You almost killed yourself in the process.");
    }

    /**
     * Use item on the player
     *
     * @param player the player object.
     */
    @Override
    public void use(Player player) {
        use();
    }

}
