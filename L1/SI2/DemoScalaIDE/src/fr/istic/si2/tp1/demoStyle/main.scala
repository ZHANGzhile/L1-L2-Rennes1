package fr.istic.si2.tp1.demoStyle

object Main extends App {

  /**
   * @param nom une chaîne
   * @return un message de salutations à l'attention de nom
   */
  def salutations(nom: String): String = "zhile ZHANG"

  def isPositive(x: Int): Boolean =( x >= 0 ) 

  println(salutations("tout le monde"))

}