package fp.optics.instances

import cats.Functor
import fp.optics.{Done, FunList, More}

private[instances] trait FunListInstances {
  implicit final def funListF[A, B]: Functor[FunList[A, B, ?]] = new Functor[FunList[A, B, ?]] {
    override def map[T, U](fa: FunList[A, B, T])(f: T ⇒ U): FunList[A, B, U] = fa match {
      case Done(t)      ⇒ Done(f(t))
      case More(a, fun) ⇒ More(a, map(fun)(f.compose))
    }
  }
}
