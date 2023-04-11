package ex4

import scala.swing._
import event._

class BoutonEffacer(s:Set[ZoneTexte]) extends Button {
  text = "Effacer"
  reactions += {
      case ButtonClicked(_) => { for(e <- s) e.effacer}
  }
  
}