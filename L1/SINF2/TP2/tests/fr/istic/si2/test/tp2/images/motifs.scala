package fr.istic.si2.test.tp2.images

import org.junit.Test
import org.junit.Assert._
import util.Random
import fr.istic.si2.scribble._
import fr.istic.si2.testerApp._
import fr.istic.si2.tp2.images.Motifs._
import fr.istic.si2.tp2.images.Motifs
import fr.istic.si2.moreAssertions._

class MotifsDefinitionTest {

  val rand = new Random()
  val _ = new AppInit(Motifs)

  /**
   * sun est bien définie
   */
  @Test
  def sunDefined {
    assertEquals(sun, FromFile("./img/sun.png"))
  }

  /**
   * cloud est bien définie
   */
  @Test
  def cloudDefined {
    assertEquals(cloud, FromFile("./img/cloud.png"))
  }

  /**
   * cloudy est bien définie
   */
  @Test
  def cloudyDefined {
    assertNotNull(cloudy)
  }

}

class MotifsCorrectionTest {

  val rand = new Random()
  val _ = new AppInit(Motifs)

  /**
   * @param i1 an Image
   * @param i2 another Image, i2 is a base-case image
   * @return i2 is included in i1, i2 is a sub-image of i1
   */
  def contains(i1: Image, i2: Image): Boolean = {
    i1 match {
      case _: Circle | Empty | _: FromFile | _: Rectangle | _: Text | _: Triangle => i1 == i2
      case Below(t, b) => contains(t, i2) || contains(b, i2)
      case BelowAlign(_, t, b) => contains(t, i2) || contains(b, i2)
      case Beside(l, r) => contains(l, i2) || contains(r, i2)
      case BesideAlign(_, l, r) => contains(l, i2) || contains(r, i2)
      case On(f, b) => contains(f, i2) || contains(b, i2)
      case OnAlign(_, f, b) => contains(f, i2) || contains(b, i2)
      case OnBackAt(f, b, _, _) => contains(f, i2) || contains(b, i2)
      case OnFrontAt(f, b, _, _) => contains(f, i2) || contains(b, i2)
      case FillColor(i1, _) => contains(i1, i2)
      case LineColor(i1, _) => contains(i1, i2)
      case Rotate(i1, _) => contains(i1, i2)
    }
  }

  /**
   * cloudy utilise bien la valeur de sun
   */
  @Test
  def cloudyUsesSun {
    assertTrue(contains(cloudy, sun))
  }

  /**
   * cloudy utilise bien la valeur de cloud
   */
  @Test
  def cloudyUsesCloud {
    assertTrue(contains(cloudy, cloud))
  }

  /**
   * les trois images sont bien distinctes.
   */
  @Test
  def cloudySunCloudDifferent {
    val tl: List[Image] = List(sun, cloud, cloudy)
    assertEquals(3, tl.toSet.size)
  }

}