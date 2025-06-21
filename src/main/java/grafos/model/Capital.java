package grafos.model;

import java.awt.Point;

public class Capital {
  private Integer id;
  private String sigla;
  private Point coordenada;

  public Capital(Integer id, String sigla, Point coordenada) {
    this.id = id;
    this.sigla = sigla;
    this.coordenada = coordenada;
  }

  public Capital() {}

  public Integer getId() { return id; }
  public String getSigla() { return sigla; }
  public Point getCoordenada() { return coordenada; }

}
