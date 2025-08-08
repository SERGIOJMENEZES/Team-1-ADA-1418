import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representa um pedido do sistema Ecommerce
 */
public class Pedido {

    private static final AtomicInteger contadorId = new AtomicInteger(1); // contador thread-safe
    private static final String PREFIXO = "PED";

    private final String id;
    private final ArrayList<Produto> produtos;
    private double valorTotal;
    private StatusPedido status;
    private LocalDateTime dataPedido;

    public Pedido(ArrayList<Produto> produtos, double valorTotal) {
        if (produtos == null || produtos.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser nula ou vazia.");
        }

        this.id = IdGenerator.gerarId(PREFIXO, contadorId);
        this.produtos = new ArrayList<>(produtos);
        this.valorTotal = valorTotal;
        this.status = StatusPedido.REALIZADO;
        this.dataPedido = LocalDateTime.now();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido #").append(id).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Data: ").append(dataPedido).append("\n");
        sb.append("Produtos:\n");
        for (Produto produto : produtos) {
            sb.append("- ").append(produto.getNome())
                    .append(" | R$ ").append(String.format("%.2f", produto.getPreco()))
                    .append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", valorTotal));
        return sb.toString();
    }

    // ====== GETTERS E SETTERS ======

    public String getId() {
        return id;
    }

    public ArrayList<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        if (status == null) {
            throw new IllegalArgumentException("Status não pode ser nulo");
        }
        this.status = status;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }
}
