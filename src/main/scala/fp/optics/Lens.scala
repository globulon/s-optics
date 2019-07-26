package fp.optics

final case class Lens[A, B, S, T](view : S ⇒ A, update: (B, S) ⇒ T)




