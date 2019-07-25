package fp.optics

package object syntax {
  object either extends Eithers
  object lens extends Lenses
  object prism extends Prims
  object adapter extends Adapters

  private[syntax] def optics[P[_, _], A, B, S, T](f: P[A, B] ⇒ P[S, T]): Optic[P, A, B, S, T] = (v1: P[A, B]) => f(v1)
}
