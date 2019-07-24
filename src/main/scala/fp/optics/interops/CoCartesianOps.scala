package fp.optics.interops

import cats.arrow.ArrowChoice
import fp.optics._

private[interops] trait CoCartesianOps {
  final implicit def choiceToCoCartesian[P[_, _] : ArrowChoice] : CoCartesian[P] = new CoCartesian[P] {
    @inline
    override def left[A, B, C]: P[A, B] ⇒ P[A + C, B + C] = ArrowChoice[P].left[A, B, C]
    @inline
    override def right[A, B, C]: P[A, B] ⇒ P[C + A, C + B] = ArrowChoice[P].right[A, B, C]
    @inline
    override def dimap[A, B, C, D](fab: P[A, B])(f: C ⇒ A)(g: B ⇒ D): P[C, D] = ArrowChoice[P].dimap[A, B, C, D](fab)(f)(g)
  }
}
