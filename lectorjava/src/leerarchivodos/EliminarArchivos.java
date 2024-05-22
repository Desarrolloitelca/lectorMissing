
package leerarchivodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;

public class EliminarArchivos {

    public void ProcesarArchivos() {
        FileReader archivo;
        BufferedReader lector;
        BufferedWriter bw;
        // se realiza la parametrizacion para la lectura de archivos .TXT
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };

        // se crea el ciclo for que va a leer la ruta especifica para ver si hay archivos txt, luego los procesa
        //File f = new File("C:\\Nueva carpeta\\Originales");
        File f = new File("D:\\Desarrollos telefonia\\CDR\\Originales");
        String[] fileList = f.list(filter);
        for (int i = 0; i < fileList.length; i++) {
            // se codifica el try para detectar algun error se fianlice con la excepción del error.
            try {
                // se pasan los parametros del archivo que se la a leer
                //archivo = new FileReader("C:\\Nueva carpeta\\Originales\\" + fileList[i]);
                archivo = new FileReader("D:\\Desarrollos telefonia\\CDR\\Originales\\" + fileList[i]);
                // se verifica si el archivo esta listo o exista
                if (archivo.ready()) {
                    // se inicia la lectura del archivo 
                    lector = new BufferedReader(archivo);
                    //bw = new BufferedWriter(new FileWriter("C:\\Nueva carpeta\\Sin Procesar\\" + fileList[i]));
                    bw = new BufferedWriter(new FileWriter("D:\\Desarrollos telefonia\\CDR\\Sin Procesar\\" + fileList[i]));
                    String linea;

                    while ((linea = lector.readLine()) != null) {

                        if (linea.contains("packet")) {

                            String cadenatexto = linea;
                            String concatenar = "";
                            String vect[] = cadenatexto.split("packet missing");

                            for (int a = 0; a < vect.length; a++) {
                                //concatenar = concatenar + vect[a];  
                                concatenar = " ";
                            }
                            //bw.write(concatenar);
                            //bw.newLine();

                        } else {
                            bw.write(linea);
                            bw.newLine();
                            bw.flush();
                        }
                    }

                } else {
                    System.out.println("El archivo no esta listo para ser leido...");
                }
                archivo.close();
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }

        }

    }
}
