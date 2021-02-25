import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerScreen extends Screen {
  public List<String> players = new ArrayList<>();
  
  public PlayerScreen(Screen prevScreen) {
    super(new JFrame(), prevScreen);
  }

  public void draw() {
    JFrame f = frame;  
          
    JLabel title = new JLabel("Add players");
    title.setBounds(150, 0, 100, 50);
    f.add(title);

    addBackButton();
    addHelp();
    finishDraw();
  }
}