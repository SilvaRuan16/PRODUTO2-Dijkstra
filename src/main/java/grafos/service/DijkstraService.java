package grafos.service;

import grafos.model.Aresta;
import grafos.model.Grafo;
import grafos.model.ResultadoDijkstra;

import java.util.*;

public class DijkstraService {
    public ResultadoDijkstra encontrarMenorCaminho(Grafo grafo, int origem, int destino, String[] nomesCapitais) {
        int totalVertices = grafo.getTotalVertices();
        double[] distancias = new double[totalVertices];
        int[] anteriores = new int[totalVertices];
        Arrays.fill(distancias, Double.POSITIVE_INFINITY);
        Arrays.fill(anteriores, -1);
        distancias[origem] = 0;

        PriorityQueue<Aresta> filaPrioridade = new PriorityQueue<>(
                Comparator.comparingDouble(Aresta::getDistancia));
        filaPrioridade.offer(new Aresta(origem, 0));

        while (!filaPrioridade.isEmpty()) {
            Aresta atual = filaPrioridade.poll();
            int verticeAtual = atual.getDestino();

            for (Aresta vizinho : grafo.getAdjacencias(verticeAtual)) {
                int verticeVizinho = vizinho.getDestino();
                double pesoAresta = vizinho.getDistancia();

                if (distancias[verticeAtual] + pesoAresta < distancias[verticeVizinho]) {
                    distancias[verticeVizinho] = distancias[verticeAtual] + pesoAresta;
                    anteriores[verticeVizinho] = verticeAtual;
                    filaPrioridade.offer(new Aresta(verticeVizinho, distancias[verticeVizinho]));
                }
            }
        }

        List<Integer> caminho = reconstruirCaminho(destino, anteriores);
        String descricaoCaminho = formatarDescricaoCaminho(caminho, nomesCapitais, distancias[destino]);

        return new ResultadoDijkstra(caminho, distancias[destino], descricaoCaminho);
    }

    private List<Integer> reconstruirCaminho(int destino, int[] anteriores) {
        List<Integer> caminho = new ArrayList<>();
        for (int atual = destino; atual != -1; atual = anteriores[atual]) {
            caminho.add(atual);
        }
        Collections.reverse(caminho);
        return caminho;
    }

    private String formatarDescricaoCaminho(List<Integer> caminho, String[] nomesCapitais, double distanciaTotal) {
        if (caminho.isEmpty() || distanciaTotal == Double.POSITIVE_INFINITY) {
            return "Não há caminho entre os vértices especificados";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Menor distância: ").append(String.format("%.2f", distanciaTotal)).append(" km\n");
        sb.append("Caminho: ");

        for (int i = 0; i < caminho.size(); i++) {
            sb.append(nomesCapitais[caminho.get(i)]);
            if (i < caminho.size() - 1) {
                sb.append(" -> ");
            }
        }

        return sb.toString();
    }
}