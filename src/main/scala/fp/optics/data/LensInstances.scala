package fp.optics.data

import fp.optics.syntax.lens.lens
import fp.optics.{Cartesian, Lens}

private[data] trait LensInstances {
  implicit final def LensCartesian[A, B]: Cartesian[Lens[A, B, ?, ?]] = new Cartesian[Lens[A, B, ?, ?]] {
    override def first[S, T, C]: Lens[A, B, S, T] ⇒ Lens[A, B, (S, C), (T, C)] = {
      case Lens(v, u) ⇒ lens[A, B, (S, C), (T, C)](v compose (_._1)) {
        case (b, (s, c)) ⇒ (u((b, s)), c)
      }
    }

    override def second[S, T, C]: Lens[A, B, S, T] ⇒ Lens[A, B, (C, S), (C, T)] = {
      case Lens(v, u) ⇒ lens[A, B, (C, S), (C, T)](v compose (_._2)) {
        case (b, (c, s)) ⇒ (c, u((b, s)))
      }
    }

    override def dimap[S, T, U, V](fab: Lens[A, B, S, T])(f: U ⇒ S)(g: T ⇒ V): Lens[A, B, U, V] =
      lens[A, B, U, V](fab.view compose f) {
        case (b, u) ⇒ g(fab.update((b, f(u))))
      }
  }
}
