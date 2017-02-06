package zork;

/**
 *
 * @author Daniel
 */
public enum Command {
    
    GO("Combine with a direction to go somewhere."),
    DESCRIBE("Get the descrition of the current room."),
    HELP("Summon this help menu"),
    QUIT("Exits the game."),
    NORTH("Your character goes north if your previous command was GO."),
    SOUTH("Your character goes south if your previous command was GO."),
    EAST("Your character goes east if your previous command was GO."),
    WEST("Your character goes west if your previous command was GO."),
    TAKE("Take an item which you need to specify afterwards."),
    ALL("Pick up all items when combined with take.");
    
    private final String details;

    Command(String det) {
        details = det;
    }
    
    String getDetails(){
        return details;
    }
}
