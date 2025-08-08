package Team

//super classe pessoa, é a classe base para pessoa
public class Pessoa {
    protected String nome;
    protected String cpf;
    protected String email;
    protected String telefone;

    //construtor da classe
    public Pessoa(String nome, String cpf, String email, String telefone) {
       if (nome == null || nome.isEmpty() ||
          cpf == null || cpf.isEmpty() ||
          email == null|| email.isEmpty() ||
          telefone == null || telefone.isEmpty()){
          throw new IllegalArgumentException("Erro: Nenhum campo pode ser nulo ou vazio ao criar uma Pessoa.");
    }
     this.nome =nome;
     this.cpf =cpf;
     this.email =email;
     this.telefone =telefone;
}
    //métodos
    public String getDados(){
        return" nome: "+ nome + ",cpf:"+ cpf +",email:" + email + ",telefone: " + telefone;

    }

    public void autualizarDados(String novoNome,String novoEmail, String novoTelefone){
        boolean dadosAtualizados = false;

        if (novoNome != null && !novoNome.isEmpty()){
            this.nome = novoNome;
            dadosAtualizados = true;
        }
        if (novoEmail != null && !novoEmail.isEmpty()){
            this.email = novoEmail;
            dadosAtualizados = true;
        }
        if (novoTelefone != null && !novoTelefone.isEmpty()){
            this.telefone = novoTelefone;
            dadosAtualizados = true;
        }
        if (dadosAtualizados){
            System.out.println("Dados atualizados com sucesso!");
        } else {
            System.out.println("Dados não atualizados, tentar novamente!");
        }

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
