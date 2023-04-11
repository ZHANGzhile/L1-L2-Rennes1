package fr.istic.si2.tp5

import org.junit.Assert._

object ExosListes extends App {

  /**
   * @param n un entier positif ou nul
   * @param p un entier quelconque
   * @return la liste de longueur n, contenant n fois l'entier p
   */
  def nfois(n: Int, p: Int): List[Int] = {
    n match {

      case 0 => Nil
      case _ => p :: nfois(n - 1, p)

    }
  }
  println(nfois(3, 5))

  /**
   * @param l une liste de chaînes quelconques
   * @return la chaîne formée de la concaténation des éléments de l, dans l'ordre
   */
  // TODO
  def concat(l: List[String]): String = {
    l match {

      case Nil    => ""
      case e :: m => e + concat(m)

    }
  }
  println(concat(List("qhqhq","blahblah")))
  

  /**
   * @param l une liste d'entiers
   * @return la liste des éléments de l, triée dans l'ordre croissant
   */
  // TODO
  // On utilisera ici le tri par insertion.
  // Vous aurez besoin d'introduire des fonctions auxiliaires
  def triInsertion(l: List[Int]): List[Int] = {
    
    l match {
      
      case Nil => Nil
      case e::Nil => e::Nil
      case e::m::Nil => if(e<=m){
                          e::m::Nil
                        }
                        else {
                          m::e::Nil
                        }
      case e::m::n => if(e<=m){
                        e::triInsertion(m::n)
                      }
                      else {
                        m::triInsertion(e::n)
                      }
    }
  }
  println(triInsertion(List(1,5,6,0,8)))

  /**
   * @param l une liste d'entiers quelconque
   * @return vrai si et seulement si l est triée dans l'ordre croissant
   */
  // TODO
  def estTriee(l: List[Int]): Boolean = {
    
    l match {
      
      case Nil => true
      case e::Nil => true
      case e::m::n=> if(e <= m) {estTriee(m::n)}
                     else {false}
      
    }
  }
  println(estTriee(List(1,2,3,6,5,6)))

  /**
   * @param l1 une liste d'entiers
   * @param l2 une liste d'entiers
   * @return l2 est la version de l1 triée
   */
  // TODO
  def versionTriee(l1: List[Int], l2: List[Int]): Boolean = ???
}