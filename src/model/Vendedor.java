package model;

class Vendedor extends Pessoa {
    private String loja;

    public Vendedor(String nome, String documento, String email, String telefone, String loja) {
        super(nome, documento, email, telefone);
        this.loja = loja;
    }

    public String getLoja() { return loja; }

}