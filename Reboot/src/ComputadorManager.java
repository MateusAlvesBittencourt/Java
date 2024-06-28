import java.io.*;
import java.util.ArrayList;

public class ComputadorManager {
    private String caminhoArquivo;
    private ArrayList<String> computadoresNaoReiniciados;

    public ComputadorManager() {
        this.caminhoArquivo = null;
        this.computadoresNaoReiniciados = new ArrayList<>();
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public ArrayList<String> reiniciarComputadores() throws IOException, InterruptedException {
        if (caminhoArquivo == null) {
            throw new IllegalArgumentException("Nenhum arquivo selecionado.");
        }

        ArrayList<String> nomesComputadores = lerNomesComputadoresDoArquivo();
        if (nomesComputadores.isEmpty()) {
            throw new IllegalArgumentException("O arquivo selecionado está vazio ou não contém nomes de computadores válidos.");
        }

        ArrayList<String> computadoresReiniciados = new ArrayList<>();
        computadoresNaoReiniciados.clear();

        for (String nomeComputador : nomesComputadores) {
            if (reiniciarComputador(nomeComputador)) {
                computadoresReiniciados.add(nomeComputador);
            } else {
                computadoresNaoReiniciados.add(nomeComputador);
            }
        }

        return computadoresNaoReiniciados;
    }

    public ArrayList<String> getComputadoresNaoReiniciados() {
        return computadoresNaoReiniciados;
    }

    private ArrayList<String> lerNomesComputadoresDoArquivo() throws IOException {
        ArrayList<String> nomesComputadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    nomesComputadores.add(linha);
                }
            }
        }
        return nomesComputadores;
    }

    private boolean reiniciarComputador(String nomeComputador) throws IOException, InterruptedException {
        String comando = "shutdown -r -t 01 -f -m \\\\" + nomeComputador;
        Process processo = Runtime.getRuntime().exec(comando);
        int codigoSaida = processo.waitFor();
        if (codigoSaida == 0) {
            System.out.println("Reiniciado: " + nomeComputador);
            return true;
        } else {
            System.err.println("Falha ao reiniciar: " + nomeComputador);
            return false;
        }
    }

    public String obterConteudoArquivo() throws IOException {
        if (caminhoArquivo == null) {
            throw new IllegalArgumentException("Nenhum arquivo selecionado.");
        }

        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        }
        return conteudo.toString();
    }
}
