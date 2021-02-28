import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class WinScreen extends Screen {

    private final List<String> players;
    private final String word;
    private final String def;
    private final List<String> defs;
    private final String turn;

    public WinScreen(List<String> players, String word, String def, List<String> defs, String turn) {
        super(new JFrame("RealWord - yay you win"), new MenuScreen());
        this.players = players;
        this.word = word;
        this.def = def;
        this.defs = defs;
        this.turn = turn;
    }

    @Override
    public void draw() {
        JFrame f=frame;

        JLabel title = new JLabel("yay you win");
        title.setBounds(150, 0, 100, 50);
        f.add(title);

        URL url = null;
        try {
            url = new URL("https://raw.githubusercontent.com/anv300/images/main/svelte.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(url);
//        icon.height
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 230, 230);
        f.getContentPane().add(label);

        boolean rel = false;
        JButton r = new JButton("rel");
        r.setBounds(100, 100, 50, 50);
        r.addActionListener((e -> {
            Main.setScreen(new WinScreen(players, word, def, defs, turn));
        }));
        if(rel) {
            f.add(r);
        }

        AtomicInteger addedInfo = new AtomicInteger();
        BiConsumer<String, String> addInfo = (name, val) -> {
            JLabel i = new JLabel(name + ": " + val);
            i.setBounds(240, 20 * addedInfo.get(), 300, 30);
            f.add(i);
            addedInfo.getAndIncrement();
        };

//        JLabel w = new JLabel("Word: " + word);
//        w.setBounds(240, 0, 300, 30);
//        f.add(w);

        addInfo.accept("Word", word);
        addInfo.accept("Definition", def);
        addInfo.accept("Guessed by", turn);

        addBackButton();
        finishDraw();
    }

    @Override
    public String getBackText() {
        return "Main menu";
    }
}
