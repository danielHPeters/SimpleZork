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
    UNDEFINED("This is only for internal use.");
    
    private final String details;

    EVerbs(String det) {
        details = det;
    }
    
    public String getDetails(){
        return details;
    }
}
