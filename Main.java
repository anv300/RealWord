import javax.swing.*;

public class Main {
  public static Screen screen = new MenuScreen();

  public static void setScreen(Screen screen1) {
    screen.clear();
    screen = screen1;
    screen1.draw();
  }

  public static void main(String[] args) {
    // System.out.println("h");
    setScreen(screen);
  }
}