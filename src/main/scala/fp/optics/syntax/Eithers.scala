package fp.optics.syntax

import fp.optics._

private[syntax] trait Eithers {
  final def plus[A, B, C, D]: (A ⇒ C) ⇒ (B ⇒ D) ⇒ A + B ⇒ C + D = f ⇒ g ⇒ {
    case Left(a) ⇒ Left(f(a))
    case Right(b) ⇒ Right(g(b))
  }

  final def either[A, B, C]: (A ⇒ C) ⇒ (B ⇒ C) ⇒ A + B ⇒ C = f ⇒ g ⇒ {
    case Left(a) ⇒ f(a)
    case Right(b) ⇒ g(b)
  }
}
