import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}

import scala.util.Random

object Main extends App {
  val config = new LwjglApplicationConfiguration
  config.title = "Scala Snake Game (by miketav2016 realisation)"
  config.width = 500
  config.height = 500
  val frame = sourse.Frame(sourse.Point(0, 0), sourse.Point(100, 100))
  val food = sourse.Food(sourse.Point(
    (new Random).between(frame.min.x, frame.max.x),
    (new Random).between(frame.min.y, frame.max.y)
  ))
  val snake = sourse.Snake(sourse.Point(7, 5) :: sourse.Point(6, 5) :: sourse.Point(5, 5) :: Nil, sourse.Right)
  val game = sourse.Game(food, snake, frame, 0, snake)
  new LwjglApplication(new SnakeGame(game, sizeMultiplayer = 5), config)
}
