package br.edu.uniaeso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Salário: " + salario;
    }
}

public class GerenciadorFuncionarios {
    private static final String FILENAME = "funcionarios.bin";
    private List<Funcionario> funcionarios;
    private Scanner scanner;

    public GerenciadorFuncionarios() {
        funcionarios = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarFuncionario() {
        System.out.print("ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Salário do funcionário: ");
        double salario = scanner.nextDouble();
        funcionarios.add(new Funcionario(id, nome, salario));
        salvarFuncionarios();
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    private void salvarFuncionarios() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            outputStream.writeObject(funcionarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void carregarFuncionarios() {
        File file = new File(FILENAME);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
                funcionarios = (List<Funcionario>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();
        gerenciador.carregarFuncionarios();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = gerenciador.scanner.nextInt();
            gerenciador.scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciador.adicionarFuncionario();
                    break;
                case 2:
                    gerenciador.listarFuncionarios();
                    break;
                case 3:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
