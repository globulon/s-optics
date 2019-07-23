package fp.optics

sealed trait FunList[A, B, T]
final case class Done[A, B, T](t: T) extends FunList[A, B, T]
final case class More[A, B, T](a: A, fun: FunList[A, B, B ⇒ T]) extends FunList[A, B, T]