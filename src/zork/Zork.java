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

import zork.engine.ZorkLoop;
import zork.utils.Parser;
import java.util.Scanner;
import zork.generators.MapGenerator;
import zork.generators.PlayerGenerator;

/**
 *
 * @author d.peters
 */
public class Zork {

    /**
     * Scanner to scan user input from console.
     */
    private final Scanner scanner;

    /**
     * The parser object to parse input commands.
     */
    private final Parser parser;
    
    /**
     * 
     */
    private final PlayerGenerator pGen;
    
    /**
     * 
     */
    private final MapGenerator mGen;

    /**
     *
     */
    private final GameState game;
    
    /**
     * 
     */
    private final ZorkActions actions;
    
    /**
     * 
     */
    private final ZorkLoop loop;

    /**
     * Default constructor. Initializes the scanner object, the loop to start
     * and end the game as well the Parser and the actual game objects
     */
    public Zork() {

        this.scanner = new Scanner(System.in);
        this.parser = new Parser(this.scanner);
        this.pGen = new PlayerGenerator(this.scanner);
        this.mGen = new MapGenerator();
        this.game = new GameState(this.pGen.createPlayer(), this.mGen.createRooms());
        this.game.setCurrentRoom(this.game.getRooms().get(3));
        this.actions = new ZorkActions(this.parser, this.game);
        this.loop = new ZorkLoop(this.actions);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Zork game = new Zork();
        game.loop.run();

    }

}
