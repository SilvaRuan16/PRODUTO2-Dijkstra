package grafos.model;

import java.util.List;

public interface Grafo {
    void adicionarAresta(int origem, int destino, double distancia);
    List<Aresta> getAdjacencias(int vertice);
    int getTotalVertices();
}