## Projeto FIAP Serverless

Projeto de avaliação da matéria Serverless da FIAP.

## Requisitos para execução local
* AWS CLI configurada.
* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Docker](https://www.docker.com/community-edition)
* [SAM CLI](https://github.com/awslabs/aws-sam-cli)
* [SAM CLI (LINUX)](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install-linux.html)
* [Python 3](https://docs.python.org/3/)

### Instalando dependências
* Utilize o `gradle wrapper` para gerar um arquivo `jar`:

```bash
./gradlew jarWithDependencies
```

* Baixe a imagem do DynamoDB via docker: 
```bash
docker run -p 8000:8000 -v $(pwd)/local/dynamodb:/data/ amazon/dynamodb-local -jar DynamoDBLocal.jar -sharedDb -dbPath /data
```

* Crie a tabela no DynamoDB: 
```bash
aws dynamodb create-table --table-name trip --attribute-definitions AttributeName=id,AttributeType=S AttributeName=date,AttributeType=S AttributeName=country,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --global-secondary-indexes 'IndexName=dateIndex,KeySchema=[{AttributeName=country,KeyType=HASH}, {AttributeName=date,KeyType=RANGE}],Projection={ProjectionType=ALL}' --billing-mode PAY_PER_REQUEST --endpoint-url http://localhost:8000

```
Caso a tabela já esteja criada, ela pode ser removida utilizando o comando: 
```bash
aws dynamodb delete-table --table-name trip --endpoint-url http://localhost:8000
```

* Utilize os arquivos de configuração para testes para iniciar o SAM localmente, substituindo 
<nome_do_so> por "linux", "mac" ou "windows" de acordo com o S.O utilizado:
```bash
sam local start-api --env-vars src/test/resources/test_environment_<nome_do_so>.json
```
* Obs: Em ambiente linux, se houver um erro de "Connection Refused" ao acessar uma das APIs, pode ser que seja necessário substituir a URL na variável ENDPOINT_OVERRIDE presente no arquivo
pelo IP do container docker em que o DynamoDB está. Para obter o IP utilize o comando `ifconfig` no terminal. 