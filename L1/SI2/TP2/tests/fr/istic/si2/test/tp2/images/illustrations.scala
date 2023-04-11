package fr.istic.si2.test.tp2.images

import org.junit.Test
import org.junit.Assert._
import util.Random
import fr.istic.si2.scribble._
import fr.istic.si2.testerApp._
import fr.istic.si2.tp2.images.ImageMeteo._
import fr.istic.si2.tp2.images._
import fr.istic.si2.moreAssertions._

class ImagesMeteoDefinitionTest {

  val rand = new Random()
  val _ = new AppInit(ImageMeteo)

  /**
   * temps est bien définie
   */
  @Test
  def tempsDefined {
    isDefined(temps(rand.nextString(4)))
  }

  /**
   * tempsPossible est bien définie
   */
  @Test
  def tempsPossibleDefined {
    isDefined(tempsPossible(rand.nextString(4)))
  }

}

class ImagesMeteoCorrectionTest {

  val rand = new Random()
  val _ = new AppInit(ImageMeteo)

  val couvert = "couvert"
  val gris = "gris"
  val beau = "beau"

  /**
   * temps ne produit pas d'erreur à l'exécution sur les arguments imposés.
   */
  @Test
  def tempsNoRTEcouvert {
    noRTE(temps(couvert))
  }

  /**
   * temps ne produit pas d'erreur à l'exécution sur les arguments imposés.
   */
  @Test
  def tempsNoRTEbeau {
    noRTE(temps(beau))
  }

  /**
   * temps ne produit pas d'erreur à l'exécution sur les arguments imposés.
   */
  @Test
  def tempsNoRTEgris {
    noRTE(temps(gris))
  }

  /**
   * temps produit des images différentes pour les temps possibles
   */
  @Test
  def tempsDifferents {
    val tl: List[Image] = List(couvert, gris, beau).map(temps)
    assertEquals(3, tl.toSet.size)
  }

  /**
   * tempsPossible ne produit pas d'erreur à l'exécution
   */
  @Test
  def tempsPossibleNoRTE {
    for (_ <- 1 to 10) {
      for (i <- 0 to 8) noRTE(tempsPossible(rand.nextString(i)))
      for (s <- List(couvert, gris, beau)) noRTE(tempsPossible(s))
    }

  }

  /**
   * tempsPossible produit le bon résultat
   */
  @Test
  def tempsPossibleOKcouvert {
    assertTrue(tempsPossible(couvert))
  }

  /**
   * tempsPossible produit le bon résultat
   */
  @Test
  def tempsPossibleOKgris {
    assertTrue(tempsPossible(gris))
  }

  /**
   * tempsPossible produit le bon résultat
   */
  @Test
  def tempsPossibleOKbeau {
    assertTrue(tempsPossible(beau))
  }

  /**
   * tempsPossible produit le bon résultat
   */
  @Test
  def tempsPossibleOKother {
    for (_ <- 1 to 10) {
      for (i <- 0 to 10) assertFalse(tempsPossible(rand.nextString(i)))
    }
  }

}


