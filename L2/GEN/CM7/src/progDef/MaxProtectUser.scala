package progDef

object Main2 extends App{
  val t= Array(1,2,3)
  // on garde une empreinte de t
  val tl= t.toList
  val res= MaxIMP2.max(t)
  // on vérifie que t n'a pas été modifié
  assert(tl==t.toList)
  // on vérifie que res est un élément du tableau
  assert(t.exists(_==res))
  // on vérifie que res maximise le tableau
  assert(t.forall(_<=res))
  println(t.toList)
  println(res)
}


object MaxIMP2 extends Max{
  def max(x:Array[Int]):Int={
    for (i <- 0 to x.length-1) x(i)=0
    0
  }
}
