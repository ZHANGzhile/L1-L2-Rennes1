package fr.istic.si2.tp1.demo

import scala.io.StdIn._

object Demo extends App {

  // Saisie au clavier du nom de l'utilisateur
  println("Quel est votre prénom ?")
  val nom: String = readLine()

  // Affichage d'un message de salutation
  println("Bonjour, " + nom + " !")

}