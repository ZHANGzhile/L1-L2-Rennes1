package ex4Factory

import scala.swing._
import java.awt.Color

class InField extends ZoneTexte {
  background = Color.BLACK
  foreground = Color.WHITE
  text = ""
  columns = 20
  border = Swing.LineBorder(Color.GRAY)
  
  def effacer:Unit= text=""
}