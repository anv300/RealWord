import javax.swing.*;
import java.awt.event.*;

public abstract class Screen {
  public final JFrame frame;
  public final Screen prevScreen;

  public Screen(JFrame frame, Screen prevScreen) {
    this.frame = frame;
    this.prevScreen = prevScreen;
  }

  protected void finishDraw() {
    frame.setSize(400,500);//400 width and 500 height  
  frame.setLayout(null);//using no layout managers  
  frame.setResizable(false);
    frame.setVisible(true);//making the frame visible
  }

  public abstract void draw();

  public void clear() {
    frame.setVisible(false);
  }

  public String getHelpText() {
    return "Click here for help";
  }
  
  public String getHelpLink() {
    return "https://github.com/anv300/RealWord/wiki";
  }

  public LabelLink getHelp() {
    LabelLink l = new LabelLink(getHelpText(), getHelpLink());
    l.setBounds(125, 200, 200, 20);
    return l;
  }

  protected void addHelp() {
    frame.add(getHelp());
  }

  public JButton getBackButton() {
    JButton back = new JButton("Back");
    back.setBounds(0, 0, 70, 20);
     back.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
            Main.setScreen(prevScreen);  
        }  
    }); 
    return back;
  }

  public void addBackButton() {
    if(prevScreen == null) return;
    frame.add(getBackButton());
  }
}