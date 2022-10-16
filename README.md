# rotatematrix

Aplicação que efetuta a rotação dos dados de uma matriz quadrada da esquerda para a direita.

O resultado esperado é reproduzido para matrizes quadradas pequenas e grandes, constituidas por diferentes números de colunas e linhas.

----------------------------------------------------------------------------------------------------------------------------------------------
## Começando

Para executar a aplicação, será necessário instalar os seguintes programas:

- [JDK 11: Necessário para executar o projeto Java](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3.8.6: Necessário para realizar o build do projeto Java](https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.8.6/)

----------------------------------------------------------------------------------------------------------------------------------------------

## Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub em um diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/condessalovelace/mavenquickstart
```
----------------------------------------------------------------------------------------------------------------------------------------------

## Construção

Para inicializar a aplicação, executar o comando abaixo:

```shell
mvn spring-boot:run
```
----------------------------------------------------------------------------------------------------------------------------------------------

## Testes
Durante o desenvolvimento foram criados testes unitários, com o intuito de validar o resultado esperado.

Também foram realizados testes de casos de erro, para validação de suas tratativas.

Para a execução dos testes da aplicação, executar o comando abaixo:

```shell
mvn test
```
----------------------------------------------------------------------------------------------------------------------------------------------

## Testes utilizando Swagger

É possível efetuar testes da aplicação via Swagger.

Para isso, após o build da aplicação em sua máquina, acessar a url:

http://localhost:8080/swagger-ui/index.html
