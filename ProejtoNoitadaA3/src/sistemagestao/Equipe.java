package sistemagestao;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private String descricao;
    private List<Usuario> membros = new ArrayList<>();

    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
    }

    @Override
    public String toString() {
        String nomesMembros = membros.isEmpty() ? "Nenhum membro" :
                membros.stream().map(Usuario::getNome).reduce((a, b) -> a + ", " + b).orElse("");
        return "Equipe: " + nome + " | Descrição: " + descricao +
               " | Membros: [" + nomesMembros + "]";
    }
}