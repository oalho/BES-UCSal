package Biblioteca;
import java.util.Scanner;

public class ExecutarBiblioteca {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Bem vindo a Biblioteca Digital");
        System.out.println("vamos iniciar a operação de emprestimo");
        System.out.println("Informe seu nome");
        String nome = scan.next();
        System.out.println("Informe o email");
        String email = scan.next();
        Leitor leitor = new Leitor (nome, email);
        System.out.println("Data atual:");
        String dataEmprestimo = scan.next();
        String dataDevolucao = dataEmprestimo + 7;
        Emprestimo emprestimo = new Emprestimo(dataEmprestimo, dataDevolucao, leitor);

        System.out.println("quantos livros quer tomar empréstimo?");
        int livros = scan.nextInt();

        for(int i = 0; i < livros; i++){
            System.out.println("Nome do livro " + i + 1);
            String titulo = scan.next();
            System.out.println("Código ISBN");
            String isbn = scan.next();
            System.out.println("Autor do livro");
            String autor = scan.next();
            Livro livro = new Livro(titulo, isbn, autor);
            
            emprestimo.addLivro(livro);
        }

        System.out.println("Emprestimo finalizado!");
        System.out.println("Resumo");
        System.out.println(emprestimo);
    
    scan.close();
    }
}