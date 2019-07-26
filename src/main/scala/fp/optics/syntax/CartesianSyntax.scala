package fp.optics.syntax

import fp.optics.{Cartesian, x}

private[syntax] trait CartesianSyntax {
  implicit final def toCartOps[P[_, _] : Cartesian, A, B](pab: P[A, B]): CartesianOps[P, A, B] = new CartesianOps[P, A, B](pab)
}

final class CartesianOps[P[_, _], A, B](val pab: P[A, B]) extends AnyVal {
  def first[C](implicit C: Cartesian[P]): P[A x C, B x C] = C.first[A, B, C](pab)

  def second[C](implicit C: Cartesian[P]): P[C x A, C x B] = C.second[A, B, C](pab)
}