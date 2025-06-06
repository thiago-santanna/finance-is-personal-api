# [Nome do Projeto] - Micro SaaS API

## Sumário

- [Sobre](#sobre)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura](#arquitetura)
- [Pré-requisitos](#pré-requisitos)
- [Como Começar](#como-começar)
    - [Clonando o Repositório](#clonando-o-repositório)
    - [Configuração do Ambiente](#configuração-do-ambiente)
- [Executando a Aplicação](#executando-a-aplicação)
- [Construindo o Projeto](#construindo-o-projeto)
- [Testando a Aplicação](#testando-a-aplicação)
- [Endpoints da API (Exemplos)](#endpoints-da-api-exemplos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Configuração Adicional](#configuração-adicional)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Sobre

`[Nome do Projeto]` é uma API de micro SaaS desenvolvida com Java e Spring Boot, seguindo os princípios da Arquitetura Limpa.
[Adicione uma breve descrição do que o micro SaaS faz, seus principais objetivos e funcionalidades.]

## Tecnologias Utilizadas

- **Java [Sua Versão do Java, ex: 17]**
- **Spring Boot [Sua Versão do Spring Boot, ex: 3.x.x]**
- **Spring MVC** (para APIs REST)
- **Spring Data JPA** (para persistência de dados)
- **[Seu Banco de Dados, ex: PostgreSQL, MySQL, H2]**
- **Maven / Gradle** (gerenciador de dependências e build)
- **JUnit 5** (para testes unitários)
- **Mockito** (para mocking em testes)
- **[Outras bibliotecas importantes, ex: Lombok, MapStruct, Spring Security, Docker]**

## Arquitetura

Este projeto adota a **Arquitetura Limpa (Clean Architecture)** para promover um design desacoplado, testável e de fácil manutenção. As principais camadas são:
- **Domain**: Contém as entidades de negócio e regras de negócio puras.
- **Application**: Orquestra os casos de uso e a lógica da aplicação.
- **Infrastructure**: Lida com detalhes externos como frameworks, banco de dados, e APIs externas.

```
├── application/                        # Camada de Aplicação (Regras de Negócio da Aplicação)
│   ├── usecase/                        # Casos de Uso (interactors)
│   │   └── impl/                       # Implementações dos Casos de Uso
│   ├── port/                           # Portas (interfaces) para comunicação entre camadas
│   │   ├── in/                         # Portas de Entrada (driven by services/use cases)
│   │   └── out/                        # Portas de Saída (driving repositories, external services)
│   └── service/                        # Serviços de aplicação (orquestradores de casos de uso, se necessário)
│
├── domain/                             # Camada de Domínio (Regras de Negócio da Empresa)
│   ├── model/                          # Entidades e Objetos de Valor (Value Objects)
│   └── exception/                      # Exceções de domínio
│
├── infrastructure/                     # Camada de Infraestrutura (Detalhes de Implementação)
│   ├── adapter/                        # Adaptadores para o mundo externo
│   │   ├── in/                         # Adaptadores de Entrada (ex: Controllers REST)
│   │   │   └── controller/
│   │   └── out/                        # Adaptadores de Saída (ex: Repositórios, Clientes HTTP)
│   │       ├── persistence/            # Persistência (ex: JPA Repositories)
│   │       │   ├── entity/             # Entidades de banco de dados (se diferentes das de domínio)
│   │       │   └── repository/         # Implementações dos Repositórios
│   │       └── client/                 # Clientes para serviços externos
│   ├── config/                         # Configurações do Spring Boot, Beans, Segurança, etc.
│   └── security/                       # Configurações específicas de segurança (se complexas)
│
└── MainApplication.java                # Classe principal do Spring Boot
```

Consulte a seção [Estrutura do Projeto](#estrutura-do-projeto) para mais detalhes sobre a organização dos pacotes.

## Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- JDK ([Sua Versão do Java, ex: 17] ou superior)
- Maven ([Sua Versão do Maven, ex: 3.8.x] ou superior) ou Gradle ([Sua Versão do Gradle, ex: 7.x] ou superior)
- [Seu Banco de Dados, ex: PostgreSQL] (se não estiver usando um banco em memória como H2 para desenvolvimento)
- [Opcional: Docker e Docker Compose, se o projeto utilizar]
- [Opcional: Sua IDE favorita, ex: IntelliJ IDEA, VS Code, Eclipse]

## Como Começar

### Clonando o Repositório

```bash
git clone https://github.com/thiago-santanna/finance-is-personal-api
cd finance-is-personal-api