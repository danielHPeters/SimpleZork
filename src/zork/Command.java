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

}
