import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionariosCSV {
    public static void main(String[] args) {
        String arquivoCSV = "funcionarios.csv";

        try {
            CSVReader reader = new CSVReader(new FileReader(arquivoCSV));
            String[] linha;
            List<Funcionario> funcionarios = new ArrayList<>();

            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                String cargo = linha[1];
                double salario = Double.parseDouble(linha[2]);
                Funcionario funcionario = new Funcionario(nome, cargo, salario);
                funcionarios.add(funcionario);
            }
            
            reader.close();

            
            System.out.println("Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
 
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nFiltrar por cargo (Deixe em branco para ignorar):");
            String cargoFiltro = scanner.nextLine();
            System.out.println("Filtrar por salário mínimo (Deixe em branco para ignorar):");
            String salarioMinimoStr = scanner.nextLine();
            double salarioMinimo = Double.MIN_VALUE;
            if (!salarioMinimoStr.isEmpty()) {
                salarioMinimo = Double.parseDouble(salarioMinimoStr);
            }
            System.out.println("\nResultados da filtragem:");
            for (Funcionario funcionario : funcionarios) {
                if ((cargoFiltro.isEmpty() || funcionario.getCargo().equalsIgnoreCase(cargoFiltro)) &&
                        funcionario.getSalario() >= salarioMinimo) {
                    System.out.println(funcionario);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
  
    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
