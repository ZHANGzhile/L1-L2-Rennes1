package fr.istic.si2.bonus1.secretPixel

import fr.istic.si2.scribble._
import fr.istic.si2.math._

object Definitions {

  /**
   * Largeur de la fenêtre graphique
   */
  val WIDTH: Int = 500

  /**
   * Hauteur de la fenêtre graphique
   */
  val HEIGHT: Int = 500

  /**
   * Abscisse en pixels du pixel secret
   */
  val SECRETX: Int = (scala.math.random() * WIDTH).toInt

  /**
   * Ordonnée en pixels du pixel secret
   */
  val SECRETY: Int = (scala.math.random() * HEIGHT).toInt

  /**
   * @param x1 abscisse d'un point p
   * @param y1 ordonnée d'un point p
   * @param x2 abscisse d'un point p'
   * @param y2 ordonnée d'un point p'
   * @return distance euclidienne entre p=(x1;y1) et p'=(x2;y2)
   */
  // TODO Bonus 1
  def distance(x1: Double, y1: Double, x2: Double, y2: Double): Double = ???

  /**
   * distance maximale du pixel secret à un des quatre bords de la fenêtre
   */
  // TODO Bonus 1
  val MAXDIST: Double = ???

  /**
   * @param x abscisse d'un point
   * @param y ordonnée d'un point
   * @return distance entre (x;y) et le point secret
   */
  // TODO Bonus 1
  def distSecret(x: Double, y: Double): Double = ???

  /**
   * Couleur initiale du jeu. Ici noir opaque
   */
  // TODO Bonus 1
  val couleurInit: Color = ???

  /**
   * @param c une couleur
   * @return plateau de jeu de couleur c
   */
  // TODO Bonus 1
  def jeu(c: Color): Image = ???

  /**
   * @param x abscisse d'un point
   * @param y ordonnée d'un point
   * @return une opacité dans [0;255] proportionnelle à l'écart entre le point et le pixel secret
   */
  // TODO Bonus 1
  def opacite(x: Double, y: Double): Int = ???

  /**
   * @param x abscisse d'un point
   * @param y ordonnée d'un point
   * @return couleur correspondant à l'éloignement entre (x;y) et le point secret.
   *                 L'opacité de la couleur donne le taux d'echec
   *
   */
  // TODO Bonus 1
  def calculCouleur(x: Double, y: Double): Color = ???

  /**
   * @param c couleur
   * @param n niveau
   * @return l'opacité de c est en dessous du seuil correspondant au niveau de difficulté de n
   */
  // TODO Bonus 1
  def jeuFini(c: Color, n: String): Boolean = ???

  /**
   * @param c couleur
   * @return plateau final du jeu, avec un message de succès, et un cercle entourant le point secret
   */
  // TODO Bonus 1
  def finDuJeu(c: Color): Image = ???
}
