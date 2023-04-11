package cm7

object Quizz1 {
  def plus(x:Int,y:Int):Int={
    assert(x+y>0)
    x
  } ensuring (res => (res==x+y))
  
  plus(10,20)
}

object Quizz1b {
  def moins(x:Int,y:Int):Int={
    require(x>y)
    x - x
  } ensuring (res => res>0)
  
  moins(20,10)
}

object Quizz1c {
  def f(a:Int):Int={
	require(a match {
	  	case 18 | 19 => true
	  	case _ => false})
    18}
  
  f(10)
}

object Quizz1d {
  def max(a:Int,b:Int):Int={
	30
  } ensuring (res => res>=a && res>=b)
  
  max(10,20)
}


object Quizz2{
  def divEntiere(n:Int,d:Int):(Int,Int)={
    require(d>0 && n>=0)
    (0,0)
  } ensuring (res => n== (res._1 * d + res._2) &&
                     res._2<= d)
        
}

object Quizz2b{
  def plus(x:Int,y:Int):Int={
    x+y
  } ensuring (res => res==plus(x,y))
}

object Quizz2c{
  def intersection(a:Set[Int],b:Set[Int]):Set[Int]={
    a
  } ensuring (res => res.forall(a.contains(_)))
}



