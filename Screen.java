import javax.swing.*;

public abstract class Screen {
  public final JFrame frame;

  public Screen(JFrame frame) {
    this.frame = frame;
  }

  public abstract void draw();

  public void clear() {
    frame.setVisible(false);
  }
}