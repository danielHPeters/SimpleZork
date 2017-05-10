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
package zork.enums;

/**
 *
 * @author Daniel
 */
public enum EVerbs {
    
    GO("Combine with a direction to go somewhere."),
    DESCRIBE("Get the descrition of the current room."),
    HELP("Summon this help menu"),
    QUIT("Exits the game."),
    NORTH("Your character goes north if your previous command was GO."),
    SOUTH("Your character goes south if your previous command was GO."),
    EAST("Your character goes east if your previous command was GO."),
    WEST("Your character goes west if your previous command was GO."),
    TAKE("Take an item which you need to specify afterwards."),
    ALL("Pick up all items when combined with take."),
    INVENTORY("Display items in your inventory."),
    USE ("Use an item."),
    ATTACK("Attack a character."),
    STATS("Shows player stats."),
    MASOCHIST("You enjoy hitting yourself eh?"),
    AXE("Use axe."),
    BUCKET("Use bucket"),
    SHOVEL("Use schovel"),
    WOOD("???"),
    NUKA("!!!!!????"),
    TALK("Talk to npc specified right after this command"),
    KING("Talk to the King"),
    COOK("Talk to the cook."),
    UNDEFINED("This is only for internal use.");
    
    private final String details;

    EVerbs(String det) {
        details = det;
    }
    
    public String getDetails(){
        return details;
    }
}
