package Notas;
import java.util.Scanner;
public class ExecutarNotas{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o nome do aluno");
        String nome = scan.next();
        System.out.println("Informe a primeira nota");
        Integer n1 = scan.nextInt();
        System.out.println("Informe a segunda nota");
        Integer n2 = scan.nextInt();
        System.out.println("Informe a terceira nota");
        Integer n3 = scan.nextInt();

        Notas n = new Notas(nome, n1, n2, n3);

        if (n.notaFinal() >= 60){
            System.out.println("Nota final:" + n.notaFinal());
            System.out.println("Aprovado");
        } else {
            System.out.println("Nota final: " + n.notaFinal());
            System.out.println("Reprovado");
            System.out.println("Faltaram " + n.minimo() + " pontos");
        }

    scan.close();
    }
}