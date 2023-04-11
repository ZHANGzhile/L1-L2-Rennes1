package fr.istic.si2.tp1.demoVues

import scala.io.StdIn._

object Taches extends App {

  val question: String = "Quel est votre prénom ?"

  /* TODO: pour plus d'élégance, définir la fonction salutation, et l'utiliser plus bas*/
  def salutation(nom: String): String = nom
   

  // Saisie au clavier du nom de l'utilisateur
  println(question)

  val nom: String = readLine()

  //Affichage d'un message de salutation
  println("Bonjour, " + nom + " !")

}