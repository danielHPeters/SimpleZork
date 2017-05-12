/*
 * Copyright (C) 2017 d.peters
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
package zork.models.talk;

import java.util.List;

/**
 * Prototype Dialog class for use with dialog System. WIP.
 *
 * @author d.peters
 * @version 0.2
 */
public class Dialog {

    /**
     * List of dialog choices
     */
    private List<Message> choiches;

    /**
     * Owner of this dialog. The owner object must implement ITalkable
     * interface.
     */
    private ITalkable owner;
}
