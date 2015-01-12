import ScalaJSKeys._

name := "sconfig-js"

scalaJSSettings

unmanagedSourceDirectories in Compile += baseDirectory.value / ".." / "shared"

