package JogoDaVelha;
import JogoDaVelha.Jogador;
public class Tabuleiro {
    private char[][] tabuleiro = new char[3][3];
    private boolean vez = false, jogadavalida = false, vitoria = false, fim = false;
    private char escolha;
    private int jogadas = 0;

    public Tabuleiro(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void exibirTabuleiro(){
        System.out.println("\n 0 1 2");
        for (int i = 0; i < 3; i++){
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++){
                System.out.print(tabuleiro[i][j]);
                if (j < 2){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2){
                System.out.println(" -----------");
            }
        }
        System.out.println();
    }

    public boolean fazerJogada(int linha, int coluna, char simbolo){
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2){
            return false;
        }

        if (tabuleiro[linha][coluna] != ' '){
            return false;
        }

        tabuleiro[linha][coluna] = simbolo;
        return true;
    }

    public boolean validarVitoria(){
        
        for (int i = 0; i < 3; i++){
            if (tabuleiro[i][0] != ' ' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2]){
                return true;
            }
        }   

        for (int j = 0; j < 3; j++){
            if (tabuleiro[0][j] != ' ' && tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[0][j] == tabuleiro[2][j]){
                return true;
            }
        }
        if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2]){
            return true;
        }

        if (tabuleiro[0][0] != ' ' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0]){
            return true;
        }
        
        return false;
    }

}