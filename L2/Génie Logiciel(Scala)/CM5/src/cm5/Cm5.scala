package cm5

object Cm5 {
  /* Exemples */
  
  val l= List(1,2,3,4)
  def f(x:Int)=x+1
  val l2= l.map(f)
  val l3= l.map(_+1)

  // en impératif
  var l4=List[Int]()
  for (i<- l){ 
     l4= l4:+ (i+1)
  }
  
  /* Exemples */
  
  l.filter(_>2)
  
  /* Exercice 1 */
    
  val s=Set(1,2,3)
  s.map(_.toString())
  /* Exercice 2 */
  
  def remove(x:String,l:List[String])=
    l.filter(_!=x)
  
  remove("A",List("A","B","A"))
  
  /* Exercice 3 */
  
  val t= Array(1,2,3,4)
  t.reduce(_*_)
  
  (1 to 10).reduce(_ * _)
  
  /* Exercice 4 */
  
  val s2= Set(1,2,3,4)
  //s2.map(_ * _)
  
  /* Exercice 5 */

  s2.map((x:Int)=> x*x)
  
  
  /* Files polymorphes */
  
  trait Queue[T]{ 
      def get:T
      def put(x:T):Unit
  }

  class MyQueue[T](init:List[T]) extends Queue[T]{ 
      private var b= init
      def get={
        val h=b(0)
        b=b.drop(1)
        h}
      
      def put(x:T)={
        b=b:+x
      }
  }
  
  val iq= new MyQueue(List("a","b"))
  val iq2:MyQueue[String]= new MyQueue(List())
  
  /* Arbres binaires polymorphes */
  sealed trait Arbre[+T]
  case class Noeud[+T](i:T,g:Arbre[T],d:Arbre[T]) extends Arbre[T]
  case object Feuille extends Arbre[Nothing]
  
  /* Exercice 6 */
  
  trait Multi[T]{
    def + (x:T) : Unit
    def exist (x:T) : Int
   
  }
  
  /* Exercice 7 */
  
  class Multix[T] extends Multi[T]{
    var m:Map[T,Int]=Map()
    def exist (x:T) : Int = m.getOrElse(x,0)
    def +(x:T):Unit= m= m + (x -> (m.getOrElse(x,0) + 1))
  }
  
  /* Exercice 8 */

  object MultiFactory{
    def get[T]():Multi[T] = new Multix[T]()
  }

  val me= MultiFactory.get[String]
  me + "a"
  me + "b"
  me + "a"
  me + "a"
  me.exist("a")
  me.exist("d")
  
  /* Exemple 8 et 9 */
  
  class Rational(n:Int,d:Int){
    	 val num=n
    	 val den=d
    	 def isNull:Boolean=(num==0)
    	 def this(x:Int)={this(x,1)}
    	 def +(r:Rational):Rational = { new Rational(this.num*r.den+this.den*r.num,this.den*r.den) }
    	 override def toString=this.num+"/"+this.den
    	 
     	 override def equals(o:Any)={
          o match {
            case e:Rational => e.num==this.num && e.den==this.den
            case _ => false
          }
       }
  }
  val r1= new Rational(3,4)
  val r2= new Rational(3,4)
  val r3= new Rational(1,2)
  
  r1==r3
  r1==r2
  val sr= Set(r1,r2,r3)
  
  /* Exercice 9 */

    
  /* Exercice 10 */

  
  /* Exercice 11 */

  /* Exercice 12 */
  
  trait Aire{
    val unite:String
    val taille:Int
    override def toString= taille+" "+unite+"2"
  }
  
  class Rectangle(larg:Int,long:Int) extends Aire{
    val unite="cm"
    val taille=larg*long
  }
  
  class Cercle(rayon:Int) extends Aire{
    val unite="m"
    val taille=(3.14*rayon*rayon).toInt
  }

  val r= new Rectangle(10,20)
  val c= new Cercle(30)
  
}