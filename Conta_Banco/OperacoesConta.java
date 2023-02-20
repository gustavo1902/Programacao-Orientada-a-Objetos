package Conta_Banco;

import java.util.Scanner;


public class OperacoesConta {
    
    public static void main(String[] args){
        
        // Criação das contas
        ContaBancaria conta1 = new ContaBancaria("João", 1234, 1000.0);
        ContaBancaria conta2 = new ContaBancaria("Maria", 5678, 500.0);
        
        // Exibição das informações das contas
        System.out.println("Selecione a conta:");
        System.out.println("1 - " + conta1.getNome() + " - Número: " + conta1.getNumero() + " - Saldo: " + conta1.getSaldo());
        System.out.println("2 - " + conta2.getNome() + " - Número: " + conta2.getNumero() + " - Saldo: " + conta2.getSaldo());
        
        // Leitura da opção selecionada pelo usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Opção selecionada: ");
        int opcao = scanner.nextInt();
        
        // Seleção da conta de acordo com a opção selecionada pelo usuário
        ContaBancaria contaSelecionada = null;
        if (opcao == 1) {
            contaSelecionada = conta1;
        } else if (opcao == 2) {
            contaSelecionada = conta2;
        } else {
            System.out.println("Opção inválida!");
            return;
        }
        
        // Exibição das informações da conta selecionada
        System.out.println("\nConta selecionada: " + contaSelecionada.getNome() + " - Número: " + contaSelecionada.getNumero() + " - Saldo: " + contaSelecionada.getSaldo());
        
        // Realização das operações
        System.out.println("\nSelecione a operação:");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Transferir");
        System.out.print("Opção selecionada: ");
        int operacao = scanner.nextInt();
        
        if (operacao == 1) {
            System.out.print("Valor a depositar: ");
            double valor = scanner.nextDouble();
            contaSelecionada.depositar(valor);
            System.out.println("Novo saldo: " + contaSelecionada.getSaldo());
        } else if (operacao == 2) {
            System.out.print("Valor a sacar: ");
            double valor = scanner.nextDouble();
            contaSelecionada.sacar(valor);
            System.out.println("Novo saldo: " + contaSelecionada.getSaldo());
        } else if (operacao == 3) {
            System.out.print("Número da conta de destino: ");
            int numeroDestino = scanner.nextInt();
            System.out.print("Valor a transferir: ");
            double valor = scanner.nextDouble();
            ContaBancaria contaDestino = null;
            if (contaSelecionada.getNumero() == numeroDestino) {
                System.out.println("Não é possível transferir para a mesma conta!");
                return;
            } else if (contaSelecionada.getSaldo() < valor) {
                System.out.println("Saldo insuficiente!");
                return;
            } else if (contaSelecionada.getNumero() == conta1.getNumero()) {
                contaDestino = conta2;
            } else if (contaSelecionada.getNumero() == conta2.getNumero()) {
                contaDestino = conta1;
            } else {
                System.out.println("Conta de destino não encontrada!");
                return;
            }
            contaSelecionada.transferir(contaDestino, valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }              
    }
}
