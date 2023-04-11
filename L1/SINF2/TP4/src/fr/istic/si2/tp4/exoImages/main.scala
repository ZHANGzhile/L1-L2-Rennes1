package fr.istic.si2.tp4.exoImages

import fr.istic.si2.scribble._
import scala.annotation.tailrec

object ExosImages extends App {

  /**
   * Couleurs utilisées pour faire l'immeuble
   */
  val orange: Color = Color(255, 165, 0, 255)
  val limegreen: Color = Color(50, 205, 50, 255)

  /**
   * @param c une couleur
   * @param i une image dont les couleurs de ligne et de remplissage ne sont pas définies
   * @return l'image i coloriée entièrement (bord et intérieur) de la couleur c
   */
  def solid(c: Color, i: Image): Image = {
    lineColor(fillColor(i, c), c)
  }

  /**
   * Image du toit
   */
  val toit: Image = solid(orange, besideAlign(Bottom, Triangle(31), Triangle(20)))

  /**
   * Image de l'étage
   */
  val etage: Image = {
    val r1: Image = solid(TRANSPARENT, Rectangle(5, 10))
    val fenetre: Image = Rectangle(10, 12)
    val r3: Image = solid(TRANSPARENT, Rectangle(20, 10))
    val facade: Image = fillColor(Rectangle(50, 20), limegreen)

    on(beside(r1, fenetre, r3, fenetre, r1), facade)
  }

  /**
   * @param n un entier positif ou nul
   * @return image d'un immeuble à n étages, surmonté d'un toit
   */
  // TODO 
  def immeuble(n: Int): Image = {
    n match {
      case 0 => toit
      case _ => Below(immeuble(n-1),etage)
    }
  }
  draw(immeuble(5))

  /**
   * Image de perle pour le motif de base du collier
   */
  val perle = FromFile("img/perle.png")

  /**
   * @param n un entier positif ou nul
   * @return image de collier horizontal de n perles
   */
  // TODO 
  def collierPerles(n: Int): Image = {
    n match {
      case 1 => perle
      case _ => Beside(collierPerles(n-1),perle)
    }
  }
  draw(collierPerles(5))

  /**
   * @param n un entier strictement positif
   * @return image d'un anneau rouge de rayon n
   */
  def anneau(n: Int): Image = {
    lineColor(Circle(10 * n), RED)
  }

  /**
   * @param n un entier positif ou nul
   * @return image de n cercles concentriques de plus en plus grands
   */
  // TODO 
  def anneaux(n: Int): Image = {
    n match {
      case 1 => anneau(1)
      case _ => On(anneaux(n-1),anneau(n))
    }
  }
  draw(anneaux(5))

  /**
   * Boules utilisées pour la guirlande
   */
  val boule_rouge: Image = solid(RED, Circle(20))
  val boule_noire: Image = solid(BLACK, Circle(20))

  /**
   * @param n un entier positif ou nul
   * @return image d'une guirlande horizontale de 2 * n boules de couleurs, en alternant boules rouges et boules noires
   */
  // TODO  
  def guirlande(n: Int): Image = {
    if(n == 1) {Beside(boule_noire,boule_rouge)}
    else {Beside(guirlande(n-1),Beside(boule_noire,boule_rouge))}
  }
  draw(guirlande(5))

  /**
   * @param n un entier positif ou nul
   * @return image d'une guirlande horizontale de n boules de couleurs, en alternant boules rouges et noires, en commençant par une boule rouge
   */
  // TODO  
  def guirlandeBis(n: Int): Image = {
    if (n == 1) {boule_rouge}
    else if(n % 2 == 0){Beside(guirlandeBis(n-1),boule_noire)}
    else {Beside(guirlandeBis(n-1),boule_rouge)}
  }
  draw(guirlandeBis(5))

}