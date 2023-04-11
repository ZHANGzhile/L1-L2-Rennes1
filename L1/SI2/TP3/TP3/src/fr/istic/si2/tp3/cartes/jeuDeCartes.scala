package fr.istic.si2.tp3.cartes

// Type des couleurs des cartes
sealed trait Couleur
case object Pique extends Couleur
case object Coeur extends Couleur
case object Carreau extends Couleur
case object Trefle extends Couleur

// Type des valeurs des cartes
sealed trait Valeur
case object As extends Valeur
case object Roi extends Valeur
case object Dame extends Valeur
case object Valet extends Valeur
case class Num(n: Int) extends Valeur // Attention, n doit être compris entre 2 et 10 !

// Type des cartes
case class Carte(c: Couleur, v: Valeur)

object ExoBase {

  /**
   * La carte représentant l'as de pique
   */
  val asPique: Carte = Carte(Pique,As)

  /**
   * La carte représentant le roi de coeur
   */
  val roiCoeur: Carte = Carte(Coeur,Roi)

  /**
   * La carte représentant le sept de carreau
   */
  val septCarreau: Carte = Carte(Carreau,Num(7))

}

object JeuCartes extends App {
  
  val x : Carte = Carte(Pique,Num(7))
  val y : Carte = Carte(Coeur,Num(7))
  val z : Carte = Carte(Pique,Num(7))

  /**
   * @param c une carte
   * @return vrai si et seulement si la carte c est une figure
   * @note un as n'est pas considéré ici comme une figure
   */
  // TODO 
  def estUneFigure(c: Carte): Boolean = {
    c match {
      
      case Carte(_, Num(_)) => true
      case _ => true
      
    }
  }

  /**
   * @param c1 une carte
   * @param c2 une carte
   * @return vrai si et seulement si c1 et c2 réalisent une condition de bataille
   */
  // TODO 
  def bataille(c1: Carte, c2: Carte): Boolean = {
    (c1.v == c2.v && c1.c != c2.c)
  }
  
  println(bataille(x,y))
  /**
   * @param c1 une carte
   * @param c2 une carte
   * @return la couleur commune de c1 et c2 (si elle existe!)
   */
  // TODO  - Vous devez définir cette version sans pattern-matching
  def couleurCommune(c1: Carte, c2: Carte): Option[Couleur] = {
   if(c1.c == c2.c) Some(c1.c)
   else None
  }
  println(couleurCommune(x,y))
  println(couleurCommune(x,z))
  /**
   * @param c1 une carte
   * @param c2 une carte
   * @return la couleur commune de c1 et c2 (si elle existe!)
   */
  // TODO  - Vous devez utiliser le pattern matching pour cette version
  def couleurCommunePM(c1: Carte, c2: Carte): Option[Couleur] = {
    (c1.c, c2.c) match { // On impose le filtrage du tuple (c1.c, c2.c) pour cet exercice
      case (c1.c , c2.c) => Some(c1.c)
      case _ => None
    }
  }

  /**
   * @param c une carte
   * @param ncouleur une couleur
   * @return la carte de même valeur que c et de couleur ncouleur
   */
  // TODO 
  def changeCouleur(c: Carte, ncouleur: Couleur): Carte = {
    Carte(ncouleur,c.v)
  }
  val newcouleur : Couleur = Trefle
  println(changeCouleur(x,newcouleur))
  /**
   * Définition du type alias Hand : un triplet de cartes
   */
  type Hand = (Carte, Carte, Carte)

  /**
   * @param h une main
   * @return toutes les couleurs des cartes de la main h, dans l'ordre
   */
  // TODO 
  def couleurs(h: Hand): (Couleur, Couleur, Couleur) = {
    (h._1.c, h._2.c, h._3.c)
  }

  /**
   * @param h une main
   * @return la main h contient la couleur rouge
   */
  // TODO  - Vous devez utiliser le pattern matching pour cet exercice
  def contientRouges(h: Hand): Boolean = {
    couleurs(h) match {
      case (Coeur,_,_) => true
      case (Carreau,_,_) => true
      case (_,Coeur,_) => true
      case (_,Carreau,_) => true
      case (_,_,Coeur) => true
      case (_,_,Carreau) => true
      case _ => false
    }
  }

}