package sistemagestao;

import java.util.List;
import java.util.Scanner;

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
                case 1 -> {
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
                }

                case 2 -> {
                    List<Usuario> candidatos = sistema.getUsuarios().stream()
                            .filter(u -> u.getPerfil().equalsIgnoreCase("gerente") ||
                                         u.getPerfil().equalsIgnoreCase("administrador"))
                            .toList();

                    if (candidatos.isEmpty()) {
                        System.out.println("Nenhum usuário com perfil de gerente ou administrador cadastrado!");
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
                    for (int i = 0; i < candidatos.size(); i++) {
                        System.out.println(i + " - " + candidatos.get(i));
                    }
                    int idx = sc.nextInt();
                    sc.nextLine();

                    if (idx < 0 || idx >= candidatos.size()) {
                        System.out.println("Índice inválido!");
                        break;
                    }

                    Usuario gerente = candidatos.get(idx);

                    sistema.cadastrarProjeto(new Projeto(nomeProj, desc, inicio, fim, status, gerente));
                }

                case 3 -> {
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
                                if (idxUser >= 0 && idxUser < sistema.getUsuarios().size()) {
                                    equipe.adicionarMembro(sistema.getUsuarios().get(idxUser));
                                    System.out.println("Membro adicionado!");
                                } else {
                                    System.out.println("Índice inválido!");
                                }
                                System.out.print("Digite outro índice (ou -1 para parar): ");
                            }
                            sc.nextLine();
                        }
                    }

                    sistema.cadastrarEquipe(equipe);
                }

                case 4 -> {
                    System.out.println("=== Usuários ===");
                    if (sistema.getUsuarios().isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        sistema.getUsuarios().forEach(System.out::println);
                    }
                }

                case 5 -> {
                    System.out.println("=== Projetos ===");
                    if (sistema.getProjetos().isEmpty()) {
                        System.out.println("Nenhum projeto cadastrado.");
                    } else {
                        sistema.getProjetos().forEach(System.out::println);
                    }
                }

                case 6 -> {
                    System.out.println("=== Equipes ===");
                    if (sistema.getEquipes().isEmpty()) {
                        System.out.println("Nenhuma equipe cadastrada.");
                    } else {
                        sistema.getEquipes().forEach(System.out::println);
                    }
                }

                case 0 -> {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
