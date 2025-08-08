package model.enums;

class Carrinho {
    private Cliente cliente;
    private List<Produto> produtos;

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto p) { produtos.add(p); }
    public double calcularTotal() {
        return produtos.stream().mapToDouble(Produto::getValor).sum();
    }

    public void listarProdutos() {
        produtos.forEach(System.out::println);
    }
}