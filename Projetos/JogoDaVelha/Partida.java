package JogoDaVelha;
import  java.util.Scanner;
public class Partida {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean vez = true;

        
        System.out.println("Vamos iniciar o jogo da velha");
        System.out.println("Jogador 1, escolha seu nome");
        String nome = scan.next();
        System.out.println("Escolha o símbolo que te representará (X) ou (O)");
        char simbolo = scan.next().charAt(0);
        Jogador jogador1 = new Jogador(nome, simbolo);

        if(simbolo == 'X'){
            if (vez){
                char escolha = 'X';
            } else {
                char escolha = 'O';
            }
        } else if (simbolo == 'O') {
            if (vez){
                char escolha = 'O';
            } else {
                char escolha = 'X';
            }
        }

        System.out.println("Jogador 2, escolha seu nome");
        String nomeJogador2 = scan.next();
        Jogador jogador2 = new Jogador(nomeJogador2, simbolo);

        gerarTabuleiro();

    scan.close();
    }
}