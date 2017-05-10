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
package zork.generators;

import java.util.ArrayList;
import java.util.List;
import zork.enums.ENpc;
import zork.models.Room;
import zork.models.entities.Npc;
import zork.models.items.Item;
import zork.models.items.actions.AxeAction;
import zork.models.items.actions.NukaAction;
import zork.models.items.actions.ShovelAction;
import zork.models.items.actions.WoodAction;

/**
 *
 * @author d.peters
 */
public class MapGenerator {

    public List<Room> createRooms() {

        List<Room> rooms;

        Room garden = new Room("Garden", "The King's Garden. A very pleasant place.");
        Room throneRoom = new Room("Throne Room", "The kining is awaiting you.");
        Room armory = new Room("Armory", "The armory is filled with swords and muskets.");
        Room diningRoom = new Room("Dining Room", "You see a grand table with lots of chairs around it.");
        Room kitchen = new Room("Kitchen", "You smell a steak sizzling on a fire.");

        Item shovel = new Item("shovel", "A rusty shovel", 1, new ShovelAction());
        Item bucket = new Item("bucket", "It has a hole in it.", 0);
        Item axe = new Item("axe", "A dangerous looking weapon.", 10, new AxeAction());
        Item nuka = new Item("nuka", "!!!!!!!!!???????", 1111111111, new NukaAction());
        Item wood = new Item("wood", "???", 100000, new WoodAction());

        Npc king = new Npc("King", 40, ENpc.KING);
        Npc cook = new Npc("Cook", 27, ENpc.COOK);
        Npc wd = new Npc("Wood", 100, ENpc.WOOD);

        garden.setExits(null, null, throneRoom, null);
        throneRoom.setExits(garden, null, diningRoom, armory);
        armory.setExits(null, throneRoom, null, null);
        diningRoom.setExits(throneRoom, null, kitchen, null);
        kitchen.setExits(diningRoom, null, null, null);

        garden.getItems().add(shovel);
        garden.getItems().add(bucket);
        armory.getItems().add(axe);
        armory.getItems().add(nuka);
        throneRoom.getItems().add(wood);

        throneRoom.getCharacters().add(king);
        kitchen.getCharacters().add(cook);
        garden.getCharacters().add(wd);

        rooms = new ArrayList<>();
        rooms.add(garden);
        rooms.add(throneRoom);
        rooms.add(armory);
        rooms.add(diningRoom);
        rooms.add(kitchen);

        return rooms;
    }

}
