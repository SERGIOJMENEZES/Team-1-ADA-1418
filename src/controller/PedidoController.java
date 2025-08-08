package controller;

import model.Pedido;
import model.Produto;
import model.enums.StatusPedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class PedidoController {

    private final HashMap<String, Pedido> pedidos = new HashMap<>();
    private final ProdutoController produtoController;

    public PedidoController(ProdutoController produtoController) {
        this.produtoController = produtoController;
    }

    /**
     * Cria um pedido a partir de uma lista de produtos.
     * Verifica se a lista é nula ou vazia e se todos os produtos estão disponíveis.
     * Calcula o valor total e cria o pedido com a lista informada.
     *
     * @param produtos lista de produtos a serem incluídos no pedido
     * @return o pedido criado ou null caso a lista seja inválida ou contenha produtos indisponíveis
     */
    public Pedido criarPedido(ArrayList<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            System.out.println("Nenhum produto válido foi selecionado. Pedido não criado.");
            return null;
        }

        for (Produto produto : produtos) {
            if (produto == null || !produto.isAtivo()) {
                System.out.println("Um ou mais produtos inválidos ou indisponíveis foram detectados. Pedido não criado.");
                return null;
            }
        }

        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }

        Pedido pedido = new Pedido(produtos, valorTotal);
        pedidos.put(pedido.getId(), pedido);
        System.out.println("Pedido criado com sucesso: " + pedido.getId());

        return pedido;
    }

    /**
     * Exibe os detalhes completos de um pedido.
     * Caso o pedido seja nulo, exibe uma mensagem de erro.
     *
     * @param pedido o pedido cujos detalhes serão exibidos
     */
    public void exibirDetalhes(Pedido pedido) {
        if (pedido == null) {
            System.out.println("Nao foi possivel exibir os detalhes do pedido.");
            return;
        }

        System.out.println(pedido);
    }

    /**
     * Altera o status de um pedido existente.
     * Verifica se o pedido e o novo status não são nulos antes de alterar.
     *
     * @param pedido o pedido cujo status será alterado
     * @param novoStatus o novo status a ser atribuído ao pedido
     */
    public void alterarStatusPedido(Pedido pedido, StatusPedido novoStatus) {
        if (pedido == null || novoStatus == null) {
            System.out.println("Nao foi possivel alterar o status do pedido.");
            return;
        }

        pedido.setStatus(novoStatus);
        System.out.println("Status do pedido " + pedido.getId() + " alterado para " + novoStatus);
    }

    /**
     * Busca um pedido por um ID.
     *
     * @param id identificador do pedido a ser buscado
     * @return o pedido correspondente ao ID, ou null se não encontrado
     */
    public Pedido buscarPedidoPorId(String id) {
        return pedidos.get(id);
    }

    /**
     * Busca todos os pedidos que possuam um determinado status.
     *
     * @param status o status para filtrar os pedidos
     * @return lista de pedidos que correspondem ao status informado
     */
    public ArrayList<Pedido> buscarPedidosPorStatus(StatusPedido status) {
        ArrayList<Pedido> pedidosEncontrados = new ArrayList<>();

        for (Pedido pedido : pedidos.values()) {
            if (pedido.getStatus() == status) {
                pedidosEncontrados.add(pedido);
            }
        }

        return pedidosEncontrados;
    }

    /**
     * Busca todos os pedidos realizados numa data específica.
     *
     * @param data a data para filtrar os pedidos
     * @return lista de pedidos realizados na data informada
     */
    public ArrayList<Pedido> buscarPedidosPorData(LocalDate data) {
        ArrayList<Pedido> pedidosEncontrados = new ArrayList<>();

        for (Pedido pedido : pedidos.values()) {
            if (pedido.getDataPedido().toLocalDate().equals(data)) {
                pedidosEncontrados.add(pedido);
            }
        }

        return pedidosEncontrados;
    }
}