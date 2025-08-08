package model.enums;

class Carrinho {
    private Cliente cliente;
    private List<ItemCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        // Se o produto já existir no carrinho, soma quantidade
        for (ItemCarrinho item : itens) {
            if (item.getProduto().equals(produto)) {
                item.atualizarQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        itens.add(new ItemCarrinho(produto, quantidade));
    }

    public void removerItem(Produto produto) {
        itens.removeIf(item -> item.getProduto().equals(produto));
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemCarrinho::subTotal).sum();
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            itens.forEach(System.out::println);
            System.out.println("TOTAL: R$ " + calcularTotal());
        }
    }
}