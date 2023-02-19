package Conta_Banco;

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
        operacoes.depositar(conta, 500.0);
        conta.imprimir(); // Imprime os dados após o depósito
        
        operacoes.sacar(conta, -200.0);
        conta.imprimir(); // Imprime os dados após a tentativa de saque
    }
}
