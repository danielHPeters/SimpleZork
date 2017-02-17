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
package zork.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import zork.enums.EVerbs;

/**
 *
 * @author d.peters
 */
public class Parser {

    /**
     *
     */
    public Scanner scanner;

    /**
     *
     * @param scanner
     */
    public Parser(Scanner scanner) {

        this.scanner = scanner;

    }

    /**
     *
     * @return
     */
    public Queue<EVerbs> getCommand() {

        Queue<EVerbs> commands = new LinkedList<>();
        String userCommand = scanner.nextLine().toUpperCase();
        String[] foundWords = userCommand.split(" ");

        for (String word : foundWords) {

            try {

                EVerbs value = EVerbs.valueOf(word);
                commands.add(value);

            } catch (IllegalArgumentException e) {
                commands.add(EVerbs.UNDEFINED);
            }

        }

        return commands;

    }

    /**
     *
     * @return
     */
    public String[] handleInput() {
        String userCommand = scanner.nextLine().toUpperCase();
        String[] foundWords = userCommand.split(" ");

        return foundWords;
    }

    public void parse() {
        String[] input = handleInput();

        
        try {
            
        } catch (IllegalArgumentException e) {
        }
    }

}
