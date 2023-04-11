package fr.istic.si2.tp5

import org.junit.Assert._

/**
 * Type algébrique récursif permettant de modéliser
 * des listes d'entiers non vides
 */
sealed trait ListeNVE
//TODO Compléter ici la définition du type algébrique ListeNVE
case class Chiffres(n: Int) extends ListeNVE
case class NonVide(n1: ListeNVE) extends ListeNVE

object ExosListesNonVides extends App {

  /**
   * @param l une liste non vide d'entiers
   * @return le dernier élément de l
   */
  // TODO
  def dernier(l: List[Int]): Int = {

    l match {

      case Nil      => 0
      case e :: Nil => e
      case e :: m   => dernier(m)

    }
  }
  println(dernier(List(5, 6, 9, 10)))

  val l1: ListeNVE = NonVide(NonVide(Chiffres(5)))

  /**
   * @param l une ListeNVE quelconque
   * @return le dernier élément de l
   */
  // TODO
  def dernier(l: ListeNVE): Int = {

    l match {

      case Chiffres(a) => a
      case NonVide(m)  => dernier(m)
    }
    
  }
  println(dernier(l1))
}
