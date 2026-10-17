package Dolar;
import java.util.Scanner;

public class ExecutarDolar {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Ola! Informe quantos dólares deseja obter");
        double d = scan.nextDouble();

        Dolar dolar = new Dolar(d);
        dolar.convert();

        System.out.println("a quantida de reais necessaria é: " + dolar.convert());
    scan.close();
    }
}
