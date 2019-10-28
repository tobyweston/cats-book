name := "cats-book"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.0.0"
)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-unchecked"
)
