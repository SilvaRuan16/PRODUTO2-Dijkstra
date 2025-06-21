package grafos.controller;

import grafos.model.Capital;
import grafos.model.GrafoListaAdjacencia;
import grafos.model.ResultadoDijkstra;
import grafos.service.CalculadoraRotaService;

import javax.swing.*;
import java.util.List;

public class RotaController {
    private final CalculadoraRotaService calculadora;
    private final List<Capital> capitais;

    public RotaController(List<Capital> capitais) {
        this.capitais = capitais;
        this.calculadora = new CalculadoraRotaService(criarGrafoComRotas());
    }

    private GrafoListaAdjacencia criarGrafoComRotas() {
        GrafoListaAdjacencia grafo = new GrafoListaAdjacencia(capitais.size());

        grafo.adicionarAresta(12, 1, 837);
        grafo.adicionarAresta(1, 23, 806);
        grafo.adicionarAresta(1, 16, 1130);
        grafo.adicionarAresta(14, 3, 785);
        grafo.adicionarAresta(14, 18, 901);
        grafo.adicionarAresta(18, 20, 544);

        grafo.adicionarAresta(23, 25, 446);
        grafo.adicionarAresta(25, 9, 634);
        grafo.adicionarAresta(9, 15, 534);
        grafo.adicionarAresta(9, 11, 688);
        grafo.adicionarAresta(15, 11, 185);
        grafo.adicionarAresta(11, 19, 120);
        grafo.adicionarAresta(19, 13, 117);
        grafo.adicionarAresta(13, 0, 294);
        grafo.adicionarAresta(0, 22, 356);
        grafo.adicionarAresta(22, 25, 1162);

        grafo.adicionarAresta(4, 10, 209);
        grafo.adicionarAresta(10, 16, 873);
        grafo.adicionarAresta(10, 6, 937);
        grafo.adicionarAresta(10, 5, 900);
        grafo.adicionarAresta(5, 6, 694);
        grafo.adicionarAresta(6, 18, 1457);

        grafo.adicionarAresta(2, 4, 741);
        grafo.adicionarAresta(2, 10, 906);
        grafo.adicionarAresta(2, 24, 586);
        grafo.adicionarAresta(2, 26, 524);
        grafo.adicionarAresta(2, 21, 434);
        grafo.adicionarAresta(24, 21, 429);
        grafo.adicionarAresta(24, 7, 540);
        grafo.adicionarAresta(26, 21, 521);
        grafo.adicionarAresta(22, 2, 1377);

        grafo.adicionarAresta(7, 8, 300);
        grafo.adicionarAresta(8, 17, 476);
        grafo.adicionarAresta(5, 7, 991);

        grafo.adicionarAresta(16, 25, 1112);
        grafo.adicionarAresta(22, 4, 1350);

        grafo.adicionarAresta(22, 24, 1962);

        return grafo;
    }

    public ResultadoDijkstra calcularRota(int origem, int destino, String[] nomesCapitais) {
        return calculadora.calcularMenorRota(origem, destino, nomesCapitais);
    }
}