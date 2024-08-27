# API Usuários

## Sobre o projeto
API RESTful desenvolvida em Spring Boot para criação e autenticação de usuários através de e-mail e senha.  
Na criação, o usuário deve informar um nome, um e-mail que não esteja cadastro no banco de dados e uma senha forte que contenha letras maiúsculas e minúsculas, símbolos e números. Assim que o cadastro é realizado o usuário recebe um e-mail de confirmação.  
Para autenticar, o usuário deve informar o e-mail e senha cadastrados para gerar um token JWT que dará acesso à obtenção de dados do respectivo usuário.

![image](https://github.com/user-attachments/assets/916d964d-ac05-483e-8c1e-b20d8fc1944c)

### Tecnologias utilizadas:
- Spring Boot
- Spring Mail
- JPA / Hibernate
- Maven
- MySQL
- MongoDB
- JWT
- RabbitMQ
