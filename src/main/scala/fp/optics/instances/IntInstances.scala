package fp.optics.instances

import fp.optics.Lens
import fp.optics.syntax.lens._

private[instances] trait IntInstances {
  implicit val sign: Lens[Boolean, Boolean, Int, Int] = lens[Boolean, Boolean, Int, Int] (
    {
      case i if i >= 0 ⇒ true
      case _           ⇒ false
    },
    {
      case (true, i) ⇒ math.abs(i)
      case (_,    i) ⇒ - sign.update((true, i))
    }
  )
}
