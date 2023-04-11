package exerciceSol

trait ArrayCopy {
  def copy(t1:Array[Char],t2:Array[Char]):Unit={
    require(t1!=null)
    require(t2!=null)
    require(t1.length<=t2.length)  // on doit avoir la place de copier les éléments de t1 dans t2
    val lc1=t1.toList
    val lc2=t2.toList
    copyIMP(t1,t2)
    assert(t1.toList==lc1)
    for (i<- 0 to t1.length-1){    // on retrouve dans t2 tous les éléments de t1
      assert(t2(i)==lc1(i))
    }
    for (i<- t1.length to t2.length-1){ // au delà on retrouve les anciens éléments
      assert(t2(i)==lc2(i))
    }
  } 
  
  protected def copyIMP(t1:Array[Char],t2:Array[Char])
}