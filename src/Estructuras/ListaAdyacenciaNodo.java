package Estructuras;

public class ListaAdyacenciaNodo
{

    private String Origen;
    private String Destino;
    private double TiempoRuta;
    private ListaAdyacenciaNodo Abajo;
    private ListaAdyacenciaNodo Derecha;

    //Constructor que genera el nodo a enlazar
    public ListaAdyacenciaNodo(String Origen, String Destino, double TiempoRuta)
    {
        this.Origen = Origen;
        this.Destino = Destino;
        this.TiempoRuta = TiempoRuta;
        this.Abajo=null;
        this.Derecha=null;
    }

    //Constructor que crea el origen
    public ListaAdyacenciaNodo(String origen)
    {
        Origen = origen;
        this.Destino = "";
        this.TiempoRuta = 0.0;
        this.Abajo=null;
        this.Derecha=null;
    }

    //Constructor Vacio

    public ListaAdyacenciaNodo()
    {
    }


    //Set's & Get's de parametros privados

    public String getOrigen() { return Origen; }

    public void setOrigen(String origen) { Origen = origen; }

    public String getDestino() { return Destino; }

    public void setDestino(String destino) { Destino = destino; }

    public double getTiempoRuta() { return TiempoRuta; }

    public void setTiempoRuta(double tiempoRuta) { TiempoRuta = tiempoRuta; }

    public ListaAdyacenciaNodo getAbajo() { return Abajo; }

    public void setAbajo(ListaAdyacenciaNodo abajo) { Abajo = abajo; }

    public ListaAdyacenciaNodo getDerecha() { return Derecha; }

    public void setDerecha(ListaAdyacenciaNodo derecha) { Derecha = derecha; }
}
