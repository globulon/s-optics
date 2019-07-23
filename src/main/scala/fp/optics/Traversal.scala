package fp.optics

final case class Traversal[A, B, S, T](extract: S ⇒ FunList[A, B, T])
