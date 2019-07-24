package fp.optics.syntax

import cats.arrow.Profunctor
import fp.optics.{Adapter, Optic}

private[syntax] trait Adapters {
  final def adapter[A, B, S, T](from: S ⇒ A)(to: B ⇒ T): Adapter[A, B, S, T] = Adapter[A, B, S, T](from, to)

  final def adapterC2P[P[_, _] : Profunctor, A, B, S, T]: Adapter[A, B, S, T] ⇒ Optic[P, A, B, S, T] = {
    case Adapter(from, to) ⇒ pab ⇒ Profunctor[P].dimap(pab)(from)(to)
  }
}
