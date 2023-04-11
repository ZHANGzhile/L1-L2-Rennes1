package fr.istic.si2.checkpoint3

import fr.istic.si2.checkpoint.oracles.{ Bit, Zero, One }

object QuestionRecursivite extends App {

  /**
   * @param l une liste d'entiers
   * @param e1 un entier
   * @param e2 un entier
   * @return la liste des éléments de l en remplaçant chaque occurence de e1 par e2
   */
  // TODO CP3 - 1 pt
  def remplace(l: List[Int], e1: Int, e2: Int): List[Int] = ???

  /**
   * @param l une liste de chaînes de caractères
   * @param n un entier positif ou nul
   * @return le n-ième élément de l (en partant de 0), s'il existe
   */
  // TODO CP3 - 2pts
  def nth(l: List[String], n: Int): Option[String] = ???

  /**
   * @param l une liste de chaînes
   * @param n un entier positif ou nul
   * @return la liste des n premiers éléments de l
   * @note Si n est trop grand, on renvoie toute la liste l
   */
  // TODO CP3 - 3pts
  def lesPremiers(n: Int, l: List[String]): List[String] = ???

  /**
   * @param lb une liste de bits représentant un entier positif ou nul
   * @return l'indice, en partant de 0, du premier bit à 1 en partant de la gauche.
   * @note Convention: si aucun bit n'est à 1, on retourne la longueur de lb
   */
  // TODO CP3 - 2pts
  def premierBitNonNul(lb: List[Bit]): Int = ???

}

