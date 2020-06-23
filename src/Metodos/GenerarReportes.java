
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Metodos;

    import Variables.VariablesGlobales;

    import javax.swing.*;
    import java.io.*;
    import java.nio.charset.StandardCharsets;

//---------------------------------------------------Principal----------------------------------------------------------

    public class GenerarReportes
    {
        private static String TipoReporte;

        public GenerarReportes(String tipoReporte, String Cadena)
        {
            TipoReporte = tipoReporte;
            GenerarArchivoDot(Cadena);
            GenerarGrafica(Cadena);
        }

        public static synchronized void GenerarArchivoDot(String Cadena)
        {
            try
            {
                String Ruta = "C:\\GraficasE\\" + TipoReporte + ".txt";
                BufferedWriter Buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ruta), StandardCharsets.UTF_8));
                PrintWriter Print = new PrintWriter(Buffer);
                Print.write(Cadena + "\n");
                Print.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error Al Escribir El Archivo", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        public static synchronized void GenerarGrafica(String Cadena)
        {
            try
            {
                ProcessBuilder Builder;
                String FileInput = "C:\\GraficasE\\" + TipoReporte + ".txt";
                String FileOutput = "C:\\GraficasE\\" + TipoReporte + ".png";

                Builder = new ProcessBuilder("dot", "-Tpng", "-o", FileOutput, FileInput);
                Builder.redirectErrorStream(true);
                Builder.start();

                VariablesGlobales.GenereReporte = true;

                try
                {
                    Thread.sleep(10000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            catch (IOException e)
            {
                String Type = "png";
                String RepresentationType = "dot";
                String FileOutput = "";
                String FileInput = "";

                FileOutput = "C:\\GraficasE\\" + TipoReporte;
                FileInput = "C:\\GraficasE\\" + TipoReporte + ".txt";

                GraphViz GenerarGrafica = new GraphViz();
                GenerarGrafica.addln(Cadena);
                GenerarGrafica.increaseDpi();

                File Output = new File(FileOutput + "." + Type);
                GenerarGrafica.writeGraphToFile(GenerarGrafica.getGraph(GenerarGrafica.getDotSource(), Type, RepresentationType), Output);

                try
                {
                    Thread.sleep(10000);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                VariablesGlobales.NombreReporte = FileOutput + "." + Type;
            }
        }
    }
