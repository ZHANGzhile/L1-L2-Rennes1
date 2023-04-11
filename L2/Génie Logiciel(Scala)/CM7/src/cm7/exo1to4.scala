package cm7

object Exercice1{
	def max(a:Int,b:Int):Int={
	  1
	} ensuring (res =>  (a== res && a<=b) || (b==res && b<=a)  )
}
 
object Exercice2{
  def delete(x:Int,l:List[Int]):List[Int]={
    List()
  } ensuring (res => !res.contains(x) &&
      { var res2=true
        for (e <-l){
          if (e!=x) res2= res2 && res.contains(e) 
        }
        res2
      }
      )
}

object Exercice3{
  def intersection(a:Set[Int],b:Set[Int]):Set[Int]={
    Set()
  } ensuring (res => res.subsetOf(a) && res.subsetOf(b) &&
      {var res2=true
       for (e<- a){
         if (b.contains(e)) res2=res2&& res.contains(e)
         if (a.contains(e)) res2=res2&& res.contains(e)
       }
      res2
      })
}


object Exercice4{
  def triCroissant(l:List[Int]):List[Int]={
    List()
  } ensuring (true)
}


