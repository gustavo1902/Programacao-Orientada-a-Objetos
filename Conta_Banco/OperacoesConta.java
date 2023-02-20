package Conta_Banco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OperacoesConta {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);

        // Lê o arquivo de contas previamente
        String nomeArquivo = "./input.txt";
        ArrayList<ContaBancaria> contas = ContaBancaria.lerArquivo(nomeArquivo);

        ContaBancaria contaSelecionada = null;

        realizarOperacao(123, contas);
    }

    public static void realizarOperacao(int numeroConta, ArrayList<ContaBancaria> contas) {
        Scanner leitor = new Scanner(System.in);
        double deposito = 0;
        double saque = 0;
        int opcao = 0;

        ContaBancaria contaSelecionada = ContaBancaria.selecionarConta(numeroConta, contas);

        if (contaSelecionada == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        while (opcao != 5) {
            System.out.println();
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Realizar depósito");
            System.out.println("3 - Realizar saque");
            System.out.println("4 - Selecionar outra conta");
            System.out.println("5 - Sair");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    double saldo = ContaBancaria.consultarSaldo(numeroConta, contas);
                    System.out.printf("Saldo: R$ %.2f%n", saldo);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    deposito = leitor.nextDouble();
                    boolean depositoRealizado = contaSelecionada.depositar(deposito, contas);
                    if (depositoRealizado) {
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao realizar depósito.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor a ser sacado: ");
                    saque = leitor.nextDouble();
                    boolean saqueRealizado = contaSelecionada.sacar(saque, contas);
                    if (saqueRealizado) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao realizar saque.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o número da conta:");
                    numeroConta = leitor.nextInt();
                    realizarOperacao(numeroConta, contas);
                    break;
                case 5:
                    System.out.println("Encerrando operação.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}


