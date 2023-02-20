package Conta_Banco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ContaBancaria {
    private String nomeCliente;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String nomeCliente, int numeroConta, double saldo) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public static ArrayList<ContaBancaria> lerArquivo(String nomeArquivo) throws IOException {
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha = leitor.readLine();
        while (linha != null) {
            String[] campos = linha.split(",");
            String nomeCliente = campos[0];
            int numeroConta = Integer.parseInt(campos[1]);
            double saldo = Double.parseDouble(campos[2]);
            ContaBancaria conta = new ContaBancaria(nomeCliente, numeroConta, saldo);
            contas.add(conta);
            linha = leitor.readLine();
        }
        leitor.close();
        return contas;
    }

    public static ContaBancaria selecionarConta(int numeroConta, ArrayList<ContaBancaria> contas) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public static double consultarSaldo(int numeroConta, ArrayList<ContaBancaria> contas) {
        ContaBancaria conta = selecionarConta(numeroConta, contas);
        if (conta == null) {
            return -1;
        }
        return conta.getSaldo();
    }

    public static boolean depositar(int numeroConta, double valor, ArrayList<ContaBancaria> contas) {
        ContaBancaria conta = selecionarConta(numeroConta, contas);
        if (conta == null) {
            return false;
        }
        double saldoAtual = conta.getSaldo();
        double novoSaldo = saldoAtual + valor;
        conta.saldo = novoSaldo;
        return true;
    }

    public static boolean sacar(int numeroConta, double valor, ArrayList<ContaBancaria> contas) {
        ContaBancaria conta = selecionarConta(numeroConta, contas);
        if (conta == null) {
            return false;
        }
        double saldoAtual = conta.getSaldo();
        if (valor > saldoAtual) {
            return false;
        }
        double novoSaldo = saldoAtual - valor;
        conta.saldo = novoSaldo;
        return true;
    }
}
