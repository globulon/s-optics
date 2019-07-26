package fp.optics.syntax

import fp.optics._
import cartesian._
import product._
import cats.syntax.profunctor._

private[syntax] trait Lenses {
  final def lens[A, B, S, T](v: S ⇒ A)(u: (B x S) ⇒ T): Lens[A, B, S, T] = Lens[A, B, S, T](v, u)

  //lensP p a b s t = ∀ p . Cartesian p => Optic p a b s t
  final def lensP[P[_, _] : Cartesian, A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = optics(f)

  final def lensC2P[P[_, _]: Cartesian, A, B, C]: Lens[A, B, C, C] ⇒ Optic[P, A, B, C, C] = {
    case Lens(v, u) ⇒ _.first[C].dimap(fork(v)(identity[C])) (u)
  }

  final def lensP2C[A, B, S, T]: Optic[Lens[A, B, ?, ?], A, B, S, T] ⇒ Lens[A, B, S, T] =
    _.apply(lens[A, B, A, B](identity)(_._1))
}