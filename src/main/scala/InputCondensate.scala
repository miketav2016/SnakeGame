import com.badlogic.gdx.InputAdapter

class InputCondensate extends InputAdapter {
  private var keys: List[Int] = Nil
  def list: List[Int] = keys.reverse
  def clear(): Unit = keys = Nil

  override def keyDown(keycode: Int): Boolean = {
    keys = keycode :: keys
    true
  }


}
