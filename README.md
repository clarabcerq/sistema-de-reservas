# Sistema de Reservas

> Objetivo:

Um sistema simples para gerenciamento de reservas em hotéis, salas e eventos. Projeto de aprendizado e prática do Spring Security desenvolvido com Java e Spring Boot.

> Funcionalidades:

- Cadastro de usuários e locais;
- Criação e gerenciamento de reservas;
- Listagem e cancelamento de usuários, locais e reservas

> Tecnologias:

- Java 21
- Spring Web
- Spring Data JPA
- Spring Security
- Spring Devtools
- Banco de Dados H2
- Lombok
- Gradle

> Instruções:

1. Clone o repositório:
   git clone https://github.com/seu-usuario/sistema-de-reservas.git
2. Abra o projeto na IDE de sua preferência
3. Rode a aplicação e realize os testes no Postman ou Insomnia com os seguintes endpoints:

Usuarios:
   POST
     http://localhost:8080/usuarios

     Estrutura JSON:
     {
        "nome": "",
        "email": "",
        "senha": "",
        "role": ""
     }

     OBS: "role" pode ser USER ou ADMIN.

   GET ALL
     http://localhost:8080/usuarios
   GET ID
     http://localhost:8080/usuarios/{id}
   PUT
     http://localhost:8080/usuarios/{id}
   DELETE
     http://localhost:8080/usuarios/{id}
   
Locais:
   POST
     http://localhost:8080/locais

     Estrutura JSON:
     {
        "nome": "",
        "tipo": "",
        "endereco": ""
     }

     OBS: "tipo" pode ser HOTEL, SALA ou EVENTO.
     
   GET ALL
     http://localhost:8080/locais
   GET ID
     http://localhost:8080/locais/{id}
   PUT
     http://localhost:8080/locais/{id}
   DELETE
     http://localhost:8080/locais/{id}

Reservas:
   POST
     http://localhost:8080/reservas

     Estrutura JSON:
     {
        "inicio": "01-07-2025 14:00",
        "encerramento": "01-07-2025 16:00",
        "usuario": {
          "id": 1
        },
        "local": {
          "id": 1
        }
     }
     
   GET ALL
     http://localhost:8080/reservas
   GET ID
     http://localhost:8080/reservas/{id}
   PUT
     http://localhost:8080/reservas/{id}
   DELETE
     http://localhost:8080/reservas/{id}
