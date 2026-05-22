# 0. Identificação do Aluno
* **Instituição:** UniBH  
* **Unidade Curricular:** Modelos, Métodos e Técnicas de Engenharia de Software  
* **Professor:** Lucas Goulart Silva  
* **Aluno:** Lucas Eduardo Dias | **RA:** 123117336  

---

# Documentação do Trabalho Prático: Sistema de Controle de Agendamentos para Barbearia

## 1. Introdução

Este documento apresenta a análise, modelagem e proposta de solução para um sistema de controle de agendamentos e atendimento para uma barbearia local, desenvolvido como trabalho prático da Unidade Curricular de Modelos, Métodos e Técnicas de Engenharia de Software do UniBH.

## 2. Definição do Problema

### 2.1. Contexto Atual

Atualmente, a barbearia opera com um sistema de agendamentos predominantemente manual, utilizando cadernos e trocas de mensagens via WhatsApp. Este método, embora simples, introduz uma série de ineficiências e problemas operacionais que afetam a qualidade do serviço e a gestão do negócio.

### 2.2. Problemas Identificados

A abordagem manual resulta nos seguintes problemas:

A abordagem manual resulta em diversos problemas operacionais. Primeiramente, a ausência de um sistema centralizado e automatizado para gerenciar a disponibilidade de horários frequentemente leva a **conflitos de horário**, com agendamentos duplicados para o mesmo barbeiro ou horário. Em segundo lugar, a gestão da fila de atendimento é realizada de forma improvisada, baseada na memória ou em anotações dispersas, o que causa **dificuldade na organização da fila** e, consequentemente, atrasos e insatisfação dos clientes. Além disso, agendamentos realizados por mensagens podem ser facilmente perdidos ou esquecidos, resultando na **perda de agendamentos** e impactando negativamente a receita e a reputação da barbearia. Outro ponto crítico é a **falta de histórico de clientes**, pois não há um registro estruturado de seus serviços preferidos ou visitas anteriores, dificultando a personalização do atendimento e a fidelização. A **dificuldade na análise de serviços** também é um problema, já que a ausência de dados impede a identificação dos serviços mais procurados, o que dificulta decisões estratégicas sobre marketing e oferta de serviços. Por fim, a desorganização geral do processo de agendamento e atendimento contribui para **atrasos no atendimento**, gerando insatisfação e potencial perda de clientes.

### 2.3. Usuários Envolvidos

Os principais usuários do sistema proposto são:

Os principais usuários do sistema proposto são o **Cliente**, que busca agendar, cancelar ou consultar seus agendamentos; o **Barbeiro/Atendente**, profissional responsável por gerenciar a agenda, registrar atendimentos e visualizar o histórico dos clientes; e o **Administrador (Dono da Barbearia)**, que será responsável pela gestão geral do sistema, incluindo cadastro de serviços, visualização de relatórios e configurações.

### 2.4. Funcionamento Atual (Manual)

O fluxo de trabalho atual pode ser resumido da seguinte forma:

Atualmente, o fluxo de trabalho manual inicia-se quando o cliente entra em contato com a barbearia, geralmente por telefone ou WhatsApp, para solicitar um agendamento. O barbeiro ou atendente, então, verifica a disponibilidade em uma agenda física ou anota o horário em um caderno. É importante notar que não existe um mecanismo automático de validação de horário, o que torna o processo dependente da atenção humana para evitar conflitos. O controle do atendimento é realizado de forma informal, sem um sistema dedicado para gerenciar a fila ou o status dos serviços, e não há um histórico estruturado de clientes ou serviços realizados.

## 3. Solução Proposta (Sistema Back-end em Java)

Propõe-se o desenvolvimento de um sistema back-end em Java para automatizar e otimizar o controle de agendamentos e atendimentos da barbearia. O foco será na implementação de funcionalidades essenciais que resolvam os problemas identificados, aplicando os princípios de Engenharia de Software.

### 3.1. Funcionalidades Principais

O sistema deverá contemplar as seguintes funcionalidades:

O sistema deverá contemplar funcionalidades essenciais para a gestão da barbearia. Isso inclui o **Cadastro de Clientes**, para registro e gerenciamento de suas informações, e o **Cadastro de Serviços**, para definir e manter os serviços oferecidos, como corte, barba e coloração, com suas respectivas durações e preços. A **Criação de Agendamentos** permitirá que clientes ou atendentes agendem serviços, associando cliente, barbeiro, serviço, data e horário. Uma funcionalidade crucial será a **Validação de Conflito de Horários**, que impedirá agendamentos duplicados para o mesmo barbeiro ou em horários já ocupados. O **Cancelamento de Agendamentos** será possível, com o registro do histórico de cancelamentos. Para a organização, haverá a **Consulta de Agenda**, permitindo a visualização por dia e por barbeiro, e o **Histórico de Atendimentos**, que manterá um registro detalhado dos serviços realizados para cada cliente.

### 3.2. Regras de Negócio

As seguintes regras de negócio serão implementadas para garantir a integridade e a eficiência do sistema:

Para garantir a integridade e a eficiência do sistema, as seguintes regras de negócio serão implementadas: primeiramente, um barbeiro não poderá ter dois agendamentos simultâneos. Em segundo lugar, os agendamentos só poderão ser realizados em horários que estejam disponíveis na agenda do barbeiro. Adicionalmente, o cancelamento de um agendamento deverá ser registrado, e o agendamento original será mantido no histórico com o status de cancelado. Por fim, cada agendamento deverá estar associado a um cliente, um serviço, um barbeiro, uma data/hora específica e um status (por exemplo, agendado, concluído ou cancelado).

## 4. Levantamento e Análise de Requisitos (Abordagem Ágil)

### 4.1. Product Backlog Priorizado
* **Alta Prioridade:** RF01 (Agendamento de Horários), RF02 (Validação de Conflito).
* **Média Prioridade:** RF03 (Cancelamento de Agendamento), RF04 (Cadastro de Clientes/Serviços).
* **Baixa Prioridade:** RF05 (Histórico de Atendimentos).

### 4.2. User Stories e Critérios de Aceitação (BDD)

**US01 – Agendamento de Serviço (Cliente)**
* **Como** Cliente da barbearia,
* **Eu quero** solicitar o agendamento de um serviço escolhendo o barbeiro, data e horário,
* **Para que** eu garanta meu atendimento sem conflitos na agenda.
* **Critérios de Aceitação:**
  * **Cenário 1: Horário vago.** Dado que o Barbeiro "Carlos" está disponível às 14:00; Quando o cliente Lucas solicita o agendamento; Então o sistema confirma a reserva e muda o status para `CONFIRMADO`.
  * **Cenário 2: Conflito de horário.** Dado que o Barbeiro "Carlos" já tem um agendamento às 14:00; Quando outro cliente tenta agendar no mesmo horário; Então o sistema rejeita a operação e lança uma exceção de conflito.

**US02 – Cancelamento de Compromisso (Cliente/Atendente)**
* **Como** Usuário do sistema,
* **Eu quero** cancelar um agendamento existente,
* **Para que** o horário fique livre para outros clientes e o registro fique salvo no histórico.
* **Critérios de Aceitação:**
  * **Cenário 1: Cancelamento com sucesso.** Dado que o cliente Lucas possui um agendamento `CONFIRMADO`; Quando ele solicita o cancelamento; Então o status muda para `CANCELADO` e o horário é liberado.

## 5. Modelagem da Solução

A modelagem da solução será realizada utilizando diagramas UML, com foco inicial no diagrama de classes para representar a estrutura estática do sistema. Outros diagramas (e.g., de sequência, de atividades) poderão ser adicionados conforme a necessidade para detalhar o comportamento do sistema.

### 5.1. Diagrama de Classes (Esboço)

Serão identificadas as seguintes classes principais:

Serão identificadas as seguintes classes principais: `Cliente`, `Servico`, `Barbeiro`, `Agendamento` e `Agenda` (ou um serviço de agendamento).

As relações entre essas classes serão definidas para refletir as regras de negócio, como um `Cliente` podendo ter múltiplos `Agendamento`s, um `Barbeiro` tendo uma `Agenda` com vários `Agendamento`s, e um `Agendamento` estando associado a um `Servico`.

## 6. Desenvolvimento da Solução (Java)

A implementação será em Java, seguindo as melhores práticas de Engenharia de Software, incluindo:

A implementação será em Java, seguindo as melhores práticas de Engenharia de Software. Isso inclui a aplicação dos **Princípios SOLID** (Single Responsibility Principle - SRP, Open/Closed Principle - OCP, Liskov Substitution Principle - LSP, Interface Segregation Principle - ISP e Dependency Inversion Principle - DIP) para garantir um código robusto e de fácil manutenção. Será feita a **utilização de Padrões de Projeto**, tanto criacionais, estruturais quanto comportamentais. Especificamente, foram implementados o padrão **Strategy** (em `com.barbearia.strategy`) para validação de regras de agendamento e o padrão **Factory** (em `com.barbearia.factory`) para a criação centralizada de serviços. O **desenvolvimento de Testes Unitários** foi fundamental para validar o comportamento das classes e funcionalidades críticas, como a validação de conflito de horários. Por fim, a **Estrutura do Projeto** está organizada de forma clara, com pacotes bem definidos para separar responsabilidades: `model` para as entidades, `service` para a lógica de negócio, `factory` para criação de objetos e `strategy` para as validações.

## 7. Entregáveis

O projeto final será disponibilizado em um repositório GitHub e incluirá:

O projeto final será disponibilizado em um repositório GitHub e incluirá o código-fonte completo da aplicação Java, os testes unitários desenvolvidos, a documentação detalhada (este arquivo Markdown), os diagramas UML (incluindo o diagrama de classes) e instruções claras para a execução da aplicação.

## 8. Critérios de Avaliação

O trabalho será avaliado com base nos seguintes critérios:

A avaliação do trabalho considerará diversos aspectos, como a coerência e relevância do problema escolhido, a qualidade do levantamento e análise de requisitos, a organização e modelagem da solução, e a qualidade do código desenvolvido, com a aplicação dos princípios SOLID e o uso coerente de padrões de projeto. Também serão avaliados a implementação de testes unitários, a organização do repositório GitHub, a evolução contínua do projeto (evidenciada pelos commits), a participação individual dos integrantes (se aplicável) e a clareza na apresentação e justificativa das decisões adotadas.
