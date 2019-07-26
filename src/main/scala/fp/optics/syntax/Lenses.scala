package fp.optics.syntax

import fp.optics.{Cartesian, Lens, Optic}

private[syntax] trait Lenses {
  final def lens[A, B, S, T](v: S ⇒ A)(u: (B, S) ⇒ T): Lens[A, B, S, T] = Lens[A, B, S, T](v, u)

  //lensP p a b s t = ∀ p . Cartesian p => Optic p a b s t
  final def lensP[P[_, _] : Cartesian, A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = optics(f)
}