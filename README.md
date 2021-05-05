# Solicitacao de Compra

Projeto de Aplicação de fluxo de aprovação para compra de material de escritório, construído com back-end em Java EE, e front-end em Angular.

Cada parte da aplicação encontra-se em seus respectivos diretórios:
* back-end;
* front-end;

## Recursos necessários para execução da Aplicação

* Java JDK 11;
* Apache Maven 3.8;
* Apache Tomcat 9;
* Node.js;

## Configuração de conexão com o bando de dados
* Executar o script para criação do banco de dados, que encontra-se em `back-end/src/main/resources/META-INF/createDatabase.sql`
* Não é necessário criar nenhuma tabela. A Aplicação vai criar automaticamente, ao inicializar a primeira vez;
* No arquivo `back-end/src/main/resources/META-INF/persistence.xml`, editar o `value` das propriedades a seguir,  informando o usuário e senha de conexão do banco MySQL da máquina 
<pre>
&lt;property name="javax.persistence.jdbc.user" value="root" />
&lt;property name="javax.persistence.jdbc.password" value="pass" />
</pre>

## Build dos arquivos do servidor (back-end)
Neste ponto, o Java e o Apache Maven já devem estar instalados; 
* Acessar, via prompt de comando, o diretório com os fontes do back-end.
* Executar o comando `mvn install -DskipTests`

## Configuração do Tomcat, e Deploy do servidor (back-end)
* Abrir o arquivo `server.xml`, que se encontra na pasta `conf`, no diretório da instalação do Tomcat;
* Na tag `Connector`, do protocolo HTTP, configurar o valor ta propriedade `port` para `8081`. As demais propriedades podem ser mantidas com o valor padrão da instalação.
<pre>
&lt;Connector port="8081" protocol="HTTP/1.1"
    connectionTimeout="20000"
    URIEncoding="ISO-8859-1"		   
    redirectPort="8443" 
/>
</pre>

* Na tag `Host`, setar as propriedades `unpackWARs` e `autoDeploy` para true;
* Dentro desta tag `Host`, criar a tag `Context` conforme exemplo abaixo, onde 
`C:\back-end` representa o caminho absoluto onde e encontra o diretório do backend.
* Setar a propriedade `path` para `/purchase`. Este é o contexto do servidor.
<pre>
&lt;Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">
    
    &lt;Context crossContext="true" debug="0" 
        docBase="C:\back-end\target\back-end.war" 
        path="/purchase" 
        reloadable="false" 
        previleged="true"
    /> 
</pre>
* O diretório `\target`, bem como o arquivo `back-end.war`, são criados pelo clean install do maven;

Feito isto, o servidor já pode ser executado. Basta iniciar o serviço do Tomcat.

Ao finalizar, o servidor estará rodando em `http://localhost:8081/purchase/`

## Build dos arquivos do front-end e deploy da aplicação
Neste ponto, o Node.js e o Angular CLI já devem estar instalados;

* Acessar, via prompt de comando, o diretório com os fontes do front-end.
* Executar o comando `npm-install`;
* Ao finalizar, executar o comando `npm-start`;

Feito isto, a aplicação irá iniciar, podendo ser acessada, em `http://localhost:4200/`