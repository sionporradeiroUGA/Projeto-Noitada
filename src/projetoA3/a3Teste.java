import java.util.*;

// Classe Usuário
class Usuario {
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

// Classe Projeto
class Projeto {
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
        return "Projeto: " + nome + " | Status: " + status + " | Gerente: " + gerente.getNome();
    }
}

// Classe Equipe
class Equipe {
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
        return "Equipe: " + nome + " | Membros: " + membros.size();
    }
}

// Classe de Gestão
class SistemaGestao {
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

// Classe Principal
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaGestao sistema = new SistemaGestao();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Projeto");
            System.out.println("3 - Cadastrar Equipe");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Listar Projetos");
            System.out.println("6 - Listar Equipes");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();
                    System.out.print("Login: ");
                    String login = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    System.out.print("Perfil (administrador/gerente/colaborador): ");
                    String perfil = sc.nextLine();

                    sistema.cadastrarUsuario(new Usuario(nome, cpf, email, cargo, login, senha, perfil));
                    break;

                case 2:
                    if (sistema.getUsuarios().isEmpty()) {
                        System.out.println("Cadastre primeiro um usuário para ser gerente!");
                        break;
                    }
                    System.out.print("Nome do projeto: ");
                    String nomeProj = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Data de início: ");
                    String inicio = sc.nextLine();
                    System.out.print("Data de término prevista: ");
                    String fim = sc.nextLine();
                    System.out.print("Status (planejado/em andamento/concluído/cancelado): ");
                    String status = sc.nextLine();

                    System.out.println("Escolha um gerente (digite o índice):");
                    for (int i = 0; i < sistema.getUsuarios().size(); i++) {
                        System.out.println(i + " - " + sistema.getUsuarios().get(i));
                    }
                    int idx = sc.nextInt();
                    sc.nextLine();

                    Usuario gerente = sistema.getUsuarios().get(idx);

                    sistema.cadastrarProjeto(new Projeto(nomeProj, desc, inicio, fim, status, gerente));
                    break;

                case 3:
                    System.out.print("Nome da equipe: ");
                    String nomeEquipe = sc.nextLine();
                    System.out.print("Descrição: ");
                    String descEquipe = sc.nextLine();
                    Equipe equipe = new Equipe(nomeEquipe, descEquipe);

                    if (!sistema.getUsuarios().isEmpty()) {
                        System.out.println("Deseja adicionar membros? (s/n): ");
                        String resp = sc.nextLine();
                        if (resp.equalsIgnoreCase("s")) {
                            for (int i = 0; i < sistema.getUsuarios().size(); i++) {
                                System.out.println(i + " - " + sistema.getUsuarios().get(i));
                            }
                            System.out.print("Digite o índice do usuário (ou -1 para parar): ");
                            int idxUser;
                            while ((idxUser = sc.nextInt()) != -1) {
                                equipe.adicionarMembro(sistema.getUsuarios().get(idxUser));
                                System.out.print("Digite outro índice (ou -1 para parar): ");
                            }
                            sc.nextLine();
                        }
                    }

                    sistema.cadastrarEquipe(equipe);
                    break;

                case 4:
                    System.out.println("=== Usuários ===");
                    sistema.getUsuarios().forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("=== Projetos ===");
                    sistema.getProjetos().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("=== Equipes ===");
                    sistema.getEquipes().forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}