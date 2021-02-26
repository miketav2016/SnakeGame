name := "SnakeGame"
version := "0.1"
scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl" % "1.9.10",
  "com.badlogicgames.gdx" % "gdx-platform" % "1.9.10" classifier "natives-desktop"
)
assemblyJarName in assembly := "SnakeGame-1.0.jar"



