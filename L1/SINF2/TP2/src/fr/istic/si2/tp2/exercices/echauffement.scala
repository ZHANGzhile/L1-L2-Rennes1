package fr.istic.si2.tp2.exercices

import scala.util.Random

object ExosBasiques extends App {

  /**
   * @param x un entier
   * @return le double de x
   */
  def double(x: Int): Int = {
    x + x
  }

  /**
   * @param x un entier
   * @return le quadruple de x
   */
  /* TODO TP2: utiliser au moins deux fois la fonction double */
  def quadruple(x: Int): Int = ???

  /**
   * @param x un entier
   * @return le chiffre des unités de x
   */
  def unite(x: Int): Int = {
    scala.math.abs(x % 10)
  }

  /**
   * @param x un entier
   * @return le chiffre des dizaines de x
   */
  def dizaine(x: Int): Int = {
    unite(x / 10)
  }

  /**
   * @param x un entier
   * @return vrai si et seulement si x est positif ou nul
   */
  /* TODO TP2 : il y a plusieurs solutions, avec et sans conditionnelle */
  def signe(x: Int): Boolean = ???

  /**
   * @param x entier à deux chiffres maximum (appartient à [-99;99])
   * @return l'entier x "renversé": son chiffre des dizaines est celui
   *         des unités de x, et réciproquement. Son signe est conservé
   */
  def renverser(x: Int): Int = ???

}
