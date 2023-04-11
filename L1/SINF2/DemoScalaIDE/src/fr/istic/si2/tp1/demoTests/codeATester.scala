package fr.istic.si2.tp1.demoTests

import scala.io.StdIn._

object CodeATester extends App {

  /**
   * @param x un entier
   * @return x plus 1
   */
  def plus1(x: Int): Int = {
    x + 1
  }

  /**
   * @param langue un mot parmis "FR", "ENG", "GER".
   * @return le mot "bonjour" dans la langue indiquée par langue (français, anglais, ou allemand)
   */
  def bonjour(langue: String): String = {
    langue match {
      case "FR"  => "bonjour"
      case "ENG" => "hello"
      case "GER" => "Hallo"
    }
  }

  // Interaction simple avec l'utilisateur
  while (true) {
    val question = "ENG / FR / GER ?"
    println(question)
    val l = readLine()
    println(bonjour(l))
  }

}