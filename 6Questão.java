import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {
    public static void main(String[] args) {
        String nomeArquivo = "dados.csv";
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                for (String campo : campos) {
                    System.out.print(campo + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
