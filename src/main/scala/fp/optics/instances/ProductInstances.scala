package fp.optics.instances

import fp.optics._
import fp.optics.syntax.adapter._
import fp.optics.syntax.lens.lens

private[instances] trait ProductInstances {
  final def productL[A, B, C]: Lens[A, B, A x C, B x C] = lens[A, B, A x C, B x C] {
    case (a, _) ⇒ a
  } {
    case (aa, (_, c)) ⇒ (aa, c)
  }

  final def productLL[A, B, C, D]: Lens[A, B, A x C x D, B x C x D] = lens[A, B, A x C x D, B x C x D] {
    _._1._1
  } {
    case (b, ((_, c), d)) ⇒ ((b, c), d)
  }

  final def flatten[A, B, C, AA, BB, CC]: Adapter[(A, B, C), (AA, BB, CC), ((A, B), C), ((AA, BB), CC)] =
    adapter[(A, B, C), (AA, BB, CC), ((A, B), C), ((AA, BB), CC)] {
      case ((a, b), c) ⇒ (a, b, c)
    } {
      case (a, b, c) ⇒ ((a, b), c)
    }
}
