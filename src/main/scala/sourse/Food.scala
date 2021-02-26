package sourse

import scala.util.Random

case class Food(body: Point) {
  def moveRandomIn(frame: Frame): Food = {
    val x = (new Random).between(frame.min.x, frame.max.x)
    val y = (new Random).between(frame.min.y, frame.max.y)
    copy(body = Point(x, y))
  }
}
