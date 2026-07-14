# 🩺 Agendamento Médico

Projeto desenvolvido com o objetivo de aplicar conceitos de Arquitetura Hexagonal (Ports & Adapters) utilizando Spring Boot, 
explorando boas práticas de desenvolvimento, separação de responsabilidades, autenticação com JWT, DTOs, persistência com Spring Data JPA e banco de dados H2.

# 📌 Objective

Gerenciar um sistema de agendamento médico através de uma API REST.

A aplicação permite:

Cadastrar pacientes
Cadastrar médicos
Cadastrar consultórios
Cadastrar convênios médicos
Cadastrar laboratórios e hospitais
Registrar receitas e exames
Agendar consultas
Agendar exames
Realizar autenticação utilizando JWT
Validar dados de entrada utilizando Bean Validation
Retornar respostas padronizadas utilizando DTOs

# ⚙️ Technologies
Java 17+
Spring Boot 3.2
Railway
Spring Web
Spring Data JPA
Hibernate
Spring Security
JWT (JSON Web Token)
Bean Validation
Thymeleaf
H2 Database
Lombok
Maven
Git / GitHub

# 🧠 Business Logic

A aplicação foi desenvolvida seguindo os princípios da Arquitetura Hexagonal, separando claramente as responsabilidades entre domínio, aplicação e infraestrutura.

## Controllers

Responsáveis por disponibilizar os endpoints REST da aplicação.

Implementam toda a regra de negócio da aplicação.
São responsáveis por:

validações
processamento dos dados
comunicação com os repositórios
tratamento das regras de agendamento
Repository (Persistence)

A camada de persistência utiliza Spring Data JPA.

Os Repository Adapters fazem a comunicação entre a aplicação e o banco de dados utilizando os JpaRepository.

## DTO Request

Os DTOs Request recebem os dados enviados pelo cliente, evitando que as entidades sejam expostas diretamente.

Os DTOs Response retornam apenas as informações necessárias para o cliente.

A autenticação é realizada utilizando:

Spring Security
JWT Authentication
AuthController
Token JWT

Garantindo acesso protegido aos endpoints da aplicação.

Exception Handler

O projeto possui tratamento centralizado de exceções através do:

GlobalExceptionHandler

Permitindo respostas padronizadas para erros da API.

# ▶️ Execution
Deploy no Railway
https://consulta-medica-production-5fec.up.railway.app

# 🗄️ Database

O sistema utiliza o banco H2 Database para persistência dos dados.

O banco é inicializado automaticamente pelo Spring Boot.

Caso o H2 Console esteja habilitado:

http://localhost:8080/h2-console

# 👨‍🏫 Assessment
Critérios atendidos
✅ Arquitetura Hexagonal (Ports & Adapters)
✅ API REST
✅ Spring Boot
✅ Spring Data JPA
✅ CRUD completo
✅ DTO Request
✅ DTO Response
✅ Spring Security
✅ JWT Authentication
✅ Bean Validation
✅ Tratamento global de exceções
✅ Banco H2
✅ Organização em camadas
✅ Boas práticas de desenvolvimento
✅ Documentação

# 🚀 Future Features
Banco PostgreSQL ou Oracle
Docker
Swagger/OpenAPI
Testes Unitários
Testes de Integração
Upload de exames e receitas
Notificações por e-mail
Agendamento online via calendário
Monitoramento com Spring Actuator
CI/CD com GitHub Actions
