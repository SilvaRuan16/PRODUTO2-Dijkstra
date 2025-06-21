package grafos.model;

public class Aresta {
  private final int destino;
  private final double distancia;

  public Aresta(int destino, double distancia) {
    this.destino = destino;
    this.distancia = distancia;
  }

  public int getDestino() {
    return destino;
  }

  public double getDistancia() {
    return distancia;
  }
}