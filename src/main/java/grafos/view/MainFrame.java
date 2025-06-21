package grafos.view;

import grafos.controller.RotaController;
import grafos.model.Capital;
import grafos.model.ResultadoDijkstra;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private final RotaController controller;
    private final List<Capital> capitais;
    private final MapaPainel mapaPainel;
    private JTextField campoOrigem;
    private JTextField campoDestino;
    private JTextArea areaResultado;

    public MainFrame() {
        super("Rotas no Mapa do Brasil");
        this.capitais = inicializarCapitais();
        this.controller = new RotaController(capitais);
        this.mapaPainel = new MapaPainel(capitais);

        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
    }

    private List<Capital> inicializarCapitais() {
        List<Capital> capitais = new ArrayList<>();
        capitais.add(new Capital(1, "SE", new Point(550, 210)));
        capitais.add(new Capital(2, "PA", new Point(315, 145)));
        capitais.add(new Capital(3, "MG", new Point(440, 300)));
        capitais.add(new Capital(4, "RR", new Point(200, 60)));
        capitais.add(new Capital(5, "DF", new Point(395, 270)));
        capitais.add(new Capital(6, "MS", new Point(300, 320)));
        capitais.add(new Capital(7, "MT", new Point(270, 220)));
        capitais.add(new Capital(8, "PR", new Point(350, 380)));
        capitais.add(new Capital(9, "SC", new Point(360, 420)));
        capitais.add(new Capital(10, "CE", new Point(515, 150)));
        capitais.add(new Capital(11, "GO", new Point(360, 270)));
        capitais.add(new Capital(12, "PB", new Point(580, 170)));
        capitais.add(new Capital(13, "AP", new Point(350, 50)));
        capitais.add(new Capital(14, "AL", new Point(570, 205)));
        capitais.add(new Capital(15, "AM", new Point(160, 115)));
        capitais.add(new Capital(16, "RN", new Point(560, 150)));
        capitais.add(new Capital(17, "TO", new Point(380, 200)));
        capitais.add(new Capital(18, "RS", new Point(320, 450)));
        capitais.add(new Capital(19, "RO", new Point(180, 200)));
        capitais.add(new Capital(20, "PE", new Point(540, 185)));
        capitais.add(new Capital(21, "AC", new Point(80, 200)));
        capitais.add(new Capital(22, "RJ", new Point(460, 360)));
        capitais.add(new Capital(23, "BA", new Point(480, 240)));
        capitais.add(new Capital(24, "MA", new Point(420, 130)));
        capitais.add(new Capital(25, "SP", new Point(380, 360)));
        capitais.add(new Capital(26, "PI", new Point(485, 170)));
        capitais.add(new Capital(27, "ES", new Point(495, 320)));
        return capitais;
    }

    private void inicializarComponentes() {
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelPrincipal.add(criarPainelEntrada(), BorderLayout.WEST);
        painelPrincipal.add(criarPainelListaCapitais(), BorderLayout.EAST);
        painelPrincipal.add(criarPainelCentral(), BorderLayout.CENTER);

        add(painelPrincipal);
    }

    private JPanel criarPainelEntrada() {
        JPanel painelEntrada = new JPanel(new GridBagLayout());
        painelEntrada.setBorder(BorderFactory.createTitledBorder("Configuração da Rota"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelOrigem = new JLabel("Origem (número):");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelEntrada.add(labelOrigem, gbc);

        campoOrigem = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        painelEntrada.add(campoOrigem, gbc);

        JLabel labelDestino = new JLabel("Destino (número):");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelEntrada.add(labelDestino, gbc);

        campoDestino = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        painelEntrada.add(campoDestino, gbc);

        JButton btnCalcular = new JButton("Calcular Menor Rota");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        painelEntrada.add(btnCalcular, gbc);

        btnCalcular.addActionListener(e -> calcularRota());

        return painelEntrada;
    }

    private void calcularRota() {
        try {
            int origem = Integer.parseInt(campoOrigem.getText()) - 1;
            int destino = Integer.parseInt(campoDestino.getText()) - 1;

            if (origem < 0 || origem >= capitais.size() || destino < 0 || destino >= capitais.size()) {
                areaResultado.setText("Por favor, insira números entre 1 e " + capitais.size());
                mapaPainel.setCaminhoAtual(null);
                return;
            }

            String[] nomesCapitais = capitais.stream()
                    .map(c -> c.getId() + ": " + c.getSigla())
                    .toArray(String[]::new);

            ResultadoDijkstra resultado = controller.calcularRota(origem, destino, nomesCapitais);
            areaResultado.setText(resultado.getDescricaoCaminho());
            mapaPainel.setCaminhoAtual(resultado.getCaminho());

        } catch (NumberFormatException ex) {
            areaResultado.setText("Por favor, insira números válidos");
            mapaPainel.setCaminhoAtual(null);
        }
    }

    private JScrollPane criarPainelListaCapitais() {
        JPanel painelLista = new JPanel();
        painelLista.setLayout(new BoxLayout(painelLista, BoxLayout.Y_AXIS));
        painelLista.setBorder(BorderFactory.createTitledBorder("Capitais"));

        for (Capital capital : capitais) {
            JLabel labelCapital = new JLabel(capital.getId() + ": " + capital.getSigla());
            labelCapital.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            painelLista.add(labelCapital);
        }

        JScrollPane scroll = new JScrollPane(painelLista);
        scroll.setPreferredSize(new Dimension(150, 600));
        return scroll;
    }

    private JPanel criarPainelCentral() {
        JPanel painelCentral = new JPanel(new BorderLayout(10, 10));

        mapaPainel.setPreferredSize(new Dimension(600, 500));
        mapaPainel.setBorder(BorderFactory.createTitledBorder("Mapa do Brasil"));
        painelCentral.add(mapaPainel, BorderLayout.CENTER);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
        areaResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));

        JScrollPane scrollResultado = new JScrollPane(areaResultado);
        scrollResultado.setPreferredSize(new Dimension(600, 100));
        painelCentral.add(scrollResultado, BorderLayout.SOUTH);

        return painelCentral;
    }
}