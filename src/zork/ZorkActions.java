package zork;

import java.util.Queue;
import zork.enums.EItem;
import zork.enums.EStats;
import zork.enums.EVerbs;
import zork.models.Room;
import zork.models.entities.Npc;
import zork.models.entities.base.DamageAbleEntity;
import zork.utils.Parser;

/**
 *
 * @author d.peters
 */
public class ZorkActions {
    
    /**
     * 
     */
    private final Parser parser;
    
    /**
     * 
     */
    private final GameState game;
    
    /**
     * 
     * @param parser
     * @param game 
     */
    public ZorkActions(Parser parser, GameState game){
        this.parser = parser;
        this.game = game;
    }
    
    /**
     *
     * @param commands
     */
    public void specifyDirection(Queue<EVerbs> commands) {
        EVerbs command;
        if (commands.isEmpty()) {

            System.out.println("\nWhere do you want to go?");
            commands = this.parser.getCommand();

        }
        command = commands.poll();
        Room nextRoom = this.game.getCurrentRoom().goToNextRoom(command);

        if (nextRoom != null) {
            this.game.setCurrentRoom(nextRoom);
        } else {
            System.out.println("\nYou walked into a wall...");
        }
    }

    /**
     *
     * @param commands
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
                            itm.use();
                        }
                    });
                }
            }
        }
    }

    /**
     *
     */
    public void masochistAction() {
        double selfDamage = this.game.getPlayer().getStats().get(EStats.ATTACK).getValue();
        System.out.println("\nYou hit yourself with a bludgeon.");
        this.game.getPlayer().takeDamage(selfDamage);
    }

    /**
     *
     */
    public void attackAction() {
        if (!this.game.getCurrentRoom().getCharacters().isEmpty()) {
            if (this.game.getCurrentRoom().getCharacters().get(0) instanceof DamageAbleEntity) {

                DamageAbleEntity dmgChar = (DamageAbleEntity) this.game.getCurrentRoom().getCharacters().get(0);
                dmgChar.takeDamage(this.game.getPlayer().getStats().
                        get(EStats.ATTACK).getValue());
            }
        }
    }

    /**
     *
     */
    public void npcGreetings() {
        if (!this.game.getCurrentRoom().getCharacters().isEmpty()) {
            System.out.println("There is somebody in the room...");
            this.game.getCurrentRoom().getCharacters().forEach(character -> {
                if (character instanceof Npc) {
                    Npc ch = (Npc) character;
                    ch.salutation();
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
    
    public void roomDescription(){
        System.out.println(this.game.getCurrentRoom().getDescription());
    }
    
    /**
     * 
     */
    public void currentRoomMessage(){
        System.out.println("\nYou are in the " + this.game.getCurrentRoom().getName() + ".");
    }
    
    /**
     * 
     */
    public void unknownCmdMsg(){
        System.out.println("\nI don't understand that command.");
    }
    
    /**
     * 
     */
    public void askForAction(){
        System.out.println("What do you want to do?");
    }
    
    /**
     * 
     * @return 
     */
    public Queue<EVerbs> getCommand(){
        return parser.getCommand();
    }
}
