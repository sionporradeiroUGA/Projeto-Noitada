package sistemagestao;

public class Projeto {
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private String status; // planejado, em andamento, concluído, cancelado
    private Usuario gerente;

    public Projeto(String nome, String descricao, String dataInicio, String dataFim, String status, Usuario gerente) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Projeto: " + nome + " | Status: " + status +
               " | Gerente: " + gerente.getNome() +
               " | Descrição: " + descricao;
    }
}