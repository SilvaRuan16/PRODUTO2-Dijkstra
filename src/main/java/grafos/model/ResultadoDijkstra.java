package grafos.model;

import java.util.List;

public class ResultadoDijkstra {
    private final List<Integer> caminho;
    private final double distanciaTotal;
    private final String descricaoCaminho;

    public ResultadoDijkstra(List<Integer> caminho, double distanciaTotal, String descricaoCaminho) {
        this.caminho = caminho;
        this.distanciaTotal = distanciaTotal;
        this.descricaoCaminho = descricaoCaminho;
    }

    public List<Integer> getCaminho() { return caminho; }
    public double getDistanciaTotal() { return distanciaTotal; }
    public String getDescricaoCaminho() { return descricaoCaminho; }
}