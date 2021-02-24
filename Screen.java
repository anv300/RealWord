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

  public String getHelpText() {
    return "Click here for help";
  }
  
  public String getHelpLink() {
    return "https://github.com/anv300/RealWord/wiki";
  }

  public LabelLink getHelp() {
    return new LabelLink(getHelpText(), getHelpLink());
  }

  protected void addHelp() {
    frame.add(getHelp());
  }
}