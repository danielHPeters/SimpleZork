package zork.models.talk;

import java.util.List;

/**
 * Prototype Dialog class for use with dialog System. WIP.
 *
 * @author d.peters
 * @version 0.2
 */
public class Dialog {
    /**
     * List of dialog choices.
     */
    private List<Message> choiches;

    /**
     * Owner of this dialog. The owner object must implement ITalkAble
     * interface.
     */
    private ITalkAble owner;
}
