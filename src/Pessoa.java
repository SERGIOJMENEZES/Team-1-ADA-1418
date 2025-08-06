package Team

//super classe pessoa, é a classe base para pessoa
public class Pessoa{
    protected String nome;
    protected String cpf;
    protected String email;
    protected String telefone;

    //construtor da classe
    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
    //métodos
    public String getDados(){
        return" nome: "+ nome + ",cpf:"+ cpf +",email:" + email + ",telefone: " + telefone;

    }

    public void autualizarDados(String novoNome,String novoEmail, String novoTelefone){
        this.nome = novoNome;
        this.email = novoEmail;
        this.telefone = novoTelefone;
        System.out.println("Dados Atualizados!");
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }

}
