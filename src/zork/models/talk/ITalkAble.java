package zork.models.talk;

/**
 * Interface for objects that can talk.
 *
 * @author d.peters
 * @version 1.0.1
 */
public interface ITalkAble {
  /**
   * Talk to another object which implements the ITalkAble interface.
   *
   * @param to conversation partner
   */
  void talkTo(ITalkAble to);

  /**
   * Greeting method.
   */
  void salutation();
}
