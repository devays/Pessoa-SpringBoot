# Exercício de Cadastro de Pessoas - README

Este é um exercício simples de cadastro de pessoas usando Spring Boot e MySQL. O objetivo deste projeto é fornecer um exemplo básico de como criar, atualizar, listar e excluir registros de pessoas em um banco de dados.

## Requisitos

Antes de executar este projeto, certifique-se de que você tenha as seguintes ferramentas instaladas:

- Java JDK
- Spring Boot
- MySQL

## Configuração do Banco de Dados

Certifique-se de configurar seu banco de dados MySQL com as credenciais corretas no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/exercicios-sb
spring.datasource.username=root
spring.datasource.password=root
```
## Executando o Projeto

Para executar o projeto, siga estas etapas:

1. Clone o repositório para o seu ambiente local.
2. Certifique-se de ter todas as dependências configuradas no seu ambiente (Java, Spring Boot, MySQL).
3. Configure o banco de dados como mencionado acima.
4. Execute o aplicativo Spring Boot.

Certifique-se de que você está no diretório raiz do projeto ao executar o aplicativo Spring Boot. Você pode usar o seguinte comando:
```./mvnw spring-boot:run```

O aplicativo será iniciado e estará disponível para uso.

## Endpoints

O aplicativo oferece os seguintes endpoints para operações CRUD:

- POST /api/pessoas: Cria uma nova pessoa com nome, email, usuário e senha.
- GET /api/pessoas/todos: Lista todas as pessoas cadastradas.
- GET /api/pessoas/{parteNome}: Lista pessoas com nomes que contenham a parte especificada.
- PUT /api/pessoas: Atualiza uma pessoa existente com base no nome. Você pode atualizar a senha, mantendo o nome.
- DELETE /api/pessoas/deletar/{id}: Exclui uma pessoa com base no ID.

Lembre-se de que este é um exemplo básico e pode ser expandido para incluir mais recursos e validações, dependendo dos requisitos do seu projeto.
