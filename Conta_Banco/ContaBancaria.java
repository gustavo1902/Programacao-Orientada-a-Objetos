package Conta_Banco;

public class ContaBancaria {
    private String nome;
    private int numero;
    private double saldo;

    public ContaBancaria(String nome, int numero, double saldo){
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
    }

    public void imprimir(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Número: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("\n");
    }
    
    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar(double valor){
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Operação realizada!");
        } else {
            System.out.println("Saldo insuficiente para realizar a operação!");
        }
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência!");
        }
    }
    
    

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
