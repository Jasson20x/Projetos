import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ContaBancaria implements Serializable {
    private String nome;
    private double saldo;

    public ContaBancaria(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public static void main(String[] args) {

        ContaBancaria conta = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("conta.dat"))) {
            conta = (ContaBancaria) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        conta.depositar(100);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("conta.dat"))) {
            oos.writeObject(conta);
            System.out.println("Saldo atualizado e objeto serializado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
