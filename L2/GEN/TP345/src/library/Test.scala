package library
import java.io.FileWriter

object Test extends App {
   val requete = ParserExpression.lireExpression
  println(requete)
  def traduireURL(e:Expression): String={
     e match {
     case Ou(e1, e2) => 
        traduireURL(e1) +"+"+ traduireURL(e2)
     case Et(e1, e2) => traduireURL(e1) +"+" +traduireURL(e2)
     case Mot(s)     => s
    }
  }
  val siteReference = "https://search.vivastreet.com/annonces/fr?lb=new&search=1&start_field=1&keywords="+traduireURL(requete)
  println(siteReference)
  //println("/////////////////")
  //println(AnalysePageWL.resultats(siteReference, requete))
  //println("***********************")
  //println(Resultat.resultatVersHtml(AnalysePageWL.resultats(siteReference, requete)))
  //println(HtmlVersString2.traduire(Resultat.resultatVersHtml(AnalysePageWL.resultats(siteReference, requete))))
  
  val file= new FileWriter("monFichier.html")
  try{
    file.write(HtmlVersString2.traduire(Resultat.resultatVersHtml(AnalysePageWL.resultats(siteReference, requete))))
  } finally file.close()
}