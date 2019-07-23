package fp.optics.instances

import fp.optics._
import fp.optics.syntax.lens.lens

private[instances] trait ProductInstances {
  final implicit def productL[A, B, C]: Lens[A, B, A x C, B x C] = lens[A, B, A x C, B x C](
    { case (a, _) ⇒ a },
    { case (aa, (_, c)) ⇒ (aa, c) }
  )
}
