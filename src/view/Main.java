package view;

import controller.PedidoController;
import controller.ProdutoController;
import model.*;
import model.enums.Categoria;
import model.enums.Condicao;
import model.enums.StatusPedido;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        PedidoController pedidoController = new PedidoController();

        // Criar produtos
        Produto produto1 = produtoController.criarProduto("Notebook", "Ultrafino", 3500.00, Categoria.ELETRONICOS, Condicao.NOVO);
        Produto produto2 = produtoController.criarProduto("Smartphone", "Tela AMOLED", 2500.00, Categoria.ELETRONICOS, Condicao.NOVO);

        // Criar cliente
        Cliente cliente1 = new Cliente(1, "Paula", "01234567899", "emaildapaula@email.com", "99999999999", "12345");

        // Exibir detalhes dos produtos
        produtoController.exibirDetalhes(produto1);
        produtoController.exibirDetalhes(produto2);

        // Vender produtos (reduzir estoque)
        produtoController.venderProduto(produto1, 3);
        produtoController.reporProduto(produto1, 10);

        // Ativar e desativar produto
        produtoController.desativarProduto(produto2);
        produtoController.ativarProduto(produto2);

        // Buscar produto por ID e exibir detalhes
        Produto pEncontrado = produtoController.buscarProdutoPorId(produto1.getId());
        produtoController.exibirDetalhes(pEncontrado);

        // Criar uma lista de produtos para o pedido
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        // Criar pedido
        Pedido pedido1 = pedidoController.criarPedido(produtos, cliente1);

        // Exibir detalhes do pedido criado
        pedidoController.exibirDetalhes(pedido1);

        // Alterar status do pedido
        pedidoController.alterarStatusPedido(pedido1, StatusPedido.ENVIADO);

        // Alterar status do pedido
        pedidoController.alterarStatusPedido(pedido1, StatusPedido.ENTREGUE);

        // Buscar pedido por cliente
        ArrayList<Pedido> pedidosPorCliente = pedidoController.buscarPedidosPorCliente(cliente1);
        for (Pedido pedido : pedidosPorCliente) {
            pedidoController.exibirDetalhes(pedido);
        }
    }
}