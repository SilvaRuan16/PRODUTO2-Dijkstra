package grafos.model;

import java.util.ArrayList;
import java.util.List;

public class GrafoListaAdjacencia implements Grafo {
    private final int totalVertices;
    private final List<List<Aresta>> listaAdjacencia;

    public GrafoListaAdjacencia(int totalVertices) {
        this.totalVertices = totalVertices;
        this.listaAdjacencia = new ArrayList<>();
        for (int i = 0; i < totalVertices; i++) {
            listaAdjacencia.add(new ArrayList<>());
        }
    }

    @Override
    public void adicionarAresta(int origem, int destino, double distancia) {
        listaAdjacencia.get(origem).add(new Aresta(destino, distancia));
        listaAdjacencia.get(destino).add(new Aresta(origem, distancia));
    }

    @Override
    public List<Aresta> getAdjacencias(int vertice) {
        return listaAdjacencia.get(vertice);
    }

    @Override
    public int getTotalVertices() {
        return totalVertices;
    }
}