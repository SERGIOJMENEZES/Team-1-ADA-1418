package model;

class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    public void atualizarQuantidade(int novaQuantidade) {
        if (novaQuantidade > 0) {
            this.quantidade = novaQuantidade;
        } else {
            System.out.println("⚠ Quantidade inválida.");
        }
    }

    public double subTotal() {
        return produto.getValor() * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + " x" + quantidade + " = R$ " + subTotal();
    }
}
