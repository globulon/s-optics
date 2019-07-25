package fp.optics.syntax

import fp.optics._

private[syntax] trait Prims {
  final def prism[A, B, S, T](m: S ⇒ T + A)(b: B ⇒ T): Prism[A, B, S, T] = new Prism[A, B, S, T] {
    override def `match`: S ⇒ T + A = m

    override def build: B ⇒ T = b
  }

  //lensP p a b s t = ∀ p . Cartesian p => Optic p a b s t
  final def lensP[P[_, _] : Cartesian, A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = optics(f)
}