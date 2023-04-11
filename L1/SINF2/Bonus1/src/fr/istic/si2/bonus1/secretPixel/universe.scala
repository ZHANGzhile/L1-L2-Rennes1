package fr.istic.si2.bonus1.secretPixel

import fr.istic.si2.scribble._

class SecretPixel(niveau: String) extends Universe[Color] {

  type State = Color
  val WIDTH: Int = Definitions.WIDTH
  val HEIGHT: Int = Definitions.HEIGHT
  val name: String = "Le Pixel Secret"

  override def init: State = {
    Definitions.couleurInit
  }

  override def react(s: State, e: Event): State = {
    e match {
      case MouseMove(x, y) => Definitions.calculCouleur(x, y)
      case _ => s
    }
  }

  override def stopWhen(s: State): Boolean = {
    Definitions.jeuFini(s, niveau)
  }

  override def toImage(s: State): Image = {
    if (stopWhen(s)) { Definitions.finDuJeu(s) }
    else { Definitions.jeu(s) }
  }
}
