package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Dados {

    ArrayList<Caminhao> caminhoes;
    ArrayList<Cliente> clientes;
    ArrayList<Carga> cargas;
    ArrayList<Destino> destinos;

    public Dados() {
        caminhoes = new ArrayList<>();
        clientes = new ArrayList<>();
        cargas = new ArrayList<>();
        destinos = new ArrayList<>();
        carregarDados();
    }

    public ArrayList<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Carga> getCargas() {
        return cargas;
    }

    public ArrayList<Destino> getDestinos() {
        return destinos;
    }

    private void carregarDados() {

        String linha = "";

        try {
            BufferedReader leCaminhoes = new BufferedReader(new FileReader("src/data/caminhoes.txt"));
            linha = "";
            while (true) {
                if ((linha = leCaminhoes.readLine()) != null && !linha.isEmpty()) {
                    String[] dados = linha.split(";");
                    Caminhao caminhao = new Caminhao(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]), Double.parseDouble(dados[3]));
                    caminhoes.add(caminhao);
                } else {
                    break;
                }
            }
            leCaminhoes.close();
        } catch (Exception e) {
            System.err.println("erro ao carregar caminhoes\n" + e);
        }

        try {
            BufferedReader leClientes = new BufferedReader(new FileReader("src/data/clientes.txt"));
            linha = "";
            while (true) {
                if ((linha = leClientes.readLine()) != null && !linha.isEmpty()) {
                    String[] dados = linha.split(";");
                    Cliente cliente = new Cliente(Integer.parseInt(dados[0]), dados[1], dados[2]);
                    clientes.add(cliente);
                } else {
                    break;
                }
            }
            leClientes.close();
        } catch (Exception e) {
            System.err.println("erro ao carregar clientes\n" + e);
        }

        try {
            BufferedReader leCargas = new BufferedReader(new FileReader("src/data/cargas.txt"));
            linha = "";
            while (true) {
                if ((linha = leCargas.readLine()) != null && !linha.isEmpty()) {
                    String[] dados = linha.split(";");
                    switch (dados[0]) {
                        case "Perecivel":
                            Perecivel p = new Perecivel(Integer.parseInt(dados[1]), dados[2], new Destino(Integer.parseInt(dados[3]), dados[4], dados[5]), new Cliente(Integer.parseInt(dados[6]), dados[7], dados[8]), Double.parseDouble(dados[9]), Double.parseDouble(dados[10]), Integer.parseInt(dados[11]), Integer.parseInt(dados[12]));
                            cargas.add(p);
                            break;
                        case "Duravel":
                            Duravel d = new Duravel(Integer.parseInt(dados[1]), dados[2], new Destino(Integer.parseInt(dados[3]), dados[4], dados[5]), new Cliente(Integer.parseInt(dados[6]), dados[7], dados[8]), Double.parseDouble(dados[9]), Double.parseDouble(dados[10]), Integer.parseInt(dados[11]), dados[12], dados[13]);
                            cargas.add(d);
                            break;
                    }
                } else {
                    break;
                }
            }
            leCargas.close();
        } catch (Exception e) {
            System.err.println("erro ao carregar cargas\n" + e);
        }

        try {
            BufferedReader leDestinos = new BufferedReader(new FileReader("src/data/destinos.txt"));
            linha = "";
            while (true) {
                if ((linha = leDestinos.readLine()) != null && !linha.isEmpty()) {
                    String[] dados = linha.split(";");
                    Destino destino = new Destino(Integer.parseInt(dados[0]), dados[1], dados[2]);
                    destinos.add(destino);
                } else {
                    break;
                }
            }
            leDestinos.close();
        } catch (Exception e) {
            System.err.println("erro ao carregar destinos\n" + e);
        }
    }

    public void salvarDados(ArrayList<Caminhao> caminhoes, ArrayList<Cliente> clientes, ArrayList<Carga> cargas, ArrayList<Destino> destinos) {
        try {
            BufferedWriter gravaCaminhoes = new BufferedWriter(new FileWriter("src/data/caminhoes.txt"));
            if (!caminhoes.isEmpty()) {
                for (Caminhao caminhao : caminhoes) {
                    gravaCaminhoes.append(caminhao + "\n");
                }
            } else {
                gravaCaminhoes.append("");
            }
            gravaCaminhoes.close();

            BufferedWriter gravaClientes = new BufferedWriter(new FileWriter("src/data/clientes.txt"));
            if (!clientes.isEmpty()) {
                for (Cliente cliente : clientes) {
                    gravaClientes.append(cliente + "\n");
                }

            } else {
                gravaClientes.append("");
            }
            gravaClientes.close();

            BufferedWriter gravaCargas = new BufferedWriter(new FileWriter("src/data/cargas.txt"));
            if (!cargas.isEmpty()) {
                for (Carga carga : cargas) {
                    gravaCargas.append(carga + "\n");
                }
            } else {
                gravaCargas.append("");
            }
            gravaCargas.close();

            BufferedWriter gravaDestinos = new BufferedWriter(new FileWriter("src/data/destinos.txt"));
            if (!destinos.isEmpty()) {
                for (Destino destino : destinos) {
                    gravaDestinos.append(destino + "\n");
                }
            } else {
                gravaDestinos.append("");
            }
            gravaDestinos.close();
        } catch (Exception e) {
            System.out.println("erro");
        }
    }
}
