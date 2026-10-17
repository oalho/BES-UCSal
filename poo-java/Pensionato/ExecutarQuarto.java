package Pensionato;
import java.util.Scanner;
public class ExecutarQuarto {
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);

        Estudante[] vet = new Estudante[10];

        System.out.println("Bem vindo ao aluguel de quarto");
        System.out.println("Quantos quartos serão alugados?");
        int nQuartos = scan.nextInt();

        for (int i = 1; i <= nQuartos; i++){
            System.out.println();
            System.out.println("Aluguel " + i + ":");
            System.out.println("Informe o nome:");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.println("Informe o email");
            scan.nextLine();
            String email = scan.nextLine();
            System.out.println("Senhor(a) " + nome + ", escolha o quarto(1-10)");
            int quarto = scan.nextInt();
            vet [quarto - 1] = new Estudante(nome, email);
        }

        System.out.println();
        System.out.println("Quartos ocupados:");
        for (int i = 0; i < 10; i++){
            if (vet[i] != null){
                System.out.println((i + 1) + (": ") + vet[i]);
            }
        }
    scan.close();    
    }
}
