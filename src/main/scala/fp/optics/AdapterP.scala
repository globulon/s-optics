package fp.optics

trait AdapterP[P[_, _], A, B, S, T]
  extends Cartesian[P] with Optic[P, A, B, S, T]
