
//-------------------------------------------------Paquetes E Imports---------------------------------------------------

    package Modelos;

//------------------------------------------------------Principal-------------------------------------------------------

    public class ModeloClientes
    {
        private String DPICliente;
        private String NombresCliente;
        private String ApellidosCliente;
        private String FechaNacimentoCliente;
        private String GeneroCliente;
        private int TelefonoCliente;
        private String DireccionCliente;

        //---------------------------------------------Constructor------------------------------------------------------

        public ModeloClientes(String DPICliente, String nombresCliente, String apellidosCliente, String fechaNacimento, String generoCliente, int telefonoCliente, String direccionCliente)
        {
            this.DPICliente = DPICliente;
            NombresCliente = nombresCliente;
            ApellidosCliente = apellidosCliente;
            FechaNacimentoCliente = fechaNacimento;
            GeneroCliente = generoCliente;
            TelefonoCliente = telefonoCliente;
            DireccionCliente = direccionCliente;
        }

        //Gets And Sets Clientes

        public String getDPICliente()
        {
            return DPICliente;
        }

        public void setDPICliente(String DPICliente)
        {
            this.DPICliente = DPICliente;
        }

        public String getNombresCliente()
        {
            return NombresCliente;
        }

        public void setNombresCliente(String nombresCliente)
        {
            NombresCliente = nombresCliente;
        }

        public String getApellidosCliente()
        {
            return ApellidosCliente;
        }

        public void setApellidosCliente(String apellidosCliente)
        {
            ApellidosCliente = apellidosCliente;
        }

        public String getGeneroCliente()
        {
            return GeneroCliente;
        }

        public void setGeneroCliente(String generoCliente)
        {
            GeneroCliente = generoCliente;
        }

        public int getTelefonoCliente()
        {
            return TelefonoCliente;
        }

        public void setTelefonoCliente(int telefonoCliente)
        {
            TelefonoCliente = telefonoCliente;
        }

        public String getDireccionCliente()
        {
            return DireccionCliente;
        }

        public void setDireccionCliente(String direccionCliente)
        {
            DireccionCliente = direccionCliente;
        }

        public String getFechaNacimentoCliente()
        {
            return FechaNacimentoCliente;
        }

        public void setFechaNacimentoCliente(String fechaNacimentoCliente)
        {
            FechaNacimentoCliente = fechaNacimentoCliente;
        }
    }
