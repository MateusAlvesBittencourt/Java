public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JanelaInstalador frame = new JanelaInstalador();
                frame.setVisible(true);
            }
        });
    }
}
