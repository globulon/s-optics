package fp.optics.syntax

import fp.optics.{Cartesian, Lens, Optic, x}

private[syntax] trait Lenses {
  final def lens[A, B, S, T](v: S ⇒ A)(u: B x S ⇒ T): Lens[A, B, S, T] = new Lens[A, B, S, T] {
    override def view: S ⇒ A = v

    override def update: B x S ⇒ T = u
  }

  //lensP p a b s t = ∀ p . Cartesian p => Optic p a b s t
  final def lensP[P[_, _] : Cartesian, A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = optics(f)
}