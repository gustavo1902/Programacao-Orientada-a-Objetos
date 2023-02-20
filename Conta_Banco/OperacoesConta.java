package Conta_Banco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OperacoesConta {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo de contas: ");
        String nomeArquivo = leitor.nextLine();
        ArrayList<ContaBancaria> contas = ContaBancaria.lerArquivo(nomeArquivo);

        int opcao = 0;
        while (opcao != 5) {
            System.out.println();
            System.out.println("Selecione uma opção:");
            System.out.println("1 Selecionar conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Sair");

            opcao = leitor.nextInt();
            leitor.nextLine();
      
            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    int numeroConta = leitor.nextInt();
                    leitor.nextLine();
                    ContaBancaria conta = ContaBancaria.selecionarConta(numeroConta, contas);
                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        System.out.println("Conta selecionada: " + conta.getNomeCliente());
                    }
                    break;
      
                case 2:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = leitor.nextInt();
                    leitor.nextLine();
                    double saldo = ContaBancaria.consultarSaldo(numeroConta, contas);
                    if (saldo == -1) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        System.out.println("Saldo da conta: " + saldo);
                    }
                    break;
      
                case 3:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = leitor.nextInt();
                    leitor.nextLine();
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = leitor.nextDouble();
                    leitor.nextLine();
                    boolean sucessoDeposito = ContaBancaria.depositar(numeroConta, valorDeposito, contas);
                    if (sucessoDeposito) {
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
      
                case 4:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = leitor.nextInt();
                    leitor.nextLine();
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = leitor.nextDouble();
                    leitor.nextLine();
                    boolean sucessoSaque = ContaBancaria.sacar(numeroConta, valorSaque, contas);
                    if (sucessoSaque) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada ou saldo insuficiente.");
                    }
                    break;
      
                case 5:
                    System.out.println("Saindo...");
                    break;
      
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
      
        leitor.close();
    }
}
