import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CriarCSV {
    public static void main(String[] args) {
     
        String arquivoCSV = "funcionarios.csv";

        try {
         
            CSVWriter escritor = new CSVWriter(new FileWriter(arquivoCSV, true));

        
            Scanner scanner = new Scanner(System.in);

         
            System.out.println("Digite o nome do funcionário:");
            String nome = scanner.nextLine();
            System.out.println("Digite o cargo do funcionário:");
            String cargo = scanner.nextLine();
            System.out.println("Digite o salário do funcionário:");
            String salario = scanner.nextLine();

           
            String[] linha = {nome, cargo, salario};
            escritor.writeNext(linha);

          
            escritor.close();
            scanner.close();

            System.out.println("Os detalhes do funcionário foram escritos no arquivo CSV com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
