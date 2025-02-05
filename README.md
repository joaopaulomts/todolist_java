# TodoList API

Este projeto é uma API REST simples para gerenciamento de tarefas (To-Do List), construída com Spring Boot. As tarefas são armazenadas em memória durante a execução da aplicação, utilizando uma lista de objetos.

## 📌 Endereço Base

```
http://localhost:8080
```

## 🚀 Endpoints

### 1️⃣ Criar uma Tarefa

* **Endpoint:** `/todo`
* **Método HTTP:** `POST`
* **Body (JSON):**

```json
{
  "name": "Nome da Tarefa",
  "description": "Descrição da Tarefa",
  "deadline": "dd/MM/yyyy"
}
```

* **Exemplo:**

```json
{
  "name": "Fazer compras",
  "description": "Comprar frutas, legumes e pão",
  "deadline": "15/03/2024"
}
```

* **Resposta (JSON):**

```json
{
  "id": 1,
  "name": "Fazer compras",
  "description": "Comprar frutas, legumes e pão",
  "deadline": "15/03/2024",
  "createdAt": "2024-02-05T10:30:00.000Z",
  "completed": false
}
```

### 2️⃣ Listar todas as Tarefas

* **Endpoint:** `/todo`
* **Método HTTP:** `GET`
* **Resposta (JSON):**

```json
[
  {
    "id": 1,
    "name": "Fazer compras",
    "description": "Comprar frutas, legumes e pão",
    "deadline": "15/03/2024",
    "createdAt": "2024-02-05T10:30:00.000Z",
    "completed": false
  },
  {
    "id": 2,
    "name": "Pagar contas",
    "description": "Pagar conta de luz e água",
    "deadline": "15/03/2024",
    "createdAt": "2024-02-05T11:00:00.000Z",
    "completed": true
  }
]
```

### 3️⃣ Obter uma Tarefa por ID

* **Endpoint:** `/todo/{id}`
* **Método HTTP:** `GET`
* **Parâmetros:**
    * `id`: ID da tarefa
* **Resposta (JSON):**

```json
{
  "id": 1,
  "name": "Fazer compras",
  "description": "Comprar frutas, legumes e pão",
  "deadline": "15/03/2024",
  "createdAt": "2024-02-05T10:30:00.000Z",
  "completed": false
}
```

### 4️⃣ Atualizar uma Tarefa

* **Endpoint:** `/todo/{id}`
* **Método HTTP:** `PUT`
* **Parâmetros:**
    * `id`: ID da tarefa
* **Body (JSON):** (Campos que deseja atualizar)

```json
{
  "name": "Fazer compras urgentes",
  "deadline": "15/03/2024"
}
```

* **Resposta (JSON):** (Tarefa atualizada)

```json
{
  "id": 1,
  "name": "Fazer compras urgentes",
  "description": "Comprar frutas, legumes e pão",
  "deadline": "15/03/2024",
  "createdAt": "2024-02-05T10:30:00.000Z",
  "completed": false
}
```

### 5️⃣ Deletar uma Tarefa

* **Endpoint:** `/todo/{id}`
* **Método HTTP:** `DELETE`
* **Parâmetros:**
    * `id`: ID da tarefa
* **Resposta:** (Código de status 200)

## ℹ️ Observações

* A aplicação deve estar em execução na porta `8080` (padrão do Spring Boot).
* O formato da data (`deadline`) deve ser `dd/MM/yyyy`.
* O campo `createdAt` representa a data e hora de criação da tarefa.
* Os dados são armazenados em memória e **não persistem** após o término da execução da aplicação.

## 🛠 Tecnologias Utilizadas

* Java 17+
* Spring Boot 3+
* Maven

## ▶️ Como Executar

1. Clone este repositório.
2. Certifique-se de ter o **Java** e o **Maven** instalados.
3. Navegue até o diretório do projeto.
4. Execute o comando:
   ```sh
   mvn spring-boot:run
   ```
5. A API estará disponível em `http://localhost:8080`

---


