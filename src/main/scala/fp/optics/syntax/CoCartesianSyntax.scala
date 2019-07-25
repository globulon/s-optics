package fp.optics.syntax

import fp.optics.{+, CoCartesian}

private[syntax] trait CoCartesianSyntax {
  implicit final def toCoCartOps[P[_, _]: CoCartesian, A, B](pab: P[A, B]): CoCartesianOps[P, A, B] =
    new CoCartesianOps[P, A, B](pab)
}

final class CoCartesianOps[P[_, _], A, B](val pab: P[A, B]) extends AnyVal {
  def left[C](implicit CC: CoCartesian[P]): P[A + C, B + C] = CC.left[A, B, C](pab)
  def right[C](implicit CC: CoCartesian[P]): P[C + A, C + B] = CC.right[A, B, C](pab)
}
