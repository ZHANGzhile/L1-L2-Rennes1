package testers
import org.junit.Assert._
import org.junit.Test

import scala.util.Random

class TestInter {
  val rand= new Random
  
  // Générer un entier aléatoire entre i et j
  def genInt(i:Int,j:Int)= rand.nextInt(j-i+1)+i
  
  //Générer un ensemble d'entier aléatoires de taille i
  def genSetL(i:Int):Set[Int]=
    if (i<=0) Set[Int]() else genSetL(i-1)+genInt(0,10)
    
  //Générer un ensemble d'entier aléatoires de taille aléatoire. genSet est défini
  // comme une fonction (sans paramètres) avec def et non comme une valeur (avec val/var) ce qui fait 
  // qu'à chaque apparition de genSet dans le code, une nouvelle valeur est 
  // calculée pour l'occasion
    
  def genSet= genSetL(genInt(0,5))
  
  @Test
  def test1{              // 100.000 tests, hop
    for (i<-1 to 100000) Inter.intersec(genSet,genSet)
  }

//  @Test
//  def test1{              // 100.000 tests, hop
//    for (i<-1 to 100000) {
//      val s1= genSet
//      val s2= genSet
//      println("i="+i+" s1="+s1+" s2="+s2)
//      Inter.intersec(s1,s2)
//    }
//  }

}