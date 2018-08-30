package ch.peters.daniel.zork.models.talk

/**
 * Interface for objects that can talk.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.1.0
 */
interface Speaker {
  /**
   * Talk to another object which implements the Speaker interface.
   *
   * @param to conversation partner
   */
  fun talkTo(to: Speaker)

  /**
   * Greeting method.
   */
  fun greet(): String
}
