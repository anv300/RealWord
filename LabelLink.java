import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LabelLink extends JLabel {
  public String link;

  public LabelLink(String text, String link) {
    super(text);
    this.link = link;
  }

  {
    setForeground(Color.BLUE.darker());
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    addMouseListener(new MouseAdapter() {
 
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
         
        Desktop.getDesktop().browse(new URI(link));
         
    } catch (IOException | URISyntaxException e1) {
        e1.printStackTrace();
    }
    }
});
  }
}