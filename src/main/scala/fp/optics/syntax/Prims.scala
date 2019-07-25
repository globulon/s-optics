package fp.optics.syntax

import fp.optics._
import cocartesian._
import cats.syntax.profunctor._

private[syntax] trait Prims {
  final def prism[A, B, S, T](m: S ⇒ T + A)(b: B ⇒ T): Prism[A, B, S, T] = new Prism[A, B, S, T] {
    override def `match`: S ⇒ T + A = m

    override def build: B ⇒ T = b
  }

  //prismP p a b s t = ∀ p . CoCartesian p => Optic p a b s t
  final def prismP[P[_, _] : CoCartesian, A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = optics(f)

  final def prismC2P[P[_, _] : CoCartesian, A, B, C]: Prism[A, B, C, C] ⇒ Optic[P, A, B, C, C] =
    p ⇒ _.right[C].dimap(p.`match`){
      either.either (identity[C]) (p.build)
    }
}