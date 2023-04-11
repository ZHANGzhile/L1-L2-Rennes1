package fr.istic.si2.huffman

import Encodage._
import Decodage._
import ConstructionCode._
import Utils._

/**
 * Application principale V2 : avec construction du code
 */
object HuffmanApp2 extends App {

  /**
   * Une liste de couples caractère / fréquence d'apparition
   * à utiliser par l'application principale.
   */
  val lfreqs: List[(Char, Double)] = ('a',0.45)::('b',0.18)::('c',0.09)::('d',0.09)::('r',0.19)::Nil
  val s1: String = "ab"
  val h: List[Huffman] = initHuffman(lfreqs)
  val s2: String ="acbabcabbc"
  /*
  println(h)
  println(triSelonFreq(h))
  println(uneFusion(h))
  println(fusion(h))
  println("fusion")
  println(fusion(initHuffman(analyseFrequences(s2))))
  println("code Huffman")
  println(codeHuffman(lfreqs))
  println(s2.toList)
  println(analyseFrequences(s2))
  println(analyseFrequences("ab"))
  */

  /**
   * @param s une chaîne de caractères
   * Demontre le bon fonctionnement des fonctions ce qu'on a fait :
   *          -construire un arbre de Huffman a partir de la chaine de caracteres s
   *          -encode la chaine de caracteres s en utilisant cet arbre de Huffman
   *          -ecrire l'encodage dans un fichier
   */
  def testV2(s: String): Unit={
    if(s == ""){
      sys.error("la chaine a compresser ne doit pas etre vide")
    }
    println("La chaîne de caractères : " + s)
    val h : Huffman = codeHuffman(analyseFrequences(s))
    println("L'arbre de Huffman construit à partir de s : \n" + h)
    val enhuffman: String = listBitToString(encode(s,h))
    ecrireFichier("fichiers/texte3.txt",enhuffman)
    println("L'endodage de s est dans le fichier texte3.text")
  }
  testV2(lireFichier("fichiers/texte1.txt"))
  
}