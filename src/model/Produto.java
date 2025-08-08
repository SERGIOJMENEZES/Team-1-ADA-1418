package model;

import model.enums.Categoria;
import model.enums.Condicao;
import utils.IdGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representa um produto do sistema Ecommerce
 */
public class Produto {

    // Gerador automático de IDs únicos para produtos
    private static final AtomicInteger contadorId = new AtomicInteger(1); // contador thread-safe
    public static final int ESTOQUE_INICIAL = 50;
    private static final String PREFIXO = "PROD";

    private final String id;
    private String nome;
    private String descricao;
    private double preco;
    private Categoria categoria;
    private Condicao condicao;
    private int estoque;
    private boolean ativo;

    public Produto(String nome, String descricao, double preco, Categoria categoria, Condicao condicao, int estoque,
                   boolean ativo) {
        this.id = IdGenerator.gerarId(PREFIXO,  contadorId);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.condicao = condicao;
        this.estoque = estoque;
        this.ativo = ativo;
    }

    public Produto(String nome, String descricao, double preco, Categoria categoria, Condicao condicao) {
        this(nome, descricao, preco, categoria, condicao, ESTOQUE_INICIAL, true);
    }

    /**
     * Reduz o estoque do produto, caso haja quantidade suficiente.
     *
     * @param quantidade a ser reduzida
     * @return true se o estoque foi reduzido com sucesso, false se não há estoque suficiente ou quantidade for invalida
     */
    public boolean reduzirEstoque(int quantidade) {
        if (quantidade <= 0) {
            return false;
        }

        if (estoque < quantidade) {
            return false;
        }

        estoque -= quantidade;
        return true;
    }

    /**
     * Aumenta o estoque do produto com a quantidade fornecida.
     *
     * @param quantidade a ser adicionada ao estoque
     * @return true se a reposição foi bem-sucedida, false se a quantidade for inválida
     */
    public boolean aumentarEstoque(int quantidade) {
        if (quantidade <= 0) {
            return false;
        }

        estoque += quantidade;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Produto: ").append(nome).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        sb.append("Categoria: ").append(categoria).append("\n");
        sb.append("Condição: ").append(condicao).append("\n");
        sb.append("Preço: R$ ").append(String.format("%.2f", preco)).append("\n");
        sb.append("Estoque: ").append(estoque).append("\n");
        sb.append("Ativo: ").append(ativo ? "Sim" : "Não").append("\n");
        return sb.toString();
    }

    // ====== GETTERS E SETTERS ======

    public final String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }

        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null) {
            throw new IllegalArgumentException("Descriçao não pode ser nula.");
        }

        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }

        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula.");
        }

        this.categoria = categoria;
    }

    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        if (condicao == null) {
            throw new IllegalArgumentException("Condiçao não pode ser nula.");
        }

        this.condicao = condicao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo.");
        }

        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}