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
 * Action for shovel items
 *
 * @author d.peters
 * @version 1.0.1
 */
public class ShovelAction implements IUseable {

    /**
     * Use method without any params
     */
    @Override
    public void use() {
        System.out.println("You try to dig a hole in the ground.");
    }

    /**
     * Use method with param to do something with the player object.
     *
     * @param player the player object
     */
    @Override
    public void use(Player player) {
        use();
    }

}
