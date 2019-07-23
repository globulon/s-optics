package fp.optics

trait Prism[A, B, S, T] {
  def `match`: S ⇒ S + A
  def build: B ⇒ T
}