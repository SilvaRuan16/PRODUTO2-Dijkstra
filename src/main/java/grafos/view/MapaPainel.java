package grafos.view;

import grafos.model.Capital;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MapaPainel extends JPanel {
    private final ImageIcon icon;
    private final List<Capital> capitais;
    private List<Integer> caminhoAtual;

    public MapaPainel(List<Capital> capitais) {
        this.capitais = capitais;
        this.icon = new ImageIcon(getClass().getResource("../images/mapa_do_brasil.jpeg"));
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.err.println("Erro ao carregar a imagem!");
        }
    }

    public void setCaminhoAtual(List<Integer> caminhoAtual) {
        this.caminhoAtual = caminhoAtual;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        desenharMapa(g2d);
        desenharCapitais(g2d);
        if (caminhoAtual != null && caminhoAtual.size() > 1) {
            desenharCaminho(g2d);
        }
    }

    private void desenharMapa(Graphics2D g2d) {
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image img = icon.getImage();
            g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        } else {
            g2d.setColor(Color.RED);
            g2d.drawString("Imagem não carregada", 10, 20);
        }
    }

    private void desenharCapitais(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        for (Capital capital : capitais) {
            Point p = capital.getCoordenada();
            int x = (int) (p.x * getWidth() / 600.0);
            int y = (int) (p.y * getHeight() / 500.0);
            g2d.fillOval(x - 5, y - 5, 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(capital.getId()), x + 8, y + 5);
            g2d.setColor(Color.WHITE);
        }
    }

    private void desenharCaminho(Graphics2D g2d) {
        g2d.setColor(new Color(0, 0, 0, 150));
        g2d.setStroke(new BasicStroke(3));
        for (int i = 0; i < caminhoAtual.size() - 1; i++) {
            Point p1 = capitais.get(caminhoAtual.get(i)).getCoordenada();
            Point p2 = capitais.get(caminhoAtual.get(i + 1)).getCoordenada();
            int x1 = (int) (p1.x * getWidth() / 600.0);
            int y1 = (int) (p1.y * getHeight() / 500.0);
            int x2 = (int) (p2.x * getWidth() / 600.0);
            int y2 = (int) (p2.y * getHeight() / 500.0);
            g2d.drawLine(x1, y1, x2, y2);
        }
    }
}