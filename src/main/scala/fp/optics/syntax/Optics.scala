package fp.optics.syntax

import fp.optics.Optic

private[syntax] trait Optics {
  private[syntax] def optics[P[_, _], A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = (v1: P[A, B]) => f(v1)
}
