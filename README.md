# 0. Identificação do Aluno
* **Instituição:** UniBH  
* **Unidade Curricular:** Modelos, Métodos e Técnicas de Engenharia de Software  
* **Professor:** Lucas Goulart Silva  
* **Aluno:** Lucas Eduardo Dias | **RA:** 123117336  

---

# Sistema de Controle de Agendamentos para Barbearia

Este projeto é uma solução back-end desenvolvida em Java para gerenciar agendamentos e atendimentos em uma barbearia.

## Estrutura do Projeto

- `src/main/java/com/barbearia/model`: Contém as classes de modelo (Entidades).
- `src/main/java/com/barbearia/service`: Contém as classes de serviço com a lógica de negócio.
- `src/main/java/com/barbearia/factory`: Contém as fábricas para criação de objetos (Design Pattern Factory).
- `src/main/java/com/barbearia/strategy`: Contém as estratégias de validação (Design Pattern Strategy).
- `src/test/java/com/barbearia/service`: Contém os testes unitários.

## Tecnologias Utilizadas

- Java (JDK 11 ou superior)
- Princípios SOLID
- Padrão de Projeto Strategy
- Testes Unitários

## Como Executar

1.  Certifique-se de ter o JDK instalado em sua máquina.
2.  Navegue até a raiz do projeto.
3.  Compile o código:
    ```bash
    javac -d bin src/main/java/com/barbearia/model/*.java src/main/java/com/barbearia/strategy/*.java src/main/java/com/barbearia/service/*.java src/test/java/com/barbearia/service/*.java
    ```
4.  Execute os testes:
    ```bash
    java -cp bin com.barbearia.service.AgendamentoServiceTest
    ```

## Documentação

A documentação completa do projeto, incluindo a análise de requisitos e modelagem, pode ser encontrada no arquivo `documentacao_barbearia.md` na raiz do arquivo ZIP.
