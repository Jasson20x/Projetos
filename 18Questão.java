import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class LerCSV {
    public static void main(String[] args) {
        String arquivoCSV = "alunos.csv";

        try {
          
            CSVReader leitor = new CSVReader(new FileReader(arquivoCSV));
            String[] linha;


            while ((linha = leitor.readNext()) != null) {
                for (String coluna : linha) {
                    System.out.print(coluna + "\t");
                }
                System.out.println();
            }

            
            leitor.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}
