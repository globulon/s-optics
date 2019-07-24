package fp.optics.data

import cats.arrow.Profunctor
import fp.optics.Prism
import fp.optics.syntax.prism._
import fp.optics.syntax.either._

private[data] trait PrismInstances {
  implicit final def prismProfunctor[A, B]: Profunctor[Prism[A, B, ?,?]] = new Profunctor[Prism[A, B, ?,?]] {
    override def dimap[S, T, U, V](fab: Prism[A, B, S, T])(f: U ⇒ S)(g: T ⇒ V): Prism[A, B, U, V] =
      prism( plus(g)(identity[A])  compose fab.`match` compose f)(g compose fab.build)
  }
}
