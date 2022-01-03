# Vila DevInHouse

### Ajustes e melhorias


## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
<!---Estes são apenas requisitos de exemplo. Adicionar, duplicar ou remover conforme necessário--->
* Você está utilizando a última versão do `postgresql`
* Você tem uma máquina `<Windows / Linux / Mac>`.
* Você tem uma IDE compátivel com `Spring Boot`

## 🚀 Instalando VilaDevInHouse

Para instalar o `VilaDevInHouse`, siga estas etapas:

Siga os scripts SQL localizados em:
```
VilaDevInHouse/database/BD_fisico.sql
(não esqueça de selecionar banco de dados após criá-lo, antes de seguir com as outras etapas)
```
Insira os dados de seu banco no application.properties, nas variáveis:

```
spring.datasource.url:URL DO BANCO
spring.datasouce.username: USERNAME DO BANCO
spring.datasource.password: SENHA DO BANCO
```

Altere também a variável para o orçamento da vila:

```
village.budget
```

## ☕ Usando o `VilaDevInHouse`

Para usar <VilaDevInHouse>, siga estas etapas:

```
Efetue o login utilizando a rota "/login" com um JSON contendo "username" e "password";

{
  "username": "USERNAME_AQUI",
  "password": "PASSWORD_AQUI"
}
```
- Após logar, salve o token para autenticar nas próximas rotas.
(Obs: pode ser necessário autenticar novamente após um período de tempo).

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
GET: htto://localhost:8080/api/villagers/searchByMonth/INSIRA O MES AQUI (Mês ou número do mês)
```
Listar Moradores por nome
```
GET:
http://localhost:8080/api/villagers/searchByName?name=INSIRA O NOME AQUI
```
Listar moradores por idade maior ou superior a X
```
GET: http://localhost:8080/api/villager/search/age?age=INSIRA A IDADE AQUI
```
Listar dados de um morador pelo id:
```
GET: http://localhost:8080/api/villager/ID DO MORADOR
```
Cadastro de habitante:
```
POST: http://localhost:8080/api/villager/new

Com o body:

{
    "name": "***",
    "surname" : "***",
    "birthday" : "****-**-**,
    "income": ****,
    "cpf": "***.***.***-**",
    "email": "*********",
    "password": "*****"
}

(Susbistitua os * pelos dados desejados)
(A data de nascimento deve ser passada no padrão AAAA-MM-DD)

```
Ecluir morador

```
DELETE: http://localhost:8080/villager?id=ID DO USUÁRIO
```


[⬆ Voltar ao topo](#VilaDevInHouse)<br>
