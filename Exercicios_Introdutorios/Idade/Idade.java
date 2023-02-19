package Exercicios_Introdutorios.Idade;

public class Idade {
    int idade = 15;

    public void verificaIdade() {
        if (idade < 18) {
            System.out.println("Não pode entrar");
        } else {
            System.out.println("Pode entrar");
        }
    }

    public static void main(String[] args) {
        Idade pessoa = new Idade();
        pessoa.verificaIdade();
    }
}
