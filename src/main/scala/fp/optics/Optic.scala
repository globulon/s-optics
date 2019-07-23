package fp.optics

trait Optic [P[_, _], A, B, S, T] extends (P[A, B] ⇒ P[S, T])
