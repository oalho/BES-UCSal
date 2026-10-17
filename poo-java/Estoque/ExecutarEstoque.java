package Estoque;
import java.util.Scanner;

public class ExecutarEstoque{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String r;

        System.out.println("CONTROLE ESTOQUE");
        System.out.println();
        System.out.println("Informe os dados do produto");

        Produto p = new Produto();

        System.out.println("Nome do produto");
        p.setNome(scan.nextLine());
        System.out.println("Preço unitário");
        p.setPreco(scan.nextDouble());
        System.out.println("Quantidade");
        p.setQuantidade(scan.nextInt());
        scan.nextLine();
        
    do{
        System.out.println("\nDeseja adicionar, remover ou finalizar?");
        r = scan.nextLine();

        if(r.equalsIgnoreCase("adicionar")){
            int valor = scan.nextInt();
            scan.nextLine();
            p.addEstoque(valor);
        } else if (r.equalsIgnoreCase("remover")){
            int valor = scan.nextInt();
            scan.nextLine();
            p.remEstoque(valor);
        } else if (!r.equalsIgnoreCase("finalizar")){
            System.out.println("essa opção é invalida! Digite (adicionar), (remover) ou (finalizar)");
        }

    } while (!r.equalsIgnoreCase("finalizar"));

    System.out.println("Nome: " + p.getNome() + "| Preço: " + p.getPreco() + "| Quantidade: " + p.getQuantidade());
    System.out.println("Valor total do estoque: " + p.valorEstoque());

    scan.close();
    }
}