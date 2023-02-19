package Conta_Banco;

import java.util.Scanner;

public class OperacoesConta {

    public void depositar(ContaBancaria conta, double valor){
        conta.setSaldo(conta.getSaldo() + valor);
    }

    public void sacar(ContaBancaria conta, double valor){
        if (valor > 0 && valor <= conta.getSaldo()) {
            conta.setSaldo(conta.getSaldo() - valor);
        } else if (valor < 0) {
            System.out.println("Valor inválido para saque!");
        } else {
            System.out.println("Saldo insuficiente para realizar a operação!");
        }
    }    
    
    public static void main(String[] args){
        ContaBancaria conta = new ContaBancaria("João", 1234, 1000.0);
        conta.imprimir(); // Imprime os dados iniciais da conta
        
        OperacoesConta operacoes = new OperacoesConta();
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;
        
        while (opcao != 3) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Sair");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a depositar:");
                    double valorDeposito = scanner.nextDouble();
                    operacoes.depositar(conta, valorDeposito);
                    conta.imprimir();
                    break;
                case 2:
                    System.out.println("Digite o valor a sacar:");
                    double valorSaque = scanner.nextDouble();
                    operacoes.sacar(conta, valorSaque);
                    conta.imprimir();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
