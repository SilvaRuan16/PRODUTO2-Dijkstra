package grafos.service;

import grafos.model.Grafo;
import grafos.model.ResultadoDijkstra;

public class CalculadoraRotaService {
    private final DijkstraService dijkstraService;
    private final Grafo grafo;

    public CalculadoraRotaService(Grafo grafo) {
        this.grafo = grafo;
        this.dijkstraService = new DijkstraService();
    }

    public ResultadoDijkstra calcularMenorRota(int origem, int destino, String[] nomesCapitais) {
        return dijkstraService.encontrarMenorCaminho(grafo, origem, destino, nomesCapitais);
    }
}