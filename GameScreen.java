import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends Screen{

    public final List<String> players;
    public final String word;
    public final String def;
    public final List<String> defs;
    private final String chosenPlr;
    public String currentTurn;
    public final JLabel turnL;
    public final List<String> plrs;

    public String nextTurn() {
        String toR = plrs.get(plrs.indexOf(currentTurn) + 1);
        currentTurn = toR;
        turnL.setText("Current turn: " + currentTurn);
        return toR;
    }

    public GameScreen(List<String> players, String word, String def, List<String> defs, String chosenPlr, Screen prevScreen) {
        super(new JFrame("RealWord"), prevScreen);
        this.players = players;
        this.word = word;
        this.def = def;
        this.defs = defs;
        this.chosenPlr = chosenPlr;
        plrs = new ArrayList<>();
        plrs.addAll(players);
        plrs.remove(chosenPlr);
        currentTurn = plrs.get(0);
        turnL = new JLabel("Current turn: " + currentTurn);
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
        scrollPane.setBounds(30,90,240,100);
//        list.addListSelectionListener((this::valueChanged));
        frame.add(scrollPane);
        listB = list;
        p = scrollPane;
    }

    protected void guessDef() {
        if(listB.getSelectedValue().equals(def)) {
            System.out.println("Guessed right!");
            Main.setScreen(new WinScreen(players, word, def, defs, chosenPlr, currentTurn));
        } else {
            System.out.println("Guessed wrong!");
            nextTurn();
            defs.remove(listB.getSelectedValue());
            ((DefaultListModel) listB.getModel()).removeElement(listB.getSelectedValue());
        }
    }

    @Override
    public void draw() {
        JFrame f = frame;

        JLabel title = new JLabel("RealWord");
        title.setBounds(150, 0, 100, 50);
        f.add(title);

        JLabel cWord = new JLabel("Word: " + word);
        cWord.setBounds(120, 35, 200, 50);
        f.add(cWord);

        JLabel in = new JLabel("Click the definition that you think is right");
        in.setBounds(70, 50, 400, 50);
        f.add(in);

        JButton check = new JButton("Check!");
        check.setBounds(280,90, 100, 30);
        check.addActionListener(this::guessDef);
        f.add(check);

        turnL.setBounds(120, 20, 200, 50);
        f.add(turnL);

        drawList();

        addHelp();
        addBackButton();
        finishDraw();
    }

    private void guessDef(ActionEvent actionEvent) {
        guessDef();
    }
}
