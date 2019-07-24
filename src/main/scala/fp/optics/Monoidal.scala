package fp.optics

import cats.arrow.Profunctor

trait Monoidal[P[_, _]] extends Profunctor[P] {
  def par[A, B, C, D] : P[A, B] ⇒ P[C, B] ⇒ P[A x C, B x D]
  def pempty: P[Unit, Unit]
}

object Monoidal {
  def apply[P[_, _]: Monoidal]: Monoidal[P] = implicitly[Monoidal[P]]
}