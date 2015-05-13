sconfig
=======

A simple configuration library for Scala and Scala.js with an API compatible to [Typesafe config](https://github.com/typesafehub/config). The Scala/JVM backend is just a wrapper around the Typesafe config library.

Getting Started
---------------

### sbt settings
Add one of the following entries to your `build.sbt` (depending on your target):

**Scala/JVM**:
```scala
libraryDependencies += "biz.enef" %% "sconfig" % "0.1-SNAPSHOT"
```

**Scala.js**:
```scala
libraryDependencies += "biz.enef" %%% "sconfig" % "0.1-SNAPSHOT"
```


License
-------
This code is open source software licensed under the [MIT License](http://opensource.org/licenses/MIT).
