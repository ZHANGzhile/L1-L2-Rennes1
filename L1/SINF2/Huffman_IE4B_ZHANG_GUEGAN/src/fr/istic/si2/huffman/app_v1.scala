package fr.istic.si2.huffman

import Encodage._
import Decodage._
import ConstructionCode._
import Utils._
import scala.io.StdIn._

/**
 * Application principale V1 : arbre de code fixé
 */
object HuffmanApp1 extends App {

  /**
   * Arbre de code utilisé par l'application principale
   */
  val h: Huffman = Noeud(1.0, Feuille(0.57, 'a'), Noeud(0.43, Feuille(0.10, 'b'), Feuille(0.33, 'c')))
  val l1: List[Bit] = One::Zero::Zero::Nil
  val lc1: List[Char] = 'a'::'b'::'c'::Nil
  /*
  println(decodeSymbol(h,l1)) //affiche(Some(b),List(Zero))
  println(decode(l1,h)) //affiche Some(ba)
  println(encodeList(lc1,h)) //affiche List(Zero, One, Zero, One, One)
  
  val s1: String = "aabb"
  val s2: String = "aba"
  println(vers16Bits(s1))
  println(vers16Bits(s2))
  println(toChar(vers16Bits(s2)))
  */

  /**
   * @param h un arbre Huffman
   * Demontre le bon fonctionnement des fonctions ce qu'on a fait 
   */
  def testV1(h: Huffman): Unit = {
      println("Chaîne à encoder ?")
      val content: String = readLine()
      println("Chaîne encodée standard :")
      val binaire: String = vers16Bits(content)
      println(binaire)
      println("taille (nb Bits) : " + binaire.length)
      println("Chaîne encodée Huffman :")
      val listchar: List[Char] = content.toList
      val enhuffman: String = listBitToString(encodeList(listchar,h))
      println(enhuffman)
      println("taille (nb Bits) : " + enhuffman.length)
      println("Chaîne décodée Huffman :")
      val dehuffman: Option[String] = decode(encodeList(listchar,h),h)
      if(dehuffman == None) println("Erreur ou caractere(s) non encodable(s)\nEncore ? [Y/N]")
      else { println(dehuffman.get)
             if(dehuffman.get == content) println("Encore ? [Y/N]")
             else println("Erreur ou caractere(s) non encodable(s)\nEncore ? [Y/N]")
            }
      val reponse = readLine()
      if(reponse == "Y") testV1(h)
      else println("Au revoir")
   }
   testV1(h)
}