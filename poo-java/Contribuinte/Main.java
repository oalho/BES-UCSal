package Contribuinte;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.println("Digite o número de contribuintes");
            int qtd = scan.nextInt();
            for(int i = 0; i < qtd; i++){
                System.out.println("Dados do contribuinte " + (i + 1) + ":");
                System.out.println("Pessoa Física ou Jurídica? (f/j)");
                char cpfj = scan.next().charAt(0);
                System.out.println("Nome:");
                String nome = scan.next();
                if (cpfj == 'f'){
                    
                }
            }


    scan.close();
    }
}
