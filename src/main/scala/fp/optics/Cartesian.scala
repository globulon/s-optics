package fp.optics

import cats.arrow.Profunctor

//Probably Strong in Cats 2.0
trait Cartesian[P[_, _]] extends Profunctor[P] {
  def first[A, B, C]: P[A, B] ⇒ P[A x C, B x C]
  def second[A, B, C]: P[A, B] ⇒ P[C x A, C x B]
}

object Cartesian {
  def apply[P[_,_] : Cartesian]: Cartesian[P] = implicitly[Cartesian[P]]
}