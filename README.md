# Valorant Player

API REST para cadastro e gerenciamento de jogadores de **VALORANT**, desenvolvida
com Spring Boot, Spring Web MVC, Spring Data JPA e banco H2.

## Tecnologias

- Java 17
- Spring Boot
- Maven
- H2 (memória)
- PostgreSQL (dependência disponível para futura configuração)

## Como executar

Pré-requisitos: Java 17+ e Maven (ou o Maven Wrapper).

```bash
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/players` | Cadastra um player |
| `GET` | `/players` | Lista todos os players |
| `GET` | `/players/{id}` | Busca um player pelo ID |
| `PUT` | `/players/{id}` | Atualiza um player |

Exemplo de payload:

```json
{
  "nickname": "Aspas",
  "tag": "BR1",
  "elo": "RADIANTE",
  "mainRole": "DUELISTA",
  "mainAgent": "JETT"
}
```

Os campos são validados; `nickname`, `tag`, `elo`, `mainRole` e `mainAgent` são
obrigatórios. Os valores de elo, função e agente devem corresponder aos enums
definidos no projeto.

## Arquitetura

O código está organizado por responsabilidade:

- `controller`: endpoints HTTP e respostas;
- `service`: regras de negócio;
- `repository`: acesso aos dados com Spring Data JPA;
- `model`: entidade `Player`;
- `dto`: objetos de entrada e saída da API;
- `enums`: elos, funções e agentes disponíveis.

## Banco de dados e testes

Por padrão, a aplicação usa H2 em memória. O console está disponível em
`http://localhost:8080/h2-console`, usando a URL
`jdbc:h2:mem:valorant`, usuário `sa` e senha vazia.

Para executar os testes:

```bash
./mvnw test
```
