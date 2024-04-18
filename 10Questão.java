import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App.java {
    public static void main(String[] args) {
        String nomeArquivo1 = "arquivo1.txt";
        String nomeArquivo2 = "arquivo2.txt";
        String nomeArquivoConcatenado = "arquivo_concatenado.txt";

       
        String conteudoArquivo1 = "Conteúdo do arquivo 1.";
        String conteudoArquivo2 = "Conteúdo do arquivo 2.";

        
        escreverArquivo(nomeArquivo1, conteudoArquivo1);
        escreverArquivo(nomeArquivo2, conteudoArquivo2);

        
        concatenarArquivos(nomeArquivo1, nomeArquivo2, nomeArquivoConcatenado);

        System.out.println("Arquivos concatenados com sucesso.");
    }

    private static void escreverArquivo(String nomeArquivo, String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    private static void concatenarArquivos(String arquivo1, String arquivo2, String arquivoConcatenado) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(arquivo1));
             BufferedReader reader2 = new BufferedReader(new FileReader(arquivo2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoConcatenado))) {

            String linha;

            while ((linha = reader1.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }

            
            writer.newLine();

            
            while ((linha = reader2.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao concatenar arquivos: " + e.getMessage());
        }
    }
}
