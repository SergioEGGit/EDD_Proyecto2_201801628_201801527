package Modelos;

public class ModeloVehiculo {

    private String Placa;
    private String Marca;
    private String Modelo;
    private int Anio;
    private String Color;
    private double Precio;
    private boolean TipoTransmicion;//true Mecanico false Automatico


    //Constructor de Modelo Vehiculo
    public ModeloVehiculo(String placa, String marca, String modelo, int anio, String color, double precio, boolean tipoTransmicion) {
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        Anio = anio;
        Color = color;
        Precio = precio;
        TipoTransmicion = tipoTransmicion;
    }

    //Constructor Vacio
    public ModeloVehiculo() {
    }

    //Set's & Get's

    public String getPlaca() { return Placa; }

    public void setPlaca(String placa) {Placa = placa; }

    public String getMarca() { return Marca; }

    public void setMarca(String marca) { Marca = marca; }

    public String getModelo() { return Modelo; }

    public void setModelo(String modelo) { Modelo = modelo; }

    public int getAnio() { return Anio; }

    public void setAnio(int anio) { Anio = anio; }

    public String getColor() { return Color; }

    public void setColor(String color) { Color = color; }

    public double getPrecio() { return Precio; }

    public void setPrecio(double precio) { Precio = precio; }

    public boolean isTipoTransmicion() { return TipoTransmicion; }

    public void setTipoTransmicion(boolean tipoTransmicion) { TipoTransmicion = tipoTransmicion; }

    @Override
    public String toString() {
        return "ModeloVehiculo{" +
                "Placa='" + Placa + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", Anio=" + Anio +
                ", Color='" + Color + '\'' +
                ", Precio=" + Precio +
                ", TipoTransmicion=" + TipoTransmicion +
                '}';
    }
}
