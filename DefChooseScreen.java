import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DefChooseScreen extends Screen {
    public final List<String> defs;
    public final List<String> players;
    public final String word;
    public String rightDef;

    public DefChooseScreen(List<String> players, String word, Screen prevScreen) {
        super(new JFrame("RealWord - Add definitions"), prevScreen);
        this.players = players;
        this.word = word;
        this.defs = new ArrayList<>();
    }

    JList listB;
    JScrollPane p;

    protected void drawList() {
        if(p != null) {
            p.setVisible(false);
            frame.remove(p);
        };
        DefaultListModel dlm = new DefaultListModel();
        for(String def : defs) {
            dlm.addElement(def);
        }
        JScrollPane scrollPane = new JScrollPane();
        JList list = new JList(dlm);
        list.setBackground(Color.gray);

        scrollPane.setViewportView(list);
        scrollPane.setBounds(30,80,240,100);
        frame.add(scrollPane);
        listB = list;
        p = scrollPane;
    }

    @Override
    public void draw() {
        JFrame f = frame;

        JLabel right = new JLabel("Right definition: None");
        right.setBounds(0, 10, 500, 100);
        f.add(right);

        Consumer<String> setRight = (r) -> {
            right.setText("Right definition: " + r);
            rightDef = r;
        };

        JLabel title = new JLabel("Add definitions");
        title.setBounds(150, 0, 100, 50);
        f.add(title);

        JLabel wo = new JLabel("Chosen word: " + word);
        wo.setBounds(50, 10, 500, 50);
        f.add(wo);


        JButton deletePlayer = new JButton("Delete");
        deletePlayer.setBounds(280,90, 100, 30);
        deletePlayer.addActionListener(e -> {
            // if(list1.getSelectedIndex() != -1) {
            //         data = "Programming language Selected: " + list1.getSelectedValue();
            //         label.setText(data);
            //      }
            if(listB.getSelectedIndex() != -1) {
                if(listB.getSelectedValue().equals(rightDef)) {
                    setRight.accept("None");
                }
                ((DefaultListModel) listB.getModel()).remove(listB.getSelectedIndex());
                defs.remove(listB.getSelectedValue());
            }
        });

        f.add(deletePlayer);

        JButton markRight = new JButton("Mark right");
        markRight.setBounds(280,140, 100, 30);
        markRight.addActionListener(
                e -> {
                    if(listB.getSelectedIndex() != -1) {
                        setRight.accept(String.valueOf(listB.getSelectedValue()));
                    }
                }
        );
        f.add(markRight);

        JTextField addPlayer = new JTextField();
        addPlayer.addActionListener(
                ae -> {
                    if(!addPlayer.getText().equals("")) {
                        ((DefaultListModel) listB.getModel()).addElement(addPlayer.getText());
                        defs.add(addPlayer.getText());
                        addPlayer.setText("");
                    }

                }
        );
        addPlayer.setBounds(125, 200, 200, 20);
        f.add(addPlayer);

        drawList();

        JButton continu = new JButton("Continue");
        continu.setBounds(10, 200, 100, 20);
        continu.addActionListener(e -> {
            if(rightDef.equals("None")) return;
            Main.setScreen(new GameScreen(players, word, rightDef, defs, this));
        });
        f.add(continu);

        addBackButton();
        addHelp();
        finishDraw();
    }
}
