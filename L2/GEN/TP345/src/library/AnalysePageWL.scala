package library

object AnalysePageWL extends AnalysePage {
  val objFiltrageUrls: FiltrageURLs = null
  val objFiltrageHtml: FiltrageHtml = null
  
  def trouverTitre(doc:Html):String = {
    doc match {
      case Tag("title",_,l) => {
        l match{
          case List(Texte(t)) => t
          case _ => ""
        }
      }
      case Tag(_,_,l) => {
        for(tag:Html <- l){
          var buffer = trouverTitre(tag)
          if (buffer.length() > 0) return buffer
        }
        ""
      }
      case Texte(_) => ""
      
    }
  }
  

  def resultats(url: String, exp: Expression): List[(String, String)] = {
    val docHTML:Html = OutilsWebObjet.obtenirHtml(url)
    val lURLs:List[String] = URLFilter.filtreAnnonce(docHTML)
    //println(lURLs)
    var lDocsHtml:List[Html] = List()
    var lURLHtml:List[(String,Html)] = List()
    var lTitreURL:List[(String, String)] = List()
    
    for(u:String <- lURLs){
      try{
        var html = OutilsWebObjet.obtenirHtml(u)
        lDocsHtml = html::lDocsHtml
        if(FiltrageHtml2.filtreHtml(html,exp)){
          lURLHtml = (u,html)::lURLHtml
          println(trouverTitre(html))
          lTitreURL = (trouverTitre(html),u)::lTitreURL
        }
      }
      catch {
        case _:TagNodeConversionException => print("le lien n'existe pas")
      }
    }

   
    println(lTitreURL)
    lTitreURL
  }
}