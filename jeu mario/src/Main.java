import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static Screen screen = new Screen();

    static int width = 700;
    static int height = 350;
    
    public static void main(String[] args) throws Exception {


        JFrame window = new JFrame("Mario");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        //screen = new Screen();

        window.setContentPane(screen);
        window.setVisible(true);
    }
}
