package library

object Resultat extends ProductionResultat{
  
  def creerLiens(l:List[(String,String)]): List[Html] = {
    l match {
      case Nil => List(Texte(""))
      case l1::l2 => List(Tag("a",List(("href",l1._2)),List(Texte(l1._1)))) ++ creerLiens(l2)
    }
  }
  
  def creerTitres(l:List[(String,String)]): Html = {
    l match {
      case Nil => Texte("")
      case l1::l2 => Texte(l1._1 + " =" )
    }
  }
  
    
  
  
  def resultatVersHtml(l: List[(String, String)]): Html ={
    
  
    Tag("html", List(),
    List(
      Tag("head", List(),
        List(
          Tag("meta", List(("charset", "utf-8")), List()),
          Tag("title", List(), List(Texte("Resultat"))))),
      Tag("body", List(), List(
        Tag("center", List(), creerLiens(l)
          )))))
    }



 
}