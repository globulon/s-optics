package fp.optics

package object syntax extends Optics {
  object either extends Eithers
  object lens extends Lenses
  object prism extends Prims
  object adapter extends Adapters
  object cocartesian extends CoCartesianSyntax
  object cartesian extends CartesianSyntax
  object product extends Products
}
