# Cartesian

Aplicação Java para visualização de funções matemáticas em um plano cartesiano, com interface gráfica em Swing e interpretador de expressões matemáticas.

## Visão geral

O projeto permite inserir uma expressão matemática, como `x ^ 2`, `sin(x)`, `log(x)` ou combinações mais complexas, e renderizar o gráfico correspondente em uma janela interativa.

A interface foi construída com Swing, e a lógica de cálculo da expressão é feita por um parser e um tokenizer próprios, organizados no pacote `com.project.exprInterpreter`.

## Funcionalidades

- Entrada de expressão matemática pela interface
- Representação gráfica de funções no plano cartesiano
- Eixos e escala visuais do gráfico
- Suporte ao zoom por rolagem do mouse
- Interpretação de expressões matemáticas com operações e funções
- Testes automatizados para parser e gerenciamento de tokens

## Stack

- Java 17
- Maven
- Swing
- JUnit 5

## Estrutura do projeto

```text
Cartesian/
├── .mvn/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── project/
│   │               ├── App.java
│   │               ├── Window.java
│   │               ├── components/
│   │               │   ├── Axis.java
│   │               │   ├── FuncInput.java
│   │               │   ├── Globals.java
│   │               │   ├── Graph.java
│   │               │   ├── MathFunc.java
│   │               │   └── MouseScrollListener.java
│   │               └── exprInterpreter/
│   │                   ├── calculator/
│   │                   ├── datastruct/
│   │                   ├── parser/
│   │                   └── token/
│   └── test/
│       └── java/
│           ├── ParserExprTest.java
│           ├── TimingExtension.java
│           └── TokenManagerTest.java
├── pom.xml
├── .gitignore
└── README.md
```

## Requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- JDK 17+
- Maven 3.8+

## Como executar

Na raiz do projeto, execute:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass=com.project.App
```

Se preferir gerar o pacote compilado:

```bash
mvn clean package
java -jar target/cartesiano-1.0-SNAPSHOT.jar
```

## Como rodar os testes

```bash
mvn test
```

## Exemplo de expressão

```text
x ^ 2
sin(x)
log(x)
```

## Observações

O projeto trabalha com um parser customizado para interpretar expressões matemáticas e convertê-las em uma árvore de operações, que é então avaliada em pontos do eixo X para desenhar o gráfico.

## Licença

Este projeto não especifica uma licença no `pom.xml` ou no repositório. Caso queira distribuir ou reutilizar o código, é recomendado confirmar a licença antes de publicar ou reutilizar em outro contexto.

## Contribuição

Contribuições são bem-vindas. Para propor melhorias:

1. Faça um fork do projeto
2. Crie uma branch para a funcionalidade
3. Commit e push
4. Abra um Pull Request

