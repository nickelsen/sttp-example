ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

val zioV = "2.0.2"
val sttpV = "3.8.2"
val sttpSharedV = "1.3.9"
val circeV = "0.14.2"

lazy val root = (project in file("."))
  .settings(
    name := "sttp-example",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioV,
      "dev.zio" %% "zio-test" % zioV % Test,
      "com.softwaremill.sttp.client3" %% "zio" % sttpV,
      "com.softwaremill.sttp.client3" %% "core" % sttpV,
      "com.softwaremill.sttp.model" %% "core" % "1.5.2",
      "com.softwaremill.sttp.shared" %% "core" % sttpSharedV,
      "com.softwaremill.sttp.shared" %% "zio" % sttpSharedV,
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % sttpV,
      "dev.zio" %% "zio-stacktracer" % zioV,
      "dev.zio" %% "zio-streams" % zioV,
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
