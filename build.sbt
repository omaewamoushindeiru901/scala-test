name := "scala-selenium"

version := "0.1"

scalaVersion := "2.13.8"

fork in Test := true

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-java" % "3.141.59",
  "org.scalatestplus" %% "scalatestplus-selenium" % "1.0.0-M2",
  "org.scalatest" %% "scalatest" % "3.1.1" % Test)
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/reports")

val allureScalaTestVersion = "2.13.3"

resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "io.qameta.allure" % "allure-scalatest_2.13" % allureScalaTestVersion % Test

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
  Tests.Argument(TestFrameworks.ScalaTest, "-C", "io.qameta.allure.scalatest.AllureScalatest")
)

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.10"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"