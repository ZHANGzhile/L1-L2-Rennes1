package testers
import scala.util.Random

// On écrit la fonction avec ses pre/post-condition
object Inter{
  def intersec(a:Set[Int],b:Set[Int]):Set[Int]={
      if (a.isEmpty) Set[Int]()
      else {
        val e= a.head
        if (b.contains(e)) (intersec(a.tail,a)+e)
        else intersec(a.tail,b)
      }
  }   ensuring (inter =>inter.forall (e => a.contains(e) && b.contains(e)) &&
                        a.forall(e => !b.contains(e) || inter.contains(e)) &&
                        b.forall(e => !a.contains(e) || inter.contains(e)))

}
