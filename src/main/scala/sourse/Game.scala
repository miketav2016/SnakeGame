package sourse

case class Game(food: Food, snake: Snake, frame: Frame, elapsedTime: Float, start: Snake) {
  def handle(input: List[Direction]): Game = {
    if (input.isEmpty) {
      this
    } else {
      copy(snake = input.foldLeft(snake)((s, d) => s.turn(d)))
    }
  }

  def update(deltaTime: Float): Game = {
    val elapsed = elapsedTime + deltaTime
    val speed = snake.body.length.toDouble / 1000
    if (elapsed > 0.1 - speed) {
      copy(snake = snake.move(), elapsedTime = 0) match {
        case game if !game.snake.headIsIn(frame) => game.reset()
        case game if game.snake.isBitTail => game.reset()
        case game if game.snake.canEat(food) => game.copy(snake = snake.eat(food), food = food.moveRandomIn(frame))
        case game => game
      }
    } else {
      copy(elapsedTime = elapsed)
    }
  }

  def reset(): Game = {
    copy(snake = start)
  }

  def points(): List[Point] = (food.body :: snake.body) ::: frame.points.toList

}
