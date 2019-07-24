package fp.optics.syntax

import fp.optics._

private[syntax] trait Prims {
  final def prism[A, B, S, T](m: S ⇒ T + A)(b: B ⇒ T): Prism[A, B, S, T] = new Prism[A, B, S, T] {
    override def `match`: S ⇒ T + A = m

    override def build: B ⇒ T = b
  }
}