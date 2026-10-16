/*
Clase registor para leer y escribir los registros de las partidas
 */
package projecte.pkgfinal;
public class Registro {
    //Atributo string para recibir la fecha
    private String Fecha;
    //Atributo linea para el jugador
    private Linea Jugador;
    //Atributos int para los distintos disparos
    private int Hundidos, Tocados, Agua;
    boolean ganado;
    
    
    //MÉTODOS
    
    //Métodos Constructores
    //Constructor vacío
    public Registro(){
        
    }
    //Constructor con parametros
    public Registro(Linea jug, String fecha, int hun, int toc, int agua, boolean gan){
        Jugador=jug;
        Fecha=fecha;
        Hundidos=hun;
        Tocados=toc;
        Agua=agua;
        ganado=gan;
    }
    
    //Métodos funcionales
    //método que lleva a cabo la conversión de un objeto Registro a String para su
    //visualización en pantalla en una partida en solitario
    public String toStringSolo(){
        String salida=Fecha+"#"+Jugador+"#Solo#10x10#5-4-3-3-2#Hundidos "+Hundidos+"#Tocados "+Tocados+"#Agua "+Agua+"#Ha ganado.";
        return salida;        
    }
    //método que lleva a cabo la conversión de un objeto Registro a String para su
    //visualización en pantalla en una partida en uno contra uno
    public String toString(){
        String salida;
        if (ganado==true){
           salida=Fecha+"#"+Jugador+"#1contra1#10x10#5-4-3-3-2#Hundidos "+Hundidos+"#Tocados "+Tocados+"#Agua "+Agua+"#Ha ganado.";
        }
        else{
           salida=Fecha+"#"+Jugador+"#1contra1#10x10#5-4-3-3-2#Hundidos "+Hundidos+"#Tocados "+Tocados+"#Agua "+Agua+"#Ha perdido.";
        }
        return salida;
    }
}
