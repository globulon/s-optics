package fp.optics.syntax

import cats.syntax.profunctor._
import fp.optics._
import fp.optics.syntax.cocartesian._

private[syntax] trait Prims {
  final def prism[A, B, S, T](m: S ⇒ T + A)(b: B ⇒ T): Prism[A, B, S, T] = Prism[A, B, S, T](m, b)

  //prismP p a b s t = ∀ p . CoCartesian p => Optic p a b s t
  final def prismP[P[_, _] : CoCartesian, A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = optics(f)

  final def prismC2P[P[_, _] : CoCartesian, A, B, C]: Prism[A, B, C, C] ⇒ Optic[P, A, B, C, C] = {
    case Prism(m, b) ⇒ _.right[C].dimap(m){
      either.either (identity[C]) (b)
    }
  }

  final def prismP2C[A, B, S, T]: Optic[Prism[A, B, ?, ?], A, B, S, T] ⇒ Prism[A, B, S, T] =
    _.apply(prism[A, B, A, B](Right(_))(identity))
}