import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ajustamos para a classe Processo correta que o código utiliza
class Processo {
    String nome;
    int tamanho; // em MB

    public Processo(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return nome + " (" + tamanho + "MB)";
    }
}

public class GerenciadorMemoriaSwap {
    private final int CAPACIDADE_RAM;
    private int ramDisponivel;
    
    private final List<Processo> memoriaRAM = new ArrayList<>();
    private final Queue<Processo> areaSwap = new LinkedList<>();

    public GerenciadorMemoriaSwap(int capacidadeRAM) {
        this.CAPACIDADE_RAM = capacidadeRAM;
        this.ramDisponivel = capacidadeRAM;
    }

    public synchronized void alocar(Processo processo) {
        System.out.println("\n[Solicitação] Tentando alocar " + processo);

        if (processo.tamanho > CAPACIDADE_RAM) {
            System.out.println("❌ Erro: O processo é maior do que a capacidade total da RAM.");
            return;
        }

        while (ramDisponivel < processo.tamanho) {
            if (memoriaRAM.isEmpty()) {
                break;
            }
            swapOut();
        }

        memoriaRAM.add(processo);
        ramDisponivel -= processo.tamanho;
        System.out.println("✅ " + processo.nome + " alocado com sucesso na RAM.");
        exibirEstado();
    }

    private void swapOut() {
        Processo vitima = memoriaRAM.remove(0); 
        ramDisponivel += vitima.tamanho;
        areaSwap.add(vitima);
        System.out.println("🔄 [SWAP-OUT] RAM cheia! Movendo " + vitima.nome + " para o Disco (Swap).");
    }

    public synchronized void liberar(String nomeProcesso) {
        for (int i = 0; i < memoriaRAM.size(); i++) {
            if (memoriaRAM.get(i).nome.equalsIgnoreCase(nomeProcesso)) {
                Processo p = memoriaRAM.remove(i);
                ramDisponivel += p.tamanho;
                System.out.println("\n🗑️ [Liberado] " + p.nome + " finalizou e saiu da RAM.");
                
                verificarSwapIn();
                exibirEstado();
                return;
            }
        }

        if (areaSwap.removeIf(p -> p.nome.equalsIgnoreCase(nomeProcesso))) {
            System.out.println("\n🗑️ [Liberado] " + nomeProcesso + " foi removido diretamente do Swap.");
            exibirEstado();
            return;
        }

        System.out.println("\n⚠ Processo " + nomeProcesso + " não encontrado.");
    }

    private void verificarSwapIn() {
        while (!areaSwap.isEmpty() && areaSwap.peek().tamanho <= ramDisponivel) {
            Processo doDisco = areaSwap.poll();
            memoriaRAM.add(doDisco);
            ramDisponivel -= doDisco.tamanho;
            System.out.println("🔄 [SWAP-IN] Trazendo " + doDisco.nome + " de volta para a RAM.");
        }
    }

    public void exibirEstado() {
        System.out.println("=== MAPA DE MEMÓRIA ===");
        System.out.println("RAM Livre: " + ramDisponivel + "MB / Total: " + CAPACIDADE_RAM + "MB");
        System.out.println("Na RAM: " + memoriaRAM);
        System.out.println("No Disco (Swap): " + areaSwap);
        System.out.println("=======================");
    }

    public static void main(String[] args) {
        GerenciadorMemoriaSwap gm = new GerenciadorMemoriaSwap(100);

        gm.alocar(new Processo("Chrome", 40));
        gm.alocar(new Processo("VSCode", 40));
        gm.alocar(new Processo("Spotify", 30));
        gm.liberar("VSCode");
    }
}
