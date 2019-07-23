package fp.optics

import cats.arrow.Profunctor

trait Cartesian[P[_, _]] extends Profunctor[P] {
  def first[A, B, C]: P[A, B] ⇒ P[(A, C), (B, C)]
  def second[A, B, C]: P[A, B] ⇒ P[(C, A), (C, A)]
}