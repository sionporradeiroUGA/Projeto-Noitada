# Projeto-Noitada
projeto faculdade JAVA 

package model;

public class Usuario {
    private int id; // chave primária no banco
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String cargo;
    private String login;
    private String senha;
    private Perfil perfil;

    public enum Perfil {
        ADMINISTRADOR,
        GERENTE,
        COLABORADOR
    }

    public Usuario(String nomeCompleto, String cpf, String email, String cargo, String login, String senha, Perfil perfil) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getCargo() { return cargo; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public Perfil getPerfil() { return perfil; }
}
