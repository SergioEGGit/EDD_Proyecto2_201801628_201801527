
//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Variables;

    import Estructuras.ListaDobleCircularConductores;
    import Estructuras.ListaAdyacencia;
    import Metodos.MetodoGlobales;

//--------------------------------------------------Principal-----------------------------------------------------------

    public class VariablesGlobales
    {
        public static ListaDobleCircularConductores ListaDobleCircularConductores = new ListaDobleCircularConductores();
        public static ListaAdyacencia ListaAdyacenciaRutas = new ListaAdyacencia();
        public static MetodoGlobales MetodoGlobales = new MetodoGlobales();
        public static String ItemsArchivo[][] = null;
        public static String NombreReporte = "";
        public static boolean GenereReporte = false;
    }
