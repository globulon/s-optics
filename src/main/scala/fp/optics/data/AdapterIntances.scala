package fp.optics.data

import cats.arrow.Profunctor
import fp.optics.Adapter
import fp.optics.syntax.adapter._

private[data] trait AdapterIntances {
  implicit final def adapterProfunctor[A, B]: Profunctor[Adapter[A, B, ?, ?]] = new Profunctor[Adapter[A, B, ?, ?]] {
    override def dimap[S, T, U, V](fab: Adapter[A, B, S, T])(f: U ⇒ S)(g: T ⇒ V): Adapter[A, B, U, V] =
      adapter(fab.from compose f)(g compose fab.to)
  }
}
