package Exercicios_Introdutorios;

public class Exercicio6 {
    //Fibonacci até 100
    public static void main(String[] args){
        int a = 0;
        int b = 1;
        int c = 0;
        while (c <= 100){
            System.out.println(c);
            a = b;
            b = c;
            c = a + b;
        }
    }
}
