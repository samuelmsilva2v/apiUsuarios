# API Usuários

## Sobre o projeto
API RESTful desenvolvida em Spring Boot para criação e autenticação de usuários através de e-mail e senha.
<br><br>
Na criação, o usuário deve informar um nome, um e-mail que não esteja cadastro no banco de dados e uma senha forte que contenha letras maiúsculas e minúsculas, símbolos e números. Assim que o cadastro é realizado o usuário recebe um e-mail de confirmação e um log é gerado
no MongoDB.
<br><br>
Para autenticar, o usuário deve informar o e-mail e senha cadastrados para gerar um token JWT.


### Tecnologias utilizadas:
- Spring Boot
- Spring Mail
- JPA / Hibernate
- Maven
- MySQL
- MongoDB
- JWT
- RabbitMQ
- Swagger

## Endpoints 
| Método | Endpoint             | Descrição                   |
|--------|-----------------------|-----------------------------|
| POST   | `/api/usuario/criar`      | Cadastrar um novo usuário      |
| POST    | `/api/usuario/autenticar`      | Autenticar usuário   |
| GET    | `/api/usuario/obter-dados` | Consultar dados do usuário autenticado  |

## Configuração e Execução

#### Requisitos
- Java 21 ou superior
- Spring Boot 3.3.5
- Maven 3.8+
- MySQL

### 1. Clone o repositório:

```bash
https://github.com/samuelmsilva2v/apiUsuarios.git
cd apiUsuarios
```

### 2. Instale as dependências:

```bash
mvn clean install
```

### 3. Execute o projeto:
```bash
mvn spring-boot:run
```

### 4. Acesse a aplicação:
  - Documentação da API: http://localhost:8081/swagger-ui/index.html


### Autor
- Samuel Maciel da Silva
  - [LinkedIn](https://www.linkedin.com/in/samuelmsilva2v/)
  - [E-mail](mailto:samuelmsilva@outlook.com.br)




