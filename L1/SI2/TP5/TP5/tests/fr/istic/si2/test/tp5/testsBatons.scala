package fr.istic.si2.test.tp5

import org.junit.Test
import org.junit.Assert._
import fr.istic.si2.scribble._
import fr.istic.si2.testerApp._
import fr.istic.si2.moreAssertions._
import fr.istic.si2.tp5._
import fr.istic.si2.tp5.ExosBatons._

class TestsExosBatons {

  val _ = new AppInit(ExosBatons) // Ne pas supprimer

  /**
   * Tests de la fonction plus : 0 = 0 + 0 
   */
  @Test(timeout=100)
  def plusZero() {
    assertEquals(Zero,plus(Zero,Zero))
  }
  
  /**
   * Tests de la fonction plus : 1 = 1 + 0 
   */
  @Test(timeout=100)
  def plusTest1() {
    assertEquals(Baton(Zero),plus(Baton(Zero),Zero))
  }
  
  // A vous de compléter les jeux de test pour tester vos fonctions !
  // Inspirez-vous des exemples ci-dessus
  /**
   * Tests de la fonction supOuEgal : Baton(Zero) superieur Zero)
   */
  @Test(timeout=100)
  def supTest1() {
    assertEquals(true,supOuEgal(Baton(Zero),Zero))
  }
  


}
