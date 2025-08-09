package model;

//classe cliente é a subclasse que herda os dados da classe pessoa
public class Cliente extends Pessoa {
    private String senha;

    public Cliente (String nome, String cpf, String email, String telefone ,String senha ){
        //o super chama o construtor da classe pessoa
        super(nome, cpf, email, telefone);
    this.senha = senha;

     }

     //métodos
    public boolean autenticar (String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }
    public void redefinirSenha (String novaSenha) {
       this.senha = novaSenha;

       System.out.println("Senha redefinida com sucesso!");
    }

}
