package fp.optics.syntax

private[syntax] trait Products {
  final def cross[A, B, C, D]: (A ⇒ C) ⇒ (B ⇒ D) ⇒ (A, B) ⇒ (C, D) = f ⇒ g ⇒ {
    case (a, b) ⇒ (f(a), g(b))
  }

  final def fork[A, B, C]: (A ⇒ B) ⇒ (A ⇒ C) ⇒ A ⇒ (B, C) = f ⇒ g ⇒ a ⇒ (f(a), g(a))
}
