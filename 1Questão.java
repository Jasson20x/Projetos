import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

  
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

  
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println();
    }

    public static void main(String[] args) {
      
        String arquivoCSV = "produtos.csv";


        List<Produto> produtos = new ArrayList<>();

        try {
      
            CSVReader leitor = new CSVReader(new FileReader(arquivoCSV));
            String[] linha;

   
            while ((linha = leitor.readNext()) != null) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);
                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
            }

           
            leitor.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }


        for (Produto produto : produtos) {
            produto.exibirDetalhes();
        }
    }
}
