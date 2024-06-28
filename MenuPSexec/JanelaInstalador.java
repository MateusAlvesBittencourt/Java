import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JanelaInstalador extends JFrame {
    private JTextField campoInstalador;
    private JTextField campoParametros;
    private JTextField campoPatrimonio;
    private JTextArea areaScript;
    private GeradorDeScript gerador;
    private JButton botaoGerar;
    private JButton botaoInstalar;

    public JanelaInstalador() {
        setTitle("Gerador de Script PSExec");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gerador = new GeradorDeScript();

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Selecione o Instalador
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        painel.add(new JLabel("Selecione o Instalador:"), constraints);

        campoInstalador = new JTextField();
        campoInstalador.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        painel.add(campoInstalador, constraints);

        JButton botaoProcurar = new JButton("Procurar...");
        botaoProcurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser seletorArquivo = new JFileChooser();
                int valorRetorno = seletorArquivo.showOpenDialog(null);
                if (valorRetorno == JFileChooser.APPROVE_OPTION) {
                    campoInstalador.setText(seletorArquivo.getSelectedFile().getAbsolutePath());
                }
            }
        });
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        painel.add(botaoProcurar, constraints);

        // Parâmetros de Instalação
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        painel.add(new JLabel("Parâmetros de Instalação:"), constraints);

        campoParametros = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        painel.add(campoParametros, constraints);

        // Patrimônio
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        painel.add(new JLabel("Patrimônio:"), constraints);

        campoPatrimonio = new JTextField();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        painel.add(campoPatrimonio, constraints);

        add(painel, BorderLayout.NORTH);

        areaScript = new JTextArea();
        areaScript.setEditable(false);
        areaScript.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaScript);
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        botaoGerar = new JButton("Gerar Script");
        botaoGerar.addActionListener(new GerarScriptListener());
        painelBotoes.add(botaoGerar);

        botaoInstalar = new JButton("Instalar");
        botaoInstalar.addActionListener(new InstalarScriptListener());
        botaoInstalar.setEnabled(false); // Desabilitar o botão de instalar inicialmente
        painelBotoes.add(botaoInstalar);

        JButton botaoEncerrar = new JButton("Encerrar");
        botaoEncerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        painelBotoes.add(botaoEncerrar);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private class GerarScriptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String instalador = campoInstalador.getText();
            String parametros = campoParametros.getText();
            String patrimonio = campoPatrimonio.getText();

            if (instalador.isEmpty() || patrimonio.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios antes de gerar o script.");
                return;
            }

            try {
                String script = gerador.gerarScript(instalador, parametros, patrimonio);
                areaScript.setText(script);
                botaoInstalar.setEnabled(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar o script: " + ex.getMessage());
            }
        }
    }

    private class InstalarScriptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String script = areaScript.getText();
            if (script.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Gere o script primeiro!");
                return;
            }

            try {
                gerador.executarScript(script);
                JOptionPane.showMessageDialog(null, "Instalação concluída com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao executar o script: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JanelaInstalador().setVisible(true);
            }
        });
    }
}
