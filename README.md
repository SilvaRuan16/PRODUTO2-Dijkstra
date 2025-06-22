# Documentação de Requisitos: Sistema de Cálculo da Menor Distância entre Capitais Brasileiras

## 1. Escopo do Projeto
O sistema deve implementar um algoritmo em Java que utilize grafos e o algoritmo de Dijkstra para calcular o caminho mais curto entre duas capitais brasileiras, com base em distâncias reais ou estimadas. O sistema deve oferecer uma interface para entrada de dados e exibição de resultados, incluindo uma representação visual do mapa do Brasil com a rota destacada.

## 2. Requisitos Funcionais
### RF01: Construção do Grafo
O sistema deve construir um grafo representando as 27 capitais brasileiras como vértices e suas conexões como arestas ponderadas. A distância entre as capitais devem ser reais ou próximas com uma margem minima de erros.

### RF02: Cálculo do Menor Caminho
O sistema deve calcular a menor distância entre duas capitais selecionadas usando o algoritmo de Dijkstra. O usuário deve fornecer os dados necessários para a operação. O algoritmo deve retornar o caminho correto e a soma das distâncias.

### RF03: Interface do Usuário
O sistema deve permitir a entrada de capitais e exibir resultados de forma intuitiva. A interface gráfica deve possuir uma lista de opções para o usuário selecionar, campos para informar os dados, um painel para mostrar o percurso e o calculo da distancia e por último o sistema deve mostrar um mapa do Brasil com as capitais de origem e destino destacadas.

## 4. Especificações Técnicas
### Tecnologias

Linguagem: Java (JDK 8 ou superior).
Estrutura de Dados:
Grafo implementado como lista de adjacência ou matriz de adjacência.
Algoritmo: Dijkstra, com otimização para grafos ponderados não negativos.
Interface:
Console (obrigatório).
Interface gráfica usando Swing ou JavaFX.
Readme.md
O sistema de calculo de rotas foi feito em maior parte atraves do liveshare.
