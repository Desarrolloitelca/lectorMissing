
package leerarchivodos;

import leerarchivodos.eliminador.Eliminador;
import moverarchivo.MoverArchivo;


public class LectorMain {
     public static void main(String[] args) {
       EliminarArchivos procesos = new EliminarArchivos();
       MoverArchivo mvrarchivo = new MoverArchivo();
       //Eliminador procesoeliminador = new Eliminador();
       
       
        procesos.ProcesarArchivos();
        mvrarchivo.MoverArchivoTemp();
        //procesoeliminador.Eliminador();
       
       
    }
}
