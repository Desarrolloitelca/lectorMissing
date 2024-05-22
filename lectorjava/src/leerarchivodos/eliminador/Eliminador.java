
package leerarchivodos.eliminador;

import java.io.File;
import java.io.FilenameFilter;

public class Eliminador {
      public void Eliminador(){
        FilenameFilter filter = new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
             return name.endsWith(".txt");
            }
            
        };
        try {
              File eliminador = new File("C:\\Nueva carpeta\\movidos");

            String lista[] = eliminador.list(filter);
            for (int i = 0; i < lista.length; i++) {
                File eliminadordos = new File(eliminador + "\\" + lista[i]);
                eliminadordos.delete();
                System.out.println("lista: " + eliminadordos);
        }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
          try {
              
          } catch (Exception e) {
          } finally {
              
          }
      }
}