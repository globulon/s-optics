package fp.optics.data

import fp.optics._
import fp.optics.syntax.either._
import fp.optics.syntax.prism._

private[data] trait PrismInstances {
  implicit final def prismProfunctor[A, B]: CoCartesian[Prism[A, B, ?,?]] = new CoCartesian[Prism[A, B, ?,?]] {
    override def dimap[S, T, U, V](fab: Prism[A, B, S, T])(f: U ⇒ S)(g: T ⇒ V): Prism[A, B, U, V] =
      prism( plus(g)(identity[A])  compose fab.`match` compose f)(g compose fab.build)

    override def left[S, T, C]: Prism[A, B, S, T] ⇒ Prism[A, B, S + C, T + C] = p ⇒ prism[A, B, S + C, T + C] {
      either[S, C, T + C + A] {
        s ⇒ plus[T, A, T + C, A](Left(_))(identity)(p.`match`(s))
      } {
        c ⇒ Left(Right(c))
      }
    } {
      b ⇒ Left(p.build(b))
    }

    override def right[S, T, C]: Prism[A, B, S, T] ⇒ Prism[A, B, C + S, C + T] = p ⇒ prism[A, B, C + S, C + T] {
      either[C, S, C + T + A] {
        c ⇒ Left(Left(c))
      } {
        s ⇒ plus[T, A, C + T, A](Right(_))(identity)(p.`match`(s))
      }
    } {
      b ⇒ Right(p.build(b))
    }
  }
}
