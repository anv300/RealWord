import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.event.*;

public class PlayerScreen extends Screen {
  public List<String> players = new ArrayList<>();
  
  public PlayerScreen(Screen prevScreen) {
    super(new JFrame(), prevScreen);
  }

  JList playlistB;

  protected JList drawPlayerList() {
    if(playlistB != null) playlistB.setVisible(false);
    DefaultListModel dlm = new DefaultListModel();
    for(String player : players) {
      dlm.addElement(player);
    } 
    JScrollPane scrollPane = new JScrollPane();
    JList playersList = new JList(dlm);
    // JPanel playersList = new JPanel(); 
    // playersList.setBounds(30,80,320,100);
    playersList.setBackground(Color.gray);
    // playersList.setLayout(new BoxLayout(playersList, BoxLayout.Y_AXIS));
    // for(String player : players) {
    //   JLabel label = new JLabel(player);
    //   playersList.add(label);
    // }
    // playlistB = playersList;
    // JScrollPane scrollFrame = new JScrollPane(playersList);
    // playersList.setAutoscrolls(true);
    // frame.add(scrollFrame);
    scrollPane.setViewportView(playersList);
    scrollPane.setBounds(30,80,240,100);
    frame.add(scrollPane);
    playlistB = playersList;
    return playersList;
  }

  public void draw() {
    JFrame f = frame;  
          
    JLabel title = new JLabel("Add players");
    title.setBounds(150, 0, 200, 50);
    f.add(title);

    addTestPlayers();
    drawPlayerList();

    JButton deletePlayer = new JButton("Delete");
    deletePlayer.setBounds(280,90, 100, 80);
    deletePlayer.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
            // if(list1.getSelectedIndex() != -1) {                       
            //         data = "Programming language Selected: " + list1.getSelectedValue();   
            //         label.setText(data);  
            //      }   
            if(playlistB.getSelectedIndex() != -1) {
              ((DefaultListModel) playlistB.getModel()).remove(playlistB.getSelectedIndex());
              players.remove(playlistB.getSelectedValue());
            } 
        }  
    }); 
    f.add(deletePlayer);

    addBackButton();
    addHelp();
    finishDraw();
  }

  protected void addTestPlayers() {
    players.add("svelte");
    players.add("react");
    players.add("vue");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
    players.add("angular");
  }
}