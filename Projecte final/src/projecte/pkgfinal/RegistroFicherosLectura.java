/*
Clase RegistroFicherosLectrura para leer registros en un fichero
 */
package projecte.pkgfinal;

import java.io.BufferedReader;
import java.io.FileReader;

public class RegistroFicherosLectura {
    //DECLARACIONES
    //Declaración atributo de clase constante entero que representa el final de
    //un fichero
    private static final int FINAL_FICHERO=-1;
    //declaración atributo de objclaseeto constante entero que representa el código
    //del caracter de control RETURN
    private static final int RETURN=(int) '\r';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final int SALTO_LINEA=(int) '\n';
    //declaración atributo de clase constante entero que representa el código
    //del caracter que separa los campos en el registro
    private static final int separador=(int) '#';
    //declaración atributo de clase variable entero que represente el código
    //de caracter leido desde el fichero
    private int codigo;
    //Boolean para saber si la partida es solitaria
    boolean solo;
    //declaración atributo de objeto BufferedReader que posibilite el enlace
    //con el fichero de texto a nivel de lectura
    private BufferedReader fichero=null;
    
    //MÉTODOS
    
    //Métodos Constructores
    public RegistroFicherosLectura(String nombre) throws Exception {
        //establecimiento del enlace lógico con el fichero físico
        fichero=new BufferedReader(new FileReader(nombre));
    }
    //Métodos Funcionales
    
    //método que verifica si hay registros por leer en un fichero de texto dado
    public boolean quedanRegistros() throws Exception {
        //lectura código de caracter desde el fichero
        codigo=fichero.read();
        return (codigo!=FINAL_FICHERO); 
    }
    //método que lleva a cabo la lectura de un objeto Linea desde un fichero de texto
    public Registro lectura() throws Exception {
        Registro registro;
        String fecha;
        Linea nombre;
        int hundido, tocado, agua;
        boolean ganado;
        // Leer hasta que se encuentre un número(la fecha) o el final del fichero
        while ((codigo != FINAL_FICHERO) && ((codigo < '0') || (codigo > '9')))  {
            codigo = fichero.read();
        }
        if (codigo!=FINAL_FICHERO){
        fecha=sacarFecha();
        nombre=sacarNombre();
        esSolo();
        saltarCampos();
        hundido=sacarHundido();
        tocado=sacarTocado();
        agua=sacarAgua();
        ganado=sacarGanado();
        registro=new Registro(nombre, fecha, hundido, tocado, agua, ganado);
        return registro;
        }
        return null;
    }
    //Metodo que lee el nombre en un registro
    private Linea sacarNombre()throws Exception {
        Linea linea=new Linea();
        if (codigo == 0) {
        codigo = fichero.read();
    }
        while ((codigo!=FINAL_FICHERO)&&(codigo!=RETURN)&&(codigo!=SALTO_LINEA)&&(codigo!=separador)) {
            //añadir elcaracter correspondiente al código leido al objeto Linea
            linea.putCaracter(codigo);
            //lectura siguiente código de caracter desde el fichero de texto
            codigo=fichero.read();
        }
        if ((codigo==RETURN)||(codigo==separador)){
            //lectura caracter de control SALTO DE LINEA que viene después del
            //caracter RETURN
            codigo=fichero.read();
        }   
        return linea;
    }
    //Metodo que lee la fecha en un registro
    private String sacarFecha()throws Exception {
        Linea linea=new Linea();
        if (codigo == 0) {
        codigo = fichero.read();
    }
        while ((codigo!=FINAL_FICHERO)&&(codigo!=RETURN)&&(codigo!=SALTO_LINEA)&&(codigo!=separador)) {
            //añadir elcaracter correspondiente al código leido al objeto Linea
            linea.putCaracter(codigo);
            //lectura siguiente código de caracter desde el fichero de texto
            codigo=fichero.read();
        }
        if ((codigo==RETURN)||(codigo==separador)){
            //lectura caracter de control SALTO DE LINEA que viene después del
            //caracter RETURN
            codigo=fichero.read();
        }   
        return linea.toString();
    }
    //Metodo que lee los hundidos en un registro
private int sacarHundido() throws Exception {
    return leerNumero();
}
//Metodo que lee los tocados en un registro
private int sacarTocado() throws Exception {
    return leerNumero();
}
//Metodo que lee los aguas en un registro
private int sacarAgua() throws Exception {
    return leerNumero();
}
//Metodo para leer un numero
private int leerNumero() throws Exception {
    int numero = 0;
    // Leer hasta que se encuentre un número
    while ((codigo < '0') || (codigo > '9')) {
        codigo = fichero.read();
    }
    // Leer el número completo
    while ((codigo >= '0') && (codigo <= '9')) {
        numero = numero * 10 + (codigo - '0');
        codigo = fichero.read();
    }
    // Si encuentra un separador o salto de línea, avanzamos
    if ((codigo == RETURN) || (codigo == separador)) {
        codigo = fichero.read();
    }
    return numero;
}
    //Metodo que lee si ha ganado en un registro
    private boolean sacarGanado()throws Exception {
        if (codigo == 0) {
        codigo = fichero.read();
    }
        while ((codigo!=FINAL_FICHERO)&&(codigo!=RETURN)&&(codigo!=SALTO_LINEA)) {
            if (codigo=='g'){
                while(codigo!='.'){
                    codigo = fichero.read();
                }
                //Leemos el punto y el return
                codigo=fichero.read();
                codigo=fichero.read();
                return true;
            }
            else{
                while(codigo!='.'){
                    codigo = fichero.read();
                }
                //Leemos el punto y el return
                codigo=fichero.read();
                codigo=fichero.read();
                return false;
            }
        }
        return false;
    }
    ////Metodo que salta los campos fijos en un registro
    private void saltarCampos()throws Exception {
        Linea linea=new Linea();
        int x=0;
        while(x!=3){
        while ((codigo!=FINAL_FICHERO)&&(codigo!=RETURN)&&(codigo!=SALTO_LINEA)&&(codigo!=separador)) {
            //añadir elcaracter correspondiente al código leido al objeto Linea
            linea.putCaracter(codigo);
            //lectura siguiente código de caracter desde el fichero de texto
            codigo=fichero.read();
        }
        if ((codigo==RETURN)||(codigo==separador)){
            //lectura caracter de control SALTO DE LINEA que viene después del
            //caracter RETURN
            codigo=fichero.read();
        }
        x++;
        }
        
    }
    //método para saber si es solo
    private void esSolo()throws Exception{
        if (codigo=='S'){
            solo=true;
        }
        else{
            solo=false;
        }
    }
    //metodo para ver si es en solitario
    public boolean getSolo(){
        return solo;
    }
    //método que lleva a cabo el cierre del enlace lógico con el fichero de texto
    public void cierre() throws Exception {
            fichero.close();
    }
}
