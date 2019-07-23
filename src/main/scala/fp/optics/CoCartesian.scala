package fp.optics

import cats.arrow.Profunctor

trait CoCartesian[P[_, _]] extends Profunctor[P] {
  def left[A, B, C]: P[A, B] ⇒ P[A + C, B + C]
  def right[A, B, C]: P[A, B] ⇒ P[C + A, C + B]
}