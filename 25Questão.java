import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Venda implements Serializable {
    private String data;
    private double valor;
    private String produto;

    public Venda(String data, double valor, String produto) {
        this.data = data;
        this.valor = valor;
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getProduto() {
        return produto;
    }

    public static void main(String[] args) {

        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("2024-04-17", 100.00, "Produto A"));
        vendas.add(new Venda("2024-04-18", 150.00, "Produto B"));
        vendas.add(new Venda("2024-04-19", 200.00, "Produto C"));

        String nomeArquivo = "vendas.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {

            String[] cabecalho = { "Data", "Valor", "Produto" };
            writer.writeNext(cabecalho);

            for (Venda venda : vendas) {
                String[] linha = { venda.getData(), String.valueOf(venda.getValor()), venda.getProduto() };
                writer.writeNext(linha);
            }

            System.out.println("Vendas exportadas para o arquivo " + nomeArquivo + " com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar as vendas para o arquivo CSV: " + e.getMessage());
        }
    }
}
