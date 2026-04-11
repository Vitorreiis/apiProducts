#  API Products - Gestão de Produtos

![License](https://img.shields.io/github/license/Vitorreiis/apiProducts?style=for-the-badge)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)

> Uma API RESTful moderna e escalável desenvolvida para estudo e gerenciamento completo de produtos, permitindo operações de CRUD com validações robustas e arquitetura limpa.

###  Status do Projeto
 **Concluído** (ou em manutenção para melhorias de performance)

---

## Funcionalidades

- **Gerenciamento de Produtos**: Cadastro, atualização, listagem e exclusão.
- **Validação de Dados**: Verificação de campos obrigatórios e tipos de dados via Bean Validation.
- **Persistência de Dados**: Integração com banco de dados relacional.
- **Arquitetura MVC**: Separação clara entre Models, Repositories, Services e Controllers.
- **Tratamento de Exceções**: Retornos HTTP padronizados para erros de requisição.

---

## Arquitetura do Sistema
*MVC (Movel View Controller)
*O fluxo segue o padrão Controller -> Service -> Repository -> DB.*

---

## Como Executar

### Pré-requisitos
* **Java 17** ou superior.
* **Maven 3.8+**.
* Uma IDE de sua preferência (IntelliJ, VS Code, Eclipse).

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Vitorreiis/apiProducts.git](https://github.com/Vitorreiis/apiProducts.git)
    cd apiProducts
    ```

2.  **Configuração do Ambiente:**
    Crie ou edite o arquivo `src/main/resources/application.properties` para configurar seu banco de dados:
    ```properties
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Instale as dependências e compile:**
    ```bash
    mvn clean install
    ```

4.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

---

## Endpoints da API

| Método     | Rota               | Descrição                                     | Status Code    |
| :---       | :---               | :---                                          | :---           |
| **GET**    | `/products`        | Lista todos os produtos cadastrados           | 200 OK         |
| **GET**    | `/products/{id}`   | Busca um produto específico pelo ID           | 200 / 404      |
| **POST**   | `/products`        | Cria um novo produto no sistema               | 201 Created    |
| **PUT**    | `/products/{id}`   | Atualiza os dados de um produto existente     | 200 / 404      |
| **DELETE** | `/products/{id}`   | Remove um produto permanentemente             | 204 No Content |

### Exemplo de Payload (POST):
```json
{
  "name": "Smartphone XYZ",
  "price": 1200.50,
  "description": "8GB RAM, 128GB Storage"
}
```

## Contato

#### Linkedin - [Vitor Reis](https://www.linkedin.com/in/vitor-reis-4a595b20a/)
#### Link do Projeto: https://github.com/Vitorreiis/apiProducts

<p align="center">Desenvolvido por Vitor Reis</p>
