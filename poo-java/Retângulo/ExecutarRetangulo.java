package Retângulo;
import java.util.Scanner;
public class ExecutarRetangulo{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        Retangulo r = new Retangulo();

        System.out.println("Calculo Retângulo");
        System.out.println();
        System.out.println("informe a altura do retangulo");
        r.setAltura(scan.nextDouble());
        System.out.println("informe a largura do retangulo");
        r.setLargura(scan.nextDouble());

        System.out.println("Informações do retângulo:");
        System.out.println("Área: " + r.calculoArea());
        System.out.println("Perímetro: " + r.calculoPerimetro());

    scan.close();
    }
}