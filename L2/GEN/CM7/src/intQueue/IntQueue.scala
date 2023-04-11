package intQueue

trait IntQueue{
	def get:Int ={
	  require(!empty)
	  getIMP
	}
	
	def put(x:Int)={
	  putIMP(x:Int)
	} ensuring (!empty)
	
	def empty:Boolean
	
	protected def getIMP:Int
	protected def putIMP(x:Int):Unit
}

class MyIntQueue extends IntQueue{
	private var b= List[Int]()
	protected def getIMP= {val h=b(0); b=b.drop(1); h}
	protected def putIMP(x:Int)= {b=b:+x}
	def empty=b.isEmpty 
}

object IntQueueApp extends App{
    val q:IntQueue= new MyIntQueue
    q.put(1)
    q.put(2)
    q.put(3)
    vider(q)
    retarder(q)

    def vider(q: IntQueue):Unit= while(!q.empty) q.get
    def retarder(q:IntQueue):Unit= q.put(q.get)

}
