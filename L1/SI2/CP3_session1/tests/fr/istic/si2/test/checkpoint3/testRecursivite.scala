package fr.istic.si2.test.checkpoint3

import org.junit.Test
import org.junit.Assert._
import util.Random
import fr.istic.si2.testerApp._
import fr.istic.si2.moreAssertions._
import fr.istic.si2.checkpoint3.QuestionRecursivite
import fr.istic.si2.checkpoint3.QuestionRecursivite._
import fr.istic.si2.checkpoint3._
import fr.istic.si2.checkpoint.oracles.Oracles._
import fr.istic.si2.checkpoint.oracles.Consignes._
import fr.istic.si2.checkpoint.oracles.Consignes
import fr.istic.si2.checkpoint.oracles.{ Bit, Zero, One }

class RecursiviteDefinitionTest {
  val rand = new Random()
  val exos = parseFile("recursivite.scala", "fr.istic.si2.checkpoint3")

  /**
   * premierBitNonNul est bien définie
   */
  @Test(timeout = 30000)
  def premierBitNonNulDefined {
    isDefined(premierBitNonNul(Nil))
  }

  /**
   * premierBitNonNul est récursive directe, et n'utilise pas de boucle
   */
  @Test(timeout = 30000)
  def premierBitNonNulStyle {
    checkStyleRec(exos, "premierBitNonNul")
  }

  /**
   * nth est bien définie
   */
  @Test(timeout = 30000)
  def nthDefined {
    isDefined(nth(Nil, 0))
  }

  /**
   * nth est récursive directe, et n'utilise pas de boucle
   */
  @Test(timeout = 30000)
  def nthStyle {
    checkStyleRec(exos, "nth")
  }

  /**
   * lesPremiers est bien définie
   */
  @Test(timeout = 30000)
  def lesPremiersDefined {
    isDefined(lesPremiers(4, Nil))
  }

  /**
   * lesPremiers est récursive directe, et n'utilise pas de boucle
   */
  @Test(timeout = 30000)
  def lesPremiersStyle {
    checkStyleRec(exos, "lesPremiers")
  }

  /**
   * remplace est bien définie
   */
  @Test(timeout = 30000)
  def remplaceDefined {
    isDefined(remplace(Nil, 2, 3))
  }

  /**
   * remplace est récursive directe, et n'utilise pas de boucle
   */
  @Test(timeout = 30000)
  def remplaceStyle {
    checkStyleRec(exos, "remplace")
  }

}

class RecursiviteCorrectionTest {

  val rand = new Random()
  val exos = parseFile("recursivite.scala", "fr.istic.si2.checkpoint3")

  /**
   * @return un Bit au hasard
   */
  def genBit(): Bit = {
    if (rand.nextBoolean()) Zero else One
  }

  /**
   * premierBitNonNul est correcte - cas de base
   */
  @Test(timeout = 30000)
  def premierBitNonNulOKbase {
    assertEquals(oraclepremierBitNonNul(List[Bit]()), premierBitNonNul(Nil))
    for (_ <- 1 to 100) {
      val l = Seq.fill(Random.nextInt(40))(genBit()).toList
      assertEquals(oraclepremierBitNonNul(One :: l), premierBitNonNul(One :: l))
    }
  }

  /**
   * premierBitNonNul est correcte - cas récursifs
   */
  @Test(timeout = 30000)
  def premierBitNonNulOKother {
    for (_ <- 1 to 100) {
      val l = Seq.fill(Random.nextInt(40))(genBit()).toList
      assertEquals(oraclepremierBitNonNul(l), premierBitNonNul(l))
    }
  }

  /**
   * nth est correcte - cas de base
   */
  @Test(timeout = 30000)
  def nthOKbase {
    for (_ <- 1 to 1000) {
      val n = Random.nextInt(100)
      assertEquals(None, nth(Nil, n))
    }
  }

  /**
   * nth est correcte - cas récursifs
   */
  @Test(timeout = 30000)
  def nthOKother {
    for (_ <- 1 to 1000) {
      val n = 1 + Random.nextInt(100)
      val s = Random.nextString(5)
      val l = s :: Seq.fill(n)(Random.nextString(Random.nextInt(8))).toList
      val m = Random.nextInt(l.size)
      assertEquals(Some(l(m)), nth(l, m))
      assertEquals(None, nth(l, math.max(l.size, Random.nextInt(100))))
    }
  }

  /**
   * lesPremiers est correcte - cas de base
   */
  @Test(timeout = 30000)
  def lesPremiersOKbase {
    for (i <- 1 to 1000) {
      assertTrue(lesPremiers(Random.nextInt(50), Nil).isEmpty)
      assertEquals(oraclelesPremiers(i, Nil), lesPremiers(i, Nil))
    }
  }

  /**
   * lesPremiers est correcte - cas récursifs
   */
  @Test(timeout = 30000)
  def lesPremiersOKother {
    for (_ <- 1 to 100) {
      val l = Seq.fill(Random.nextInt(30))(Random.nextString(10)).toList
      val n = Random.nextInt(30)
      assertEquals(oraclelesPremiers(n, l), lesPremiers(n, l))
    }
  }

  /**
   * remplace est correcte - cas de base
   */
  @Test(timeout = 30000)
  def remplaceOKbase {
    assertTrue(remplace(Nil, Random.nextInt(100), Random.nextInt(100)).length == 0)
  }

  /**
   * remplace est correcte - cas récursifs
   */
  @Test(timeout = 30000)
  def remplaceOKother {
    for (_ <- 1 to 100) {
      val l = Seq.fill(Random.nextInt(100) + 1)(Random.nextInt()).toList
      val e1 = Random.nextInt()
      val e2 = Random.nextInt()
      assertEquals(oracleremplace(l, e1, e2), remplace(l, e1, e2))
      val e3 = l(Random.nextInt(l.length))
      val e4 = Random.nextInt()
      assertEquals(oracleremplace(l, e3, e4), remplace(l, e3, e4))
    }
  }

}

