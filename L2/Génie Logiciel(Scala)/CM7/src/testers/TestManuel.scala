package testers
import org.junit.Assert._
import org.junit.Test

class TestManuel {
   @Test
  def test1{
    assertEquals(Set(),Inter.intersec(Set(),Set(1,2)))
    assertEquals(Set(),Inter.intersec(Set(1,2),Set()))
    assertEquals(Set(),Inter.intersec(Set(0),Set(1,2)))
    assertEquals(Set(2),Inter.intersec(Set(1,2),Set(2,3))) 
  }
}