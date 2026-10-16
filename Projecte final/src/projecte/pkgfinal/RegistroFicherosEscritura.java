/*
Clase RegistroFicherosEscritura para escribir registros en un fichero
 */
package projecte.pkgfinal;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class RegistroFicherosEscritura {
    // Declaración de atributos
    private BufferedWriter fichero = null;
    private static final int RETURN = (int) '\r';
    private static final int SALTO_LINEA = (int) '\n';
    
    // Constructores
    public RegistroFicherosEscritura(String nombre) throws Exception {
        fichero = new BufferedWriter(new FileWriter(nombre));
    }
    
    public RegistroFicherosEscritura(String nombre, boolean adicion) throws Exception {
        fichero = new BufferedWriter(new FileWriter(nombre, adicion));
    }
    
    // Método para escribir un objeto Registro en un fichero
    public void escritura(Registro registro,  boolean esSolo) throws Exception {
        if (esSolo) {
            fichero.write(registro.toStringSolo());
        } 
        else {
            fichero.write(registro.toString());
        }
        escrituraSaltoDeLinea();
    }
    
    // Método para escribir un salto de línea en el fichero
    public void escrituraSaltoDeLinea() throws Exception {
        fichero.write(RETURN);
        fichero.write(SALTO_LINEA);
    }
    
    // Método para cerrar el fichero
    public void cierre() throws Exception {
        fichero.close();
    }
}

