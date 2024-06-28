// Classe App
public class App {
    public static void main(String[] args) {
        SoftwareManager manager = new SoftwareManager();
        Interface gui = new Interface(manager);
        gui.setVisible(true);
    }
}