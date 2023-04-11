package fr.istic.si2.test.tp3.restaurant

import org.junit.Test
import org.junit.Assert._
import util.Random
import fr.istic.si2.testerApp._
import fr.istic.si2.moreAssertions._

import fr.istic.si2.tp3.restaurant._
import fr.istic.si2.tp3.restaurant.Definitions._

class RestaurantDefinitionTest {
  /**
   *  La fonction commandeEntree est bien définie
   */
  @Test
  def commandeEntreeDefined() {
    isDefined(commandeEntree("foo"))
  }

  /**
   *  La fonction commandePlat est bien définie
   */
  @Test
  def commandePlatDefined() {
    isDefined(commandePlat("foo"))
  }

  /**
   *  La fonction commandeDessert est bien définie
   */
  @Test
  def commandeDessertDefined() {
    isDefined(commandeDessert("foo"))
  }

  /**
   *  La fonction prixEntree est bien définie
   */
  @Test
  def prixEntreeDefined() {
    isDefined(prixEntree(Melon))
  }

  /**
   *  La fonction prixPlat est bien définie
   */
  @Test
  def prixPlatDefined() {
    isDefined(prixPlat(PoissonDuJour))
  }

  /**
   *  La fonction prixDessert est bien définie
   */
  @Test
  def prixDessertDefined() {
    isDefined(prixDessert(SaladeDeFruits))
  }

  /**
   *  La fonction prixMenu est bien définie
   */
  @Test
  def prixMenuDefined() {
    isDefined(prixFormule(PetiteFaim(PoissonDuJour)))
  }

  /**
   *  La fonction changerDessert est bien définie
   */
  @Test
  def changerDessertDefined() {
    isDefined(changerDessert(PetiteFaim(PoissonDuJour), SaladeDeFruits))
  }

  /**
   *  La fonction changerOuAnnulerDessert est bien définie
   */
  @Test
  def changerOuAnnulerDessertDefined() {
    isDefined(changerOuAnnulerDessert(PetiteFaim(PoissonDuJour), None))
  }
}

class RestaurantCorrectionTest {

  /**
   * La fonction commandeEntree ne provoque pas d'erreur à l'exécution
   */
  @Test
  def commandeEntreeNoRTE() {
    noRTE(commandeEntree("Foie Gras"))
    noRTE(commandeEntree("Melon"))
    noRTE(commandeEntree("Crudités"))
    noRTE(commandeEntree("foo"))
  }

  /**
   * La fonction commandePlat ne provoque pas d'erreur à l'exécution
   */
  @Test
  def commandePlatNoRTE() {
    noRTE(commandePlat("Poisson du jour"))
    noRTE(commandePlat("Couscous"))
    noRTE(commandePlat("Couscous Vegetarien"))
    noRTE(commandePlat("Couscous Royal"))
    noRTE(commandePlat("Gratin"))
    noRTE(commandePlat("bar"))
  }

  /**
   * La fonction commandeDessert ne provoque pas d'erreur à l'exécution
   */
  @Test
  def commandeDessertNoRTE() {
    noRTE(commandeDessert("Salade de fruits"))
    noRTE(commandeDessert("Café"))
    noRTE(commandeDessert("Glace"))
    noRTE(commandeDessert("Glace chocolat"))
    noRTE(commandeDessert("Glace chantilly"))
    noRTE(commandeDessert("pimp"))
  }

  /**
   * Appel de p sur toutes les entrées
   * @param p Une fonction à appeler
   */
  def pourChaqueEntree(p: Entree => Unit): Unit = {
    p(FoieGras)
    p(Melon)
    p(Crudites)
  }

  /**
   * Appel de p sur tous les plats
   * @param p Une fonction à appeler
   */
  def pourChaquePlat(p: Plat => Unit): Unit = {
    p(PoissonDuJour)
    p(Gratin)
    p(Couscous(PouletMerguez))
    p(Couscous(Vegetarien))
    p(Couscous(Royal))
  }

  /**
   * Appel de p sur tous les desserts
   * @param p Une fonction à appeler
   */
  def pourChaqueDessert(p: Dessert => Unit): Unit = {
    p(SaladeDeFruits)
    p(Cafe)
    p(Glace(None))
    p(Glace(Some(Chocolat)))
    p(Glace(Some(Chantilly)))
  }

  /**
   * Appel de p sur toutes les formules possibles
   * @param p Une fonction à appeler
   */
  def pourChaqueMenu(p: Formule => Unit): Unit = {
    def testPlat(plat: Plat) {
      p(PetiteFaim(plat))

      def testEntree(entree: Entree) {
        p(EntreePlat(entree, plat))
        pourChaqueDessert((dessert: Dessert) => p(Complete(entree, plat, dessert)))
      }
      pourChaqueEntree(testEntree)

      pourChaqueDessert((dessert: Dessert) => p(PlatDessert(plat, dessert)))
    }
    pourChaquePlat(testPlat)
  }

  /**
   * La fonction prixEntree ne provoque pas d'erreur à l'exécution
   */
  @Test
  def prixEntreeNoRTE() {
    pourChaqueEntree((e: Entree) => noRTE(prixEntree(e)))
  }

  /**
   * La fonction prixPlat ne provoque pas d'erreur à l'exécution
   */
  @Test
  def prixPlatNoRTE() {
    pourChaquePlat((p: Plat) => noRTE(prixPlat(p)))
  }

  /**
   * La fonction prixDessert ne provoque pas d'erreur à l'exécution
   */
  @Test
  def prixDessertNoRTE() {
    pourChaqueDessert((d: Dessert) => noRTE(prixDessert(d)))
  }

  /**
   * La fonction prixMenu ne provoque pas d'erreur à l'exécution
   */
  @Test
  def prixMenuNoRTE() {
    pourChaqueMenu((m: Formule) => noRTE(prixFormule(m)))
  }

  /**
   * La fonction changerDessert ne provoque pas d'erreur à l'exécution
   */
  @Test
  def changerDessertNoRTE() {
    def testMenu(m: Formule) = {
      pourChaqueDessert((d: Dessert) => noRTE(changerDessert(m, d)))
    }
    pourChaqueMenu(testMenu)
  }

  /**
   * La fonction changerOuAnnulerDessert ne provoque pas d'erreur à l'exécution
   */
  @Test
  def changerOuAnnulerDessertNoRTE() {
    def testMenu(m: Formule) = {
      noRTE(changerOuAnnulerDessert(m, None))
      pourChaqueDessert((d: Dessert) => noRTE(changerOuAnnulerDessert(m, Some(d))))
    }
    pourChaqueMenu(testMenu)
  }

  /**
   * Test de la fonction commandeEntree avec FoieGras
   */
  @Test
  def commandeEntreeTestFoieGras {
    assertEquals(commandeEntree("Foie Gras"), Some(FoieGras))
  }

  /**
   * Test de la fonction commandeEntree avec Melon
   */
  @Test
  def commandeEntreeTestMelon {
    assertEquals(Some(Melon), commandeEntree("Melon"))
  }

  /**
   * Test de la fonction commandeEntree avec Crudite
   */
  @Test
  def commandeEntreeTestCrudite {
    assertEquals(Some(Crudites), commandeEntree("Crudités"))
  }

  /**
   * Test de la fonction commandeEntree avec None
   */
  @Test
  def commandeEntreeTestNone {
    assertEquals(None, commandeEntree("Hello"))
  }

  /**
   * Test de la fonction commandePlat avec PoissonDuJour
   */
  @Test
  def commandePlatTestPoisson() {
    assertEquals(Some(PoissonDuJour), commandePlat("Poisson du jour"))
  }

  /**
   * Test de la fonction commandePlat avec Gratin
   */
  @Test
  def commandePlatTestGratin() {
    assertEquals(Some(Gratin), commandePlat("Gratin"))
  }

  /**
   * Test de la fonction commandePlat avec Couscous
   */
  @Test
  def commandePlatTestCouscous() {
    assertEquals(Some(Couscous(PouletMerguez)), commandePlat("Couscous"))
  }

  /**
   * Test de la fonction commandePlat avec Couscous Vegetarien
   */
  @Test
  def commandePlatTestCouscousVege() {
    assertEquals(Some(Couscous(Vegetarien)), commandePlat("Couscous Végétarien"))
  }

  /**
   * Test de la fonction commandePlat avec Couscous Royal
   */
  @Test
  def commandePlatTestCouscousRoyal() {
    assertEquals(Some(Couscous(Royal)), commandePlat("Couscous Royal"))
  }

  /**
   * Test de la fonction commandePlat avec None
   */
  @Test
  def commandePlatTestNone() {
    assertEquals(None, commandePlat("world"))
  }

  /**
   * Test de la fonction commandeDessert avec Cafe
   */
  @Test
  def commandeDessertTestCafe() {
    assertEquals(Some(Cafe), commandeDessert("Café"))
  }

  /**
   * Test de la fonction commandeDessert avec SaladeDeFruits
   */
  @Test
  def commandeDessertTestSalade() {
    assertEquals(Some(SaladeDeFruits), commandeDessert("Salade de fruits"))
  }

  /**
   * Test de la fonction commandeDessert avec Glace
   */
  @Test
  def commandeDessertTestGlace() {
    assertEquals(Some(Glace(None)), commandeDessert("Glace"))
  }

  /**
   * Test de la fonction commandeDessert avec Glace Chocolat
   */
  @Test
  def commandeDessertTestGlaceChoco() {
    assertEquals(Some(Glace(Some(Chocolat))), commandeDessert("Glace chocolat"))
  }

  /**
   * Test de la fonction commandeDessert avec Glace Chantilly
   */
  @Test
  def commandeDessertTestGlaceChantilly() {
    assertEquals(Some(Glace(Some(Chantilly))), commandeDessert("Glace chantilly"))
  }

  /**
   * Test de la fonction commandeDessert avec None
   */
  @Test
  def commandeDessertTestNone() {
    assertEquals(None, commandeDessert("foo bar"))
  }

  /**
   * Test de la fonction prixEntree avec FoieGras
   */
  @Test
  def prixEntreeTestFoieGras() {
    assertEquals(8, prixEntree(FoieGras))
  }

  /**
   * Test de la fonction prixEntree avec Melon
   */
  @Test
  def prixEntreeTestMelon() {
    assertEquals(4, prixEntree(Melon))
  }

  /**
   * Test de la fonction prixEntree avec Crudite
   */
  @Test
  def prixEntreeTestCrudite() {
    assertEquals(5, prixEntree(Crudites))
  }

  /**
   * Test de la fonction prixPlat avec PoissonDuJour
   */
  @Test
  def prixPlatTestPoisson() {
    assertEquals(11, prixPlat(PoissonDuJour))
  }

  /**
   * Test de la fonction prixPlat avec Gratin
   */
  @Test
  def prixPlatTestGratin() {
    assertEquals(10, prixPlat(Gratin))
  }

  /**
   * Test de la fonction prixPlat avec Couscous
   */
  @Test
  def prixPlatTestCouscous() {
    assertEquals(12, prixPlat(Couscous(PouletMerguez)))
  }

  /**
   * Test de la fonction prixPlat avec Couscous Vegetarien
   */
  @Test
  def prixPlatTestCouscousVege() {
    assertEquals(10, prixPlat(Couscous(Vegetarien)))
  }

  /**
   * Test de la fonction prixPlat avec Couscous Royal
   */
  @Test
  def prixPlatTestCouscousRoyal() {
    assertEquals(14, prixPlat(Couscous(Royal)))
  }

  /**
   * Test de la fonction prixDessert avec Cafe
   */
  @Test
  def prixDessertTestCafe() {
    assertEquals(1, prixDessert(Cafe))
  }

  /**
   * Test de la fonction prixDessert avec SaladeDeFruits
   */
  @Test
  def prixDessertTestSalade() {
    assertEquals(4, prixDessert(SaladeDeFruits))
  }

  /**
   * Test de la fonction prixDessert avec Glace
   */
  @Test
  def prixDessertTestGlace() {
    assertEquals(5, prixDessert(Glace(None)))
  }

  /**
   * Test de la fonction prixDessert avec Glace Chocolat
   */
  @Test
  def prixDessertTestGlaceChoco() {
    assertEquals(6, prixDessert(Glace(Some(Chocolat))))
  }

  /**
   * Test de la fonction prixDessert avec Glace Chantilly
   */
  @Test
  def prixDessertTestGlaceChantilly() {
    assertEquals(7, prixDessert(Glace(Some(Chantilly))))
  }

  /**
   * Test de la fonction prixMenu
   */
  @Test
  def prixMenuTest() {
    def testPlat(plat: Plat) {
      assertEquals(prixPlat(plat), prixFormule(PetiteFaim(plat)))

      def testEntree(entree: Entree) {
        assertEquals(prixEntree(entree) + prixPlat(plat) - 1, prixFormule(EntreePlat(entree, plat)))
        pourChaqueDessert((dessert: Dessert) =>
          assertEquals(prixEntree(entree) + prixPlat(plat) + prixDessert(dessert) - 2, prixFormule(Complete(entree, plat, dessert))))
      }
      pourChaqueEntree(testEntree)

      pourChaqueDessert((dessert: Dessert) =>
        assertEquals(prixPlat(plat) + prixDessert(dessert) - 1, prixFormule(PlatDessert(plat, dessert))))
    }

    pourChaquePlat(testPlat)
  }

  /**
   * Test de la fonction changerDessert
   */
  @Test
  def changerDessertTest() {
    pourChaqueMenu((m: Formule) =>
      pourChaqueDessert((d: Dessert) => m match {
        case PetiteFaim(p)     => assertEquals(PlatDessert(p, d), changerDessert(m, d))
        case EntreePlat(e, p)  => assertEquals(Complete(e, p, d), changerDessert(m, d))
        case PlatDessert(p, _) => assertEquals(PlatDessert(p, d), changerDessert(m, d))
        case Complete(e, p, _) => assertEquals(Complete(e, p, d), changerDessert(m, d))
      }))
  }

  /**
   * Test de la fonction changerOuAnnulerDessert
   */
  @Test
  def changerOuAnnulerDessertTest() {
    pourChaqueMenu((m: Formule) => {
      pourChaqueDessert((d: Dessert) => m match {
        case PetiteFaim(p)     => assertEquals(PlatDessert(p, d), changerOuAnnulerDessert(m, Some(d)))
        case EntreePlat(e, p)  => assertEquals(Complete(e, p, d), changerOuAnnulerDessert(m, Some(d)))
        case PlatDessert(p, _) => assertEquals(PlatDessert(p, d), changerOuAnnulerDessert(m, Some(d)))
        case Complete(e, p, _) => assertEquals(Complete(e, p, d), changerOuAnnulerDessert(m, Some(d)))
      })

      m match {
        case PetiteFaim(p)     => assertEquals(PetiteFaim(p), changerOuAnnulerDessert(m, None))
        case EntreePlat(e, p)  => assertEquals(EntreePlat(e, p), changerOuAnnulerDessert(m, None))
        case PlatDessert(p, _) => assertEquals(PetiteFaim(p), changerOuAnnulerDessert(m, None))
        case Complete(e, p, _) => assertEquals(EntreePlat(e, p), changerOuAnnulerDessert(m, None))
      }
    })
  }
}