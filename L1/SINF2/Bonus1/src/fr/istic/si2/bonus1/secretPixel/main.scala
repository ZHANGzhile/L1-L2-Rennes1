package fr.istic.si2.bonus1.secretPixel

import fr.istic.si2.scribble._
import Definitions._

object PixelSecret extends App {

  /**
   * Lancement de l'interface du jeu du pixel secret
   * @param n une chaîne indiquant le niveau de difficulté du jeu, parmi {"facile","moyen","difficile"} 
   */
  def jouer(n: String): Unit = {
    bigbang(new SecretPixel(n))
  }

  //Lancement du jeu
  jouer("difficile")
}
