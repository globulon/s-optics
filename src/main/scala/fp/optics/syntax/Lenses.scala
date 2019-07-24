package fp.optics.syntax

import fp.optics.{Lens, x}

private[syntax] trait Lenses {
  final def lens[A, B, S, T](v: S ⇒ A)(u: B x S ⇒ T): Lens[A, B, S, T] = new Lens[A, B, S, T] {
    override def view: S ⇒ A = v

    override def update: B x S ⇒ T = u
  }

}