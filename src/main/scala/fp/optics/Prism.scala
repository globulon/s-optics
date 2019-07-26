package fp.optics

final case class Prism[A, B, S, T](`match`: S ⇒ T + A, build: B ⇒ T)