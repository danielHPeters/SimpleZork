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
package zork;

import java.util.Queue;
import zork.enums.EItem;
import zork.enums.ENpc;
import zork.enums.EStats;
import zork.enums.EVerbs;
import zork.models.Room;
import zork.models.entities.Npc;
import zork.models.entities.base.DamageAbleEntity;
import zork.utils.Parser;

/**
 * Here the game actions are defined. Only this class should know the state of
 * the game objects
 *
 * @author d.peters
 */
public class ZorkActions {

    /**
     * The parser to get user input
     */
    private final Parser parser;

    /**
     * State of the ingame objects
     */
    private final GameState game;

    /**
     * Default constructor. It sets the parser and the game state which are
     * passed down
     *
     * @param parser
     * @param game
     */
    public ZorkActions(Parser parser, GameState game) {
        this.parser = parser;
        this.game = game;
    }

    /**
     * Ask the user to specify if "go" was entered without any direction and/or
     * go towards the specified direction
     *
     * @param commands the user command
     */
    public void specifyDirection(Queue<EVerbs> commands) {
        EVerbs command;

        if (commands.isEmpty()) {

            System.out.println("\nWhere do you want to go?");
            commands = this.parser.getCommand();

        }
        command = commands.poll();
        Room nextRoom = this.game.getCurrentRoom().goToNextRoom(command);

        // Check for invalid directions
        if (nextRoom != null) {
            this.game.setCurrentRoom(nextRoom);
        } else {
            System.out.println("\nYou walked into a wall...");
        }
    }

    /**
     * Add item from room to inventory, if it exists. If no item was specified,
     * then ask user to specify
     *
     * TODO: Allow picking up single items instead of just all
     *
     * @param commands user commands
     */
    public void specifyObject(Queue<EVerbs> commands) {
        EVerbs command;

        if (commands.isEmpty()) {

            System.out.println("\nTake what?");
            commands = this.parser.getCommand();

        }
        command = commands.poll();

        if (command.equals(EVerbs.ALL)) {

            this.game.getCurrentRoom().getItems().forEach((item) -> {
                System.out.println(
                        "\n" + item.getName() + " added to your inventory."
                );

                this.game.getPlayer().getInventory().add(item);
            });
            this.game.getCurrentRoom().getItems().clear();
        }
    }

    /**
     * Use item specified or ask user to name item to be used
     *
     * @param commands parsed user commands
     */
    public void specifyItem(Queue<EVerbs> commands) {
        EVerbs command;

        if (commands.isEmpty()) {

            System.out.println("\nUse what?");
            commands = this.parser.getCommand();

        }
        command = commands.poll();

        if (command.equals(EVerbs.ALL)) {

            this.game.getPlayer().getInventory().forEach(item -> {
                item.use();
            });
        } else {
            for (EItem item : EItem.values()) {
                if (EItem.valueOf(command.toString()).equals(item)) {
                    this.game.getPlayer().getInventory().forEach(itm -> {
                        if (itm.getName().toUpperCase().equals(item.toString())) {
                            itm.use(this.game.getPlayer());
                        }
                    });
                }
            }
        }
    }

    /**
     * Talk to an npc. Ask for dialog partner if none given.
     *
     * @param commands user submitted commands
     */
    public void talkToNpc(Queue<EVerbs> commands) {

        EVerbs command;

        if (commands.isEmpty()) {

            System.out.println("\nTo whom?");
            commands = this.parser.getCommand();

        }

        command = commands.poll();

        if (!this.game.getCurrentRoom().getCharacters().isEmpty()) {
            for (ENpc item : ENpc.values()) {
                if (ENpc.valueOf(command.toString()).equals(item)) {
                    ENpc npcId = ENpc.valueOf(command.toString());
                    this.game.getCurrentRoom().getCharacters().forEach(character -> {
                        if (character instanceof Npc) {
                            Npc npc = (Npc) character;
                            if (npc.getId().equals(npcId)) {
                                this.game.getPlayer().talkTo(npc);
                            }
                        }
                    });
                }
            }
        }

    }

    /**
     * Let the player hit himself if requested
     */
    public void masochistAction() {
        double selfDamage = this.game.getPlayer().getStats().get(EStats.ATTACK).getValue();
        System.out.println("\nYou hit yourself with a bludgeon.");
        this.game.getPlayer().takeDamage(selfDamage);
    }

    /**
     * Attack a character
     *
     * @param commands user submited commands
     */
    public void attackAction(Queue<EVerbs> commands) {

        EVerbs command;

        if (commands.isEmpty()) {

            System.out.println("\nAttack what?");
            commands = this.parser.getCommand();

        }

        command = commands.poll();

        if (!this.game.getCurrentRoom().getCharacters().isEmpty()) {

            for (ENpc item : ENpc.values()) {
                if (ENpc.valueOf(command.toString()).equals(item)) {
                    ENpc npcId = ENpc.valueOf(command.toString());
                    this.game.getCurrentRoom().getCharacters().forEach(character -> {
                        if (character instanceof Npc && character instanceof DamageAbleEntity) {
                            Npc npc = (Npc) character;
                            if (npc.getId().equals(npcId)) {
                                DamageAbleEntity dmgChar = (DamageAbleEntity) npc;
                                dmgChar.takeDamage(this.game.getPlayer().getStats().
                                        get(EStats.ATTACK).getValue());
                            }
                        }
                    });
                }
            }
        }
    }

    /**
     * Tell the player if there are npc's around
     */
    public void foundNpc() {
        if (!this.game.getCurrentRoom().getCharacters().isEmpty()) {
            this.game.getCurrentRoom().getCharacters().forEach(character -> {

                if (character.isAlive()) {
                    System.out.println(character.getName() + " is in the room...");
                } else {
                    System.out.println("You sense the corpse of " + character.getName());
                }
            });

        }
    }

    /**
     * Message printed when the player starts the game
     */
    public void welcomeMessage() {

        System.out.println("Hail brave " + this.game.getPlayer().getName() + ". Welcome to Zork.");

    }

    /**
     * Message printed when the player quits the game
     */
    public void goodbyeMessage() {
        System.out.println("\nSee you again soon " + this.game.getPlayer().getName() + "!");
    }

    /**
     * List the commands available
     */
    public void showHelp() {

        for (EVerbs c : EVerbs.values()) {
            System.out.println(c + " - " + c.getDetails());
        }

    }

    /**
     * Print the description of the room
     */
    public void roomDescription() {
        System.out.println(this.game.getCurrentRoom().getDescription());
    }

    /**
     * Tell the player his current location
     */
    public void currentRoomMessage() {
        System.out.println("\nYou are in the " + this.game.getCurrentRoom().getName() + ".");
    }

    /**
     * Send message if user gave an invalid command
     */
    public void unknownCmdMsg() {
        System.out.println("\nI don't understand that command.");
    }

    /**
     * Ask the player to do something
     */
    public void askForAction() {
        System.out.println("What do you want to do?");
    }

    /**
     * Get commands from parser
     *
     * @return
     */
    public Queue<EVerbs> getCommand() {
        return parser.getCommand();
    }

    /**
     * Print contents of the players inventory
     */
    public void showPlayerInventory() {
        this.game.getPlayer().showInventory();
    }

    /**
     * Print player stats
     */
    public void showPlayerStats() {
        this.game.getPlayer().displayStats();
    }

    /**
     * Check if player is alive
     *
     * @return
     */
    public boolean playerIsAlive() {

        return this.game.getPlayer().isAlive();
    }
}
