package fp.optics

trait Prism[A, B, S, T] {
  def `match`: S ⇒ T + A
  def build: B ⇒ T
}