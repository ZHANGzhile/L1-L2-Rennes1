package fr.istic.si2.bonus1.sentinel

import fr.istic.si2.scribble._
import fr.istic.si2.math._

object Definitions {

  /**
   * @param i une image
   * @param c une couleur
   * @return image i coloriée et tracée avec la couleur c (si i n'est pas déjà coloriée)
   */
  def allColor(i: Image, c: Color): Image = {
    fillColor(lineColor(i, c), c)
  } // Utile pour factoriser du code.

  val r_width = 100
  val t_width = 50
  val WIDTH = r_width + t_width

  /**
   * Une image de  flèche horizontale pointant vers la droite
   */
  // TODO Bonus 1
  val fleche: Image = ???

  /**
   * @param x abscisse d'un point
   * @param y ordonnée d'un point
   * @return dans un repère orthonormé, angle orienté, en degrés, entre les vecteurs O(1;0) et O(x;y)
   */
  // TODO Bonus 1
  def angle(x: Double, y: Double): Double = ???

  /**
   * @param x abscisse d'un point
   * @param y ordonnée d'un point
   * @return une image d'une flèche centrée en (0;0) pointant vers le point (x;y)
   */
  // TODO Bonus 1
  def rotation(x: Double, y: Double): Image = ???

}