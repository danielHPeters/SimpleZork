package zork.models.talk

/**
 * Interface for objects that can talk.
 *
 * @author d.peters
 * @version 1.0.1
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
