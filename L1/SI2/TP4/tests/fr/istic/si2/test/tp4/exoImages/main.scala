package fr.istic.si2.test.tp4.exoImages

import org.junit.Test
import org.junit.Assert._
import fr.istic.si2.scribble._
import fr.istic.si2.testerApp._
import fr.istic.si2.moreAssertions._
import fr.istic.si2.tp4.exoImages.ExosImages._
import fr.istic.si2.tp4.exoImages.ExosImages

class ExosImagesDefinitionTest {

  val _ = new AppInit(ExosImages)

  /**
   * La fonction collierPerles est bien définie
   */
  @Test(timeout=100)
  def collierPerlesDefined {
    isDefined(collierPerles(10))
  }

  /**
   * La fonction immeuble est bien définie
   */
  @Test(timeout=100)
  def immeubleDefined {
    isDefined(immeuble(10))
  }

  /**
   * La fonction anneau est bien définie
   */
  @Test(timeout=100)
  def anneauDefined {
    isDefined(anneau(10))
  }

  /**
   * La fonction anneaux est bien définie
   */
  @Test(timeout=100)
  def anneauxDefined {
    isDefined(anneaux(10))
  }

  /**
   * La fonction guirlande est bien définie
   */
  @Test(timeout=100)
  def guirlandeDefined {
    isDefined(guirlande(10))
  }

  /**
   * La fonction guirlandeBis est bien définie
   */
  @Test(timeout=100)
  def guirlandeBisDefined {
    isDefined(guirlandeBis(10))
  }

}

class ExercicesImagesCorrectionTest {

  val _ = new AppInit(ExosImages)

  /**
   * La fonction collierPerles ne provoque pas d'erreur à l'execution
   */
  @Test(timeout=100)
  def collierPerlesNoRTE {
    noRTE(collierPerles(10))
  }

  /**
   * La fonction immeuble ne provoque pas d'erreur à l'execution
   */
  @Test(timeout=100)
  def immeubleNoRTE {
    noRTE(immeuble(10))
  }

  /**
   * La fonction anneaux ne provoque pas d'erreur à l'execution
   */
  @Test(timeout=100)
  def anneauxNoRTE {
    noRTE(anneaux(10))
  }

  /**
   * La fonction guirlande ne provoque pas d'erreur à l'execution
   */
  @Test(timeout=100)
  def guirlandeNoRTE {
    noRTE(guirlande(10))
  }
  
  /**
   * La fonction guirlandeBis ne provoque pas d'erreur à l'execution
   */
  @Test(timeout=100)
  def guirlandeBisNoRTE {
    noRTE(guirlandeBis(10))
  }



}
