ThisBuild / scalaVersion := "3.3.0" // Ou la version Scala de votre projet

lazy val root = (project in file("."))
  .settings(
    name := "dsl_project",
    Compile / run / mainClass := Some("Main") // Spécifiez le nom de la classe principale
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.15.4" % Test