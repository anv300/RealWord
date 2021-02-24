public class PlayerScreen extends Screen {
  public List<String> players = new ArrayList<>();
  
  public MenuScreen() {
    super(new JFrame());
  }

  public void draw() {
    JFrame f = frame;  
          
    JLabel title = new JLabel("Add players");
    title.setBounds(150, 0, 100, 50);
    f.add(title);
  }
}