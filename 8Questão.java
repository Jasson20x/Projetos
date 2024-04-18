import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App.java {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_sem_excluir.txt";
        String palavraExcluir = "excluir";

        try {
            File arquivoEntrada = new File(nomeArquivoEntrada);
            File arquivoSaida = new File(nomeArquivoSaida);

            FileReader fileReader = new FileReader(arquivoEntrada);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(arquivoSaida);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
             
                if (!linha.contains(palavraExcluir)) {
                    bufferedWriter.write(linha);
                    bufferedWriter.newLine();
                }
            }

            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("Linhas contendo '" + palavraExcluir + "' foram removidas com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
