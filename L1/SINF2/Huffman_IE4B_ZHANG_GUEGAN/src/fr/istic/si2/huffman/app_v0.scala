package fr.istic.si2.huffman

import Encodage._
import Decodage._
import Utils._

/**
 * Application principale V0 : arbre de code fixé, encodage/décodage de caractères
 */
object HuffmanApp0 extends App {

  /**
   * Arbre de code utilisé par l'application principale
   */
  val h: Huffman = Noeud(
        1.00,
        Noeud(
            0.57,
            Feuille(0.25, 'a'),
            Noeud(
                0.32,
                Feuille(0.18, 'c'),
                Feuille(0.14, 'd')
            )
        ),
        Noeud(
            0.43,
            Feuille(0.21, 'b'),
            Noeud(
                0.22,
                Noeud(
                    0.13,
                    Feuille(0.07, 'f'),
                    Feuille(0.06, 'g')
                ),
                Feuille(0.09, 'e')
            )
        )
    )

  
  val h1: Huffman = Noeud(1.0, Feuille(0.57, 'a'), Noeud(0.43, Feuille(0.10, 'b'), Feuille(0.33, 'c')))
  val h2: Huffman = Noeud(1.0,
                              Feuille(0.45,'a'),Noeud(0.55,
                                                           Feuille(0.19,'r'),Noeud(0.36,
                                                                                  Noeud(0.18,
                                                                                      Feuille(0.09,'c'),Feuille(0.09,'d')),Feuille(0.18,'b'))))
  val l1: List[Bit] = One :: One :: Nil
  val l2 : List[Bit] = Zero::One::Zero::Nil
  val f : List[Bit] = One::One::Zero::Zero::Nil
  val g: List[Bit] = One::One::Zero::One::Nil

  /*
  println(decodeSymbolv0(h, f)) // ---> Some(f)
  println(decodeSymbolv0(h, g)) // ---> Some(g)
  println(decodeSymbolv0(h1, l1)) // ---> Some(c)
  println(encodeSymbol('d',h)) // ---> Some(List(Zero, One, One))
  println(encodeSymbol('f',h)) // ---> Some(List(One, One, Zero, Zero))
  println(encodeSymbol('g',h)) // ---> Some(List(One, One, Zero, One))
  println(encodeSymbol('e',h)) // ---> Some(List(One, One, One))
  println(listBitToString(f)) // ---> 1100
  println(listBitToString(g)) // ---> 1101
  println(listBitToString(l2)) // ---> 010
  println(listBitToString(l1)) // ---> 11
  println(descriptionHuffman(h2))
  */
  
  /**
   * @param h un arbre de Huffman
   * @param startChar un caractere
   * @param endChar un caractere
   * @return un tableau qui affiche en console de l'application principale de V0
   */
  def testV0(h: Huffman, startChar: Char, endChar: Char): String = {
      (startChar == (endChar + 1).toChar) match{
        case true => ""
        case false => (startChar + "    " + listBitToString(encodeSymbol(startChar, h).get) + " "
                       + decodeSymbolv0(h, encodeSymbol(startChar, h).get).get + "\n") + testV0(h, (startChar + 1).toChar, endChar) 
      }
    }
  println(testV0(h, 'a', 'g'))
}