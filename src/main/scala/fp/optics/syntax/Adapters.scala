package fp.optics.syntax

import cats.arrow.Profunctor
import cats.syntax.profunctor._
import fp.optics.{Adapter, Optic}

private[syntax] trait Adapters {
  final def adapter[A, B, S, T](from: S ⇒ A)(to: B ⇒ T): Adapter[A, B, S, T] = Adapter[A, B, S, T](from, to)

  //adapterP p a b s t = ∀ p . Profunctor p => Optic p a b s t
  final def adapterP[P[_, _] : Profunctor, A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = optics(f)

  final def adapterC2P[P[_, _] : Profunctor, A, B, S, T]: Adapter[A, B, S, T] ⇒ Optic[P, A, B, S, T] = {
    case Adapter(from, to) ⇒ _.dimap(from)(to)
  }
}
