import java.util.ArrayList;

public class ProdutoController {

    private final ArrayList<Produto> produtos = new ArrayList<>();

    /**
     * Cria um produto com os dados fornecidos e o adiciona à lista de produtos.
     * Também imprime uma mensagem confirmando a criação.
     */
    public Produto criarProduto(String nome, String descricao, double preco, Categoria categoria, Condicao condicao) {
        Produto produto = new Produto(nome, descricao, preco, categoria, condicao);
        produtos.add(produto);
        System.out.println("Produto criado: " + produto.getNome());
        return produto;
    }

    /**
     * Exibe os detalhes completos de um produto.
     * Caso o produto seja nulo, exibe uma mensagem de erro.
     */
    public void exibirDetalhes(Produto produto) {
        if (produto == null) {
            System.out.println("Produto inválido para exibição.");
            return;
        }

        System.out.println(produto);
    }

    /**
     * Ativa um produto, tornando-o disponível para venda.
     * Caso o produto seja nulo, exibe uma mensagem de erro.
     */
    public void ativarProduto(Produto produto) {
        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }

        produto.setAtivo(true);
        System.out.println("Produto ativado: " + produto.getNome());
    }

    /**
     * Desativa um produto, tornando-o indisponível para venda.
     * Caso o produto seja nulo, exibe uma mensagem de erro.
     */
    public void desativarProduto(Produto produto) {
        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }

        produto.setAtivo(false);
        System.out.println("Produto inativado: " + produto.getNome());
    }

    /**
     * Realiza a venda de uma quantidade específica de um produto.
     * Caso o produto ou a quantidade seja inválido, ou o estoque insuficiente, exibe uma mensagem de erro.
     */
    public void venderProduto(Produto produto, int quantidade) {
        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }

        boolean sucesso = produto.reduzirEstoque(quantidade);

        if (!sucesso) {
            System.out.println("Não foi possível reduzir o estoque: quantidade inválida ou insuficiente.");
        } else {
            System.out.println("Venda realizada com sucesso. Estoque atual do produto: " + produto.getEstoque());
        }
    }

    /**
     * Reabastece o estoque de um produto com a quantidade fornecida.
     * Caso o produto ou a quantidade seja inválido, exibe uma mensagem de erro.
     */
    public void reporProduto(Produto produto, int quantidade) {
        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }

        boolean sucesso = produto.aumentarEstoque(quantidade);

        if (!sucesso) {
            System.out.println("Não foi possível repor o estoque: quantidade inválida.");
        } else {
            System.out.println("Reposiçao realizada com sucesso. Estoque atual do produto: " + produto.getEstoque());
        }
    }

    /**
     * Busca um produto pelo seu ID dentro da lista de produtos.
     * Retorna o produto correspondente ou null, caso não encontrado.
     */
    public Produto buscarProdutoPorId(String id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }

        System.out.println("Nenhum produto com o ID " + id + " foi encontrado.");
        return null;
    }
}
