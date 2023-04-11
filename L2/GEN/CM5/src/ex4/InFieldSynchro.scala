package ex4

import scala.swing._
import java.awt.Color
import scala.swing.event._

object FieldCollecteur{
  var s:Set[InFieldSynchro]=Set()
  def add(e:InFieldSynchro):Unit= s= s+e
  def synchronize(v:String):Unit={
    for (e<-s) e.text=v
  }
}

class InFieldSynchro extends ZoneTexte {
  FieldCollecteur.add(this)
  background = Color.ORANGE
  foreground = Color.BLACK
  text = ""

  columns = 20
  border = Swing.LineBorder(Color.GRAY) 
  
  // On synchronise cette zone texte avec toutes les autres
  listenTo(this.keys)
  reactions+={
    case _: KeyTyped =>  FieldCollecteur.synchronize(text)
  }
  
  def effacer:Unit= text=""
}