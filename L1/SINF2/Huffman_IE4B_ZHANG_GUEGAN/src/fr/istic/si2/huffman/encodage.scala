package fr.istic.si2.huffman

import Utils._
import ConstructionCode._

object Encodage {

  /**
   * @param c un caractère
   * @param h un arbre de Huffman
   * @return l'encodage de c, selon h (si c est bien présent dans h)
   */
  def encodeSymbol(c: Char, h: Huffman): Option[List[Bit]] = {
     h match {
      
      case Noeud(_,z,o)  => (encodeSymbol(c,z),encodeSymbol(c,o)) match {
                                                                  case (None,None) => None
                                                                  case (None,Some(x)) => Some(One::x)
                                                                  case (Some(y),None) => Some(Zero::y)
                                                                  case (_,_) => None
                             } 
      case Feuille(_,c1) => if(c == c1)  Some(Nil)
                            else None
                            
    }
  }

  /**
   * @param l une liste de caractères
   * @param h un arbre de Huffman
   * @return la séquence de bits correspondants à
   *         l'encodage selon h des éléments de l, s'il a réussi.
   *         Les caractères pour lesquels l'encodage est impossible sont oubliés
   */
  def encodeList(l: List[Char], h: Huffman): List[Bit] = {
     l match {
      
      case Nil => Nil
      case a::m => encodeSymbol(a,h) match{
                                      case None => encodeList(m,h)
                                      case Some(x) => x ++ encodeList(m,h)
                   } 
    }
  }

  /**
   * @param s une chaîne de caractères
   * @param h un arbre de Huffman
   * @return l'encodage de s, selon h, en une liste de bits.
   *         (concaténation de l'encodage de chaque caractère de s selon h)
   */
  def encode(s: String, h: Huffman): List[Bit] = {
    encodeList(s.toList,h)
  }

  /**
   * @param h un arbre de Huffman
   * @return une chaîne de 0 et 1 uniquement représentant l'arbre h (voir partie 1.3 de l'énoncé)
   *         Les caractères encodables avec h sont représentés dans leur encodage binaire 16 bits.
   */
  def descriptionHuffman(h: Huffman): String = {
     h match {
       
       case Feuille(_,c) => 0 + vers16Bits(c.toString())
       case Noeud(_,z,o) => 1 + descriptionHuffman(z) + descriptionHuffman(o)
       
     }
  }

  /**
   * @param message une chaîne de caractères
   * @return la chaîne de 0 et 1, contenant:
   *         - la représentation de l'arbre de huffman construit à partir de message
   *         - puis l'encodage de message en utilisant l'arbre construit à partir de message
   */
  def encode(message: String): String = {
    if(message.length() != 0){
      val h : Huffman = codeHuffman(analyseFrequences(message))
      descriptionHuffman(h) + listBitToString(encode(message,h))
    }
    else ""
  }
}