package Exercicios_Introdutorios.Divisão;

public class Divisao {
    public static void encontrarDivisivelPorDezenove(int x, int y){
        for (int i = x ; i < y ; i++){
            if (i % 19 == 0){
                System.out.println("Achei um número divisível por 19 entre x e y");
            }
        }
    }
}
