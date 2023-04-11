package ex4

import scala.swing._
import javax.swing._

// Des zones de textes avec une opération "effacer"
trait ZoneTexte extends TextField{
  def effacer:Unit
}

class UI extends MainFrame {
  // Pour créer un objet de type ZoneTexte
  // J'ai besoin de connaître le nom d'une classe l'implantant
  // Ici InField
  val t1:ZoneTexte= new InFieldSynchro()
  val t2:ZoneTexte= new InFieldSynchro()
  val t3:ZoneTexte= new InField()
  val t4:ZoneTexte= new InField()
  val t5:ZoneTexte= new InField()
  val t6:ZoneTexte= new InField()
  val t7:ZoneTexte= new InField()
  val t8:ZoneTexte= new InField()
  val t9:ZoneTexte= new InField()
  val t10:ZoneTexte= new InField()
  
  title = "10 Zones de Texte"
  preferredSize = new Dimension(320, 240)
  val fp= new BoxPanel(Orientation.Vertical)
  val nb= new BoutonEffacer(Set(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10))
  contents = fp
  fp.contents+= nb
  fp.contents+=t1
  fp.contents+=t2
  fp.contents+=t3
  fp.contents+=t4
  fp.contents+=t5
  fp.contents+=t6
  fp.contents+=t7
  fp.contents+=t8
  fp.contents+=t9
  fp.contents+=t10 
}