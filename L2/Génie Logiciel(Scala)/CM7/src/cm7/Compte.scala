package cm7
import scala.io.StdIn._

object DemoContrats extends App{
  val objetExemple= Exemple4
  while (true){
    println("Credit= "+objetExemple.credit)
    print("Quel montant de retrait? ")
    objetExemple.retrait(readLine.toInt)
  }
}

object Exemple4{
  var credit= 1000
 
  def retrait(x:Int):Int={
  require(x <= credit)
  credit= credit - (3*x)
  credit
  }
}

object Exemple5{
  var credit= 1000
 
  def retrait(x:Int):Int={
  credit= credit - x
  assert(credit >= 0)
  credit
  }
}

object Exemple6{
  var credit= 1000
 
  def retrait(x:Int):Int={
  credit= credit - x
  credit
  } ensuring (credit >= 0)
}

object Exemple7{
  var credit= 1000
 
  def retrait(x:Int):Int={
	credit= credit - x
    credit
  } ensuring (res => res >= 0)
}

object Exemple8{
  var credit= 1000  
  var creditPre=credit
  
  def retrait(x:Int):Int={
    creditPre=credit
    credit= credit - x
    credit
  } ensuring (res => (res==creditPre - x) && credit==res)
}

object Exemple9{
  var credit= 1000
  var creditPre=credit
  
  def retrait(x:Int):Int={
    require(x<=credit)
    creditPre=credit
    credit= credit - (3*x)
    assert(credit>=0)
    credit
  } ensuring (res => (res==creditPre - x) && credit==res)
}

