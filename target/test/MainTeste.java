package grafos.testes;

import grafos.componentes.Graph;
import grafos.componentes.ResultadoCaminho;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTeste {
  @Test
  public void testeCaminhoCurtoEntreCapitais() {
    Graph grafo = new Graph(27);

    // Arestas mínimas para teste
    grafo.adicionarAresta(0, 1, 10); // Aracaju -> Belém
    grafo.adicionarAresta(1, 2, 20); // Belém -> BH
    grafo.adicionarAresta(0, 2, 50); // Aracaju -> BH

    ResultadoCaminho resultado = grafo.encontrarMenorCaminhoDijkstra(0, 2);

    assertEquals(30, resultado.distanciaTotal);
    assertEquals(List.of(0, 1, 2), resultado.caminho);
  }
}
