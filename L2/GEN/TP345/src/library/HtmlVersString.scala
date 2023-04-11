package library

object HtmlVersString2 extends HtmlVersString {

  /**
   * Produit la chaîne de caractère correspondant à un document Html
   *
   * @param h le document Html
   * @return la chaîne de caractère représentant h
   */
  def traduireAttribut(l: List[(String, String)]): String = {

    l match {
      case Nil    => ""
      case a :: l => a._1 + "=" + "\"" + a._2 + "\"" + traduireAttribut(l)
    }
  }

  def traduire(h: Html): String = {
    var s: String = ""


    h match {
      case Texte(a) => a
      case Tag(a, b, c) =>
        for (e <- c) { s += traduire(e) }
        "<" + a + " " + traduireAttribut(b) + ">" + s + "</" + a + "><br><style>body { font-family: 'Brush Script MT';  font-weight: bold; background-image: url(\"https://image.shutterstock.com/image-photo/successful-students-class-holding-thumbs-600w-85369126.jpg\"); background-repeat: no-repeat; background-size: 100% 100%;} </style><style>a:link {color:black;} a:visited {color: rgb(64,64,64);}</style> <style>a { background-color: rgba(255, 255, 255, 0.4);}</style>"
    }
  }

}