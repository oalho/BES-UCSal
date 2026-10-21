import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o número de produtos");   
        int qtd = scan.nextInt();
        List<Produto> quadro = new ArrayList<>();
        for(int i = 0; i < qtd; i++){
            System.out.println("Dados do produto " + (i + 1) + ":");
            System.out.println("O produto é usado(1) ou importado(2)?");
            int resposta = scan.nextInt();

            System.out.println("Nome do produto:");
            String nome = scan.next();
            System.out.println("Preço:");
            Double preco = scan.nextDouble();

            switch(resposta){
                case 1:
                    LocalDate data = scan.next;
                    quadro.add(new ProdutoUsado(nome, preco, data));
                break;
                case 2:
                    System.out.println("Valor da taxa:");
                    Double taxa = scan.nextDouble();
                    quadro.add(new ProdutoImportado(nome, preco, taxa));
                break;
            }
            System.out.println();

            System.out.println("Carrinho:");
            for (Produto produto: quadro ){
                System.out.println(produto.getNome() + produto.toString());
            }
        }
    
    scan.close();
    }
}
