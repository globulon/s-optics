package fp.optics

final case class Adapter[A, B, S, T](from: S ⇒ A, to: B ⇒ T)
