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
        PedidoController pedidoController = new PedidoController(produtoController);

        // Criar produtos
        Produto produto1 = produtoController.criarProduto("Notebook", "Ultrafino", 3500.00, Categoria.ELETRONICOS, Condicao.NOVO);
        Produto produto2 = produtoController.criarProduto("Smartphone", "Tela AMOLED", 2500.00, Categoria.ELETRONICOS, Condicao.NOVO);

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
        Pedido pedido = pedidoController.criarPedido(produtos);

        // Exibir detalhes do pedido criado
        pedidoController.exibirDetalhes(pedido);

        // Alterar status do pedido
        pedidoController.alterarStatusPedido(pedido, StatusPedido.ENVIADO);

        // Alterar status do pedido
        pedidoController.alterarStatusPedido(pedido, StatusPedido.ENTREGUE);
    }
}