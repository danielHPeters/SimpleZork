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

import zork.enums.EItem;
import zork.enums.EPreposition;
import zork.enums.EVerbs;

/**
 *
 * @author Daniel
 */
public class Command {

    /**
     * *
     *
     */
    private EVerbs verb;

    /**
     *
     */
    private EItem subject;

    /**
     *
     */
    private EPreposition preposition;

    /**
     *
     */
    private EItem object;

    /**
     * 
     * @param verb 
     */
    public Command(EVerbs verb){
        this.verb = verb;
    }
    
    /**
     * 
     * @param verb
     * @param subject 
     */
    public Command(EVerbs verb, EItem subject) {
        this.verb = verb;
        this.subject = subject;
    }
    
    /**
     * 
     * @param verb
     * @param subject
     * @param preposition
     * @param object 
     */
    public Command(EVerbs verb, EItem subject, EPreposition preposition, EItem object) {
        this.verb = verb;
        this.subject = subject;
    }

}
