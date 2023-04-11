package fr.istic.si2.tp2.images

import fr.istic.si2.scribble._
import scala.io.StdIn._

object ImageMeteo extends App {

  // Définition des images illustrant la météo
  val sun : Image = FromFile("./img/sun.png")
  val cloud : Image = FromFile("./img/cloud.png")
  val cloudy : Image = ??? // TODO TP2 réutiliser/recopier le code d'un exercice précédent!

  /**
   * @param t une chaîne dans {"beau", "couvert", "gris" }
   * @return une Image illustrant le temps décrit par t
   */
  def temps(t: String): Image = ???

  /**
   * @param t une chaîne quelconque
   * @return vrai si et seulement si t est une chaîne parmi "beau", "couvert", et "gris"
   */
  def tempsPossible(t: String): Boolean = ???
  
  
  // Boucle d'interaction simple avec l'utilisateur
  do {
    println("Quel temps fait-il (beau, couvert, ou gris) ?")
    val in_temps: String = readLine()
    if (tempsPossible(in_temps)) {
      draw(temps(in_temps))
    } else {
      println("Cette description du temps n'existe pas. Veuillez choisir parmi beau, couvert ou gris")
    }
    println("Continuer? (oui/non)")
  } while (readLine() == "oui")
  println("Goodbye")

}
