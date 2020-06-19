
//--------------------------------------------Paquetes Y Importaciones--------------------------------------------------

    package Modelos;

//---------------------------------------------------Principal----------------------------------------------------------

    public class ModeloConductores
    {
        //Atributos

        private String DPI;
        private String Nombres;
        private String Apellidos;
        private String TipoLicencia;
        private String Genero;
        private int Telefono;
        private String Direccion;

     //--------------------------------------------------Constructores--------------------------------------------------

        //Constructor Vacio

        public ModeloConductores()
        {

        }

        //Constructor Nuevo Conductor

        public ModeloConductores(String DPI, String nombres, String apellidos, String tipoLicencia, String genero, int telefono, String direccion)
        {
            this.DPI = DPI;
            Nombres = nombres;
            Apellidos = apellidos;
            TipoLicencia = tipoLicencia;
            Genero = genero;
            Telefono = telefono;
            Direccion = direccion;
        }

        //Métodos
        //Gets y Sets
        public String getDPI()
        {
            return DPI;
        }

        public void setDPI(String DPI)
        {
            this.DPI = DPI;
        }

        public String getNombres()
        {
            return Nombres;
        }

        public void setNombres(String nombres)
        {
            Nombres = nombres;
        }

        public String getApellidos()
        {
            return Apellidos;
        }

        public void setApellidos(String apellidos)
        {
            Apellidos = apellidos;
        }

        public String getTipoLicencia()
        {
            return TipoLicencia;
        }

        public void setTipoLicencia(String tipoLicencia)
        {
            TipoLicencia = tipoLicencia;
        }

        public String getGenero()
        {
            return Genero;
        }

        public void setGenero(String genero)
        {
            Genero = genero;
        }

        public int getTelefono()
        {
            return Telefono;
        }

        public void setTelefono(int telefono)
        {
            Telefono = telefono;
        }

        public String getDireccion()
        {
            return Direccion;
        }

        public void setDireccion(String direccion)
        {
            Direccion = direccion;
        }

        //To String
        @Override
        public String toString()
        {
            return "ModeloConductores{" +
                    "DPI='" + DPI + '\'' +
                    ", Nombres='" + Nombres + '\'' +
                    ", Apellidos='" + Apellidos + '\'' +
                    ", TipoLicencia='" + TipoLicencia + '\'' +
                    ", Genero='" + Genero + '\'' +
                    ", Telefono=" + Telefono +
                    ", Direccion='" + Direccion + '\'' +
                    '}';
        }
    }
