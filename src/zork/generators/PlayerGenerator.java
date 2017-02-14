package zork.generators;

import java.util.Scanner;
import zork.models.entities.Player;

/**
 * Generator for player objects.
 * @author d.peters
 */
public class PlayerGenerator {
    
    /**
     * 
     */
    private final Scanner scanner;
    
    /**
     * 
     * @param scanner 
     */
    public PlayerGenerator(Scanner scanner){
        this.scanner = scanner;
    }
    
    /**
     * 
     * @return 
     */
    public Player createPlayer() {

        String name = null;
        int age = 0;

        System.out.println("What's your name?");

        while (name == null) {

            name = this.scanner.nextLine();

        }

        System.out.println("How Old are you?");
        do {

            if (this.scanner.hasNextInt()) {
                age = this.scanner.nextInt();
            } else {
                System.out.println("You can only enter numbers for your age.");
                this.scanner.next();
            }

        } while (age <= 0);
        this.scanner.nextLine();
        
        return  new Player(name, age);
    }
}
