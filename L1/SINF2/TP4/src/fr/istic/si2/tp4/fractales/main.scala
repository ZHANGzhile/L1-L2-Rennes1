package fr.istic.si2.tp4.fractales

import fr.istic.si2.scribble._
import scala.annotation.tailrec

object Fractales extends App {
  
  val rougetriangle : Image = solid(RED,Triangle(20))
  val blanctriangle : Image = solid(WHITE,Triangle(20))
   draw(rougetriangle)
    /**
   * @param c une couleur
   * @param i une image dont les couleurs de ligne et de remplissage ne sont pas définies
   * @return l'image i coloriée entièrement (bord et intérieur) de la couleur c
   */
  def solid(c: Color, i: Image): Image = {
    lineColor(fillColor(i, c), c)
  }

  /**
   * @param n un entier positif ou nul
   * @return image du triangle de Sierpinski à l'ordre n
   */
  // TODO 
  
  def whiteTriangle(n:Int) : Image = {
    
  }
  def sierpinski(n: Int): Image = {
    n match {
      
      case 0 => rougetriangle
      case _ => Below(sierpinski(n-1),Beside(sierpinski(n-1),))
    }
  }

  /**
   * @param n un entier positif ou nul
   * @return image du tapis de Sierpinski à l'ordre n
   */
  // TODO 
  def tapis(n: Int): Image = ???

  /**
   * @param n un entier positif ou nul
   * @return image d'une rosace à l'ordre n
   */
  // TODO 
  def rosace(n: Int): Image = ???
}