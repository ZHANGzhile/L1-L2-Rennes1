package fr.istic.si2.test.tp4.exosCalcul

import org.junit.Test

import org.junit.Assert._
import util.Random
import fr.istic.si2.testerApp._
import fr.istic.si2.moreAssertions._
import fr.istic.si2.math._
import fr.istic.si2.tp4.exosCalcul.ExosCalculs._
import fr.istic.si2.tp4.exosCalcul.ExosCalculs

import java.io.PrintStream

class ExosEntiersDefinitionTest {

  val _ = new AppInit(ExosCalculs)

  val baos = new java.io.ByteArrayOutputStream

  /**
   * La fonction copie est bien définie
   */
  @Test(timeout = 100)
  def copieDefined {
    Console.withOut(baos) {
      isDefined(copie(100, "a"))
    }
  }

  /**
   * La fonction repeat est bien définie
   */
  @Test(timeout = 100)
  def repeatDefined {
    Console.withOut(baos) {
      isDefined(repeat(100, 'a'))
    }
  }

  /**
   * La fonction countDown est bien définie
   */
  @Test(timeout = 100)
  def countDownDefined {
    Console.withOut(baos) {
      isDefined(countDown(10))
    }
  }

  /**
   * La fonction nombreCarre est bien définie
   */
  @Test(timeout = 100)
  def nombreCarreDefined {
    isDefined(nombreCarre(10))
  }

}

class ExercicesEntiersCorrectionTest {

  val _ = new AppInit(ExosCalculs)

  val baos = new java.io.ByteArrayOutputStream

  /**
   * @param n entier positif
   * @param s une chaîne
   * @return copie(n,s)
   */
  def copieIter(n: Int, s: String): String = {
    var x = s
    if (n == 0) ""
    else {
      for (_ <- 2 to n) {
        x = x + "-" + s
      }
      x
    }
  }

  /**
   * La fonction copie ne provoque pas d'erreur à l'execution
   */
  @Test(timeout = 1000)
  def copieNoRTE {
    Console.withOut(baos) {
      noRTE(copie(1000, "essai"))
      noRTE(copie(1000, "bonjour"))
    }
  }

  /**
   * La fonction copie est correcte pour n=0
   */
  @Test(timeout = 1000)
  def copieCorrect0 {
    Console.withOut(baos) {
      assertEquals("", copie(0, "essai"))
      assertEquals("", copie(0, "bonjour"))
      assertEquals("", copie(0, "foo"))
      assertEquals("", copie(0, "SI2"))
    }
  }

  /**
   * La fonction copie est correcte
   */
  @Test(timeout = 1000)
  def copieCorrect {
    Console.withOut(baos) {
      assertEquals(copieIter(100, "essai"), copie(100, "essai"))
      assertEquals(copieIter(100, "bonjour"), copie(100, "bonjour"))
      assertEquals(copieIter(100, "foo"), copie(100, "foo"))
      assertEquals(copieIter(100, "SI2"), copie(100, "SI2"))
    }
  }

  /**
   * @param n entier positif
   * @param c un char
   * @return la string représentant repeat(n,s)
   */
  def repeatIterString(n: Int, c: Char): String = {
    if (n == 0) ""
    else {
      var x = "" + c
      for (_ <- 2 to n) {
        x = x + util.Properties.lineSeparator + c
      }
      x
    }
  }

  /**
   * La fonction repeat ne provoque pas d'erreur à l'execution
   */
  @Test(timeout = 1000)
  def repeatNoRTE {
    Console.withOut(baos) {
      noRTE(repeat(1000, 'a'))
      noRTE(repeat(1000, 'b'))
    }
  }
  /**
   * La fonction repeat a un bon cas de base
   */
  @Test(timeout = 1000)
  def repeatCorrect0 {
    Console.withOut(baos) {
      repeat(0, 'a')
      assertEquals(repeatIterString(0, 'a'), baos.toString())
    }
  }
  /**
   * La fonction repeat est correcte
   */
  @Test(timeout = 1000)
  def repeatCorrect {
    Console.withOut(baos) {
      repeat(100, 'a')
      assertEquals(repeatIterString(100, 'a'), baos.toString())
    }
  }

  /**
   * @param n un entier positif
   * @return la chaîne affichée dans la console par countDown(n)
   */
  def countDownIterString(n: Int): String = {
    var s = "Time OUT !"
    for (i <- 1 to n) {
      s = i.toString() + util.Properties.lineSeparator + s
    }
    s
  }

  /**
   * La fonction countDown ne provoque pas d'erreur à l'execution
   */
  @Test(timeout = 1000)
  def countDownNoRTE {
    Console.withOut(baos) {
      noRTE(countDown(1000))
    }
  }
  /**
   * La fonction countDown a un bon cas de base
   */
  @Test(timeout = 1000)
  def countDownCorrect0 {
    Console.withOut(baos) {
      countDown(0)
      assertEquals(countDownIterString(0), baos.toString())
    }
  }
  /**
   * La fonction countDown est correcte
   */
  @Test(timeout = 1000)
  def countDownCorrect {
    Console.withOut(baos) {
      countDown(100)
      assertEquals(countDownIterString(100), baos.toString())
    }
  }

  /**
   * La fonction nombreCarre ne provoque pas d'erreur à l'execution
   */
  @Test(timeout = 1000)
  def nombreCarreNoRTE {
    for (i <- 1 to 1000) noRTE(nombreCarre(i))
    try {
      nombreCarre(0)
      fail()
    } catch {
      case e: java.lang.StackOverflowError => ()
      case _: Throwable                    => fail("Vérifiez votre spécification, et vos cas de base !")
    }
  }

  /**
   * La fonction nombreCarre calcule bien le carré
   */
  @Test(timeout = 100)
  def nombreCarreCorrect {
    try {
      for (x <- 1 to 1000) {
        assertEquals( x * x, nombreCarre(x))
      }
    } catch {
      case e: java.lang.StackOverflowError => ()
    }

  }

}
