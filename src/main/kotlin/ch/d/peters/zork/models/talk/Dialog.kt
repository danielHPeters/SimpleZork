package ch.d.peters.zork.models.talk

import ch.d.peters.zork.interfaces.ITalkAble
import ch.d.peters.zork.models.talk.Message

/**
 * Prototype Dialog class for execute with dialog System. WIP.
 *
 * @author Daniel Peters
 * @version 1.1.0
 */
class Dialog(val choiches: List<Message>, val owner: ITalkAble)
