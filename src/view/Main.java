package view;

import controller.PedidoController;
import controller.ProdutoController;
import model.*;
import model.enums.Categoria;
import model.enums.Condicao;

import model.Cliente;
import model.ItemCarrinho;
import model.Carrinho;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ProdutoController produtoController = new ProdutoController();
    private static final PedidoController pedidoController = new PedidoController(produtoController);

    // Armazenamento temporário para clientes, carrinhos etc.
    private static final ArrayList<Cliente> clientes = new ArrayList<>();
    private static final ArrayList<Carrinho> carrinhos = new ArrayList<>();

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== MENU ===");
            System.out.println("1) Criar Produto");
            System.out.println("2) Criar Cliente");
            System.out.println("3) Criar Item no Carrinho");
            System.out.println("4) Criar Carrinho");
            System.out.println("5) Criar Pedido");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // limpar buffer

            switch (opcao) {
                case 1:
                    criarProduto();
                    break;
                case 2:
                    criarCliente();
                    break;
                case 3:
                    criarItemCarrinho();
                    break;
                case 4:
                    criarCarrinho();
                    break;
                case 5:
                    criarPedido();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private static void criarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Categorias disponíveis: ");
        for (Categoria cat : Categoria.values()) {
            System.out.println("- " + cat);
        }
        System.out.print("Escolha uma categoria: ");
        String categoriaStr = scanner.nextLine().toUpperCase();
        Categoria categoria = Categoria.valueOf(categoriaStr);

        System.out.println("Condições disponíveis: ");
        for (Condicao cond : Condicao.values()) {
            System.out.println("- " + cond);
        }
        System.out.print("Escolha uma condição: ");
        String condicaoStr = scanner.nextLine().toUpperCase();
        Condicao condicao = Condicao.valueOf(condicaoStr);

        Produto produto = produtoController.criarProduto(nome, descricao, preco, categoria, condicao);
        System.out.println("Produto criado: " + produto.getNome());
    }

    private static void criarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, email, telefone, senha);
        clientes.add(cliente);

        System.out.println("Cliente criado: " + cliente.getNome());
    }

    private static void criarItemCarrinho() {
        if (carrinhos.isEmpty()) {
            System.out.println("Nenhum carrinho criado. Crie um carrinho antes.");
            return;
        }

        System.out.println("Selecione o carrinho pelo índice:");
        for (int i = 0; i < carrinhos.size(); i++) {
            System.out.println(i + ": Carrinho do cliente " + carrinhos.get(i).getCliente().getNome());
        }
        int idxCarrinho = scanner.nextInt();
        scanner.nextLine();

        Carrinho carrinho = carrinhos.get(idxCarrinho);

        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtoController.getProdutos().size(); i++) {
            Produto p = produtoController.getProdutos().get(i);
            System.out.println(i + ": " + p.getNome() + " | R$ " + p.getPreco());
        }
        System.out.print("Selecione o produto pelo índice: ");
        int idxProduto = scanner.nextInt();
        scanner.nextLine();

        Produto produto = produtoController.getProdutos().get(idxProduto);

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        carrinho.adicionarItem(produto, quantidade);
        System.out.println("Item adicionado ao carrinho.");
    }

    private static void criarCarrinho() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Crie um cliente antes.");
            return;
        }

        System.out.println("Selecione o cliente pelo índice:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + ": " + clientes.get(i).getNome());
        }
        int idxCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = clientes.get(idxCliente);

        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(cliente);

        carrinhos.add(carrinho);

        System.out.println("Carrinho criado para cliente " + cliente.getNome());
    }

    private static void criarPedido() {
        if (carrinhos.isEmpty()) {
            System.out.println("Nenhum carrinho criado.");
            return;
        }

        System.out.println("Selecione o carrinho para criar pedido:");
        for (int i = 0; i < carrinhos.size(); i++) {
            System.out.println(i + ": Carrinho do cliente " + carrinhos.get(i).getCliente().getNome());
        }
        int idxCarrinho = scanner.nextInt();
        scanner.nextLine();

        Carrinho carrinho = carrinhos.get(idxCarrinho);

        if (carrinho.getItens().isEmpty()) {
            System.out.println("Carrinho vazio. Adicione itens antes de criar pedido.");
            return;
        }

        ArrayList<Produto> produtosParaPedido = new ArrayList<>();
        for (ItemCarrinho item : carrinho.getItens()) {
            produtosParaPedido.add(item.getProduto());
        }

        Pedido pedido = pedidoController.criarPedido(produtosParaPedido);
        if (pedido != null) {
            pedidoController.exibirDetalhes(pedido);
        }
    }
}
