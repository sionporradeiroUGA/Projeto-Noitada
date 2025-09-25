package sistemagestao;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestao {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Projeto> projetos = new ArrayList<>();
    private List<Equipe> equipes = new ArrayList<>();

    // Usuários
    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public List<Usuario> getUsuarios() { return usuarios; }

    // Projetos
    public void cadastrarProjeto(Projeto p) {
        projetos.add(p);
    }

    public List<Projeto> getProjetos() { return projetos; }

    // Equipes
    public void cadastrarEquipe(Equipe e) {
        equipes.add(e);
    }

    public List<Equipe> getEquipes() { return equipes; }
}
