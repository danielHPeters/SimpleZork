package zork.models.talk

/**
 * Interface for objects that can talk.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
interface ITalkAble {
  /**
   * Talk to another object which implements the ITalkAble interface.
   *
   * @param to conversation partner
   */
  fun talkTo( to: ITalkAble)

  /**
   * Greeting method.
   */
  fun greet(): String
}
