package test.controller;

import grafos.controller.RotaController;
import grafos.model.Capital;
import grafos.model.ResultadoDijkstra;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RotaControllerTest {

    private List<Capital> criarCapitaisMock() {
        List<Capital> capitais = new ArrayList<>();
        capitais.add(new Capital(0, "SE", new Point(550, 210)));
        capitais.add(new Capital(1, "PA", new Point(315, 145)));
        capitais.add(new Capital(2, "MG", new Point(440, 300)));
        capitais.add(new Capital(3, "RR", new Point(200, 60)));
        capitais.add(new Capital(4, "DF", new Point(395, 270)));
        capitais.add(new Capital(5, "MS", new Point(300, 320)));
        capitais.add(new Capital(6, "MT", new Point(270, 220)));
        capitais.add(new Capital(7, "PR", new Point(350, 380)));
        capitais.add(new Capital(8, "SC", new Point(360, 420)));
        capitais.add(new Capital(9, "CE", new Point(515, 150)));
        capitais.add(new Capital(10, "GO", new Point(360, 270)));
        capitais.add(new Capital(11, "PB", new Point(580, 170)));
        capitais.add(new Capital(12, "AP", new Point(350, 50)));
        capitais.add(new Capital(13, "AL", new Point(570, 205)));
        capitais.add(new Capital(14, "AM", new Point(160, 115)));
        capitais.add(new Capital(15, "RN", new Point(560, 150)));
        capitais.add(new Capital(16, "TO", new Point(380, 200)));
        capitais.add(new Capital(17, "RS", new Point(320, 450)));
        capitais.add(new Capital(18, "RO", new Point(180, 200)));
        capitais.add(new Capital(19, "PE", new Point(540, 185)));
        capitais.add(new Capital(20, "AC", new Point(80, 200)));
        capitais.add(new Capital(21, "RJ", new Point(460, 360)));
        capitais.add(new Capital(22, "BA", new Point(480, 240)));
        capitais.add(new Capital(23, "MA", new Point(420, 130)));
        capitais.add(new Capital(24, "SP", new Point(380, 360)));
        capitais.add(new Capital(25, "PI", new Point(485, 170)));
        capitais.add(new Capital(26, "ES", new Point(495, 320)));
        return capitais;
    }

    @Test
    @DisplayName("Deve calcular a menor rota entre as capitais corretamente")
    void testCalcularRotaValida() {
        List<Capital> capitais = criarCapitaisMock();
        RotaController controller = new RotaController(capitais);
        String[] siglas = capitais.stream().map(Capital::getSigla).toArray(String[]::new);
        ResultadoDijkstra resultado = controller.calcularRota(0, 1, siglas);

        assertNotNull(resultado);
        assertTrue(resultado.getDistanciaTotal() > 0);
        assertTrue(resultado.getCaminho().size() >= 2);
        assertTrue(resultado.getDescricaoCaminho().contains("Menor distância"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao calcular rota com índices inválidos")
    void testCalcularRotaIndicesInvalidos() {
        List<Capital> capitais = criarCapitaisMock();
        RotaController controller = new RotaController(capitais);
        String[] siglas = capitais.stream().map(Capital::getSigla).toArray(String[]::new);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            controller.calcularRota(0, 30, siglas);
        });
    }
}
