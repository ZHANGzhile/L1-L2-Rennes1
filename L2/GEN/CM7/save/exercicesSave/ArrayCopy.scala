package exercicesSave

trait ArrayCopy {
  def copy(t1:Array[Char],t2:Array[Char]):Unit={
    require(???)
    copyIMP(t1,t2)
    assert(???)
  } 
  
  protected def copyIMP(t1:Array[Char],t2:Array[Char])
}