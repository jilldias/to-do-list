<div align="justify">

# To-do List

A documentação da API irá reunir tanto os documentos técnicos da API quanto os resumos dos aprendizados teóricos, a fim de demonstrar a teoria e aplicação do conhecimento. O processo será incremental até a finalização do projeto.

# Arquitetura da API

## MVC

MVC é o acrônimo de Model-View-Controller, uma arquitetura que divide o projeto em camadas, em que cada uma executa o que lhe é definido.

Esse padrão pode ser usado em sistemas web, desktop e mobile, devido à sua flexibilidade e à possibilidade de reúso das classes. Em um projeto, cada camada tem a sua responsabilidade:

- **View:** camada de apresentação, coleta dados de entrada do usuário e exibe dados do Model.
- **Controller:** é como se fosse uma ponte entre a View e o Model. Essa camada recebe as requisições através da View, processa as entradas, aciona o Model quando necessário e define qual resposta da View deve ser exibida.
- **Model:** camada de aplicação das regras de negócio e que faz a comunicação com o banco de dados.

O diagrama abaixo exemplifica as regras de comunicação entre as camadas:

```text
USUÁRIO
   |
   v
+---------+
|  VIEW   |
+---------+
   |
   | Requisição HTTP - GET/POST/PUT/DELETE
   v
+------------+
| CONTROLLER |
+------------+
   |
   | Processa solicitação
   v
+---------+
|  MODEL  |
+---------+
   |
   | Retorna dados
   v
+------------+
| CONTROLLER |
+------------+
   |
   | Envia resposta HTTP - XML/JSON/HTML
   v
+---------+
|  VIEW   |
+---------+
   |
   v
USUÁRIO
```

No MVC, a manutenção do sistema é muito mais fácil. As alterações na View não afetam as regras de negócio implementadas na camada Model, e há outros benefícios na sua implementação. Fica a critério da equipe usar a arquitetura MVC de acordo com seu contexto.

## REST

REST é o acrônimo de Representational State Transfer, um estilo arquitetural de sistemas que define seis restrições principais, as quais devem ser respeitadas para que uma aplicação seja considerada RESTful, sendo:

- **Client-Server:** o cliente inicia a comunicação enviando requisições ao servidor. O servidor processa as requisições e devolve as respostas.
- **Stateless:** o servidor não armazena o estado da sessão do cliente entre requisições. Cada requisição deve conter todas as informações necessárias para ser compreendida e processada independentemente das anteriores.
- **Cacheable:** as respostas devem indicar explicitamente se podem ou não ser armazenadas em cache pelo cliente ou por intermediários. Isso reduz o tráfego na rede e melhora o desempenho, evitando consultas desnecessárias ao servidor.
- **Layered System:** o sistema pode ser desenvolvido em camadas, permitindo a existência de intermediários entre o cliente e o servidor final. O cliente não precisa saber se está se comunicando diretamente com o servidor ou com uma camada intermediária, como um proxy ou gateway.
- **Uniform Interface:** princípio que padroniza a comunicação entre cliente e servidor por meio de quatro sub-restrições, sendo: identificação dos recursos, manipulação de recursos por meio de representações, mensagens autodescritivas e HATEOAS (Hypermedia as the Engine of Application State).
- **Code on Demand:** o cliente pode receber um trecho de código executável do servidor e executá-lo localmente. Essa restrição é opcional dentro do REST.

Na arquitetura REST, os recursos são identificados por URIs (Uniform Resource Identifiers). As operações sobre esses recursos são realizadas por meio de representações e métodos HTTP, como GET, POST, PUT, PATCH e DELETE. Os códigos de status HTTP indicam o resultado do processamento das requisições. A interface uniforme estabelece um padrão de comunicação entre cliente e servidor, tornando a arquitetura mais independente e facilitando a integração entre diferentes sistemas.

## API

Uma API (Application Programming Interface) é uma interface que permite que diferentes aplicações ou componentes de um software se comuniquem. Uma API pode ser desenvolvida em várias linguagens de programação.

Então, uma API REST, que é a que estarei desenvolvendo nesse projeto, é uma interface que segue as restrições do estilo arquitetural REST e utiliza, geralmente, o protocolo HTTP para disponibilizar recursos e operações. O MVC e o REST não precisam coexistir em uma aplicação, mas nesse projeto farei o uso da arquitetura MVC, pois minha to-do-list será um monolito leve, para aprender e fixar os conceitos de desenvolvimento back-end.

</div>