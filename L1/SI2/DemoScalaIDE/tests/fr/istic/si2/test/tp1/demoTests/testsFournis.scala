package fr.istic.si2.test.tp1.demoTests

import org.junit.Test
import org.junit.Assert._
import fr.istic.si2.testerApp._
import fr.istic.si2.moreAssertions._

import fr.istic.si2.tp1.demoTests.CodeATester
import fr.istic.si2.tp1.demoTests.CodeATester._
import util.Random

class DemoDefinitionTest {

  // Initialisation de l'application
  val _ = new AppInit(CodeATester)

  // Un générateur aléatoire
  val rand = new Random()

  /**
   * La fonction plus1 est bien définie.
   */
  @Test
  def plus1Defined {
    isDefined(plus1(rand.nextInt()))
  }

  /**
   * La fonction bonjour est bien définie.
   */
  @Test
  def bonjourDefined {
    isDefined(bonjour(rand.nextString(3)))
  }

}

class DemoCorrectionTest {

  // Initialisation de l'application
  val _ = new AppInit(CodeATester)

  // Un générateur aléatoire
  val rand = new Random()

  /**
   * La fonction plus1 ne provoque pas d'erreur d'exécution
   */
  @Test
  def plus1NoRTE {
    for (_ <- 1 to 1000) noRTE(plus1(rand.nextInt()))
  }

  /**
   * Test de la fonction plus1.
   * Elle rend le bon résultat sur 1000 entiers tirés au hasard
   */
  @Test
  def plus1Test {
    for (k <- 1 to 1000) {
      val i: Int = rand.nextInt()
      assertEquals(i + 1, plus1(i))
    }
  }

  // Quelques constantes
  val fr = "FR"
  val eng = "ENG"
  val ger = "GER"

  val b_fr = "bonjour"
  val b_eng = "hello"
  val b_ger = "hallo"

  /**
   * La fonction bonjour ne provoque pas d'erreur d'exécution sur les arguments attendus
   */
  @Test
  def bonjourNoRTEfr {
    noRTE(bonjour(fr))
  }

  /**
   * La fonction bonjour ne provoque pas d'erreur d'exécution sur les arguments attendus
   */
  @Test
  def bonjourNoRTEeng {
    noRTE(bonjour(eng))
  }

  /**
   * La fonction bonjour ne provoque pas d'erreur d'exécution sur les arguments attendus
   */
  @Test
  def bonjourNoRTEger {
    noRTE(bonjour(ger))
  }

  /**
   * Test de la fonction bonjour.
   * La fonction rend le bon résultat sur "FR".
   * Le résultat attendu n'est pas sensible à la casse.
   */
  @Test
  def bonjourFR {
    assertEquals(b_fr, bonjour(fr).toLowerCase())
  }

  /**
   * Test de la fonction bonjour.
   * La fonction rend le bon résultat sur "ENG".
   * Le résultat attendu n'est pas sensible à la casse.
   */
  @Test
  def bonjourENG {
    assertEquals(b_eng, bonjour(eng).toLowerCase())
  }

  /**
   * Test de la fonction bonjour.
   * La fonction rend le bon résultat sur "GER".
   * Le résultat attendu n'est pas sensible à la casse.
   */
  @Test
  def bonjourGER {
    assertEquals(b_ger, bonjour(ger).toLowerCase())
  }

}

