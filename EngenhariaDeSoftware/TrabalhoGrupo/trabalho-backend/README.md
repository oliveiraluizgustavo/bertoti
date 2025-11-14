
## Trabalho Backend em Grupo 

### Integrantes:

- Flavio Pereira
- Cauã Mohor 
- Lucas Castro
- Luiz Gustavo Oliveira
- Richard Rangel

Este projeto usa Quarkus, o Framework Java Supersônico Subatômico. Se você quiser aprender mais sobre o Quarkus, por favor, visite seu site: https://quarkus.io/.

Rodando a aplicação em modo de desenvolvimento
Você pode rodar sua aplicação em modo de desenvolvimento (dev mode), que habilita a codificação ao vivo (live coding), usando:


./mvnw quarkus:dev
NOTA: O Quarkus agora vem com uma UI de Desenvolvimento (Dev UI), que está disponível apenas no modo de desenvolvimento em http://localhost:8080/q/dev/.

### Empacotando e rodando a aplicação
A aplicação pode ser empacotada usando:


./mvnw package
Isso produz o arquivo quarkus-run.jar no diretório target/quarkus-app/. Esteja ciente de que não é um über-jar (jar único), pois as dependências são copiadas para o diretório target/quarkus-app/lib/. A aplicação agora pode ser executada usando java -jar target/quarkus-app/quarkus-run.jar.

### Se você quiser construir um über-jar, execute o seguinte comando:

./mvnw package -Dquarkus.package.jar.type=uber-jar
A aplicação, empacotada como um über-jar, agora pode ser executada usando java -jar target/*-runner.jar.

### Criando um executável nativo
#### Você pode criar um executável nativo usando:


./mvnw package -Dnative
Ou, se você não tiver o GraalVM instalado, pode rodar a compilação do executável nativo em um contêiner usando:


./mvnw package -Dnative -Dquarkus.native.container-build=true
Você pode então executar seu executável nativo com: ./target/trabalho-backend-1.0.0-SNAPSHOT-runner

Se você quiser aprender mais sobre a construção de executáveis nativos, por favor, consulte https://quarkus.io/guides/maven-tooling.

Guias Relacionados
Driver JDBC - PostgreSQL (guia): Conecte-se ao banco de dados PostgreSQL via JDBC.

RESTEasy JAX-RS: Inicie facilmente seus Serviços Web RESTful.

Seção do guia relacionada...
