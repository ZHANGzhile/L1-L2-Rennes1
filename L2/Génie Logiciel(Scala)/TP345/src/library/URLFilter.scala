package library

object URLFilter extends FiltrageURLs {
  
  

  def filtreAnnonce(h: Html): List[String] = {

    val list = getLinks(h)

    var toKeep: List[String] = List();
    for (link: String <- list) {
      // ajouter filtrage des Tag("span",_,l) dans l il faut List(Texte("Annonce N°"))
      
      //&& isAnnonce(OutilsWebObjet.obtenirHtml(link)
      if (link.startsWith("https://www.vivastreet.com/") && !link.contains("/top") && isAnnonce(link)) {

        toKeep = toKeep ++ List(link)
      }
    }
    toKeep
  }
  
  private def isAnnonce(l: String) : Boolean = {
    var i :Int = 0
    var b : Boolean = false
    for (i <- 0 to 9) {
      b = b || l.endsWith(i.toString)
    }
    b
  }
  
  

  private def getLinks(h: Html): List[String] = {
    var list: List[String] = List();

    h match {
      case Tag("head", _, _) => List()
      case Tag("a", attributs, reste) => {

        for (a: (String, String) <- attributs) {
          a match {
            case ("href", link) => {
              for (hs: Html <- reste) {
                list = list ++ getLinks(hs);
              }
              list = list ++ List(link);
            }
            case _ => List()
          }
        }
        list
      }
      case Tag(_, _, reste) => {
        var list: List[String] = List();
        for (hs: Html <- reste) {
          list = list ++ getLinks(hs);
        }
        list
      }
      case Texte(_) => List()
    }
  }

}
