# Biblioteca de Jogos 🎮

API desenvolvida em Java com Spring Boot para gerenciar uma biblioteca pessoal de jogos.  
Permite cadastrar jogos comprados, marcar como finalizados, dar notas e listar os jogos registrados.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (banco de dados em memória)
- Postman (para testes de API)

---

## ⚙️ Como Rodar o Projeto

1. Clone o repositório:
   ```
   git clone https://github.com/rodrigo-pas/biblioteca-jogos.git
   ```

2. Abra no IntelliJ IDEA (ou outra IDE compatível)

3. Execute a classe `BibliotecaJogosApplication`

4. Acesse o console H2 (opcional):  
   [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
   **JDBC URL:** jdbc:h2:mem:jogosdb  
   **Usuário:** sa  
   **Senha:** (deixe em branco)

---

## 📫 Testando com Postman

### ▶️ Criar Jogo – `POST /jogos`

**Exemplo de JSON no corpo da requisição (raw > JSON):**

```json
{
  "nome": "God of War",
  "plataforma": "PlayStation 5",
  "finalizado": true,
  "nota": 10,
  "dataCompra": "2023-07-10"
}
```

**Header necessário:**

```
Content-Type: application/json
```

---

## 📚 Endpoints da API

| Método | Rota            | Ação                         |
|--------|------------------|------------------------------|
| GET    | /jogos           | Lista todos os jogos         |
| GET    | /jogos/{id}      | Busca jogo por ID            |
| POST   | /jogos           | Cadastra novo jogo           |
| PUT    | /jogos/{id}      | Atualiza os dados do jogo    |
| DELETE | /jogos/{id}      | Remove um jogo da biblioteca |

---

## ✅ Validações Implementadas

- `nome` e `plataforma` são obrigatórios
- `nota` deve estar entre 0 e 10
- Retorno com status HTTP apropriados: `200`, `201`, `400`, `404`, `204`

---

## 📘 Informações acadêmicas

Este projeto foi desenvolvido como parte da disciplina **Desenvolvimento Web Back-End**, no curso de **Análise e Desenvolvimento de Sistemas** da **UNINTER**.

**Aluno:** Rodrigo Pinheiro Alcantara da Silva  
**RU:** 4844626

---
