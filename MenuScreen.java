import javax.swing.*;

public class MenuScreen extends Screen {
  public MenuScreen() {
    super(new JFrame());
  }

  public void draw() {
    JFrame f = frame;  
          
    // JButton b=new JButton("click");
// b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
          
    // f.add(b);//adding button in JFrame  
          
    JLabel title = new JLabel("RealWord");
    title.setBounds(150, 0, 100, 50);
    f.add(title);

    JButton start = new JButton("Start");
    start.setBounds(150, 200, 70, 20);
    f.add(start);

    f.setSize(400,500);//400 width and 500 height  
  f.setLayout(null);//using no layout managers  
  f.setResizable(false);
    f.setVisible(true);//making the frame visible
    addHelp();
  }
}