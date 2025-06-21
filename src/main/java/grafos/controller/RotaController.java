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
        
        // Norte
        grafo.adicionarAresta(12, 1, 837); // AP - PA
        grafo.adicionarAresta(1, 23, 806); // PA - MA
        grafo.adicionarAresta(1, 16, 1130); // PA - TO
        grafo.adicionarAresta(14, 3, 785); // AM - RR
        grafo.adicionarAresta(14, 18, 901); // AM - RO
        grafo.adicionarAresta(18, 20, 544); // RO - AC

        // Nordeste
        grafo.adicionarAresta(23, 25, 446); // MA - PI
        grafo.adicionarAresta(25, 9, 634); // PI - CE
        grafo.adicionarAresta(9, 15, 534); // CE - RN
        grafo.adicionarAresta(9, 11, 688); // CE - PB
        grafo.adicionarAresta(15, 11, 185); // RN - PB
        grafo.adicionarAresta(11, 19, 120); // PB - PE
        grafo.adicionarAresta(19, 13, 117); // PE - AL
        grafo.adicionarAresta(13, 0, 294); // AL - SE
        grafo.adicionarAresta(0, 22, 356); // SE - BA
        grafo.adicionarAresta(22, 25, 1162); // BA - PI

        // Centro-Oeste
        grafo.adicionarAresta(4, 10, 209); // DF - GO
        grafo.adicionarAresta(10, 16, 873); // GO - TO
        grafo.adicionarAresta(10, 6, 937); // GO - MT
        grafo.adicionarAresta(10, 5, 900); // GO - MS
        grafo.adicionarAresta(5, 6, 694); // MS - MT
        grafo.adicionarAresta(6, 18, 1457); // MT - RO

        // Sudeste
        grafo.adicionarAresta(2, 4, 741); // MG - DF
        grafo.adicionarAresta(2, 10, 906); // MG - GO
        grafo.adicionarAresta(2, 24, 586); // MG - SP
        grafo.adicionarAresta(2, 26, 524); // MG - ES
        grafo.adicionarAresta(2, 21, 434); // MG - RJ
        grafo.adicionarAresta(24, 21, 429); // SP - RJ
        grafo.adicionarAresta(24, 7, 540); // SP - PR
        grafo.adicionarAresta(26, 21, 521); // ES - RJ
        grafo.adicionarAresta(22, 2, 1377); // BA - MG

        // Sul
        grafo.adicionarAresta(7, 8, 300); // PR - SC
        grafo.adicionarAresta(8, 17, 476); // SC - RS
        grafo.adicionarAresta(5, 7, 991); // MS - PR

        // Ligações Nordeste/Centro-Oeste
        grafo.adicionarAresta(16, 25, 1112); // TO - PI
        grafo.adicionarAresta(22, 4, 1350); // BA - DF

        // Ligações Nordeste/Sudeste
        grafo.adicionarAresta(22, 24, 1962); // BA - SP

        return grafo;
    }

    public ResultadoDijkstra calcularRota(int origem, int destino, String[] nomesCapitais) {
        return calculadora.calcularMenorRota(origem, destino, nomesCapitais);
    }
}