import java.util.concurrent.atomic.AtomicInteger;

public class Produto {

    public static final int ESTOQUE_INICIAL = 50;
    private static final AtomicInteger contadorId = new AtomicInteger(1); // contador thread-safe

    private String id;
    private String nome;
    private String descricao;
    private double preco;
    private Categoria categoria;
    private Condicao condicao;
    private int estoque;
    private boolean disponivel;

    public Produto(String nome, String descricao, double preco, Categoria categoria, Condicao condicao, int estoque,
                   boolean disponivel) {
        this.id = gerarId();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.condicao = condicao;
        this.estoque = estoque;
        this.disponivel = disponivel;
    }

    public Produto(String nome, String descricao, double preco, Categoria categoria, Condicao condicao) {
        this.id = gerarId();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.condicao = condicao;
        this.estoque = ESTOQUE_INICIAL;
        this.disponivel = true;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para reduzir estoque");
        } else if (estoque < quantidade) {
            System.out.println("Estoque insuficiente.");
        } else {
            estoque -= quantidade;
            System.out.println("Estoque atualizado com sucesso! Estoque atual: " + estoque);
        }
    }

    public void aumentarEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para aumentar estoque");
        } else {
            estoque += quantidade;
            System.out.println("Estoque atualizado com sucesso! Estoque atual: " + estoque);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %s%n" +
                        "Produto: %s%n" +
                        "Descrição: %s%n" +
                        "Categoria: %s%n" +
                        "Condição: %s%n" +
                        "Preço: R$ %.2f%n" +
                        "Estoque: %d%n" +
                        "Disponível: %s%n",
                id, nome, descricao, categoria, condicao, preco, estoque, (disponivel ? "Sim" : "Não")
        );
    }

    private String gerarId() {
        return String.format("P%04d", contadorId.getAndIncrement());
    }
}