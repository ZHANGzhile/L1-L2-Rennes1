package progDef

trait Max {
  /** le maximum d'un tableau d'entiers
   *  @param x le tableau d'entiers (non vide)
   */
  def max(x:Array[Int]):Int
}

object Main extends App{
  val t:Array[Int]= null
  val res1= MaxIMP.max(t)
  
  val t2=Array[Int]()
  val res2= MaxIMP.max(t2)
}


object MaxIMP extends Max{
  def max(x:Array[Int]):Int={
    require(x!=null)    // rejette le pointeur null
    require(x.length>0) // rejette les tableaux vides
    var max= x(0)
    for (i <- x) if (i>max) max=i
    max
  }
}
