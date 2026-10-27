import java.util.ArrayList;
import java.util.List;

public class ParticaoFixa {

    // Representação de um bloco de memória fixa
    static class Bloco {
        int id;
        int tamanhoTotal;
        int tamanhoOcupado;
        boolean isLivre;
        String idProcesso;

        Bloco(int id, int tamanhoTotal) {
            this.id = id;
            this.tamanhoTotal = tamanhoTotal;
            this.tamanhoOcupado = 0;
            this.isLivre = true;
            this.idProcesso = "Nenhum";
        }
    }

    // Representação do processo que requisita memória
    static class Processo {
        String id;
        int tamanhoNecessario;

        Processo(String id, int tamanhoNecessario) {
            this.id = id;
            this.tamanhoNecessario = tamanhoNecessario;
        }
    }

    private final List<Bloco> memoria = new ArrayList<>();

    // Inicializa a memória com partições fixas
    public void inicializarMemoria(int[] tamanhosParticoes) {
        memoria.clear();
        for (int i = 0; i < tamanhosParticoes.length; i++) {
            memoria.add(new Bloco(i + 1, tamanhosParticoes[i]));
        }
    }

    // Algoritmo First-Fit para alocação
    public boolean alocarProcesso(Processo proc) {
        for (Bloco bloco : memoria) {
            // Verifica se o bloco está livre e se o processo cabe nele
            if (bloco.isLivre && bloco.tamanhoTotal >= proc.tamanhoNecessario) {
                bloco.isLivre = false;
                bloco.idProcesso = proc.id;
                bloco.tamanhoOcupado = proc.tamanhoNecessario;
                
                int fragmentacaoInterna = bloco.tamanhoTotal - bloco.tamanhoOcupado;
                System.out.printf("✅ Processo %s (%d KB) alocado no Bloco %d (%d KB). Fragmentação Interna: %d KB.%n",
                        proc.id, proc.tamanhoNecessario, bloco.id, bloco.tamanhoTotal, fragmentacaoInterna);
                return true;
            }
        }
        System.out.printf("❌ Falha ao alocar Processo %s (%d KB): Sem partição compatível disponível.%n", 
                proc.id, proc.tamanhoNecessario);
        return false;
    }

    // Libera o bloco que está com o processo informado
    public void desalocarProcesso(String idProcesso) {
        for (Bloco bloco : memoria) {
            if (!bloco.isLivre && bloco.idProcesso.equals(idProcesso)) {
                bloco.isLivre = true;
                bloco.idProcesso = "Nenhum";
                bloco.tamanhoOcupado = 0;
                System.out.printf("🔄 Processo %s removido. Bloco %d agora está livre.%n", idProcesso, bloco.id);
                return;
            }
        }
        System.out.printf("⚠️ Processo %s não encontrado na memória.%n", idProcesso);
    }

    // Exibe o estado atual da memória
    public void exibirEstadoMemoria() {
        System.out.println("\n--- ESTADO ATUAL DA MEMÓRIA ---");
        System.out.printf("%-10s %-15s %-12s %-15s%n", "Bloco ID", "Tamanho Total", "Status", "Processo Alocado");
        for (Bloco bloco : memoria) {
            String status = bloco.isLivre ? "Livre" : "Ocupado (" + bloco.tamanhoOcupado + " KB)";
            System.out.printf("%-10d %-15s %-12s %-15s%n", 
                    bloco.id, bloco.tamanhoTotal + " KB", status, bloco.idProcesso);
        }
        System.out.println("-------------------------------\n");
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        ParticaoFixa gerenciador = new ParticaoFixa();

        // Configura as partições fixas de memória (exemplo em KB)
        int[] particoesIniciais = {100, 500, 200, 300, 600};
        gerenciador.inicializarMemoria(particoesIniciais);
        
        gerenciador.exibirEstadoMemoria();

        // Criando processos de teste
        Processo p1 = new Processo("P1", 212);
        Processo p2 = new Processo("P2", 417);
        Processo p3 = new Processo("P3", 112);
        Processo p4 = new Processo("P4", 426);

        // Simulando as requisições de alocação
        gerenciador.alocarProcesso(p1);
        gerenciador.alocarProcesso(p2);
        gerenciador.alocarProcesso(p3);
        gerenciador.alocarProcesso(p4); // Deve falhar inicialmente, pois não sobrou bloco grande o bastante

        gerenciador.exibirEstadoMemoria();

        // Desalocando um processo para abrir espaço
        gerenciador.desalocarProcesso("P2");
        
        // Tentando alocar o processo P4 novamente
        gerenciador.alocarProcesso(p4);

        gerenciador.exibirEstadoMemoria();
    }
}
