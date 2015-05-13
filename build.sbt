import SonatypeKeys._

lazy val commonSettings = Seq(
  organization := "biz.enef",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint")
)

lazy val root = project.in(file(".")).
  aggregate(sconfigJVM,sconfigJS).
  settings(commonSettings:_*).
  settings(sonatypeSettings: _*).
  settings(
    name := "sconfig",
    publish := {},
    publishLocal := {}
  )

lazy val sconfig = crossProject.in(file(".")).
  settings(commonSettings:_*).
  settings(publishingSettings:_*).
  settings(
    name := "sconfig"
  ).
  jvmSettings(
    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.3.+"
    )
  ).
  jsSettings(
    //preLinkJSEnv := NodeJSEnv().value,
    //postLinkJSEnv := NodeJSEnv().value
  )

lazy val sconfigJVM = sconfig.jvm
lazy val sconfigJS = sconfig.js


lazy val publishingSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := (
    <url>https://github.com/jokade/sconfig</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:jokade/sconfig</url>
      <connection>scm:git:git@github.com:jokade/sconfig.git</connection>
    </scm>
    <developers>
      <developer>
        <id>jokade</id>
        <name>Johannes Kastner</name>
        <email>jokade@karchedon.de</email>
      </developer>
    </developers>
  )
)
 
