//      Project: sconfig
//       Author: jokade <jkspam@karchedon.de>
//  Description: SBT build definition for the sconfig library
name := "sconfig"

version in ThisBuild := "0.1-SNAPSHOT"

organization in ThisBuild := "biz.enef"

scalaVersion in ThisBuild := "2.11.1"

scalacOptions ++= Seq("-deprecation","-feature","-Xlint")

lazy val jvm = project

lazy val js = project

lazy val root = project.in( file(".") ).aggregate(jvm,js).settings( publish := {} )

publishTo in ThisBuild := Some( Resolver.sftp("repo", "karchedon.de", "/www/htdocs/w00be83c/maven.karchedon.de/") )
