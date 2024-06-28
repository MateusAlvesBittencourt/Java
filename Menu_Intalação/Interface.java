import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Interface extends JFrame {
    // Declaração de variáveis
    private SoftwareManager manager;
    private JList<String> softwareList;
    private JButton installButton;
    private JButton exitButton;
    private JLabel statusLabel;
    private BufferedImage backgroundImage;

    // Construtor da classe Interface
    public Interface(SoftwareManager manager) {
        this.manager = manager;
        setTitle("Menu de Instalações"); // Título da janela
        setSize(800, 600); // Tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ação ao fechar a janela
        setLocationRelativeTo(null); // Posiciona a janela no centro da tela

        // Carregar a imagem de fundo
        try {
            backgroundImage = ImageIO.read(new File("J:\\W\\WALLPAPER\\Deploy.png")); // Caminho para a sua imagem
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Painel principal customizado com imagem de fundo
        BackgroundPanel mainPanel = new BackgroundPanel(backgroundImage);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Adiciona margem ao redor do painel

        // Painel para exibir a lista de softwares
        JPanel softwarePanel = new JPanel(new BorderLayout());
        softwarePanel.setOpaque(false); // Tornar o painel transparente

        // Criação da lista de softwares
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Software software : manager.getSoftwareList()) {
            listModel.addElement(software.getName());
        }
        softwareList = new JList<>(listModel);
        softwareList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        softwareList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        softwareList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        softwareList.setOpaque(false); // Tornar a JList transparente
        softwareList.setBackground(new Color(0, 0, 0, 0)); // Fundo transparente
        softwareList.setForeground(Color.WHITE); // Cor do texto

        // Tornar o JScrollPane transparente
        JScrollPane scrollPane = new JScrollPane(softwareList);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(new LineBorder(Color.WHITE, 1)); // Bordas brancas

        softwarePanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(softwarePanel, BorderLayout.CENTER);

        // Painel para os botões
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setOpaque(false); // Tornar o painel transparente

        // Botão de instalar
        installButton = createStyledButton("Instalar", new Color(63, 81, 181));
        installButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                installSelectedSoftware();
            }
        });
        buttonPanel.add(installButton);

        // Botão de encerrar
        exitButton = createStyledButton("Encerrar", new Color(183, 28, 28));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Encerra o programa
            }
        });
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Label de status
        statusLabel = new JLabel("Aguardando seleção...");
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto
        statusLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        mainPanel.add(statusLabel, BorderLayout.NORTH);

        getContentPane().add(mainPanel); // Adiciona o painel principal ao conteúdo da janela
    }

    // Método para criar botões estilizados
    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Adicionar efeito de hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor.darker());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(backgroundColor);
            }
        });

        return button;
    }

    // Método para instalar o software selecionado
    public void installSelectedSoftware() {
        String selectedSoftwareName = softwareList.getSelectedValue();
        if (selectedSoftwareName != null && !selectedSoftwareName.isEmpty()) {
            manager.installSoftware(selectedSoftwareName, statusLabel);
        } else {
            manager.informUserToSelectInstallation(statusLabel);
        }
    }

    // Painel customizado para desenhar a imagem de fundo
    class BackgroundPanel extends JPanel {
        private BufferedImage image;

        public BackgroundPanel(BufferedImage image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
