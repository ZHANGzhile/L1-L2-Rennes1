package fr.istic.si2.test.tp2.exercices

import org.junit.Test
import org.junit.Assert._
import util.Random
import fr.istic.si2.testerApp._
import fr.istic.si2.moreAssertions._

import fr.istic.si2.tp2.exercices.ExosBasiques._
import fr.istic.si2.tp2.exercices.ExosBasiques

class ExosBasiquesDefinitionTest {

  val _ = new AppInit(ExosBasiques)
  val rand = new Random()

  /**
   *  La fonction double est bien définie
   */
  @Test
  def doubleDefined {
    isDefined(double(rand.nextInt()))
  }

  /**
   *  La fonction quadruple est bien définie
   */
  @Test
  def quadrupleDefined {
    isDefined(quadruple(rand.nextInt()))
  }

  /**
   * La fonctions unite est bien définie
   */
  @Test
  def uniteDefined {
    isDefined(unite(rand.nextInt()))
  }

  /**
   * La fonction dizaine est bien définie
   */
  @Test
  def dizaineDefined {
    isDefined(dizaine(rand.nextInt()))
  }

  /**
   * La fonction signe est bien définie
   */
  @Test
  def signeDefined {
    isDefined(signe(rand.nextInt()))
  }

  /**
   * La fonction renverser est bien définie
   */
  @Test
  def renverserDefined {
    isDefined(renverser(rand.nextInt()))
  }

}

class ExosBasiquesCorrectionTest {

  val rand = new Random()
  val _ = new AppInit(ExosBasiques)

  /**
   * @return en entier dans { -1, 1 }
   */
  def nextSign: Int = {
    if (rand.nextBoolean()) { +1 } else { -1 }
  }

  /**
   * La fonction double ne leve pas d'erreur à l'exécution
   */
  @Test
  def doubleNoRTE {
    for (_ <- 1 to 10000) noRTE(double(rand.nextInt()))
  }

  /**
   * Tests de la fonction double
   */
  @Test
  def doubleOKres {
    for (i <- 1 to 10000) {
      val entier = rand.nextInt()
      assertEquals(2 * entier, double(entier))
    }
  }

  /**
   * La fonction quadruple ne leve pas d'erreur à l'exécution
   */
  @Test
  def quadrupleNoRTE {
    for (_ <- 1 to 10000) noRTE(quadruple(rand.nextInt()))
  }

  /**
   * Tests de la fonction quadruple
   */
  @Test
  def quadrupleOKres {
    for (_ <- 1 to 10000) {
      val entier = rand.nextInt()
      assertEquals(4 * entier, quadruple(entier))
    }
  }

  /**
   * La fonction unite ne leve pas d'erreur à l'exécution
   */
  @Test
  def uniteNoRTE {
    for (_ <- 1 to 10000) noRTE(unite(nextSign * rand.nextInt()))
  }

  /**
   * Tests de la fonction unite pour entiers entre -9 et 9
   * NB: fonction fournie
   */
  @Test
  def uniteOKresChiffres {
    for (i <- 0 to 9) {
      assertEquals(i, unite(nextSign * i))
    }
  }

  /**
   * Tests de la fonction unite pour entiers entre -999 et 999
   * NB: fonction fournie
   */
  @Test
  def uniteOKres999 {
    for (u <- 0 to 9) {
      for (d <- 0 to 9) {
        for (c <- 0 to 9) {
          val entier = 100 * c + 10 * d + u
          assertEquals(u, unite(nextSign * entier))
        }
      }
    }
  }

  /**
   * Tests de la fonction unite pour 1000 entiers.
   * Son résultat doit être dans [0 ; 9]
   * NB: fonction fournie
   */
  @Test
  def uniteOKres9 {
    for (i <- 1 to 1000) {
      val entier = rand.nextInt()
      val unit = unite(nextSign * entier)
      assertTrue(unit < 10 && unit >= 0)
    }
  }

  /**
   * La fonction dizaine ne leve pas d'erreur à l'exécution
   */
  @Test
  def dizaineNoRTE {
    for (_ <- 1 to 1000) noRTE(dizaine(nextSign * rand.nextInt()))
  }

  /**
   * Tests de la fonction dizaine pour entiers entre -999 et 999
   * NB: fonction fournie
   */
  @Test
  def dizaineOKresRandom {
    for (u <- 0 to 9) {
      for (d <- 0 to 9) {
        for (c <- 0 to 9) {
          val entier = 100 * c + 10 * d + u
          assertEquals(d, dizaine(nextSign * entier))
        }
      }
    }
  }

  /**
   * Tests de la fonction dizaine pour 10000 entiers.
   * Son résultat doit être [0 ; 9]
   * NB: fonction fournie
   */
  @Test
  def dizaineTestResult {
    for (i <- 1 to 10000) {
      val entier = rand.nextInt()
      val diz = dizaine(nextSign * entier)
      assertTrue(diz < 10 && diz >= 0)
    }
  }

  /**
   * La fonction signe ne provoque pas d'erreur à l'exécution
   */
  @Test
  def signeNoRTE {
    for (_ <- 1 to 1000) noRTE(signe(rand.nextInt()))
  }

  /**
   * Tests de la fonction signe pour 10000 entiers.
   */
  @Test
  def signeTestRand1000 {
    for (i <- 1 to 10000) {
      val s = nextSign
      val entier = s * (math.abs(rand.nextInt()))
      if (s < 0) { assertFalse(signe(entier)) }
      else { assertTrue(signe(entier)) }
    }
  }

  /**
   * La fonction renverser ne provoque pas d'erreur à l'exécution
   */
  @Test
  def renverserNoRTE {
    for (_ <- 1 to 10000) noRTE(renverser(nextSign * rand.nextInt(99)))
  }
  
  
  /**
   * Tests de la fonction renverser pour les entiers de -99 à 99
   */
  @Test
  def renverserTestExhaustif {
    for (u <- 0 to 9) {
      for (d <- 0 to 9) {
        val s = nextSign
        assertEquals(s * ((10 * u) + d), renverser(s * (10 * d + u)))
      }
    }
  }

}
