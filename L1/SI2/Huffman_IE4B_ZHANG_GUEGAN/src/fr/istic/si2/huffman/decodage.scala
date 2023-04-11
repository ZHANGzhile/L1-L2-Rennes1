package fr.istic.si2.huffman

import Utils._

object Decodage {

  /**
   * @param h un arbre de Huffman
   * @param l une liste de bits
   * @return caractère correspondant au décodage de l selon h
   *          si l est un chemin valide de h
   */
  def decodeSymbolv0(h: Huffman, l: List[Bit]): Option[Char] = {
    h match {

      case Noeud(_, z, o) => l match {
                               case Zero :: m => decodeSymbolv0(z, m)
                               case One :: m  => decodeSymbolv0(o, m)
                               case Nil       => None
                             }
      case Feuille(_, c)  => l match {
                              case Nil => Some(c)
                              case _   => None
                             }
    }
  }

  /**
   * @param h un arbre de Huffman
   * @param l une liste de bits
   * @return un tuple de taille 2
   *         - première composante : caractère correspondant au décodage selon h d'un préfixe de l
   *         - deuxième composante : la liste des bits restant à décoder
   */
  def decodeSymbol(h: Huffman, l: List[Bit]): (Option[Char], List[Bit]) = {
      h match {

      case Noeud(_, z, o) => l match {
                               case Zero :: m => decodeSymbol(z, m)
                               case One :: m  => decodeSymbol(o, m)
                               case Nil       => (None,Nil)
                             }
      case Feuille(_, c) => l match {
                              case _   => (Some(c),l) 
                            }
    }
  }

  /**
   * @param l une liste de bits
   * @param h un arbre de Huffman
   * @return la chaîne correspondant au décodage de l, selon h, si elle existe
   */
  def decode(l: List[Bit], h: Huffman): Option[String] = {
    decodeSymbol(h,l) match {
      
      case (None,e) => None
      case (Some(a),e) => if(e != Nil){ decode(e,h) match{
                                      case None => None
                                      case Some(x) => Some(a + x)
                                      }
                          } else Some(a.toString())
    }
  }

  /**
   * @param l une liste de bits décrivant, au moins, la représentation binaire d'un arbre de Huffman
   * @return un tuple de taille 2 comprenant :
   *         - l'arbre de code de Huffman reconstruit à partir du début de l
   *         - le reste de la liste l, après la représentation de l'arbre de Huffman
   */
  def lireDescription(l: List[Bit]): (Huffman, List[Bit]) = {
    l match {
      
      case Nil => sys.error("non definition")
      case Zero::m => (Feuille(0,toChar(cherche16Bits(m,16)._1)),cherche16Bits(m,16)._2)
      case One::m =>(Noeud(0,lireDescription(m)._1,lireDescription(lireDescription(m)._2)._1),lireDescription(lireDescription(m)._2)._2)
    }
  }
  /**
   * @param l une liste de Bits
   * @param n un entier
   * @return un tuple de taille 2 comprenant :
   *         - la chaîne de 0 et 1 représentant un caractère par son encodage sur 16 bits
   *         - le rest de la liste l
   * la fonction auxiliaire de la fonction lireDescription
   */
  def cherche16Bits(l: List[Bit], n: Int): (String,List[Bit]) = {
    l match {
      
      case Nil => ("",Nil)
      case e::m => if(n != 0) (listBitToString(e::Nil) + cherche16Bits(m,n-1)._1,Nil ++ cherche16Bits(m,n-1)._2)
                   else ("",e::m)
    }
  }

  /**
   * @param messageEnc une chaîne de 0 et 1 uniquement, contenant la représentation
   *                   d'un arbre de Huffman, puis un message encodé
   * @return le message décodé contenu dans messageEnc, en utilisant le code de huffman
   *         représenté en début de messageEnc
   */
  def decode(messageEnc: String): String = {
    val a : (Huffman,List[Bit]) = lireDescription(stringToListBit(messageEnc))
    val h : Huffman = a._1
    val m : List[Bit] = a._2
    decode(m,h) match {
      case None => ""
      case Some(s) => s
    } 
  }

}