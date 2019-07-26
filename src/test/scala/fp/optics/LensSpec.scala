package fp.optics

import org.scalacheck.{Gen, Prop}
import org.scalatest.MustMatchers
import org.scalatest.wordspec.AnyWordSpecLike
import fp.optics.instances.product._

final class LensSpec extends AnyWordSpecLike with MustMatchers {
  "A lens" when {
    "updated and viewed" should {
      "deliver the updated value" in {
        Prop.forAll(genTuple3) { case (a, b, c) ⇒
          val l = productL[Int, Int, Int]
          import l._
          view(update((c, (a, b)))) == c
        }
      }
    }
  }

  private def genTuple3: Gen[(Int, Int, Int)] = for {
    a ← Gen.choose(0, 1000)
    b ← Gen.choose(0, 1000)
    c ← Gen.choose(0, 1000)
  } yield (a, b, c)
}
