# Projeto-Noitada
projeto faculdade JAVA 


Desenvolvemos,um projeto pensado para facilitar a organização e o acompanhamento de equipes e projetos dentro de uma empresa ou organização, conforme solicitado.

Nosso sistema permite que cada pessoa seja cadastrada com suas informações básicas, como nome, CPF, e-mail, cargo, login e senha, e que receba um perfil de acordo com seu papel: administrador, gerente ou colaborador.

Também é possível criar projetos, definindo seu nome, uma breve descrição, datas de início e término e o status de andamento — seja planejado, em andamento, concluído ou cancelado. Cada projeto conta com um gerente responsável, garantindo que tudo seja acompanhado com cuidado.

Além disso, o sistema permite montar equipes, adicionando membros e permitindo que cada equipe participe de vários projetos ao mesmo tempo. Dessa forma, conseguimos organizar melhor as atividades e garantir que todos saibam suas responsabilidades.

## Funcionalidades

O programa é um sistema de gestão de projetos em Java, rodando no console.

### Recursos Principais

- **Cadastrar usuários** (administrador, gerente, colaborador)
- **Cadastrar projetos** (associando um gerente responsável)
- **Cadastrar equipes** (com membros escolhidos da lista de usuários)
- **Listar usuários, projetos e equipes**
- **Menu interativo** no terminal

---

### 1. Usuario

Representa uma pessoa cadastrada no sistema.

**Atributos principais:**
- nome
- cpf
- email
- cargo
- login
- senha
- perfil – tipo de usuário (administrador, gerente, colaborador)

**Funções importantes:**
- `getNome()` – retorna o nome do usuário
- `getPerfil()` – retorna o perfil
- `toString()` – mostra informações resumidas no console

---

### 2. Projeto

Representa um projeto.

**Atributos principais:**
- nome
- descricao
- dataInicio
- dataFim
- status (planejado, em andamento, concluído, cancelado)
- gerente (Usuario responsável)

**Função principal:**
- `toString()` – mostra resumo do projeto no console

---

### 3. Equipe

Representa uma equipe de usuários.

**Atributos:**
- nome
- descricao
- membros (lista de objetos Usuario)

**Funções:**
- `adicionarMembro()` – adiciona usuários à equipe
- `toString()` – mostra equipe + quantidade/membros

---

### 4. SistemaGestao

Funciona como um banco de dados em memória.

**Armazena listas de:**
- usuarios
- projetos
- equipes

**Métodos principais:**
- cadastrar e consultar essas listas

---

### Menu Principal

O usuário pode escolher entre:
1. Cadastrar Usuário
2. Cadastrar Projeto
3. Cadastrar Equipe
4. Listar Usuários
5. Listar Projetos
6. Listar Equipes
7. Sair

---

### Requisitos para rodar

- Instalar JDK 8+
- Usar uma IDE (Eclipse, IntelliJ, NetBeans) ou linha de comando
- Organizar os arquivos corretamente
- Executar a classe Main
