package Banco;
import java.util.Scanner;

public class ExecutarConta{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String r;

        Conta c = new Conta();

        System.out.println("Informe o número da conta");
        c.setN(scan.nextInt());
        scan.nextLine();
        System.out.println("Informe o nome do titular");
        c.setTitular(scan.nextLine());
        System.out.println("haverá um deposito inicial (s/n)");
        r = scan.nextLine();
        if (r.equalsIgnoreCase("s")){
            System.out.println("informe o valor do deposito inicial");
            c.deposito(scan.nextFloat());
        } 

        System.out.println("Dados da conta:");
        System.out.println("Número " + c.getN() + ", Nome do titular " + c.getTitular() + ", saldo " + c.getSaldo());

        do{
            System.out.println("gostaria de realizar um saque, deposito ou finalizar?");
            r = scan.nextLine();

            if (r.equalsIgnoreCase("saque")){
                System.out.println("informe o valor a ser sacado");
                    float valor = scan.nextFloat();
                    scan.nextLine();
                    c.saque(valor);
            }else if (r.equalsIgnoreCase("deposito")){
                System.out.println("Informe o valor a ser depositado");
                    float valor = scan.nextFloat();
                    scan.nextLine();
                    c.deposito(valor);
            }
            }
        while(r.equalsIgnoreCase("finalizar"));

        System.out.println("Dados da conta atualizados:");
        System.out.println("Número " + c.getN() + ", Nome do titular " + c.getTitular() + ", saldo " + c.getSaldo());

              scan.close();
    }
}