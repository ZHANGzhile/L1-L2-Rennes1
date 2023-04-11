package fr.istic.si2.bonus1.sentinel

import fr.istic.si2.scribble._

object Sentinelle extends Universe[Image] {

  type State = Image

  val WIDTH: Int = 2 * Definitions.WIDTH
  val HEIGHT: Int = WIDTH
  val name: String = "Sentinelle"

  override def init: State = {
    Definitions.fleche
  }

  override def react(s: State, e: Event): State = {
    e match {
      case MouseMove(x, y) => Definitions.rotation(x - (WIDTH / 2), -(y - (HEIGHT / 2)))
      case _               => s
    }
  }

  override def stopWhen(s: State): Boolean = {
    false
  }

  override def toImage(s: State): Image = {
    On(s, Rectangle(WIDTH, WIDTH))
  }

}
