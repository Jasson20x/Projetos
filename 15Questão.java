import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyWithBuffer {
    private static final int BUFFER_SIZE = 1024 * 1024; // 1 MB buffer size

    public static void main(String[] args) {
        String sourceFile = "arquivo_grande.bin";
        String destinationFile = "copia_arquivo_grande.bin";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Arquivo copiado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
