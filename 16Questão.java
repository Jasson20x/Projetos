import java.io.FileInputStream;
import java.io.IOException;

public class ReadFirst100Bytes {
    public static void main(String[] args) {
        String fileName = "arquivo.bin";
        int numBytesToRead = 100;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] buffer = new byte[numBytesToRead];
            int bytesRead = fis.read(buffer, 0, numBytesToRead);
            
            if (bytesRead != -1) {
                System.out.println("Primeiros 100 bytes do arquivo " + fileName + ":");
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buffer[i] + " ");
                }
            } else {
                System.out.println("O arquivo está vazio.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
