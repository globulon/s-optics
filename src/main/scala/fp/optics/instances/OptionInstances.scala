package fp.optics.instances

import fp.optics.Prism
import fp.optics.syntax.prism._

private[instances] trait OptionInstances {
  final def the[A, B]: Prism[A, B, Option[A], Option[B]] = prism[A, B, Option[A], Option[B]](
    {
      case Some(a) ⇒ Right(a)
      case _       ⇒ Left(None)
    },
    Some(_)
  )
}
