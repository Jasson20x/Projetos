import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenarArquivo {
    public static void main(String[] args) {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_ordenado.txt";
      
        List<String> linhas = new ArrayList<>();
      
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        Collections.sort(linhas);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
            System.out.println("Arquivo ordenado foi salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de saída: " + e.getMessage());
        }
    }
}
