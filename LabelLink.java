import javax.swing.*;
import java.awt.Color;
import java.net.URI;

public class LabelLink extends JLabel {
  public String link;

  public LabelLink(String text, String link) {
    this.link = link;
    super(text);
  }

  {
    setForeground(Color.BLUE.darker());
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    addMouseListener(new MouseAdapter() {
 
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
         
        Desktop.getDesktop().browse(new URI("http://www.codejava.net"));
         
    } catch (IOException | URISyntaxException e1) {
        e1.printStackTrace();
    }
    }
});
  }
}