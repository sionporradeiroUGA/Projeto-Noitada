package sistemagestao;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private String login;
    private String senha;
    private String perfil; // administrador, gerente, colaborador

    public Usuario(String nome, String cpf, String email, String cargo, String login, String senha, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getNome() { return nome; }
    public String getPerfil() { return perfil; }

    @Override
    public String toString() {
        return "Usuário: " + nome + " (" + perfil + ")";
    }
}
