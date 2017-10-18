package zork;

import zork.enums.EItem;
import zork.enums.EPreposition;
import zork.enums.EVerbs;

/**
 * Class defining a command.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class Command {
  private EVerbs verb;
  private EItem subject;
  private EPreposition preposition;
  private EItem object;

  public Command(EVerbs verb) {
    this.verb = verb;
  }

  public Command(EVerbs verb, EItem subject) {
    this.verb = verb;
    this.subject = subject;
  }

  public Command(EVerbs verb, EItem subject, EPreposition preposition, EItem object) {
    this.verb = verb;
    this.subject = subject;
  }
}
