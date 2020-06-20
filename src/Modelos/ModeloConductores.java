
//------------------------------------------------Paquetes E Imports----------------------------------------------------

    package Modelos;

//---------------------------------------------------Principal----------------------------------------------------------

    public class ModeloConductores
    {
        //Atributos

        private String DPIConductor;
        private String NombresConductor;
        private String ApellidosConductor;
        private String TipoLicenciaConductor;
        private String GeneroConductor;
        private int TelefonoConductor;
        private String DireccionConductor;

        //--------------------------------------------Constructores-----------------------------------------------------

        //Constructor Vacio

        public ModeloConductores()
        {

        }

        //Constructor Nuevo Conductor

        public ModeloConductores(String DPIConductor, String nombresConductor, String apellidosConductor, String tipoLicenciaConductor, String generoConductor, int telefonoConductor, String direccionConductor)
        {
            this.DPIConductor = DPIConductor;
            NombresConductor = nombresConductor;
            ApellidosConductor = apellidosConductor;
            TipoLicenciaConductor = tipoLicenciaConductor;
            GeneroConductor = generoConductor;
            TelefonoConductor = telefonoConductor;
            DireccionConductor = direccionConductor;
        }

        //Métodos

        //Get DPI Conductor

        public String getDPIConductor()
        {
            return DPIConductor;
        }

        //Set DPI Conductor

        public void setDPIConductor(String DPIConductor)
        {
            this.DPIConductor = DPIConductor;
        }

        //Get Nombres Conductor

        public String getNombresConductor()
        {
            return NombresConductor;
        }

        //Set Nombres Conductor

        public void setNombresConductor(String nombresConductor)
        {
            NombresConductor = nombresConductor;
        }

        //Get Apellidos Conductor

        public String getApellidosConductor()
        {
            return ApellidosConductor;
        }

        //Set Apellidos Conductor

        public void setApellidosConductor(String apellidosConductor)
        {
            ApellidosConductor = apellidosConductor;
        }

        //Get Tipo Licencia Conductor

        public String getTipoLicenciaConductor()
        {
            return TipoLicenciaConductor;
        }

        //Set Tipo Licencia Conductor

        public void setTipoLicenciaConductor(String tipoLicenciaConductor)
        {
            TipoLicenciaConductor = tipoLicenciaConductor;
        }
        
        //Get Genero Conductor

        public String getGeneroConductor() 
        {
            return GeneroConductor;
        }
        
        //Set Genero Conductor

        public void setGeneroConductor(String generoConductor) 
        {
            GeneroConductor = generoConductor;
        }
        
        //Get Telefono Conductor
        
        public int getTelefonoConductor() 
        {
            return TelefonoConductor;
        }

        //Set Telefono Conductor
        
        public void setTelefonoConductor(int telefonoConductor) 
        {
            TelefonoConductor = telefonoConductor;
        }
        
        //Get Direccion Conductor

        public String getDireccionConductor() 
        {
            return DireccionConductor;
        }
        
        //Set Direccion Conductor

        public void setDireccionConductor(String direccionConductor) 
        {
            DireccionConductor = direccionConductor;
        }
    }
