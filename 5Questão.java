import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SubstituidorDePalavras {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_python.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivoSaida))) {
            
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.replaceAll("Java", "Python");
                bw.write(linha);
                bw.newLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Substituição concluída. Verifique o arquivo 'meuarquivo_python.txt'.");
    }
}
