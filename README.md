# Teste prático desenvolvedor - Courart Informática

## Pré-requisitos

- JavaScript
- NodeJS
- MySQL
- Java 


## Como iniciar - Cliente (Front-end)

Abra o diretório cliente do projeto no terminal e digite os comandos abaixo.

1. Primeiro instalar todas as dependencias.

    ```$ npm install```

2. Em seguida, execute o comando para abri um servidor ```dev``` local no endereço ```http://localhost:4200/```

    ```$ ng serve``` 


## Como iniciar - Server (Back-end)
Para iniciar o server, é necessário ter o MySQL configurado e instalado na máquina local. 
As configurações de acesso ficam dentro do arquivo ```src/main/resources/application.properties```, bem como, 
as configurações gerais do projeto Spring Boot.
Dentro da pasta ```server/courart``` gere o build da aplicação com o comando: ```$ ./mvnw clean verify```.
Se o build passou, como esperado, o código foi compilado e um .jar executável foi criado na pasta:
```target/```, em seguida, executar a aplicação: ```$ java -jar target/courart-0.0.1-SNAPSHOT.jar```, e o servidor será 
iniciado no endereço: ```http://localhost:8080```


## API

1. Adiciona um novo veículo

    - Request
    ```POST http://localhost:8080/api/v1/veiculos```

2. Retorna veículos pelo seu modelo:

    - Request
    ```GET http://localhost:8080//modelo/{id}```

3. Retorna veículo pela sua placa:

    - Request
    ```GET  http://localhost:8080/placa/{placa}```

4. Retorna veículos pela data de cadastro, e se veículo está ativo.

    - Request
    ```GET http://localhost:8080/dt/{start}/{end}```

5. Adiciona um novo usuário

    - Request
    ```POST http://localhost:8080/api/v1/user```

6. Retorna usuário pelo seu cpf

    - Request
    ```GET http://localhost:8080/api/v1/user/cpf/{cpf}```

7. Retorna usuários pelo seu nome

    - Request
    ```GET http://localhost:8080/api/v1/user/nome/{nome}```

8. Retorna pessoas pela data de nascimento

    - Request
    ```GET http://localhost:8080/api/v1/pessoa/dt/{start}/{end}```

9. Retorna todos os modelos

    - Request
    ```GET http://localhost:8080/api/v1/modelos```

10. Adiciona um novo modelo

    - Request
    ```POST http://localhost:8080/api/v1/modelos```