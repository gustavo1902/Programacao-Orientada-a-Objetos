package Exercicios_Introdutorios;

public class Exercicio5 {
    //imprima os fatoriais de 1 a 40
    public static void main(String[] args){
        for (int i = 1; i <= 40; i++){
            int fatorial = 1;
            for (int j = 1; j <= i; j++){
                fatorial *= j;
            }
            System.out.println(fatorial);
        }
    }
}
