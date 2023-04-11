package solSave
import scala.io.StdIn._
  
object Main extends App{
  print("Donnez deux entiers")
  val a= readLine.toInt
  val b= readLine.toInt
  println(Exercice1.max(a,b))
}

object Exercice1{
	def max(a:Int,b:Int):Int={
	  1
	} ensuring (res => ((res==a || res==b ) && (res>=a && res>=b)))
}
 
object Exercice2{
  def delete(x:Int,l:List[Int]):List[Int]={
    List()
  } ensuring (res => !res.contains(x) &&
                l.forall(e => res.contains(e) || e==x) &&
                res.forall(e => res.contains(e)))
}

object Exercice3{
  def intersection(a:Set[Int],b:Set[Int]):Set[Int]={
    Set()
  } ensuring (res => res.forall(e => a.contains(e) && b.contains(e)) &&
                     a.forall(e => ! b.contains(e) || res.contains(e)) &&
                     b.forall(e => ! a.contains(e) || res.contains(e)))
}


object Exercice4{
  def isSorted(l:List[Int]):Boolean=
    l match {
    case Nil => true
    case _::Nil => true
    case x::y::r => x<=y && isSorted(y::r)
  }
  
  def triCroissant(l:List[Int]):List[Int]={
    List()
  } ensuring (res => isSorted(l) && 
              l.forall(e => res.count(_==e)==l.count(_==e)) && 
              res.forall((e:Int)=> res.count(_==e) == l.count(_ == e)))
}
