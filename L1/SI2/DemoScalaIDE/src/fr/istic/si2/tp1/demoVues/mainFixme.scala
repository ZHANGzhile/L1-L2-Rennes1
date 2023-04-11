package fr.istic.si2.tp1.demoVues

import scala.io.StdIn._

object TachesFixme extends App {

    val question: String = "Quel est votre prénom ?"
  //val nom: String = readLine()

  /**
   * @param nom une chaîne 
   * @return un message de salutations à l'attention de nom
   */
  def salutation(nom: String): String = "Bonjour " + nom + " ! Comment allez-vous ?"

  //Affichage de la question
  println(question)
  val nom: String = readLine()

  //Affichage d'un message de salutation
  println(salutation(nom))

}