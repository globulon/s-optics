package fp.optics.interops

import cats.arrow.Strong
import fp.optics._

private[interops] trait CartesianOps {
  implicit final def strongToCartesian[P[_, _] : Strong]: Cartesian[P] = new Cartesian[P] {
    @inline
    override def first[A, B, C]: P[A, B] ⇒ P[A x C, B x C] = Strong[P].first[A, B, C]
    @inline
    override def second[A, B, C]: P[A, B] ⇒ P[C x A, C x B] = Strong[P].second[A, B, C]
    @inline
    override def dimap[A, B, C, D](fab: P[A, B])(f: C ⇒ A)(g: B ⇒ D): P[C, D] = Strong[P].dimap[A, B, C, D](fab)(f)(g)
  }
}
