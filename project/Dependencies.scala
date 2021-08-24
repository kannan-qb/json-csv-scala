import sbt._
object Dependencies {

  lazy val sprayjsonVersion = "1.3.6"

  lazy val sprayJson = "io.spray" %% "spray-json" % sprayjsonVersion

  lazy val typeSafeConfigVersion = "1.4.1"

  lazy val typeSafeConfig = "com.typesafe" % "config" % typeSafeConfigVersion

  def compileDependenceies:Seq[ModuleID]=Seq(sprayJson,typeSafeConfig)

}
