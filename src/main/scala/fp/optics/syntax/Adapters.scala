package fp.optics.syntax

import fp.optics.Adapter

private[syntax] trait Adapters {
  final def adapter[A, B, S, T](from: S ⇒ A, to: B ⇒ T): Adapter[A, B, S, T] =
    Adapter[A, B, S, T](from, to)
}
