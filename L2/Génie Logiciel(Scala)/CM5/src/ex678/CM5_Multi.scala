package ex678

trait Multi[T]{
  def +(x:T):Unit
  def contains(x:T):Int
  def toString:String
}


class MultiIMP[T]() extends Multi[T]{
  var ens:Map[T,Int]= Map()
  
  def contains(x:T): Int={
    ens.getOrElse(x, 0)
  }
  def +(x:T):Unit={
    ens=ens + (x -> (contains(x)+1))
  }
 
  // Solution simple (récursive pour concat)
  private def concat(sep:String,l:List[String]):String={
    l match {
      case Nil => ""
      case x::Nil => x
      case x::y::r => x+sep+concat(sep,y::r)
    }
  }
  
  // Solution ordre sup
  private def concat2(sep:String,l:List[String]):String=
    if (l==Nil) "{{ }}"
    else "{{" + l.reduce((x,y) => x +sep+ y) + "}}"
    
  private def listOfMulti[T](l:List[(T,Int)]):List[T]={
      l match {
        case Nil => Nil
        case (k,v)::r => ((1 to v).toList.map(_ => k)) ++ listOfMulti(r)
      }
    }
    
  override def toString:String={
    val l:List[T]= listOfMulti(ens.toList)
    concat2(", ",l.map(_.toString))
   }
  
//    // Le prototype de ce qu'il ne faut pas faire avec les fonctions d'ordre sup
//    // Ca fait le travail (compliqué) mais c'est incompréhensible ;-)
//    "{{"+concat(",",ens.map(kv => concat(",",(1 to kv._2).map((k:Int) =>kv._1.toString).toList)).toList)+"}}"
//}
  
}

object MultiFactory{
  def get[T]:Multi[T]= new MultiIMP[T]()
}



object Main extends App {
  val m1=MultiFactory.get[Char]
  m1 + 'a'
  m1 + 'b'
  m1 + 'a'
  m1 + 'c'
  m1 + 'b'
  println(m1)
  println(m1.contains('a'))
  println(m1.contains('b'))
  println(m1.contains('e'))

  val m2= MultiFactory.get[String]
  m2 + "toto"
  m2 + "titi"
  m2 + "toto"
  m2 + "a"
  m2 + "a"
  println(m2)
}