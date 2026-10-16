/*
Hundir la flota
 */
package projecte.pkgfinal;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjecteFinal {
    public static void main(String[] args) throws Exception {
        //Declaraciones
        //Variable facha para dar la fecha en el registro
        LocalDateTime fecha;
        //Variable String para almacenar la fecha en modo string
        String Fecha;
        //Variable formato para poner la fecha en el formato deseado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        //Declaración para una variable para ver si ha terminado el juego, inicializada a false
        boolean FIN_JUEGO=false;
        //Declaración para el modo de juego y el turno de quien es
        int modo, turno;
        //Declaración de variables linea para cada uno de los jugadores
        //variable linea Jugador1
        Linea Jugador1=new Linea();
        //variable linea Jugador2 (este no se usará en el modo en solitario)
        Linea Jugador2=new Linea();
        //variable registro para almacenar el registro y otra para almacenar la lectura
        Registro registro, registroLectura;
        //Variable tipo RegistroFicherosEscritura para hacer el registro
        RegistroFicherosEscritura Registro=new RegistroFicherosEscritura("Registro.txt",true);
        //Variable tipo RegistroFicherosLectura para leer el registro
        RegistroFicherosLectura LecturaRegistro=new RegistroFicherosLectura("Registro.txt");
        //Variable tipo LineaFicherosLectura para hacer el registro
        LineaFicherosLectura Lectura=new LineaFicherosLectura("Registro.txt");
        //Declaración de los tableros
        //Variable Tablero jugador 1 
        Tablero tablero1;
        //Tablero jugador 2 (Este no se usará en el modo en solitario)
        Tablero tablero2;
        
        //Acciones
        //Bucle para elegir el modo de juego y si no escribes uno existente te da otra oportunidad
        while (!FIN_JUEGO) {  
        modo=menu();
        //Switch para elegir el modo de juego
        switch(modo){
            //Modo JUGAR SOLO
            case 1: //Mensaje con el modo elegido
                    System.out.println("Modo elegido, JUGAR SOLO");
                    //Lectura del jugador 1
                    System.out.print("Quien es el Jugador1? ");
                    Jugador1.lectura();
                    //Creación del tablero con la clase tablero y los ficheros
                    tablero1=crearTableros();
                    //Bucle para disparar mientras queden barcos
                    while(tablero1.quedanBarcos()){
                        //Mensaje de quien es el turno
                        System.out.println("Es el turno de "+Jugador1);
                        //Disparo con la clase tablero
                        disparos(tablero1);
                    }
                    //Cogemos la fecha actual para registrar la partida
                    fecha = LocalDateTime.now();
                    Fecha=fecha.format(formato);
                    //Creamos el registro usando parámetros 
                    registro=new Registro(Jugador1,Fecha,tablero1.disparosHundido(),tablero1.disparosTocado(),tablero1.disparosAgua(), true);
                    //Escribimos el registo en un fichero 
                    Registro.escritura(registro,true);
                    //Decimos que ha ganado
                    System.out.println("Has ganado!");
                    //Imprimimos el tablero con todas las casillas descubiertas
                    System.out.println(tablero1.toString(false));
                    
                    break;
            //Modo UNO CONTRA UNO
            case 2: System.out.println("Modo elegido, JUGAR UNO CONTRA UNO");
                    //Lectura del jugador 1
                    System.out.print("Quien es el Jugador1? ");
                    Jugador1.lectura();
                    //Lectura del jugador 2
                    System.out.print("Quien es el Jugador2? ");
                    Jugador2.lectura();
                    //Ver quién empieza
                    System.out.print("Quien empieza? (Escribe solo el numero del jugador)");
                    turno=LT.readInt();
                    //Crear el tablero del jugador 1 y 2
                    tablero1=crearTableros();
                    tablero2=crearTableros();
                    //While para disparar
                    while(tablero1.quedanBarcos()&&tablero2.quedanBarcos()){
                        //Switch para decidir quién dispara
                        switch(turno){
                            case 1://Mensaje de quien es el turno
                                    System.out.println("Es el turno de "+Jugador1);
                                    //Mostrar tu tablero
                                    System.out.println("Este es tu tablero: ");
                                    System.out.println(tablero1.toString(false));
                                    //Disparo con la clase tablero
                                    disparos(tablero2);
                                    //Cambiar el turno
                                    turno=2;
                                    break;
                            default://Mensaje de quien es el turno
                                    System.out.println("Es el turno de "+Jugador2);
                                    //Mostrar tu tablero
                                    System.out.println("Este es tu tablero: ");
                                    System.out.println(tablero2.toString(false));
                                    //Disparo con la clase tablero
                                    disparos(tablero1);
                                    //Cambiar el turno
                                    turno=1;
                                    break;
                        }
                    }
                    if (tablero1.quedanBarcos()){
                        //Cogemos la fecha actual para registrar la partida
                        fecha = LocalDateTime.now();
                        Fecha=fecha.format(formato);
                        //Hacemos el registro usando parámetros establecidos(como la dimensión)
                        //y variables que sacamos tanto del programa como de la clase tablero
                        registro=new Registro(Jugador1,Fecha,tablero2.disparosHundido(),tablero2.disparosTocado(),tablero2.disparosAgua(),true);
                        //Escribimos el registo en un fichero 
                        Registro.escritura(registro,false);
                        //Reiniciamos la variable registro por si tenemos que volver a escribir
                        registro = new Registro(Jugador2,Fecha,tablero1.disparosHundido(),tablero1.disparosTocado(),tablero1.disparosAgua(),false);
                        //Escribimos el registo en un fichero 
                        Registro.escritura(registro,false);
                        //Decimos que ha ganado
                        System.out.println("Ha ganado "+Jugador1);
                        //Imprimimos los tableros con todas las casillas descubiertas
                        System.out.println("Tablero de "+Jugador1+": ");
                        System.out.println(tablero1.toString(false));
                        System.out.println("Tablero de "+Jugador2+": ");
                        System.out.println(tablero2.toString(false));
                        }
                    else{
                        //Cogemos la fecha actual para registrar la partida
                        fecha = LocalDateTime.now();
                        Fecha=fecha.format(formato);
                        //Hacemos el registro usando parámetros establecidos(como la dimensión)
                        //y variables que sacamos tanto del programa como de la clase tablero
                        registro=new Registro(Jugador1,Fecha,tablero2.disparosHundido(),tablero2.disparosTocado(),tablero2.disparosAgua(), false);
                        //Escribimos el registo en un fichero 
                        Registro.escritura(registro,false);
                        registro=new Registro(Jugador2,Fecha,tablero1.disparosHundido(),tablero1.disparosTocado(),tablero1.disparosAgua(), true);
                        //Escribimos el registo en un fichero 
                        Registro.escritura(registro,false);
                        //Decimos que ha ganado
                        System.out.println("Ha ganado "+Jugador2);
                        //Imprimimos los tableros con todas las casillas descubiertas
                        System.out.println("Tablero de "+Jugador1+": ");
                        System.out.println(tablero1.toString(false));
                        System.out.println("Tablero de "+Jugador2+": ");
                        System.out.println(tablero2.toString(false));
                    }
                    break;
            //Modo UNO CONTRA LA CPU
            case 3: System.out.println("Modo elegido, JUGAR UNO CONTRA LA CPU");
                    System.out.println("Lo sentimos pero aun está en proceso");
                    break;
            //Ver el registro de partidas
            case 4: //Cerramos el fichero para que se escriba el registro
                    Registro.cierre();
                    //Lectura del fichero y escritura en la consola
                    System.out.println("Estos son los registros de las partidas: ");
                    registroLectura=LecturaRegistro.lectura();
                    if (LecturaRegistro.getSolo()){
                        System.out.println(registroLectura.toStringSolo());
                    }
                    else{
                        System.out.println(registroLectura.toString());
                    }
                    //Bucle que mientras quedan lineas va leyendolas y las va mostrando en consola
                    while(LecturaRegistro.quedanRegistros()){
                        registroLectura=LecturaRegistro.lectura();
                    if (LecturaRegistro.getSolo()){
                        System.out.println(registroLectura.toStringSolo());
                    }
                    else{
                        System.out.println(registroLectura.toString());
                    }
                   }
                    //Cerramos el fichero
                    LecturaRegistro.cierre();
                    Lectura.cierre();
                    break;
            //Salir del juego
            case 5: System.out.println("Has salido");
                    Registro.cierre();
                    Lectura.cierre();
                    FIN_JUEGO=true;
                    break;
            default: System.out.println("El modo elegido no existe, vuelve a intentar-lo");
                    break;
        }            
        }
    }
    //Subprograma para ver el modo de juego que quiere el usuario
    public static int menu(){
        //Declaración para almacenar el modo de juego deseado
        int ModoDeJuego;
        //Menú
        System.out.println("               MENU             ");
        System.out.println("-----------------------------------");
        System.out.println("1. ->       JUGAR SOLO             ");
        System.out.println("2. ->  JUGAR UNO CONTRA UNO        ");
        System.out.println("3. -> JUGAR UNO CONTRA LA CPU      ");
        System.out.println("4. ->  REGISTRO DE PARTIDAS      ");
        System.out.println("5. ->          SALIR      ");
        //Mensaje usuario
            System.out.print("Escribe el numero del modo que quieres: ");
            //Lectura del modo deseado
            ModoDeJuego = LT.readInt();
        return ModoDeJuego;
    }
    //Subprograma para hacer los disparos
    public static void disparos(Tablero tablero) throws Exception{
        //Mostrar el tablero
        System.out.println("Este es el tablero rival: ");
        System.out.println(tablero.toString(true));
        //Llamar a la clase tablero para que haga el procedimiento de disparar
        tablero.Disparo();
        //Mostrar como ha quedado el tablero
        System.out.println("Asi ha quedado el tablero rival: ");
        System.out.println(tablero.toString(true));
    }
    //Subprograma para crear un tablero usando los ficheros
    public static Tablero crearTableros() throws Exception{
        //Declaración de un nuevo tablero
        Tablero tablero=new Tablero();
        //Declaración de un objeto random para la distribución de los barcos 
        Random generador=new Random();
        //Numero al azar 0-99 
        int numero = generador.nextInt(100);
        //Transformar el numero en uno de los ficheros
        String azar=String.valueOf(numero);
        String fichero=azar+".txt";
        //Llama a un procedimiento de la clase tablero para que lea el fichero al azar
        //y cree el tablero con los barcos
        tablero.leerDesdeFichero(fichero, tablero);
        return tablero;
    }
}
