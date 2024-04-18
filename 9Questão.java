import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App.java {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String palavraBuscada = "Java";
        int contador = 0;

        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                
                String[] palavras = linha.split("\\s+");

               
                for (String palavra : palavras) {
                    
                    palavra = palavra.replaceAll("[^a-zA-Z]", "");
                    
                    
                    if (palavra.equals(palavraBuscada)) {
                        contador++;
                    }
                }
            }

            
            bufferedReader.close();

            System.out.println("A palavra '" + palavraBuscada + "' aparece " + contador + " vezes no texto.");
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
