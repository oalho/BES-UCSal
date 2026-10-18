package JogoDaVelha;
import  java.util.Scanner;

public class Partida {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public static void main(String[] args) {
        Partida jogo = new Partida();
        jogo.iniciarJogo();
    }

    public void iniciarJogo(){
        Scanner scan = new Scanner(System.in);
        tabuleiro = new Tabuleiro();

        System.out.println("Vamos iniciar a partida de jogo da velha!");
        System.out.println("Jogador 1, escolha seu nome:");
        String nome1 = scan.next();
        System.out.println("Escolha o simbolo (X ou O):");
        char simbolo1 = scan.next().charAt(0);
        jogador1 = new Jogador(nome1, simbolo1);

        System.out.println("Jogador 2, escolha seu nome");
        String nome2 = scan.next();
        char simbolo2 = (simbolo1 == 'X') ? 'O' : 'X';
        jogador2 = new Jogador(nome2, simbolo2);

        jogadorAtual = jogador1;
        int jogadas = 0;
        boolean fim = false;

        while (!fim){
            tabuleiro.exibirTabuleiro();
            System.out.println("Vez de " + jogadorAtual.getNome() + " (" + jogadorAtual.getSimbolo() + ")");

            System.out.print("Digite a linha (0, 1 ou 2): ");
            int linha = scan.nextInt();
            System.out.println("Digite a coluna (0, 1 ou 2): ");
            int coluna = scan.nextInt();

            boolean jogadaValida = tabuleiro.fazerJogada(linha, coluna, jogadorAtual.getSimbolo());

            if (jogadaValida){
                jogadas++;

                if(tabuleiro.validarVitoria()){
                    tabuleiro.exibirTabuleiro();
                    System.out.println("Parabéns, " + jogadorAtual.getNome() + "! A vitória é sua!");
                    fim = true;
                } else if (jogadas == 9){
                    tabuleiro.exibirTabuleiro();
                    System.out.println("Deu velha!");
                    fim = true;
                } else {
                    jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
                }

            } else {
                System.out.println("Jogada inválida!");
            }

        }
    scan.close();
    }
}