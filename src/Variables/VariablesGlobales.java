
//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Variables;

    import Estructuras.ArbolBAutos;
    import Estructuras.ListaDobleCircularConductores;
    import Estructuras.ListaAdyacencia;
    import Estructuras.TablaHashClientes;
    import Metodos.MetodoGlobales;

    import java.math.BigInteger;

//--------------------------------------------------Principal-----------------------------------------------------------

    public class VariablesGlobales
    {
        public static String ItemsArchivo[][] = null;
        public static String NombreReporte = "";
        public static boolean GenereReporte = false;
        public static boolean EstoyEnCargaMasiva = false;
        public static boolean EstoyEnRehashin = false;
        public static int ContadorCargaMasiva = 0;
        public static int SizeTabla = 37;
        public static int Orden_ArbolB=5;
        public static int NumeroHoja=0;
        public static ListaDobleCircularConductores ListaDobleCircularConductores = new ListaDobleCircularConductores();
        public static ListaAdyacencia ListaAdyacenciaRutas = new ListaAdyacencia();
        public static TablaHashClientes TablaHashClientes = new TablaHashClientes(SizeTabla);
        public static MetodoGlobales MetodoGlobales = new MetodoGlobales();
        public static ArbolBAutos ArbolBAutomoviles=new ArbolBAutos();
    }
