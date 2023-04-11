package fr.istic.si2.huffman

import Encodage._
import Decodage._
import Utils._

/**
 * Application principale V3 : avec transmission du code
 */
object HuffmanApp3 extends App {

  /*
  println(vers16Bits("r"))
  println(vers16Bits("c"))
  println(vers16Bits("d"))
  println(cherche16Bits(stringToListBit("000000001111111100000000"),16))
  println(encode("aabb"))
  println(lireDescription(stringToListBit(encode("abcdef"))))
  println(lireDescription(stringToListBit("10000000000110000100000000001100010")))
  println(decode("100000000001100001000000000011000100011"))
  */

  
  /**
   * @param message une chaîne de caractères
   * Demontre le bon fonctionnement des fonctions ce qu'on a fait :
   *          -la représentation de l'arbre de huffman construit à partir de message + 
   *              l'encodage de message en utilisant l'arbre construit à partir de message
   *          -le message décodé contenu dans l'encodage de message, en utilisant le code de huffman
   *              représenté en début de l'encodage de message
   *          -ecrire le decodage de message dans un fichier
   */
  def testV3(message: String): Unit = {
    if(message == ""){
      sys.error("la chaine a compresser ne doit pas etre vide")
    }
    println("Le message : " + message)
    val enco : String = encode(message)
    val deco : String = decode(enco)
    println("Le message encodé(la représentation de l'arbre huffman construit à partir de message et l'encodage de message en utilisant cet arbre) :\n" + enco)
    ecrireFichier("fichiers/texte4.txt",deco)
    println("Le message decodé est dans le fichier texte4.txt")
  }
  testV3(lireFichier("fichiers/texte1.txt"))
}