package Exercicios_Introdutorios.Balanco1T;

public class Balanco1T {
        public static void main(String[] args) {
            int gastosJaneiro = 15000;
            int gastosFevereiro = 23000;
            int gastosMarco = 17000;
            int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;

            System.out.println("Gasto do trimestre: R$" + gastosTrimestre);
            int mediaPorMes = gastosTrimestre / 3;
            System.out.println("Média por mês: R$" + mediaPorMes);
        }   
}