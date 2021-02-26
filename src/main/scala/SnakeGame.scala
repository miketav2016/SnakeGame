import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.{Color, GL20}
import com.badlogic.gdx.{Game, Gdx}
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType

class SnakeGame(var game: sourse.Game, val sizeMultiplayer: Float) extends Game {
  lazy val prs = new InputCondensate
  lazy val shapeRenderer = new ShapeRenderer()

  override def create() = Gdx.input.setInputProcessor(prs)

  override def render(): Unit = {
    game = game.handle(prs.list.map {
      case Keys.UP => sourse.Up
      case Keys.DOWN => sourse.Down
      case Keys.LEFT => sourse.Left
      case Keys.RIGHT => sourse.Right
    }).update(Gdx.graphics.getDeltaTime)

    prs.clear()
    Gdx.gl.glClearColor(1, 1, 1, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    shapeRenderer.setColor(Color.BLACK)
    shapeRenderer.begin(ShapeType.Filled)
    for (p <- game.points())
      shapeRenderer.circle(p.x * sizeMultiplayer, p.y * sizeMultiplayer, sizeMultiplayer / 2)
    shapeRenderer.end()
  }
}
