package fr.istic.si2.test.tp1.demoTests

import org.junit.Test
import org.junit.Assert._
import fr.istic.si2.testerApp._

import fr.istic.si2.tp1.demoTests.CodeATester
import fr.istic.si2.tp1.demoTests.CodeATester._

class MesTest {

  // Initialisation de l'application
  val _ = new AppInit(CodeATester)
  
  val fr = "FR"
  val eng = "ENG"
  val ger = "GER"

  val b_fr = "bonjour"
  val b_eng = "hello"
  val b_ger = "hallo"

  /**
   * test1
   */
  @Test
  def test1plus1 {
    // A compléter
    assertEquals(b_fr, bonjour(fr).toLowerCase())
  }

  /**
   * test2
   */
  @Test
  def test2plus1 {
    // A compléter
    assertEquals(b_eng, bonjour(eng).toLowerCase())
  }
  
  /**
   * test3
   */
  @Test
  def test3plus1 {
    // A compléter
    assertEquals(b_ger, bonjour(ger).toLowerCase())
  }

}

