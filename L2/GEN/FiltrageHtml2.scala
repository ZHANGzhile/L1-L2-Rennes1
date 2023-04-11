package library

object FiltrageHtml2 extends FiltrageHtml {

  def filtreHtml(h: Html, e: Expression): Boolean = {
    filtreHtml(traduire(h), e)
  }

  def filtreHtml(h: String, e: Expression): Boolean = {
    e match {
      case Ou(e1, e2) => filtreHtml(h, e1) || filtreHtml(h, e2)
      case Et(e1, e2) => filtreHtml(h, e1) && filtreHtml(h, e2)
      case Mot(s)     => if (h.indexOf(s.toLowerCase()) >= 0)  true else false
    }
  }

  def traduire(h: Html): String = {
    
    h match {
      case Texte(a) => a
      case Tag(a,b,c) => 
        var s: String= ""
        for(e <- c ) { s += traduire(e) } 
        s.toLowerCase()
    }
  }
}