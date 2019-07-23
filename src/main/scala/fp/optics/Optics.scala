package fp.optics

private[optics] trait Optics {
  type + [A, B] = Either[A, B]
  type x [A, B] = (A, B)
}
