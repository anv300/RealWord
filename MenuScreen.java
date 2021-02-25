import javax.swing.*;
import java.awt.event.*;

public class MenuScreen extends Screen {
  public MenuScreen() {
    super(new JFrame(), null);
  }

  public void draw() {
    JFrame f = frame;  
          
    // JButton b=new JButton("click");
// b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
          
    // f.add(b);//adding button in JFrame  

    Screen this1 = this;
          
    JLabel title = new JLabel("RealWord");
    title.setBounds(150, 0, 100, 50);
    f.add(title);

    JButton start = new JButton("Start");
    start.setBounds(150, 150, 70, 20);
    f.add(start);

     start.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
            Main.setScreen(new PlayerScreen(this1));  
        }  
    });  

    addHelp();
    finishDraw();
  }
}