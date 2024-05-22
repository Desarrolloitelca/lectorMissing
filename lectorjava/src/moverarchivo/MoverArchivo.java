
package moverarchivo;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoverArchivo {

    public void MoverArchivoTemp() {
        Path origen = Path.of("D:\\Desarrollos telefonia\\CDR\\Originales");
        Path destino = Path.of("D:\\Desarrollos telefonia\\CDR\\Temp");
        File rutaoriginal = new File("D:\\Desarrollos telefonia\\CDR\\Originales");

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }

        };

        try {

            String lista[] = rutaoriginal.list(filter);
            for (int i = 0; i < lista.length; i++) {
                String ruta = "D:\\Desarrollos telefonia\\CDR\\Originales\\";
                Path origenes = Path.of(ruta, lista[i]);

                // mueve los archivos
                Path mover = Files.move(origenes, destino.resolve(origenes.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("archivo a mover: " + origenes);

            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
