# dio-desafio-design-patterns
Desafio de projeto realizado pela DIO cujo objetivo é colocar em prática conceitos de padrões de design utilizando o Spring Boot.

## 🚀 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot**
  - Spring Web (REST APIs)
  - Spring Data JPA (persistência)
- **H2 Database** (banco em memória para testes)
- **OpenFeign** (consumo de APIs externas — ViaCEP)
- **Swagger / Springdoc OpenAPI** (documentação da API)

## 📖 Sobre o projeto

A aplicação expõe uma **API REST** para gerenciar clientes e seus endereços.  
O endereço do cliente é buscado automaticamente através da **API ViaCEP**, utilizando o CEP informado.
