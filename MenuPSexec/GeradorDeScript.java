import java.io.File;
import java.io.IOException;

public class GeradorDeScript {
    public String gerarScript(String caminhoInstalador, String parametros, String patrimonio) throws IOException {
        // Verificar se o arquivo do instalador é válido
        File arquivoInstalador = new File(caminhoInstalador);
        if (!arquivoInstalador.exists() || !arquivoInstalador.isFile()) {
            throw new IOException("O arquivo do instalador não é válido.");
        }

        // Obter o nome do arquivo do instalador
        String nomeInstalador = arquivoInstalador.getName();

        // Gerar o script PSExec com os parâmetros -s -c
        String script;
        if (nomeInstalador.endsWith(".msi")) {
            script = String.format("PsExec \\\\%s -s -c msiexec /i \"%s\" %s", patrimonio, caminhoInstalador, parametros);
        } else {
            script = String.format("PsExec \\\\%s -s -c \"%s\" %s", patrimonio, caminhoInstalador, parametros);
        }

        return script;
    }

    public void executarScript(String script) throws IOException {
        ProcessBuilder construtorDeProcesso = new ProcessBuilder("powershell.exe", "/c", script);
        construtorDeProcesso.inheritIO();
        Process processo = construtorDeProcesso.start();
        try {
            int codigoSaida = processo.waitFor();
            if (codigoSaida != 0) {
                throw new IOException("Falha ao executar o script: " + script);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("O processo foi interrompido", e);
        }
    }
}
