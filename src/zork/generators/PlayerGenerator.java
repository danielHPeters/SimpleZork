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

import java.util.Scanner;
import zork.models.entities.Player;

/**
 * Generator for player objects.
 *
 * @author d.peters
 */
public class PlayerGenerator {

    /**
     * Scanner to obtain command line input from user
     */
    private final Scanner scanner;

    /**
     * Default constructor. Initializes the scanner.
     *
     * @param scanner
     */
    public PlayerGenerator(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Creates and returns a player
     *
     * @return
     */
    public Player createPlayer() {

        String name = null;
        int age = 0;

        System.out.println("What's your name?");

        // Wait until user inserts a name.
        while (name == null) {

            name = this.scanner.nextLine();

        }

        System.out.println("How Old are you?");

        do {

            // Check input is of type int.
            if (this.scanner.hasNextInt()) {
                age = this.scanner.nextInt();
            } else {
                System.out.println("You can only enter numbers for your age.");
                this.scanner.next();
            }

        } while (age <= 0); // Check for invalid age.
        this.scanner.nextLine();

        return new Player(name, age);
    }
}
