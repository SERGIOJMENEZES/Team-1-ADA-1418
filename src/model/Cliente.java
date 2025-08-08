package model;

public class Cliente extends Pessoa {
    //Atributos
    private final int id;
    private String senha;

    //construtor
    public Cliente(int id, String nome, String cpf, String email, String telefone, String senha) {
        //o super chama o construtor da classe pessoa
        super(nome, cpf, email, telefone);

        // Validação da senha no construtor
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Erro: A senha não pode ser nula ou vazia.");
        }
        this.id = id;
        this.senha = senha;
    }

    //métodos para autenticar a senha
    public boolean autenticar(String senhaDigitada) {
        //verifica se a senha digitada e nula ou vazia
        if (senhaDigitada == null || senhaDigitada.isEmpty()) {
            return false;
        }
        //retorna o resultado da comparação
        return this.senha.equals(senhaDigitada);
    }

    //metodo para redefinir a senha do cliente para uma nova senha.
    public void redefinirSenha(String novaSenha) {
        //verificar se a nova senha foi digitada
        if (novaSenha == null || novaSenha.isEmpty()) {
            System.out.println("Erro: ao redefinir a nova senha, a senha não pode ser nula ou vazia");
            return;
        }

        //Verificar se a nova senha digitada é a mesma que a anterior.
        if (this.senha.equals(novaSenha)) {
            System.out.println("Erro: A nova senha não pode ser igual a senha anterior!");
            return;
        }

        // se a senha nova passar pelas validações a nova senha e redefinada.
        this.senha = novaSenha;

        System.out.println("Senha redefinida com sucesso!");
    }
}