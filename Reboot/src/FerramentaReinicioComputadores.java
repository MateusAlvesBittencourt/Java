import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class FerramentaReinicioComputadores extends JFrame {
    private JLabel statusLabel;
    private JTextArea listaComputadoresTextArea;
    private JTextArea naoReiniciadosTextArea;
    private JButton selecionarArquivoButton;
    private JButton reiniciarComputadoresButton;
    private ComputadorManager computadorManager;

    public FerramentaReinicioComputadores() {
        super("Ferramenta de Reinício de Computadores");
        computadorManager = new ComputadorManager();

        configurarInterface();
    }

    private void configurarInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        statusLabel = new JLabel("Selecione um arquivo .txt com os nomes dos computadores.");
        listaComputadoresTextArea = new JTextArea(10, 40);
        listaComputadoresTextArea.setEditable(false); // Impede edição manual
        JScrollPane scrollPaneLista = new JScrollPane(listaComputadoresTextArea);

        naoReiniciadosTextArea = new JTextArea(5, 40);
        naoReiniciadosTextArea.setEditable(false); // Impede edição manual
        JScrollPane scrollPaneNaoReiniciados = new JScrollPane(naoReiniciadosTextArea);

        selecionarArquivoButton = new JButton("Selecionar Arquivo");
        reiniciarComputadoresButton = new JButton("Reiniciar Computadores");

        selecionarArquivoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selecionarArquivo();
            }
        });

        reiniciarComputadoresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        FerramentaReinicioComputadores.this,
                        "Deseja realmente reiniciar os computadores listados?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    reiniciarComputadores();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(statusLabel, BorderLayout.NORTH);
        panel.add(scrollPaneLista, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(selecionarArquivoButton);
        buttonsPanel.add(reiniciarComputadoresButton);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        JPanel naoReiniciadosPanel = new JPanel(new BorderLayout());
        naoReiniciadosPanel.add(new JLabel("Computadores que não foram reiniciados:"), BorderLayout.NORTH);
        naoReiniciadosPanel.add(scrollPaneNaoReiniciados, BorderLayout.CENTER);

        add(panel, BorderLayout.NORTH);
        add(naoReiniciadosPanel, BorderLayout.SOUTH);
    }

    private void selecionarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
            statusLabel.setText("Arquivo selecionado: " + caminhoArquivo);
            computadorManager.setCaminhoArquivo(caminhoArquivo);

            try {
                mostrarListaComputadores();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao ler o arquivo: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void mostrarListaComputadores() throws IOException {
        String conteudoArquivo = computadorManager.obterConteudoArquivo();
        listaComputadoresTextArea.setText(conteudoArquivo);
    }

    private void reiniciarComputadores() {
        try {
            ArrayList<String> naoReiniciados = computadorManager.reiniciarComputadores();
            if (!naoReiniciados.isEmpty()) {
                naoReiniciadosTextArea.setText(String.join("\n", naoReiniciados));
            } else {
                naoReiniciadosTextArea.setText("Todos os computadores foram reiniciados com sucesso.");
            }
            JOptionPane.showMessageDialog(this, "Reinício solicitado para todos os computadores listados.");
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(this, "Erro ao reiniciar computadores: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FerramentaReinicioComputadores().setVisible(true);
            }
        });
    }
}
