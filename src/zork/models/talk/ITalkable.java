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

/**
 * Interface for objects that can talk
 *
 * @author d.peters
 * @version 1.0.1
 */
public interface ITalkable {

    /**
     * Talk to antother object which implements the ITalkable interface
     * @param to 
     */
    public void talkTo(ITalkable to);

    /**
     * Greeting method.
     */
    public void salutation();
}
