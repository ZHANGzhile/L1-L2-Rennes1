package fr.istic.si2.tp3.restaurant

import scala.io.StdIn._
import RestaurantUtils._

// TODO  - Fourni
object Restaurant extends App {

  /* Boucle d'interactions en console pour la prise de commande
   * et le calcul du prix du repas, selon la formule correspondante.
   * Toutes les interactions se font en entrant du texte en console
   */
  
  try {
    val rep: String = "Vous avez choisi : "

    println("Quelle entrée souhaitez-vous (facultatif) ? ")
    val entree: Option[Entree] = Definitions.commandeEntree(readLine())
    println(rep + entreeToString(entree))

    val plat: Plat = commandeObligatoire("plat", Definitions.commandePlat)
    println(rep + platToString(plat))

    println("Quel dessert souhaitez-vous (facultatif) ? ")
    val dessert: Option[Dessert] = Definitions.commandeDessert(readLine())
    println(rep + dessertToString(dessert))

    val menu: Formule = formuleCommandee(entree, plat, dessert)

    println("\n--- Votre menu --- ")
    println(menuToString(menu))
    println("--- --- --- ---\n")

    println("Souhaitez-vous changez d'avis sur le dessert ? [o/N]")
    val reponse = readLine.toLowerCase().toLowerCase()

    val menu_final = if (reponse == "o" || reponse == "oui") {

      println("Quel nouveau dessert souhaitez-vous ? ")
      val dessert: Option[Dessert] = Definitions.commandeDessert(readLine())
      val nouveau_menu: Formule = try {
        Definitions.changerOuAnnulerDessert(menu, dessert)
      } catch {
        case e: NotImplementedError =>
          dessert match {
            case Some(d) => Definitions.changerDessert(menu, d)
            case None =>
              println("[changerOuAnnulerDessert à implémenter]")
              val d = commandeObligatoire("dessert", Definitions.commandeDessert)
              Definitions.changerDessert(menu, d)
          }
      }
      println("\n--- Votre nouveau menu --- ")
      println(menuToString(nouveau_menu))
      println("--- --- --- ---\n\n")

      nouveau_menu
    } else {
      println("Votre dessert initial est conservé.")
      menu
    }

    afficherAddition(menu_final)
  } catch {
    case e: NotImplementedError => println("[à implémenter...]")
  }
}



object RestaurantUtils {

  /*
   * Fonctions auxiliaires fournies pour le fonctionnement de la boucle 
   * d'interaction textuelle.
   */
  
  /**
   * @param e une entrée optionnelle
   * @return description textuelle de e
   */
  def entreeToString(e: Option[Entree]): String = {
    e match {
      case Some(FoieGras) => "Foie Gras"
      case Some(Melon)    => "Melon"
      case Some(Crudites) => "Crudités"
      case None           => "Aucune entrée"
    }
  }

  /**
   * @param p un plat optionnel
   * @return description textuelle de p
   */
  def platToString(p: Plat): String = {
    p match {
      case PoissonDuJour           => "Poisson du jour"
      case Gratin                  => "Gratin"
      case Couscous(Vegetarien)    => "Couscous Vegetarien"
      case Couscous(PouletMerguez) => "Couscous"
      case Couscous(Royal)         => "Couscous Royal"
    }
  }

  /**
   * @param d un dessert optionnel
   * @return description textuelle de d
   */
  def dessertToString(d: Option[Dessert]): String = {
    d match {
      case Some(SaladeDeFruits)         => "Salade de fruits"
      case Some(Cafe)                   => "Café"
      case Some(Glace(None))            => "Glace"
      case Some(Glace(Some(Chocolat)))  => "Glace chocolat"
      case Some(Glace(Some(Chantilly))) => "Glace chantilly"
      case None                         => "Aucun dessert"
    }
  }

  /**
   * @param m un menu
   * @return description textuelle de m
   */
  def menuToString(m: Formule): String = {
    val sep: String = "\n - "
    m match {
      case PetiteFaim(p)     => "Petite faim :" + sep + platToString(p)
      case EntreePlat(e, p)  => "Entree+Plat :" + sep + entreeToString(Some(e)) + sep + platToString(p)
      case PlatDessert(p, d) => "Plat+Dessert :" + sep + platToString(p) + sep + dessertToString(Some(d))
      case Complete(e, p, d)  => "Complet :" + sep + entreeToString(Some(e)) + sep + platToString(p) + sep + dessertToString(Some(d))
    }
  }

  val euro = "€"

  /**
   * Affiche dans la console l'addition du menu m
   * @param m un menu
   */
  def afficherAddition(m: Formule): Unit = {
    val sep: String = ", "
    println("--- Addition ---")
    m match {
      case PetiteFaim(p) =>
        println(platToString(p) + sep + Definitions.prixPlat(p) + euro)
      case EntreePlat(e, p) =>
        println(entreeToString(Some(e)) + sep + Definitions.prixEntree(e) + euro)
        println(platToString(p) + sep + Definitions.prixPlat(p) + euro)
      case PlatDessert(p, d) =>
        println(platToString(p) + sep + Definitions.prixPlat(p) + euro)
        println(dessertToString(Some(d)) + sep + Definitions.prixDessert(d) + euro)
      case Complete(e, p, d) =>
        println(entreeToString(Some(e)) + sep + Definitions.prixEntree(e) + euro)
        println(platToString(p) + sep + Definitions.prixPlat(p) + euro)
        println(dessertToString(Some(d)) + sep + Definitions.prixDessert(d) + euro)
    }
    println("--- Total (avec réduction) : " + Definitions.prixFormule(m) + euro)
  }

  /**
   * Demande à l'utilisateur un produit obligatoire
   * @param nom Le nom du type de produit (ex. "dessert")
   * @param f Une fonction de conversion entre nom de produit et produit
   * @tparam A le type du produit
   * @return un produit de type A choisi par l'utilisateur.
   */
  def commandeObligatoire[A](nom: String, f: String => Option[A]): A = {
    println("Vous devez choisir un " + nom + ". Quel " + nom + " souhaitez-vous ? ")
    val oplat = f(readLine())
    oplat match {
      case None =>
        println("Je n'ai pas compris votre demande."); commandeObligatoire(nom, f)
      case Some(p) => p
    }
  }

  /**
   * @param entree L'entrée choisie
   * @param plat Le plat choisi
   * @param dessert Le dessert choisi
   * @return une formule correspondant au trio entrée plat desert.
   */
  def formuleCommandee(entree: Option[Entree], plat: Plat, dessert: Option[Dessert]): Formule = {
    (entree, dessert) match {
      case (Some(e), Some(d)) => Complete(e, plat, d)
      case (Some(e), None)    => EntreePlat(e, plat)
      case (None, Some(d))    => PlatDessert(plat, d)
      case (None, None)       => PetiteFaim(plat)
    }
  }
}


