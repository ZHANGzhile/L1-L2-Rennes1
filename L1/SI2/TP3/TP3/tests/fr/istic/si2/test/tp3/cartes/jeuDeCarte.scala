package fr.istic.si2.test.tp3.cartes

import org.junit.Test
import org.junit.Assert._
import util.Random
import fr.istic.si2.testerApp._
import fr.istic.si2.moreAssertions._

import fr.istic.si2.tp3.cartes._
import fr.istic.si2.tp3.cartes.JeuCartes._
import fr.istic.si2.tp3.cartes.ExoBase._

class JeuCartesDefinitionTest {
  val _ = new AppInit(JeuCartes)

  val CARTE: Carte = Carte(Trefle, As)
  val MAIN: Hand = (CARTE, CARTE, CARTE)

  /**
   * asPique, roiCoeur et septCarreau sont bien définies
   */
  @Test
  def asPicRoiCoeurSeptCarreauDefined {
    isDefined(asPique)
    isDefined(roiCoeur)
    isDefined(septCarreau)
  }

  /**
   *  La fonction bataille est bien définie
   */
  @Test
  def batailleDefined() {
    isDefined(bataille(CARTE, CARTE))
  }

  /**
   *  La fonction couleurCommunePM est bien définie
   */
  @Test
  def couleurCommunePMDefined() {
    isDefined(couleurCommunePM(CARTE, CARTE))
  }

  /**
   *  La fonction couleurCommune est bien définie
   */
  @Test
  def couleurCommuneDefined() {
    isDefined(couleurCommune(CARTE, CARTE))
  }

  /**
   *  La fonction estUneFigure est bien définie
   */
  @Test
  def estUneFigureDefined() {
    isDefined(estUneFigure(CARTE))
  }

  /**
   *  La fonction couleurs est bien définie
   */
  @Test
  def couleursDefined() {
    isDefined(couleurs(MAIN))
  }

  /**
   *  La fonction contientRouges est bien définie
   */
  @Test
  def contientRougesDefined() {
    isDefined(contientRouges(MAIN))
  }

  /**
   *  La fonction changeCouleur est bien définie
   */
  @Test
  def changeCouleurDefined() {
    isDefined(changeCouleur(CARTE, Trefle))
  }

}

class JeuCartesCorrectionTest {
  val _ = new AppInit(JeuCartes)
  val rand = new Random()

  /**
   * @param p Un prédicat sur les couleurs
   * @return true si p est vérifié pour chaque couleur
   */
  def pourChaqueCouleur(p: Couleur => Boolean): Boolean = {
    p(Pique) && p(Coeur) && p(Carreau) && p(Trefle)
  }

  /**
   * @param p Un prédicat sur les valeurs
   * @param min Une borne inférieure
   * @param max Une borne supérieure
   * @return true si p est vérifié pour chaque valeur Num entre min et max
   */
  def pourChaqueNum(p: Valeur => Boolean, min: Int, max: Int): Boolean = {
    min > max || (p(Num(min)) && pourChaqueNum(p, min + 1, max))
  }

  /**
   * @param p Un prédicat sur les valeurs
   * @return true si p est vérifié pour chaque valeur
   */
  def pourChaqueValeur(p: Valeur => Boolean): Boolean = {
    p(Valet) && p(Dame) && p(Roi) && p(As) && pourChaqueNum(p, 2, 10)
  }

  /**
   * @param p Un prédicat sur les cartes
   * @return true si p est vérifié pour chaque carte
   */
  def pourChaqueCarte(p: Carte => Boolean): Boolean = {
    pourChaqueCouleur((c: Couleur) => pourChaqueValeur((v: Valeur) => p(Carte(c, v))))
  }

  /**
   * @param p Un prédicat sur les couples de cartes
   * @return true si p est vérifié pour chaque couple
   */
  def pourChaqueCouple(p: Carte => Carte => Boolean): Boolean = {
    pourChaqueCarte((a: Carte) => pourChaqueCarte((b: Carte) => p(a)(b)))
  }

  /**
   * @return une couleur aléatoire
   */
  def randomColor(): Couleur = {
    (rand.nextInt() % 4) match {
      case 0 => Trefle
      case 1 => Carreau
      case 2 => Pique
      case _ => Coeur
    }
  }

  /**
   * @return une couleur noire aléatoire
   */
  def randomBlackColor(): Couleur = {
    (rand.nextInt() % 2) match {
      case 0 => Trefle
      case _ => Pique
    }
  }

  /**
   * @return une couleur rouge aléatoire
   */
  def randomRedColor(): Couleur = {
    (rand.nextInt() % 2) match {
      case 0 => Carreau
      case _ => Coeur
    }
  }

  /**
   * @return une valeur aléatoire
   */
  def randomValue(): Valeur = {
    (rand.nextInt() % 13) + 1 match {
      case 1      => As
      case 11     => Valet
      case 12     => Dame
      case 13     => Roi
      case n: Int => Num(n)
    }
  }

  /**
   * @return une carte aléatoire
   */
  def randomCard(): Carte = {
    Carte(randomColor(), randomValue())
  }

  /**
   * @return une carte noire aléatoire
   */
  def randomBlackCard(): Carte = {
    Carte(randomBlackColor(), randomValue())
  }

  /**
   * @return une carte rouge aléatoire
   */
  def randomRedCard(): Carte = {
    Carte(randomRedColor(), randomValue())
  }

  /**
   * @return une main aléatoire
   */
  def randomHand(): Hand = {
    (randomCard(), randomCard(), randomCard())
  }

  /**
   * @return une main aléatoire contenant au moins une carte rouge
   */
  def randomRedHand(): Hand = {
    (rand.nextInt() % 3) match {
      case 0 => (randomRedCard(), randomCard(), randomCard())
      case 1 => (randomCard(), randomRedCard(), randomCard())
      case _ => (randomCard(), randomCard(), randomRedCard())
    }
  }

  /**
   * asPique est correcte
   */
  @Test
  def asPicTest() {
    assertTrue(asPique.c == Pique && asPique.v == As)
  }

  /**
   * roiCoeur est correcte
   */
  @Test
  def roiCoeurTest() {
    assertTrue(roiCoeur.c == Coeur && roiCoeur.v == Roi)
  }

  /**
   * septCarreau est correcte
   */
  @Test
  def septCarreauTest() {
    assertTrue(septCarreau.c == Carreau && septCarreau.v == Num(7))
  }

  /**
   *  Test de la fonction estUneFigure
   */
  @Test
  def estUneFigureTest() {
    val pred = ((a: Carte) =>
      a.v match {
        case Num(_) | As => !estUneFigure(a)
        case _           => estUneFigure(a)
      })

    assertTrue(pourChaqueCarte(pred))
  }

  /**
   *  Test de la fonction bataille
   */
  @Test
  def batailleTest() {
    assertTrue(pourChaqueCouple((a: Carte) => (b: Carte) => (a.v == b.v) == bataille(a, b)))
  }

  /**
   *  Test de la fonction couleurCommunePM
   */
  @Test
  def couleurCommunePMTest() {
    assertTrue(pourChaqueCouple((a: Carte) => (b: Carte) => {
      couleurCommunePM(a, b) match {
        case Some(c) => a.c == c && b.c == c
        case None    => a.c != b.c
      }
    }))
  }

  /**
   *  Test de la fonction couleurCommune
   */
  @Test
  def couleurCommuneTest() {
    assertTrue(pourChaqueCouple((a: Carte) => (b: Carte) => {
      couleurCommune(a, b) match {
        case Some(c) => a.c == c && b.c == c
        case None    => a.c != b.c
      }
    }))
  }

  /**
   *  Test de la fonction changeCouleur
   */
  @Test
  def changeCouleurTest() {
    assertTrue(pourChaqueCarte((a: Carte) => pourChaqueCouleur((c: Couleur) => {
      val ancienne_valeur = a.v
      val nouvelle_carte = changeCouleur(a, c)
      nouvelle_carte.c == c && nouvelle_carte.v == ancienne_valeur
    })))
  }

  /**
   * La fonction couleurs ne provoque pas d'erreur à l'exécution
   */
  @Test
  def couleursNoRTE {
    for (_ <- 1 to 100) noRTE(couleurs(randomHand()))

  }

  /**
   *  Test de la fonction couleurs
   *  Non exhaustif
   */
  @Test
  def couleursTest() {
    val hand: Hand = randomHand()
    val colors = couleurs(hand)
    assertTrue(hand._1.c == colors._1 && hand._2.c == colors._2 && hand._3.c == colors._3)
  }

  /**
   * La fonction contientRouges ne provoque pas d'erreur à l'exécution
   */
  @Test
  def contientRougesNoRTE {
    for (_ <- 1 to 100) noRTE(contientRouges(randomHand()))
  }

  /**
   *  Test de la fonction contientRouges (cas positif)
   *  Non exhaustif
   */
  @Test
  def contientRougesTestPositif() {
    for (_ <- 1 to 500) {
      val hand: Hand = randomRedHand()
      assertTrue(contientRouges(hand))
    }
  }

  /**
   *  Test de la fonction contientRouges (cas négatif)
   *  Non exhaustif
   */
  @Test
  def contientRougesTestNegatif() {
    for (_ <- 1 to 500) {
      val hand: Hand = (randomBlackCard(), randomBlackCard(), randomBlackCard())
      assertFalse(contientRouges(hand))
    }
  }

}