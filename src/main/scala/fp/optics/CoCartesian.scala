package fp.optics

import cats.arrow.Profunctor

//ArrowChoice from Cats 2.0
trait CoCartesian[P[_, _]] extends Profunctor[P] {
  def left[A, B, C]: P[A, B] ⇒ P[A + C, B + C]
  def right[A, B, C]: P[A, B] ⇒ P[C + A, C + B]
}

object CoCartesian {
  def apply[P[_,_]: CoCartesian]: CoCartesian[P] = implicitly[CoCartesian[P]]
}