# Vila DevInHouse

### Ajustes e melhorias


## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
<!---Estes são apenas requisitos de exemplo. Adicionar, duplicar ou remover conforme necessário--->
* Você está utilizando a última versão do `MariaDB`
* Você tem instalado o `docker`.
* Você tem uma máquina `<Windows / Linux / Mac>`.
* Você tem uma IDE compátivel com `Spring Boot`

## 🚀 Instalando VilaDevInHouse

Instale o RabbitMQ pelo docker, utilizando linha do comando ou docker-compose, o arquivo está localizado em:

```
.VilaDevINhouse/Docker/RabbitMQ/docker-compose

```

Para instalar o `VilaDevInHouse`, siga estas etapas:

Insira as seguintes variáveis de ambiente:
```
DB_HOST = HOST DO BANCO DE DADOS; 
DB_USERNAME = USUÁRIO DO BANCO DE DADOS; 
DB_PASSWORD= SENHA DO BANCO DE DADOS; 
VILLAGE_BUDGET= ORÇAMENTO DA VILA; 
RABBIT_HOST= HOST DO RABBITMQ;
RABBIT_PORT= PORTA DO RABBITMQ; 
RABBIT_USERNAME=USUARIO DO RABBITMQ;
RABBIT_PASSWORD=SENHA DO RABBITMQ;
MAIL_USERNAME=noreply@inthurn.com.br;
```

## ☕ Usando o `VilaDevInHouse`

Para usar <VilaDevInHouse>, siga estas etapas:

Para consumir as rotas, utilize os seguintes padrões:

Listar todos os moradores:
```
GET: http://localhost:8080/api/villagers
```
Listar moradores por nome
```
GET: http://localhost:8080/api/villagers?name=INSIRA O NOME AQUI
```
Listar moradores por mês de nascimento
```
GET: http://localhost:8080/api/villager/search?month=INSIRA O MES AQUI (número do mês)
```
Listar moradores por idade maior ou superior a X
```
GET: http://localhost:8080/api/villager/search/byage?age=INSIRA A IDADE AQUI
```
Listar dados de um morador pelo id:
```
GET: http://localhost:8080/api/villager/ID DO MORADOR
```
Cadastro de habitante:
```
POST: http://localhost:8080/api/villager/new

Passando um Json no body, exemplo:
{
    "name": "John",
    "surname":"Doe",
    "cpf":"123.456.789-00",
    "birthday":"1965-10-27",
    "income":102980,
    "user":{
        "username":"jhon@gmail.com",
        "password":"loremipsum",
        "roles":[
            {
                "permission":"ADMIN"
            }
        ]
    }
}

(A data de nascimento deve ser passada no padrão AAAA-MM-DD)

```
Ecluir morador

```
DELETE:
```
http://localhost:8080/api/villager/delete?id=ID DO USUÁRIO
```
Gerar o relatório financeiro da vila:
```
GET: http://localhost:8080/api/reports/village?email=SEU_EMAIL&vality=true
```
O "vality" server para simular a tentativa de postagem da mensagem na fila.

[⬆ Voltar ao topo](#VilaDevInHouse)<br>
