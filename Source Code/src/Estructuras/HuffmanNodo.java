package Estructuras;

public class HuffmanNodo {

    private String Top;
    private char Caracter;
    private int Frecuencia;
    private HuffmanNodo HijoDerecha;
    private HuffmanNodo HijoIzquierda;
    private HuffmanNodo SigLista;
    private HuffmanNodo AntLista;

    public HuffmanNodo(char caracter) {
        this.Caracter = caracter;
        this.Top="";
        this.Frecuencia=1;
        this.HijoDerecha=null;
        this.HijoIzquierda=null;
        this.SigLista=null;
        this.AntLista=null;
    }
    public HuffmanNodo(int Frecuencia) {
        this.Top="";
        this.Frecuencia=Frecuencia;
        this.HijoDerecha=null;
        this.HijoIzquierda=null;
        this.SigLista=null;
        this.AntLista=null;
    }

    public char getCaracter() { return Caracter; }

    public void setCaracter(char caracter) { Caracter = caracter; }

    public int getFrecuencia() { return Frecuencia; }

    public void setFrecuencia(int frecuencia) { Frecuencia = frecuencia; }

    public HuffmanNodo getHijoDerecha() { return HijoDerecha; }

    public void setHijoDerecha(HuffmanNodo hijoDerecha) { HijoDerecha = hijoDerecha; }

    public HuffmanNodo getHijoIzquierda() { return HijoIzquierda; }

    public void setHijoIzquierda(HuffmanNodo hijoIzquierda) { HijoIzquierda = hijoIzquierda; }

    public HuffmanNodo getSigLista() { return SigLista; }

    public void setSigLista(HuffmanNodo sigLista) { SigLista = sigLista; }

    public HuffmanNodo getAntLista() { return AntLista; }

    public void setAntLista(HuffmanNodo antLista) { AntLista = antLista; }

    public String getTop() { return Top; }

    public void setTop(String top) { Top = top; }

    @Override
    public String toString() {
        return "HuffmanNodo{" +
                "Top='" + Top + "\'" +
                ", Caracter=" + Caracter +
                ", Frecuencia=" + Frecuencia +
                '}';
    }
}
