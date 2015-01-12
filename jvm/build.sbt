name := "sconfig-jvm"

unmanagedSourceDirectories in Compile += baseDirectory.value / ".." / "shared"

libraryDependencies += "com.typesafe" % "config" % "1.2.0"

