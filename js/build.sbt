import ScalaJSKeys._

name := "sconfig-js"

scalaJSSettings

unmanagedSourceDirectories in Compile += baseDirectory.value / ".." / "shared"

publishTo := Some(Resolver.file("file", baseDirectory.value / ".." / ".." / "maven"  ))
