
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Metodos;

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
                try
                {
                    ProcessBuilder Builder;
                    String Dot = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
                    String FileInput = "C:\\GraficasE\\" + TipoReporte + ".txt";
                    String FileOutput = "C:\\GraficasE\\" + TipoReporte + ".png";

                    Builder = new ProcessBuilder(Dot, "-Tpng", "-o", FileOutput, FileInput);
                    Builder.redirectErrorStream(true);
                    Builder.start();

                    try
                    {
                        Thread.sleep(10000);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
                catch (IOException ioException)
                {
                    JOptionPane.showMessageDialog(null, "No Se Puede Generar El Reporte", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
