package fr.istic.si2.test.huffman

import org.junit.Test
import org.junit.Assert._
import fr.istic.si2.huffman.Encodage._
import fr.istic.si2.huffman.Decodage._
import fr.istic.si2.testerApp._
import fr.istic.si2.huffman._
import Utils._
import ConstructionCode._

class TestsHuffman {

  val _ = new AppInit(HuffmanApp0) // Ne pas supprimer cette ligne.
  val hTest: Huffman = 
    Noeud(
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

  // Vous devrez tester soigneusement chacune de vos fonctions.
/**
   * Test d'encodage d'un caractère V0
   */
  @Test
  def testEncodeSymbolv0() {
    assertEquals(Some(Zero::Zero::Nil), encodeSymbol('a', hTest))
    assertEquals(Some(One::Zero::Nil), encodeSymbol('b', hTest))
    assertEquals(None, encodeSymbol('h', hTest))
  }
  
  /**
   * Test de décodage caractère V0
   */
  @Test
  def testDecodeSymbolv0() {
    assertEquals(Some('a'), decodeSymbolv0(hTest, Zero::Zero::Nil))
    assertEquals(None, decodeSymbolv0(hTest, Zero::Nil))
    assertEquals(Some('f'), decodeSymbolv0(hTest, One::One::Zero::Zero::Nil))
    assertEquals(None, decodeSymbolv0(hTest, Zero::Zero::One::Nil))
  }
  
  /**
   * Test de conversion de List de Bits en String
   */
  @Test
  def testListBitToString() {
    assertEquals("", listBitToString(Nil))
    assertEquals("0", listBitToString(Zero::Nil))
    assertEquals("01", listBitToString(Zero::One::Nil))
  }
  
  /**
   * Test de encodage la chaîne de caractères V1
   */
  @Test
  def testEncodev1() {
    assertEquals(Nil, encode("",hTest))
    assertEquals(Zero::Zero::Nil, encode("a",hTest))
    assertEquals(Zero::Zero::One::Zero::Zero::One::One::One::One::Zero::One::Nil, encode("abdg",hTest))
  }
  
  /**
   * Test de encodage les caractéres
   */
  @Test
  def testEncodeList() {
    assertEquals(Zero::Zero::Nil, encodeList(List('a'),hTest))
    assertEquals(Nil, encodeList(List('z'),hTest))
    assertEquals(Zero::Zero::One::Zero::Nil, encodeList(List('a','b','z'),hTest))
  }
  
  /**
   * Test de décodage caractère V1
   */
  @Test
  def testDecodeSymbol(){
    assertEquals((Some('a'), Nil), decodeSymbol(hTest, Zero::Zero::Nil))
    assertEquals((Some('a'), One::Nil), decodeSymbol(hTest, Zero::Zero::One::Nil))
    assertEquals((None, Nil), decodeSymbol(hTest, Zero::Nil))
  }
  
  /**
   * Test de décodage une chaîne de caractères
   */
  @Test
  def testDecode(){
    assertEquals(Some("a"), decode(Zero::Zero::Nil, hTest))
    assertEquals(Some("ab"), decode(Zero::Zero::One::Zero::Nil, hTest))
    assertEquals(None, decode(Zero::Zero::One::Nil, hTest))
    assertEquals(None, decode(Zero::Nil, hTest))
  }
  
  /**
   * Test de initialisation d'arbre de Huffman
   */
  @Test
  def testInitHuffman(){
    assertEquals(Feuille(1.0,'a')::Nil, initHuffman(('a',1.0)::Nil))
    assertEquals(Nil, initHuffman(Nil))
    assertEquals(Feuille(0.3,'a')::Feuille(0.6,'b')::Feuille(0.1,'c')::Nil, initHuffman(('a',0.3)::('b',0.6)::('c',0.1)::Nil))
  }
  
  /**
   * Test de tri d'une liste d'arbre de Huffman
   */
  @Test
  def testTriSelonFreq(){
    assertEquals(Nil, triSelonFreq(Nil))
    
    assertEquals(Noeud(0.4,Feuille(0.2,'b'),Feuille(0.2,'c'))::Feuille(0.6,'a')::Nil,
                 triSelonFreq(Feuille(0.6,'a')::Noeud(0.4,Feuille(0.2,'b'),Feuille(0.2,'c'))::Nil))
                 
    assertEquals(Feuille(0.4,'b')::Feuille(0.6,'a')::Nil, triSelonFreq(Feuille(0.6,'a')::Feuille(0.4,'b')::Nil))
    
    assertEquals(Feuille(0.1,'g')::Noeud(0.3,Feuille(0.1,'z'),Feuille(0.2,'y'))::Noeud(0.6,Feuille(0.3,'b'),Feuille(0.3,'c'))::Nil, 
                 triSelonFreq(Noeud(0.6,Feuille(0.3,'b'),Feuille(0.3,'c'))::Noeud(0.3,Feuille(0.1,'z'),Feuille(0.2,'y'))::Feuille(0.1,'g')::Nil))
  }
  
  /**
   * Test de une seule fusion sur une liste d'arbres de Huffman
   */
  @Test
  def testUneFusion(){
    assertEquals(Noeud(1.0,Feuille(0.4,'a'),Feuille(0.6,'b'))::Nil, uneFusion(Feuille(0.4,'a')::Feuille(0.6,'b')::Nil))
    
    assertEquals(Noeud(0.5,Feuille(0.1,'g'),Noeud(0.4,Feuille(0.2,'b'),Feuille(0.2,'c')))::Feuille(0.5,'a')::Nil, 
                 uneFusion(Feuille(0.5,'a')::Noeud(0.4,Feuille(0.2,'b'),Feuille(0.2,'c'))::Feuille(0.1,'g')::Nil))
                 
    assertEquals(Noeud(0.4,Feuille(0.1,'g'),Noeud(0.3,Feuille(0.1,'z'),Feuille(0.2,'y')))::Noeud(0.6,Feuille(0.3,'b'),Feuille(0.3,'c'))::Nil, 
                 uneFusion(Noeud(0.6,Feuille(0.3,'b'),Feuille(0.3,'c'))::Noeud(0.3,Feuille(0.1,'z'),Feuille(0.2,'y'))::Feuille(0.1,'g')::Nil))
  }
  
  /**
   * Test de toutes les fusions sur une liste d'arbres de Huffman
   */
  @Test
  def testFusion(){
    assertEqualsHuffman(Feuille(1.00,'a'), fusion(Feuille(1.00,'a')::Nil),0.1)
    
    assertEqualsHuffman(Noeud(1.0,Noeud(0.5,Feuille(0.1,'g'),Noeud(0.4,Feuille(0.2,'b'),Feuille(0.2,'c'))),Feuille(0.5,'a')), 
                        fusion(Feuille(0.5,'a')::Noeud(0.4,Feuille(0.2,'b'),Feuille(0.2,'c'))::Feuille(0.1,'g')::Nil), 0.1)
                        
    assertEqualsHuffman(Noeud(1.0,Noeud(0.4,Feuille(0.1,'g'),Noeud(0.3,Feuille(0.1,'z'),Feuille(0.2,'y'))),Noeud(0.6,Feuille(0.3,'b'),Feuille(0.3,'c'))),
                        fusion(Noeud(0.6,Feuille(0.3,'b'),Feuille(0.3,'c'))::Noeud(0.3,Feuille(0.1,'z'),Feuille(0.2,'y'))::Feuille(0.1,'g')::Nil), 0.1)
  }
  
  /**
   * Test de construiction un arbre de Huffman
   */
  @Test
  def testCodeHuffman(){
    assertEqualsHuffman(Feuille(1.0,'a'), codeHuffman(('a',1.0)::Nil),0.1)
    assertEqualsHuffman(Noeud(1.0,Noeud(0.4,Feuille(0.1,'c'),Feuille(0.3,'a')),Feuille(0.6,'b')), codeHuffman(('a',0.3)::('b',0.6)::('c',0.1)::Nil),0.1)
  }
  
  /**
   * Test de les fréquences de chaque caractère
   */
  @Test
  def testAnalyseFrequences(){
    assertEquals(('a',1.0)::Nil, analyseFrequences("a"))
    assertEquals(('a',0.5)::('b',0.5)::Nil, analyseFrequences("ab"))
    assertEquals(('a',0.3)::('c',0.3)::('b',0.4)::Nil, analyseFrequences("acbabcabbc"))
  }
  
  
  /**
   * Test de la représentation de l'arbre de Huffman
   */
  @Test
  def testDescriptionHuffman(){
    assertEquals("00000000001100001", descriptionHuffman(Feuille(1.0,'a')))
    assertEquals("10000000000110000110000000000110001000000000001100011", 
                 descriptionHuffman(Noeud(1.0, Feuille(0.57, 'a'), Noeud(0.43, Feuille(0.10, 'b'), Feuille(0.33, 'c')))))
    assertEquals("10000000000110000100000000001100010", descriptionHuffman(Noeud(1.0,Feuille(0.5,'a'),Feuille(0.5,'b'))))
  }
  
  /**
   * Test de encodage la chaîne de caractères V3 (par la représentation de l'arbre de Huffman)
   */
  @Test
  def testEncodev3(){
    assertEquals("", encode(""))
    assertEquals("00000000001100001", encode("a"))
    assertEquals("100000000001100001000000000011000100101", encode("abab"))
  }
  
  /**
   * Test de décodage la chaîne de caractères V3 (en utilisant la représentation de l'arbre de Huffman)
   */
  @Test
  def testDecodev3(){
    assertEquals("c", decode("00000000001100011"))
    assertEquals("cd", decode("1000000000011000110000000000110010001"))
    assertEquals("zgzg", decode("100000000001111010000000000011001110101"))
  }
  

  // Pour écrire des tests unitaires qui comparent des Double,
  // il sera nécessaire d'utiliser l'assertion
  // def assertEquals(expected: Double, actual: Double, delta: Double): Unit
  // où le 3ème paramètre delta est la précision à utiliser.
  // On donne un exemple de test ci-dessous démontrant son utilisation.

  /**
   * Test qui illustre l'utilisation de l'assertion
   * assertEquals sur les Double
   */
  @Test
  def testEgaliteDouble() {
    // Exemple de problème d'imprécision sur les Double
    assertNotEquals(2.97, 2.8 + 0.17)

    // Problème résolu en utilisant une assertion spéciale à 3 paramètres Double
    assertEquals(2.97, 2.8 + 0.17, 0.01)

    // Selon la précision utilisée, deux Double sont soient égaux, soit différents
    assertEquals(0.001, 0.002, 0.001)
    assertNotEquals(0.001, 0.002, 0.0001)
  }

  // On vous fournit également une fonction auxiliaire permettant de
  // définir des tests pour contrôler l'"égalité" de deux arbres de Huffman.
  // Vous pouvez l'utiliser dans vos tests comme n'importe quelle autre assertion.

  /**
   * Vérifie que h1 et h2 sont égaux, en comparant les fréquences Double
   * avec la précision d. Echoue si ce n'est pas le cas.
   * @param h1 un arbre de Huffman
   * @param h2 un arbre de Huffman
   * @param d un double
   */
  def assertEqualsHuffman(h1: Huffman, h2: Huffman, d: Double): Unit = {
    (h1, h2) match {
      case (Feuille(f1, c1), Feuille(f2, c2)) => {
        assertEquals(f1, f2, d);
        assertEquals(c1, c2)
      }
      case (Noeud(f1, h11, h12), Noeud(f2, h21, h22)) =>
        assertEquals(f1, f2, d);
        assertEqualsHuffman(h11, h21, d);
        assertEqualsHuffman(h12, h22, d)
      case _ => fail("Les deux arbres n'ont pas la même structure")
    }
  }

}
