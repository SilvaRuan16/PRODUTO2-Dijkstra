package grafos.testes;

import grafos.componentes.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GraphTeste {
  @Test
  public void testDijkstraRetornaCaminhoCorreto() {
    Graph grafo = new Graph(4);
    String[] nomesCapitais = { "A", "B", "C", "D" };

    // Arestas:
    // A(0) --10-- B(1)
    // B(1) --5-- C(2)
    // A(0) --100-- D(3)
    // C(2) --10-- D(3)
    grafo.adicionarAresta(0, 1, 10);
    grafo.adicionarAresta(1, 2, 5);
    grafo.adicionarAresta(0, 3, 100);
    grafo.adicionarAresta(2, 3, 10);

    // Caminho esperado: A(0) -> B(1) -> C(2) -> D(3)
    List<Integer> caminho = grafo.encontrarMenorCaminhoDijkstra(0, 3, nomesCapitais);

    List<Integer> esperado = List.of(0, 1, 2, 3);
    assertEquals(esperado, caminho, "O caminho retornado está incorreto.");
  }

  @Test
  public void testDijkstraSemCaminho() {
    Graph grafo = new Graph(3);
    String[] nomesCapitais = { "A", "B", "C" };

    // Apenas A(0) e B(1) estão conectados
    grafo.adicionarAresta(0, 1, 10);

    // Tentando caminho entre A(0) e C(2) (sem conexão)
    List<Integer> caminho = grafo.encontrarMenorCaminhoDijkstra(0, 2, nomesCapitais);

    assertTrue(caminho.isEmpty(), "Deveria retornar lista vazia para vértices desconectados.");
  }

  @Test
  public void testDijkstraOrigemIgualDestino() {
    Graph grafo = new Graph(2);
    String[] nomesCapitais = { "A", "B" };

    // Mesmo sem arestas, se origem == destino, caminho deve ser só ele
    List<Integer> caminho = grafo.encontrarMenorCaminhoDijkstra(1, 1, nomesCapitais);

    assertEquals(List.of(1), caminho, "Quando origem e destino são iguais, o caminho deve conter apenas esse vértice.");
  }
}
