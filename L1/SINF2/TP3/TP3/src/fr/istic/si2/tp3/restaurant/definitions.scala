package fr.istic.si2.tp3.restaurant

import scala.io.StdIn._

// Le type des entrées
sealed trait Entree
case object FoieGras extends Entree
case object Melon extends Entree
case object Crudites extends Entree

// Le type des accompagnements de couscous
sealed trait Genre
case object Vegetarien extends Genre
case object PouletMerguez extends Genre
case object Royal extends Genre

// Le type des plats
sealed trait Plat
case object PoissonDuJour extends Plat
case object Gratin extends Plat
case class Couscous(g: Genre) extends Plat

// Le type des suppléments
sealed trait Supplement
case object Chocolat extends Supplement
case object Chantilly extends Supplement

// Le type des desserts
sealed trait Dessert
case object SaladeDeFruits extends Dessert
case object Cafe extends Dessert
case class Glace(supp: Option[Supplement]) extends Dessert

// Le type des formules
sealed trait Formule
case class PetiteFaim(p: Plat) extends Formule
case class EntreePlat(e: Entree, p: Plat) extends Formule
case class PlatDessert(p: Plat, d: Dessert) extends Formule
case class Complete(e: Entree, p: Plat, d: Dessert) extends Formule

// Les fonctions de gestion de prise de commandes
object Definitions {

  /**
   * @param nom une chaîne quelconque
   * @return une entrée proposées à la carte correspondant à nom, si elle existe
   * @note les entrées proposées à la carte sont "Foie Gras", "Melon" et "Crudités"
   */
  // TODO 
  def commandeEntree(nom: String): Option[Entree] = {
    nom match {
      case "Foie Gras" => Some(FoieGras)
      case "Melon" => Some(Melon)
      case "Crudités" => Some(Crudites)
      case _ => None
    }
  }

  /**
   * @param nom une chaîne quelconque
   * @return un plat proposé à la carte correspondant à nom, s'il existe
   * @note les plats proposés à la carte sont indiqués dans l'énoncé
   */
  // TODO 
  def commandePlat(nom: String): Option[Plat] = {
    nom match {
      case "Gratin" => Some(Gratin)
      case "Poisson du jour" => Some(PoissonDuJour)
      case "Couscous" => Some(Couscous(PouletMerguez))
      case "Couscous Végétarien" => Some(Couscous(Vegetarien))
      case "Couscous Royal" => Some(Couscous(Royal))
      
      case _ => None
    }
  }

  /**
   * @param nom une chaîne quelconque
   * @return un dessert proposé à la carte correspondant à nom, s'il existe
   * @note les desserts proposés à la carte sont indiqués dans l'énoncé
   */
  // TODO 
  def commandeDessert(nom: String): Option[Dessert] = {
    nom match{
      case "Café" => Some(Cafe)
      case "Salade de fruits" => Some(SaladeDeFruits)
      case "Glace" => Some(Glace(None))
      case "Glace chocolat" => Some(Glace(Some(Chocolat)))
      case "Glace chantilly" => Some(Glace(Some(Chantilly)))
      
      case _ => None
    }
  }

  /**
   * @param e une entrée
   * @return le prix de e en € sur le menu
   */
  // TODO 
  def prixEntree(e: Entree): Int = {
    e match {
      case FoieGras => 8
      case Melon => 4
      case Crudites => 5
    }
  }

  /**
   * @param p un plat
   * @return le prix de p en € sur le menu
   */
  // TODO 
  def prixPlat(p: Plat): Int = {
    p match{
      case Gratin => 10
      case PoissonDuJour => 11
      case Couscous(PouletMerguez) => 12
      case Couscous(Vegetarien) => 10
      case Couscous(Royal) => 14
    }
  }

  /**
   * @param d un dessert
   * @return le prix de d en € sur le menu
   */
  // TODO 
  def prixDessert(d: Dessert): Int = {
    d match{
      case Cafe => 1
      case SaladeDeFruits => 4
      case Glace(None) => 5
      case Glace(Some(Chocolat)) => 6
      case Glace(Some(Chantilly)) => 7
    }
  }

  /**
   * @param f une formule
   * @return le prix de f en € sur le menu
   */
  // TODO 
  def prixFormule(f: Formule): Int = {
    f match {
      case PetiteFaim(p) => prixPlat(p)
      case EntreePlat(e, p) => prixPlat(p) + prixEntree(e)-1
      case PlatDessert(p, d) => prixPlat(p) + prixDessert(d)-1
      case Complete(e, p, d) => prixPlat(p) + prixEntree(e) + prixDessert(d)-2
    }
  }

  /**
   * @param f une formule
   * @param nd un nouveau dessert
   * @return la formule constituée des plats de f, et avec nd comme dessert
   * @note Pour les formules sans dessert, cela consiste à changer de formule.
   */
  // TODO 
  def changerDessert(f: Formule, nd: Dessert): Formule = {
    f match {
      case PetiteFaim(p) => PlatDessert(p,nd)
      case EntreePlat(e,p) => Complete(e,p,nd)
      case PlatDessert(p,d) => PlatDessert(p,nd)
      case Complete(e,p,d) => Complete(e,p,nd)
    }
  }

  /**
   * @param f Une formule
   * @param ndo Soit un nouveau dessert, soit rien
   * @return la formule f avec nd comme dessert s'il existe, sinon, la formule f sans dessert
   */
  // TODO 
  def changerOuAnnulerDessert(f: Formule, ndo: Option[Dessert]): Formule = {
    if(ndo == None){
      f match {
        case PlatDessert(p,nd) => PetiteFaim(p)
        case Complete(e,p,nd) => EntreePlat(e,p)
      }
    }
    else if(ndo == Some(d)) changerDessert(f,d)
  }
}