package fr.istic.si2.checkpoint1

object ExercicesCP1 extends App {

  /**
   * @param x un entier
   * @return la valeur absolue de x
   *         (la valeur de x sans tenir compte de son signe)
   */
  /* TODO CP1 */
  def valeurAbsolue(x: Int): Int = ???

  /**
   * @param s une chaîne de caractères quelconque
   * @return vrai si et seulement si s correspond exactement à "a", "b", ou "c"
   * @note attention, les chaînes sont en minuscules.
   */
  /*  TODO CP1 : Vous devez utiliser le pattern matching et aucune conditionnelle. */
  def abc(s: String): Boolean = ???

  /**
   * @param m un entier
   * @param x un entier
   * @param y un entier
   * @return vrai si et seulement si m est le minimum de x et y
   * @note Exemples :
   *       - 4 est le minimum de 6 et 4
   *       - 6 n'est pas le minimum de 4 et 6
   *       - 6 est le minimum de 6 et 6
   *       - 8 n'est pas le minimum de 12 et 1
   */
  /*  TODO CP1 : Vous ne devez pas utiliser de conditionnelle. Utilisez des opérateurs booléens. */
  def estMin(m: Int, x: Int, y: Int): Boolean = ???

}
