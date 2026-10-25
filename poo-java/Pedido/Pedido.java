package Pedido;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private String momento;
    private StatusPedido status;
    private Cliente cliente;
    private List<ItensPedido> itens = new ArrayList<>();

    public Pedido(String momento, StatusPedido status, Cliente cliente){
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedido> itens) {
        this.itens = itens;
    }

    public void addItem(ItensPedido item){
        itens.add(item);
    }

    public void removeItem(ItensPedido item){
        itens.remove(item);
    }

    public Double total(){
        Double total = 0.0;

        for(ItensPedido item: itens){
            total += item.subtotal();
        }

        return total;
    }
}
