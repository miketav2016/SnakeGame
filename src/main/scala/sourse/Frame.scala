package sourse

case class Frame(min: Point, max: Point) {
  def points: Seq[Point] = {
    for (i <- min.x until max.x;
         j <- min.y until max.y
         if i == min.x || i == max.x || j == min.y || j == max.y)
      yield Point(i, j)
  }
}
