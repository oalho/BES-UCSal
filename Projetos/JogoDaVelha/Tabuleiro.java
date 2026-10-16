package JogoDaVelha;

public class Tabuleiro {
    char[][] tabuleiro = new char[3][3];
    private boolean vez = false, jogadavalida = false, vitoria = false, fim = false;
    private char escolha;
    private int jogadas = 0;

    public void gerarTabuleiro(){
        for(int i= 0; i < 3; i++){  
            System.out.print("|");
            for(int k = 0; k < 3; k++){
                System.out.println("_________");
            }
        }
    }


    public boolean validarVitoria(){
        //linhas
        if (tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][0] == tabuleiro[0][2]){
            return true;
        }

        if (tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][0] == tabuleiro[1][2]){
            return true;
        }

        if (tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][0] == tabuleiro[2][2]){
            return true;
        }
        //colunas
        if (tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[0][0] == tabuleiro[2][0]){
            return true;
        }

        if (tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[0][1] == tabuleiro[2][1]){
            return true;
        }

        if (tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[0][2] == tabuleiro[2][2]){
            return true;
        }
        //diagonais
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2]){
            return true;
        }

        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0]){
            return true;
        }
        
        return false;
    }

    public boolean fimPartida(){
        if(vitoria){
            if(vez){
                System.out.println(nome + " a vitória é sua! Parabéns!");
            } else{
                System.out.println(nomeJogador2 + " a vitória é sua! Parabéns");
            }
        
            fim = true;
        }

        if(jogadas == 9 && !vitoria){
            System.out.println("deu velha!");
            fim = true;
        }
    }
}