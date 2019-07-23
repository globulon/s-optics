package fp.optics

import cats.arrow.Profunctor

//Probably ...
trait Monoidal[P[_, _]] extends Profunctor[P] {
  def par[A, B, C, D] : P[A, B] ⇒ P[C, B] ⇒ P[A x C, B x D]
  def pempty: P[Unit, Unit]
}
