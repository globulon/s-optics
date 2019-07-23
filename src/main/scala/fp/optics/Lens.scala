package fp.optics

trait Lens[A, B, S, T] {
  def view : S ⇒ A
  def update: B x S ⇒ T
}




