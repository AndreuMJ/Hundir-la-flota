/*
Clase Linea --> aglutina las declaraciones y funcionalidades para gestionar
objetos Lineas.
Un objeto Linea estará constituido por una secuencia de caracteres delimitado por
un salto de linea. Como máximo el número de caracteres que puede conformar un
objeto Linea será de 255 caracteres.
 */
package projecte.pkgfinal;


public class Linea {
    //DECLARACIONES
    //Declaración atributo de clase constante entero que representa el final de
    //un fichero
    private static final char FINAL_LINEA='\n';
    //declaración atributo de clase constante entero que representa el máximo
    //número de caracteres que puede contener un objetoLinea
    private static final int MAXIMO=255;
    //declaración atributo de objeto variable array de caracteres que representa 
    //los caracteres de un objeto Linea 
    private char [] caracteres=new char[MAXIMO];  
    //declaración atributo de objeto variable entero que represente el número
    //de caracteres de un objeto Linea
    private int numeroCaracteres;   
    //declaración atributo de clase variable caracter que representa el último
    //caracter leido desde la secuencia de entrada por teclado
    private static char caracter;
    
    
    //MÉTODOS
    
    //Métodos Constructores
    public Linea() {
        numeroCaracteres=0;
    }
    
    //Métodos funcionales
    //método que lleva a cabo la verificación de si una objeto Linea ha sido
    //totalmente leido desde el teclado
    public static boolean quedanLineas() throws Exception {
        //lectura primer caracter de la secuencia de entrada por teclado
        caracter=LT.readChar();
        //verificar final de Linea
        return (caracter!=FINAL_LINEA);
    }
    
    //método que lleva a cabo la lectura de una Linea desde el teclado
    public void lectura() throws Exception {
        //inicialización de getNumeroCaracteres
        numeroCaracteres=0;
        while (caracter!=FINAL_LINEA) {
            //almacenar el caracter leido en el array caracteres del objeto Linea
            caracteres[numeroCaracteres]=caracter;
            //incrementar getNumeroCaracteres
            numeroCaracteres++;
            //lectura del siguiente caracter de la secuencia
            caracter=LT.readChar();    
        }
        //Reiniciar el caracter para el siguiente llamado
        if (caracter == FINAL_LINEA) {
        caracter = 0; 
    }
    }
    
    //método que lleva a cabo la conversión de un objeto Linea a String para su
    //visualización en pantalla

    @Override
    public String toString(){
        String salida="";
        for (int indice=0;indice<numeroCaracteres;indice++) {
            salida=salida+caracteres[indice];
        }
        return salida;
    }
    
    //método que devuelve el número de caracteres que conforman un objeto Linea
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    //método que lleva a cabo la obtención del caracter del objeto Linea en función
    //de la posición dada por parámetro
    public char getCaracter(int pos) {
        return caracteres[pos];
    }
    //método que lleva a cabo la adición de un caracter dado por parámetro
    //al objeto Linea
    public void putCaracter(int codigo) {
        caracteres[numeroCaracteres]=(char)codigo;
        numeroCaracteres++;
    }
    
    //método que añade caracteres de un string a la linea
     public void addCaracteres(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            caracteres[numeroCaracteres] = texto.charAt(i);
            numeroCaracteres++;
        }
    }
}