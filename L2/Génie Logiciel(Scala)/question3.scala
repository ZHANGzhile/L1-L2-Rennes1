sealed trait Modification
case class AjoutAvant(ligne:Int,valeur:String) extends Modification
case class AjoutApres(ligne:Int,valeur:String) extends Modification
case class Suppression(ligne:Int) extends Modification

class Document(doc: List[String]) {
  var document: List[String] = doc
  def exportation: String = document.reduce(_+'\n'+_)
  
  def applique(l:List[Modification]):Unit = {
   l match {
     case Nil => print("")
     case AjoutAvant(l,v)::liste => document =  modif(document, l-1, v); applique(liste)
     case AjoutApres(l,v)::liste => document = modif(document, l, v); applique(liste)
     case Suppression(l)::liste => document = modif(document.updated(l-1, "@SUPPRIMER"), document.size, ""); applique(liste)
   }
}
  
  private def modif(doc:List[String], l:Int, v:String): List[String]= {
    (doc,l) match {
      case (Nil,_) => v::Nil
      case (liste, 0) => v::liste
      case (ligne::liste, _) => if(ligne == "@SUPPRIMER") modif(liste, l-1, v)
                                else ligne::modif(liste, l-1, v)
    }
  }

  def toPrint:Unit = {
    document.map(x => println(x))
  }


  object test extends App {
  var doc:Document = new Document(List("fanfan", "mignon", "zouzou"))
  val listModif: List[Modification] = List(AjoutApres(1, "Inser"))  
  doc.applique(listModif)
  doc.toPrint
}