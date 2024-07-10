package viewer;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Caminhao;
import model.Carga;
import model.Cliente;
import model.Dados;
import model.Destino;
import model.Duravel;
import model.Perecivel;

public class Gerenciador extends javax.swing.JFrame {

    ArrayList<Caminhao> caminhoes;
    ArrayList<Cliente> clientes;
    ArrayList<Carga> cargas;
    ArrayList<Destino> destinos;
    DefaultTableModel dtmCaminhoes;
    DefaultTableModel dtmClientes;
    DefaultTableModel dtmCargas;
    DefaultTableModel dtmDestinos;
    Dados dados;

    public Gerenciador() {
        initComponents();
        init();
    }

    private void init() {
        this.setLocationRelativeTo(null);
        dados = new Dados();
        caminhoes = dados.getCaminhoes().isEmpty() ? new ArrayList<>() : dados.getCaminhoes();
        clientes = dados.getClientes().isEmpty() ? new ArrayList<>() : dados.getClientes();
        cargas = dados.getCargas().isEmpty() ? new ArrayList<>() : dados.getCargas();
        destinos = dados.getDestinos().isEmpty() ? new ArrayList<>() : dados.getDestinos();
        dtmCaminhoes = (DefaultTableModel) tabela_caminhoes.getModel();
        dtmClientes = (DefaultTableModel) tabela_clientes.getModel();
        dtmCargas = (DefaultTableModel) tabela_cargas.getModel();
        dtmDestinos = (DefaultTableModel) tabela_destinos.getModel();
        desabilitarCampos("caminhao");
        desabilitarCampos("cliente");
        desabilitarCampos("carga");
        desabilitarCampos("destino");

        iniciaTabelas();
    }

    public void iniciaTabelas() {
        for (Caminhao caminhao : dados.getCaminhoes()) {
            Object[] data = {caminhao.getCodigo(), caminhao.getNome(), caminhao.getAutonomia(), caminhao.getCusto()};
            dtmCaminhoes.addRow(data);
        }
        for (Cliente cliente : dados.getClientes()) {
            Object[] data = {cliente.getCodigo(), cliente.getNome(), cliente.getTelefone()};
            dtmClientes.addRow(data);
        }
        for (Carga carga : dados.getCargas()) {
            Object[] data = {carga.getCodigo(), carga.getOrigem(), carga.getDestino().getNome(), carga.getClass().getSimpleName(), carga.getPeso(), carga.getValor()};
            dtmCargas.addRow(data);
        }
        for (Destino destino : dados.getDestinos()) {
            Object[] data = {destino.getCodigo(), destino.getNome(), destino.getCidade()};
            dtmDestinos.addRow(data);
        }
    }

    private void defineTipo() {
        switch (combobox_tipo_carga.getSelectedIndex()) {
            case 0:
                label1.setVisible(false);
                txt_setor_carga.setVisible(false);
                label2.setText("VALIDADE");
                break;
            case 1:
                label1.setVisible(true);
                txt_setor_carga.setVisible(true);
                label2.setText("MATERIAL");
                break;
        }
    }

    private void habilitarCampos(String objeto) {
        switch (objeto) {
            case "caminhao":
                txt_codigo_caminhao.setEnabled(true);
                txt_nome_caminhao.setEnabled(true);
                txt_autonomia_caminhao.setEnabled(true);
                txt_custo_caminhao.setEnabled(true);
                botao_cadastrar_caminhao.setText("CADASTRAR");
                break;
            case "cliente":
                txt_codigo_cliente.setEnabled(true);
                txt_nome_cliente.setEnabled(true);
                txt_telefone_cliente.setEnabled(true);
                botao_cadastrar_cliente.setText("CADASTRAR");
                break;
            case "carga":
                txt_codigo_carga.setEnabled(true);
                txt_valor_carga.setEnabled(true);
                txt_peso_carga.setEnabled(true);
                txt_tempo_carga.setEnabled(true);
                txt_origem_carga.setEnabled(true);
                txt_codigo_destino_carga.setEnabled(true);
                txt_nome_destino_carga.setEditable(false);
                txt_cidade_destino_carga.setEditable(false);
                txt_codigo_cliente_carga.setEnabled(true);
                txt_nome_cliente_carga.setEditable(false);
                txt_telefone_cliente_carga.setEditable(false);
                combobox_tipo_carga.setEnabled(true);
                txt_setor_carga.setEnabled(true);
                txt_validade_carga.setEnabled(true);
                botao_cadastrar_carga.setText("CADASTRAR");
                break;
            case "destino":
                txt_codigo_destino.setEnabled(true);
                txt_nome_destino.setEnabled(true);
                txt_cidade_destino.setEnabled(true);
                botao_cadastrar_destino.setText("CADASTRAR");
                break;
        }
    }

    private void desabilitarCampos(String objeto) {
        switch (objeto) {
            case "caminhao":
                txt_codigo_caminhao.setText("");
                txt_nome_caminhao.setText("");
                txt_autonomia_caminhao.setText("");
                txt_custo_caminhao.setText("");
                txt_codigo_caminhao.setEnabled(false);
                txt_nome_caminhao.setEnabled(false);
                txt_autonomia_caminhao.setEnabled(false);
                txt_custo_caminhao.setEnabled(false);
                botao_cadastrar_caminhao.setText("NOVO");
                break;
            case "cliente":
                txt_codigo_cliente.setText("");
                txt_nome_cliente.setText("");
                txt_telefone_cliente.setText("");
                txt_codigo_cliente.setEnabled(false);
                txt_nome_cliente.setEnabled(false);
                txt_telefone_cliente.setEnabled(false);
                botao_cadastrar_cliente.setText("NOVO");
                break;
            case "carga":
                txt_codigo_carga.setText("");
                txt_valor_carga.setText("");
                txt_peso_carga.setText("");
                txt_tempo_carga.setText("");
                txt_origem_carga.setText("");
                txt_codigo_destino_carga.setText("");
                txt_nome_destino_carga.setText("");
                txt_cidade_destino_carga.setText("");
                txt_codigo_cliente_carga.setText("");
                txt_nome_cliente_carga.setText("");
                txt_telefone_cliente_carga.setText("");
                combobox_tipo_carga.setSelectedIndex(0);
                txt_setor_carga.setText("");
                txt_validade_carga.setText("");
                txt_codigo_carga.setEnabled(false);
                txt_valor_carga.setEnabled(false);
                txt_peso_carga.setEnabled(false);
                txt_tempo_carga.setEnabled(false);
                txt_origem_carga.setEnabled(false);
                txt_codigo_destino_carga.setEnabled(false);
                txt_nome_destino_carga.setEnabled(false);
                txt_cidade_destino_carga.setEnabled(false);
                txt_codigo_cliente_carga.setEnabled(false);
                txt_nome_cliente_carga.setEnabled(false);
                txt_telefone_cliente_carga.setEnabled(false);
                combobox_tipo_carga.setEnabled(false);
                txt_setor_carga.setEnabled(false);
                txt_validade_carga.setEnabled(false);
                botao_cadastrar_carga.setText("NOVO");
                break;
            case "destino":
                txt_codigo_destino.setText("");
                txt_nome_destino.setText("");
                txt_cidade_destino.setText("");
                txt_codigo_destino.setEnabled(false);
                txt_nome_destino.setEnabled(false);
                txt_cidade_destino.setEnabled(false);
                botao_cadastrar_destino.setText("NOVO");
                break;
        }
    }

    private Destino buscaDestinoPorCodigo(int codigo) {
        for (Destino d : destinos) {
            if (d.getCodigo() == codigo) {
                return d;
            }
        }
        return null;
    }

    private Cliente buscaClientePorCodigo(int codigo) {
        for (Cliente c : clientes) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }

    private void cadastrar(String objeto) {
        switch (objeto) {
            case "caminhao":
                switch (botao_cadastrar_caminhao.getText()) {
                    case "NOVO":
                        habilitarCampos("caminhao");
                        txt_codigo_caminhao.requestFocus();
                        break;
                    case "CADASTRAR":
                        if (txt_codigo_caminhao.getText().isEmpty() || txt_nome_caminhao.getText().isEmpty() || txt_autonomia_caminhao.getText().isEmpty() || txt_custo_caminhao.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
                        } else {
                            Caminhao c = new Caminhao(Integer.parseInt(txt_codigo_caminhao.getText()), txt_nome_caminhao.getText(), Double.parseDouble(txt_autonomia_caminhao.getText()), Double.parseDouble(txt_custo_caminhao.getText()));
                            caminhoes.add(c);
                            Object[] data = {c.getCodigo(), c.getNome(), c.getAutonomia(), c.getCusto()};
                            dtmCaminhoes.addRow(data);
                            desabilitarCampos("caminhao");
                            dados.salvarDados(caminhoes, clientes, cargas, destinos);
                        }
                        break;
                    case "SALVAR":
                        if (txt_codigo_caminhao.getText().isEmpty() || txt_nome_caminhao.getText().isEmpty() || txt_autonomia_caminhao.getText().isEmpty() || txt_custo_caminhao.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
                        } else {
                            Caminhao mod = new Caminhao(Integer.parseInt(txt_codigo_caminhao.getText()), txt_nome_caminhao.getText(), Double.parseDouble(txt_autonomia_caminhao.getText()), Double.parseDouble(txt_custo_caminhao.getText()));
                            caminhoes.set(tabela_caminhoes.getSelectedRow(), mod);
                            dtmCaminhoes.setValueAt(mod.getCodigo(), tabela_caminhoes.getSelectedRow(), 0);
                            dtmCaminhoes.setValueAt(mod.getNome(), tabela_caminhoes.getSelectedRow(), 1);
                            dtmCaminhoes.setValueAt(mod.getAutonomia(), tabela_caminhoes.getSelectedRow(), 2);
                            dtmCaminhoes.setValueAt(mod.getCusto(), tabela_caminhoes.getSelectedRow(), 3);
                            botao_cadastrar_caminhao.setEnabled(true);
                            botao_editar_caminhao.setEnabled(true);
                            botao_excluir_caminhao.setEnabled(true);
                            desabilitarCampos("caminhao");
                            dados.salvarDados(caminhoes, clientes, cargas, destinos);
                        }
                        break;
                }
                break;
            case "cliente":
                switch (botao_cadastrar_cliente.getText()) {
                    case "NOVO":
                        habilitarCampos("cliente");
                        txt_codigo_cliente.requestFocus();
                        break;
                    case "CADASTRAR":
                        if (txt_codigo_cliente.getText().isEmpty() || txt_nome_cliente.getText().isEmpty() || txt_telefone_cliente.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
                        } else {
                            Cliente c = new Cliente(Integer.parseInt(txt_codigo_cliente.getText()), txt_nome_cliente.getText(), txt_telefone_cliente.getText());
                            clientes.add(c);
                            Object[] data = {c.getCodigo(), c.getNome(), c.getTelefone()};
                            dtmClientes.addRow(data);
                            desabilitarCampos("cliente");
                            dados.salvarDados(caminhoes, clientes, cargas, destinos);
                        }
                        break;
                    case "SALVAR":
                        Cliente mod = new Cliente(Integer.parseInt(txt_codigo_cliente.getText()), txt_nome_cliente.getText(), txt_telefone_cliente.getText());
                        clientes.set(tabela_clientes.getSelectedRow(), mod);
                        dtmClientes.setValueAt(mod.getCodigo(), tabela_clientes.getSelectedRow(), 0);
                        dtmClientes.setValueAt(mod.getNome(), tabela_clientes.getSelectedRow(), 1);
                        dtmClientes.setValueAt(mod.getTelefone(), tabela_clientes.getSelectedRow(), 2);
                        botao_cadastrar_cliente.setEnabled(true);
                        botao_editar_cliente.setEnabled(true);
                        botao_excluir_cliente.setEnabled(true);
                        desabilitarCampos("cliente");
                        dados.salvarDados(caminhoes, clientes, cargas, destinos);
                        break;
                }
                break;
            case "carga":
                switch (botao_cadastrar_carga.getText()) {
                    case "NOVO":
                        habilitarCampos("carga");
                        txt_codigo_carga.requestFocus();
                        break;
                    case "CADASTRAR":
                        if (combobox_tipo_carga.getSelectedIndex() == 0) {
                            Perecivel carga = new Perecivel(Integer.parseInt(txt_codigo_carga.getText()), txt_origem_carga.getText(), buscaDestinoPorCodigo(Integer.parseInt(txt_codigo_destino_carga.getText())), buscaClientePorCodigo(Integer.parseInt(txt_codigo_cliente_carga.getText())), Double.parseDouble(txt_peso_carga.getText()), Double.parseDouble(txt_valor_carga.getText()), Integer.parseInt(txt_tempo_carga.getText()), Integer.parseInt(txt_validade_carga.getText()));
                            cargas.add(carga);
                            Object[] data = {carga.getCodigo(), carga.getOrigem(), carga.getDestino().getNome(), carga.getClass().getSimpleName(), carga.getPeso(), carga.getValor(), String.valueOf(carga.getStatus()).replace("Status.", "")};
                            dtmCargas.addRow(data);
                            desabilitarCampos("carga");
                            dados.salvarDados(caminhoes, clientes, cargas, destinos);
                        } else {
                            Duravel carga = new Duravel(Integer.parseInt(txt_codigo_carga.getText()), txt_origem_carga.getText(), buscaDestinoPorCodigo(Integer.parseInt(txt_codigo_destino_carga.getText())), buscaClientePorCodigo(Integer.parseInt(txt_codigo_cliente_carga.getText())), Double.parseDouble(txt_peso_carga.getText()), Double.parseDouble(txt_valor_carga.getText()), Integer.parseInt(txt_tempo_carga.getText()), txt_setor_carga.getText(), txt_validade_carga.getText());
                            cargas.add(carga);
                            Object[] data = {carga.getCodigo(), carga.getOrigem(), carga.getDestino().getNome(), carga.getClass().getSimpleName(), carga.getPeso(), carga.getValor(), String.valueOf(carga.getStatus()).replace("Status.", "")};
                            dtmCargas.addRow(data);
                            desabilitarCampos("carga");
                            dados.salvarDados(caminhoes, clientes, cargas, destinos);
                        }
                        break;
                    case "SALVAR":
                        break;
                }

                break;
            case "destino":
                switch (botao_cadastrar_destino.getText()) {
                    case "NOVO":
                        habilitarCampos("destino");
                        txt_codigo_destino.requestFocus();
                        break;
                    case "CADASTRAR":
                        if (txt_codigo_destino.getText().isEmpty() || txt_nome_destino.getText().isEmpty() || txt_cidade_destino.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
                        } else {
                            Destino d = new Destino(Integer.parseInt(txt_codigo_destino.getText()), txt_nome_destino.getText(), txt_cidade_destino.getText());
                            Object[] data = {d.getCodigo(), d.getNome(), d.getCidade()};
                            dtmDestinos.addRow(data);
                            desabilitarCampos("destino");
                            dados.salvarDados(caminhoes, clientes, cargas, destinos);
                        }
                        break;
                    case "SALVAR":
                        Destino mod = new Destino(Integer.parseInt(txt_codigo_destino.getText()), txt_nome_destino.getText(), txt_cidade_destino.getText());
                        destinos.set(tabela_destinos.getSelectedRow(), mod);
                        dtmDestinos.setValueAt(mod.getCodigo(), tabela_destinos.getSelectedRow(), 0);
                        dtmDestinos.setValueAt(mod.getNome(), tabela_destinos.getSelectedRow(), 1);
                        dtmDestinos.setValueAt(mod.getCidade(), tabela_destinos.getSelectedRow(), 2);
                        botao_cadastrar_destino.setEnabled(true);
                        botao_editar_destino.setEnabled(true);
                        botao_excluir_destino.setEnabled(true);
                        desabilitarCampos("destino");
                        dados.salvarDados(caminhoes, clientes, cargas, destinos);
                        break;
                }
                break;

                

        }
    }

    private void editar(String objeto) {
        switch (objeto) {
            case "caminhao":
                if (tabela_caminhoes.getSelectedRow() < 0 || tabela_caminhoes.getSelectedRow() > caminhoes.size()) {
                    JOptionPane.showMessageDialog(null, "Selecione um item válido");
                } else {
                    habilitarCampos("caminhao");
                    txt_codigo_caminhao.setEnabled(false);
                    Caminhao c = caminhoes.get(tabela_caminhoes.getSelectedRow());
                    txt_codigo_caminhao.setText(String.valueOf(c.getCodigo()));
                    txt_nome_caminhao.setText(String.valueOf(c.getNome()));
                    txt_autonomia_caminhao.setText(String.valueOf(c.getAutonomia()));
                    txt_custo_caminhao.setText(String.valueOf(c.getCusto()));
                    botao_cadastrar_caminhao.setText("SALVAR");
                    botao_editar_caminhao.setEnabled(false);
                    botao_excluir_caminhao.setEnabled(false);
                }
                break;
            case "cliente":
                if (tabela_clientes.getSelectedRow() < 0 || tabela_clientes.getSelectedRow() > clientes.size()) {
                    JOptionPane.showMessageDialog(null, "Selecione um item válido");
                } else {
                    habilitarCampos("cliente");
                    txt_codigo_cliente.setEnabled(false);
                    Cliente c = clientes.get(tabela_clientes.getSelectedRow());
                    txt_codigo_cliente.setText(String.valueOf(c.getCodigo()));
                    txt_nome_cliente.setText(String.valueOf(c.getNome()));
                    txt_telefone_cliente.setText(String.valueOf(c.getTelefone()));
                    botao_cadastrar_cliente.setText("SALVAR");
                    botao_editar_cliente.setEnabled(false);
                    botao_excluir_cliente.setEnabled(false);
                }
                break;
            case "carga":
                if (tabela_cargas.getSelectedRow() < 0 || tabela_cargas.getSelectedRow() > cargas.size()) {
                    JOptionPane.showMessageDialog(null, "Selecione um item válido");
                } else {
                    habilitarCampos("carga");
                    txt_codigo_carga.setEnabled(false);
                    Carga c = cargas.get(tabela_cargas.getSelectedRow());
                    txt_codigo_carga.setText(String.valueOf(c.getCodigo()));
                    txt_valor_carga.setText(String.valueOf(c.getValor()));
                    txt_peso_carga.setText(String.valueOf(c.getPeso()));
                    txt_tempo_carga.setText(String.valueOf(c.getPrazo()));
                    txt_origem_carga.setText(String.valueOf(c.getOrigem()));
                    txt_codigo_destino_carga.setText(String.valueOf(c.getDestino().getCodigo()));
                    txt_nome_destino_carga.setText(String.valueOf(c.getDestino().getNome()));
                    txt_cidade_destino_carga.setText(String.valueOf(c.getDestino().getCidade()));
                    txt_codigo_cliente_carga.setText(String.valueOf(c.getCliente().getCodigo()));
                    txt_nome_cliente_carga.setText(String.valueOf(c.getCliente().getNome()));
                    txt_telefone_cliente_carga.setText(String.valueOf(c.getCliente().getTelefone()));
                    combobox_tipo_carga.setSelectedItem(c.getClass().getSimpleName());
                    txt_setor_carga.setText(c.getClass().getSimpleName().equals("Duravel") ? ((Duravel) c).getSetor() : "");
                    txt_validade_carga.setText(c.getClass().getSimpleName().equals("Perecivel") ? String.valueOf(((Perecivel) c).getValidade()) : "");
                    botao_cadastrar_carga.setText("SALVAR");
                    botao_editar_carga.setEnabled(false);
                    botao_excluir_carga.setEnabled(false);
                }
                break;
            case "destino":
                if (tabela_destinos.getSelectedRow() < 0 || tabela_destinos.getSelectedRow() > destinos.size()) {
                    JOptionPane.showMessageDialog(null, "Selecione um item válido");
                } else {
                    habilitarCampos("destino");
                    txt_codigo_destino.setEnabled(false);
                    Destino d = destinos.get(tabela_destinos.getSelectedRow());
                    txt_codigo_destino.setText(String.valueOf(d.getCodigo()));
                    txt_nome_destino.setText(String.valueOf(d.getNome()));
                    txt_cidade_destino.setText(String.valueOf(d.getCidade()));
                    botao_cadastrar_destino.setText("SALVAR");
                    botao_editar_destino.setEnabled(false);
                    botao_excluir_destino.setEnabled(false);
                }
                break;
        }
    }

    private void excluir(String objeto) {
        switch (objeto) {
            case "caminhao":
                if (tabela_caminhoes.getSelectedRow() < 0 || tabela_caminhoes.getSelectedRow() > caminhoes.size()) {
                    JOptionPane.showMessageDialog(null, "Selecione um item válido");
                } else {
                    int resultado = JOptionPane.showOptionDialog(null, "Deseja excluir este item?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (resultado == JOptionPane.YES_OPTION) {
                        caminhoes.remove(tabela_caminhoes.getSelectedRow());
                        dtmCaminhoes.removeRow(tabela_caminhoes.getSelectedRow());
                    }
                }
                break;
            case "cliente":
                if (tabela_clientes.getSelectedRow() < 0 || tabela_clientes.getSelectedRow() > clientes.size()) {
                    JOptionPane.showMessageDialog(null, "Selecione um item válido");
                } else {
                    int resultado = JOptionPane.showOptionDialog(null, "Deseja excluir este item?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (resultado == JOptionPane.YES_OPTION) {
                        clientes.remove(tabela_clientes.getSelectedRow());
                        dtmClientes.removeRow(tabela_clientes.getSelectedRow());
                    }
                }
                break;
            case "carga":
                if (tabela_cargas.getSelectedRow() < 0 || tabela_cargas.getSelectedRow() > cargas.size()) {
                    JOptionPane.showMessageDialog(null, "Selecione um item válido");
                } else {
                    int resultado = JOptionPane.showOptionDialog(null, "Deseja excluir este item?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (resultado == JOptionPane.YES_OPTION) {
                        cargas.remove(tabela_cargas.getSelectedRow());
                        dtmCargas.removeRow(tabela_cargas.getSelectedRow());
                    }
                }
                break;
            case "destino":
                if (tabela_destinos.getSelectedRow() < 0 || tabela_destinos.getSelectedRow() > destinos.size()) {
                    JOptionPane.showMessageDialog(null, "Selecione um item válido");
                } else {
                    int resultado = JOptionPane.showOptionDialog(null, "Deseja excluir este item?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (resultado == JOptionPane.YES_OPTION) {
                        destinos.remove(tabela_destinos.getSelectedRow());
                        dtmDestinos.removeRow(tabela_destinos.getSelectedRow());
                    }
                }
                break;
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {


        guias = new javax.swing.JTabbedPane();
        guia_caminhoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_caminhoes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nome_caminhao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_autonomia_caminhao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_custo_caminhao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        botao_cadastrar_caminhao = new javax.swing.JButton();
        botao_editar_caminhao = new javax.swing.JButton();
        botao_excluir_caminhao = new javax.swing.JButton();
        txt_codigo_caminhao = new javax.swing.JFormattedTextField();
        guia_clientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_clientes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        botao_cadastrar_cliente = new javax.swing.JButton();
        botao_editar_cliente = new javax.swing.JButton();
        botao_excluir_cliente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_codigo_cliente = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nome_cliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_telefone_cliente = new javax.swing.JFormattedTextField();
        guia_destinos = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        botao_cadastrar_destino = new javax.swing.JButton();
        botao_editar_destino = new javax.swing.JButton();
        botao_excluir_destino = new javax.swing.JButton();
        txt_codigo_destino = new javax.swing.JFormattedTextField();
        txt_nome_destino = new javax.swing.JTextField();
        txt_cidade_destino = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_destinos = new javax.swing.JTable();
        guia_cargas = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        combobox_tipo_carga = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txt_origem_carga = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_codigo_destino_carga = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_nome_destino_carga = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_cidade_destino_carga = new javax.swing.JTextField();
        txt_valor_carga = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_peso_carga = new javax.swing.JFormattedTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_codigo_cliente_carga = new javax.swing.JFormattedTextField();
        txt_nome_cliente_carga = new javax.swing.JTextField();
        txt_telefone_cliente_carga = new javax.swing.JTextField();
        txt_tempo_carga = new javax.swing.JFormattedTextField();
        label1 = new javax.swing.JLabel();
        txt_setor_carga = new javax.swing.JTextField();
        label2 = new javax.swing.JLabel();
        txt_validade_carga = new javax.swing.JFormattedTextField();
        jPanel12 = new javax.swing.JPanel();
        botao_cadastrar_carga = new javax.swing.JButton();
        botao_editar_carga = new javax.swing.JButton();
        botao_excluir_carga = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_cargas = new javax.swing.JTable();
        txt_codigo_carga = new javax.swing.JTextField();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        guias.setBackground(new java.awt.Color(255, 255, 255));
        guias.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        guia_caminhoes.setBackground(new java.awt.Color(255, 255, 255));

        tabela_caminhoes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabela_caminhoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "AUTONOMIA", "CUSTO (KM)"
            }
        ));
        tabela_caminhoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_caminhoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_caminhoes);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("CÓDIGO");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("NOME");

        txt_nome_caminhao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("AUTONOMIA");

        txt_autonomia_caminhao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("CUSTO (KM)");

        txt_custo_caminhao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AÇÕES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        botao_cadastrar_caminhao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_cadastrar_caminhao.setText("NOVO");
        botao_cadastrar_caminhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadastrar_caminhaoActionPerformed(evt);
            }
        });

        botao_editar_caminhao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_editar_caminhao.setText("EDITAR");
        botao_editar_caminhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_editar_caminhaoActionPerformed(evt);
            }
        });

        botao_excluir_caminhao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_excluir_caminhao.setText("EXCLUIR");
        botao_excluir_caminhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluir_caminhaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(botao_cadastrar_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botao_editar_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botao_excluir_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_cadastrar_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_editar_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_excluir_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_codigo_caminhao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txt_codigo_caminhao.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout guia_caminhoesLayout = new javax.swing.GroupLayout(guia_caminhoes);
        guia_caminhoes.setLayout(guia_caminhoesLayout);
        guia_caminhoesLayout.setHorizontalGroup(
            guia_caminhoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guia_caminhoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guia_caminhoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(guia_caminhoesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(txt_codigo_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_autonomia_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_custo_caminhao)))
                .addContainerGap())
        );
        guia_caminhoesLayout.setVerticalGroup(
            guia_caminhoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guia_caminhoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guia_caminhoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txt_nome_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_autonomia_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_custo_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigo_caminhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );

        guias.addTab("Caminhões", guia_caminhoes);

        guia_clientes.setBackground(new java.awt.Color(255, 255, 255));
        guia_clientes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        tabela_clientes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabela_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "TELEFONE"
            }
        ));
        jScrollPane2.setViewportView(tabela_clientes);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AÇÕES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        botao_cadastrar_cliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_cadastrar_cliente.setText("NOVO");
        botao_cadastrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadastrar_clienteActionPerformed(evt);
            }
        });

        botao_editar_cliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_editar_cliente.setText("EDITAR");
        botao_editar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_editar_clienteActionPerformed(evt);
            }
        });

        botao_excluir_cliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_excluir_cliente.setText("EXCLUIR");
        botao_excluir_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluir_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(botao_cadastrar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botao_editar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botao_excluir_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_cadastrar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_editar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_excluir_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("CÓDIGO");

        txt_codigo_cliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("NOME");

        txt_nome_cliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("TELEFONE");

        txt_telefone_cliente.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout guia_clientesLayout = new javax.swing.GroupLayout(guia_clientes);
        guia_clientes.setLayout(guia_clientesLayout);
        guia_clientesLayout.setHorizontalGroup(
            guia_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guia_clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guia_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(guia_clientesLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(9, 9, 9)
                        .addComponent(txt_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_telefone_cliente)))
                .addContainerGap())
        );
        guia_clientesLayout.setVerticalGroup(
            guia_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guia_clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guia_clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_telefone_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );

        guias.addTab("Clientes", guia_clientes);

        guia_destinos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("CÓDIGO");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("NOME");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("CIDADE");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AÇÕES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        botao_cadastrar_destino.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_cadastrar_destino.setText("NOVO");
        botao_cadastrar_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadastrar_destinoActionPerformed(evt);
            }
        });

        botao_editar_destino.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_editar_destino.setText("EDITAR");
        botao_editar_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_editar_destinoActionPerformed(evt);
            }
        });

        botao_excluir_destino.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_excluir_destino.setText("EXCLUIR");
        botao_excluir_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluir_destinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(botao_cadastrar_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botao_editar_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botao_excluir_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_editar_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_excluir_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_cadastrar_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_codigo_destino.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txt_nome_destino.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txt_cidade_destino.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        tabela_destinos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabela_destinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "CIDADE"
            }
        ));
        jScrollPane3.setViewportView(tabela_destinos);

        javax.swing.GroupLayout guia_destinosLayout = new javax.swing.GroupLayout(guia_destinos);
        guia_destinos.setLayout(guia_destinosLayout);
        guia_destinosLayout.setHorizontalGroup(
            guia_destinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guia_destinosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guia_destinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guia_destinosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(9, 9, 9)
                        .addComponent(txt_codigo_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cidade_destino))
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        guia_destinosLayout.setVerticalGroup(
            guia_destinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guia_destinosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guia_destinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txt_codigo_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cidade_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                .addContainerGap())
        );

        guias.addTab("Destinos", guia_destinos);

        guia_cargas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("CÓDIGO");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("TIPO");

        combobox_tipo_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        combobox_tipo_carga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PERECÍVEL", "DURÁVEL" }));
        combobox_tipo_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_tipo_cargaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setText("VALOR DECLARADO (R$)");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setText("TEMPO (dias)");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOGÍSTICA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ORIGEM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        txt_origem_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_origem_carga)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_origem_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DESTINO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("CÓDIGO");

        txt_codigo_destino_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_codigo_destino_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigo_destino_cargaActionPerformed(evt);
            }
        });
        txt_codigo_destino_carga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigo_destino_cargaKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setText("NOME");

        txt_nome_destino_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setText("CIDADE");

        txt_cidade_destino_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigo_destino_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nome_destino_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cidade_destino_carga)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_codigo_destino_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txt_nome_destino_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txt_cidade_destino_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_valor_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setText("PESO (t)");

        txt_peso_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setText("CÓDIGO");

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setText("NOME");

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel22.setText("TELEFONE");

        txt_codigo_cliente_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_codigo_cliente_carga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigo_cliente_cargaKeyPressed(evt);
            }
        });

        txt_nome_cliente_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txt_telefone_cliente_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigo_cliente_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nome_cliente_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_telefone_cliente_carga)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(txt_codigo_cliente_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome_cliente_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefone_cliente_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_tempo_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        label1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label1.setText("SETOR");

        txt_setor_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        label2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label2.setText("VALIDADE");

        txt_validade_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AÇÕES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        botao_cadastrar_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_cadastrar_carga.setText("NOVO");
        botao_cadastrar_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadastrar_cargaActionPerformed(evt);
            }
        });

        botao_editar_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_editar_carga.setText("EDITAR");
        botao_editar_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_editar_cargaActionPerformed(evt);
            }
        });

        botao_excluir_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        botao_excluir_carga.setText("EXCLUIR");
        botao_excluir_carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluir_cargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botao_cadastrar_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(botao_editar_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(botao_excluir_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botao_cadastrar_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botao_editar_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botao_excluir_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela_cargas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tabela_cargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "ORIGEM", "DESTINO", "TIPO", "PESO (t)", "VALOR (R$)", "STATUS"
            }
        ));
        tabela_cargas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabela_cargasMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tabela_cargas);

        txt_codigo_carga.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout guia_cargasLayout = new javax.swing.GroupLayout(guia_cargas);
        guia_cargas.setLayout(guia_cargasLayout);
        guia_cargasLayout.setHorizontalGroup(
            guia_cargasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guia_cargasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guia_cargasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(guia_cargasLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_codigo_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_valor_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_peso_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tempo_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(guia_cargasLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combobox_tipo_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_setor_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_validade_carga, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        guia_cargasLayout.setVerticalGroup(
            guia_cargasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guia_cargasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(guia_cargasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guia_cargasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel16)
                        .addComponent(txt_valor_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(txt_peso_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(txt_tempo_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_codigo_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(guia_cargasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(combobox_tipo_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1)
                    .addComponent(txt_setor_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2)
                    .addComponent(txt_validade_carga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        guias.addTab("Cargas", guia_cargas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guias)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guias)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_cadastrar_caminhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadastrar_caminhaoActionPerformed
        cadastrar("caminhao");
    }//GEN-LAST:event_botao_cadastrar_caminhaoActionPerformed

    private void botao_editar_caminhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_editar_caminhaoActionPerformed
        editar("caminhao");
    }//GEN-LAST:event_botao_editar_caminhaoActionPerformed

    private void botao_excluir_caminhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluir_caminhaoActionPerformed
        excluir("caminhao");
    }//GEN-LAST:event_botao_excluir_caminhaoActionPerformed

    private void tabela_caminhoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_caminhoesMouseClicked

    }//GEN-LAST:event_tabela_caminhoesMouseClicked

    private void botao_cadastrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadastrar_clienteActionPerformed
        cadastrar("cliente");
    }//GEN-LAST:event_botao_cadastrar_clienteActionPerformed

    private void botao_editar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_editar_clienteActionPerformed
        editar("cliente");
    }//GEN-LAST:event_botao_editar_clienteActionPerformed

    private void botao_excluir_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluir_clienteActionPerformed
        excluir("cliente");
    }//GEN-LAST:event_botao_excluir_clienteActionPerformed

    private void botao_cadastrar_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadastrar_destinoActionPerformed
        cadastrar("destino");
    }//GEN-LAST:event_botao_cadastrar_destinoActionPerformed

    private void botao_editar_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_editar_destinoActionPerformed
        editar("destino");
    }//GEN-LAST:event_botao_editar_destinoActionPerformed

    private void botao_excluir_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluir_destinoActionPerformed
        excluir("destino");
    }//GEN-LAST:event_botao_excluir_destinoActionPerformed

    private void combobox_tipo_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_tipo_cargaActionPerformed
        defineTipo();
    }//GEN-LAST:event_combobox_tipo_cargaActionPerformed

    private void tabela_cargasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_cargasMouseReleased

    }//GEN-LAST:event_tabela_cargasMouseReleased

    private void botao_cadastrar_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadastrar_cargaActionPerformed
        cadastrar("carga");
    }//GEN-LAST:event_botao_cadastrar_cargaActionPerformed

    private void botao_editar_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_editar_cargaActionPerformed
        editar("carga");
    }//GEN-LAST:event_botao_editar_cargaActionPerformed


    private void botao_excluir_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluir_cargaActionPerformed
        excluir("carga");
    }//GEN-LAST:event_botao_excluir_cargaActionPerformed

    private void txt_codigo_destino_cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigo_destino_cargaActionPerformed

    }//GEN-LAST:event_txt_codigo_destino_cargaActionPerformed

    private void txt_codigo_destino_cargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_destino_cargaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (buscaDestinoPorCodigo(Integer.parseInt(txt_codigo_destino_carga.getText())) != null) {
                txt_nome_destino_carga.setText(buscaDestinoPorCodigo(Integer.parseInt(txt_codigo_destino_carga.getText())).getNome());
                txt_cidade_destino_carga.setText(buscaDestinoPorCodigo(Integer.parseInt(txt_codigo_destino_carga.getText())).getCidade());
            } else {
                JOptionPane.showMessageDialog(null, "Destino não encontrado");
            }
        }
    }//GEN-LAST:event_txt_codigo_destino_cargaKeyPressed

    private void txt_codigo_cliente_cargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_cliente_cargaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (buscaClientePorCodigo(Integer.parseInt(txt_codigo_cliente_carga.getText())) != null) {
                txt_nome_cliente_carga.setText(buscaClientePorCodigo(Integer.parseInt(txt_codigo_cliente_carga.getText())).getNome());
                txt_telefone_cliente_carga.setText(buscaClientePorCodigo(Integer.parseInt(txt_codigo_cliente_carga.getText())).getTelefone());
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            }
        }
    }//GEN-LAST:event_txt_codigo_cliente_cargaKeyPressed

    private void editarCarga() {
        if (tabela_cargas.getSelectedRow() < 0 || tabela_cargas.getSelectedRow() > cargas.size()) {
            JOptionPane.showMessageDialog(null, "Selecione um item válido");
        } else {
            habilitarCampos("carga");
            txt_codigo_carga.setEnabled(false);
            Carga c = cargas.get(tabela_cargas.getSelectedRow());

            txt_codigo_carga.setText(String.valueOf(c.getCodigo()));
            txt_valor_carga.setText(String.valueOf(c.getValor()));
            txt_peso_carga.setText(String.valueOf(c.getPeso()));
            txt_tempo_carga.setText(String.valueOf(c.getPrazo()));
            txt_origem_carga.setText(c.getOrigem());
            txt_codigo_destino_carga.setText(String.valueOf(c.getDestino().getCodigo()));
            txt_nome_destino_carga.setText(c.getDestino().getNome());
            txt_cidade_destino_carga.setText(c.getDestino().getCidade());
            txt_codigo_cliente_carga.setText(String.valueOf(c.getCliente().getCodigo()));
            txt_nome_cliente_carga.setText(c.getCliente().getNome());
            txt_telefone_cliente_carga.setText(c.getCliente().getTelefone());

            if (c instanceof Perecivel) {
                combobox_tipo_carga.setSelectedIndex(0);
                txt_validade_carga.setText(String.valueOf(((Perecivel) c).getValidade()));
                txt_setor_carga.setVisible(false);
                label1.setVisible(false);
            } else if (c instanceof Duravel) {
                combobox_tipo_carga.setSelectedIndex(1);
                txt_setor_carga.setText(((Duravel) c).getSetor());
                txt_validade_carga.setText(((Duravel) c).getMaterial());
                txt_setor_carga.setVisible(true);
                label1.setVisible(true);
            }
            botao_cadastrar_carga.setText("SALVAR");
            botao_editar_carga.setEnabled(false);
            botao_excluir_carga.setEnabled(false);
        }
    }

    private void excluirCarga() {
        if (tabela_cargas.getSelectedRow() < 0 || tabela_cargas.getSelectedRow() > cargas.size()) {
            JOptionPane.showMessageDialog(null, "Selecione um item válido");
        } else {
            int resultado = JOptionPane.showOptionDialog(null, "Deseja excluir este item?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (resultado == JOptionPane.YES_OPTION) {
                cargas.remove(tabela_cargas.getSelectedRow());
                dtmCargas.removeRow(tabela_cargas.getSelectedRow());
                dados.salvarDados(caminhoes, clientes, cargas, destinos);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Gerenciador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_cadastrar_caminhao;
    private javax.swing.JButton botao_cadastrar_carga;
    private javax.swing.JButton botao_cadastrar_cliente;
    private javax.swing.JButton botao_cadastrar_destino;
    private javax.swing.JButton botao_editar_caminhao;
    private javax.swing.JButton botao_editar_carga;
    private javax.swing.JButton botao_editar_cliente;
    private javax.swing.JButton botao_editar_destino;
    private javax.swing.JButton botao_excluir_caminhao;
    private javax.swing.JButton botao_excluir_carga;
    private javax.swing.JButton botao_excluir_cliente;
    private javax.swing.JButton botao_excluir_destino;
    private javax.swing.JComboBox<String> combobox_tipo_carga;
    private javax.swing.JPanel guia_caminhoes;
    private javax.swing.JPanel guia_cargas;
    private javax.swing.JPanel guia_clientes;
    private javax.swing.JPanel guia_destinos;
    private javax.swing.JTabbedPane guias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JTable tabela_caminhoes;
    private javax.swing.JTable tabela_cargas;
    private javax.swing.JTable tabela_clientes;
    private javax.swing.JTable tabela_destinos;
    private javax.swing.JTextField txt_autonomia_caminhao;
    private javax.swing.JTextField txt_cidade_destino;
    private javax.swing.JTextField txt_cidade_destino_carga;
    private javax.swing.JFormattedTextField txt_codigo_caminhao;
    private javax.swing.JTextField txt_codigo_carga;
    private javax.swing.JFormattedTextField txt_codigo_cliente;
    private javax.swing.JFormattedTextField txt_codigo_cliente_carga;
    private javax.swing.JFormattedTextField txt_codigo_destino;
    private javax.swing.JFormattedTextField txt_codigo_destino_carga;
    private javax.swing.JTextField txt_custo_caminhao;
    private javax.swing.JTextField txt_nome_caminhao;
    private javax.swing.JTextField txt_nome_cliente;
    private javax.swing.JTextField txt_nome_cliente_carga;
    private javax.swing.JTextField txt_nome_destino;
    private javax.swing.JTextField txt_nome_destino_carga;
    private javax.swing.JTextField txt_origem_carga;
    private javax.swing.JFormattedTextField txt_peso_carga;
    private javax.swing.JTextField txt_setor_carga;
    private javax.swing.JFormattedTextField txt_telefone_cliente;
    private javax.swing.JTextField txt_telefone_cliente_carga;
    private javax.swing.JFormattedTextField txt_tempo_carga;
    private javax.swing.JFormattedTextField txt_validade_carga;
    private javax.swing.JFormattedTextField txt_valor_carga;
    
}
