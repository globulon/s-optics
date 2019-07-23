package fp.optics

private[optics] trait Denotations {
  type + [A, B] = Either[A, B]
  type x [A, B] = (A, B)
}
