/*
PROBLEMA 4
CLASE Tablero
Implementar la clase Tablero teniendo en cuenta que un objeto Tablero
viene representado por los siguientes atributos:
- dimX, dimY → atributos enteros que representan las filas y columnas de
un objeto Tablero.
- Matriz → atributo array de dimX * dimY componentes objetos Casilla.
- AGUA → atributo de clase constante de tipo carácter con el valor ‘a’ que
representa el contenido AGUA.
- BARCO → atributo de clase constante de tipo carácter con el valor ‘v’ que
representa el contenido Barco.
- TOCADO → atributo de clase constante de tipo carácter con el valor ‘t’
que representa el contenido Tocado.
- HUNDIDO → atributo de clase constante de tipo carácter con el valor ‘x’
que representa el contenido Hundido.
Los métodos para implementar en la clase Tablero son los siguientes:
1.Método constructor sin parámetros que crea un objeto Tablero con un
atributo matriz de 10x10 componentes objeto Casilla.
2. Método constructor con dos parámetros enteros que dan valor a los
atributos dimX y dimY instanciando además el atributo matriz.
3. Método inicializar que lleva a cabo la inicialización de todas las
componentes del atributo matriz con sus correspondientes valores
teniendo en cuenta que el atributo contenido de cada componente será
inicializado con el contenido AGUA.
4. Método toString con un parámetro booleano, de forma que si el
parámetro es false convertirá el objeto Tablero en un String donde los
valores caracteres de las casillas serán sustituidos por la visualización
de los colores atendiendo al siguiente criterio:
CASILLA CON VALOR ‘a’ (AGUA)→ se visualizará con el color azul.
CASILLA CON VALOR ‘v’ (BARCO) → se visualizará con el color verde.
CASILLA CON VALOR ‘t’ (TOCADO) → se visualizará con el color amarillo.
CASILLA CON VALOR ‘x’ (HUNDIDO) → se visualizará con el color rojo.
En cambio, si el parámetro dado es true el objeto Tablero será
convertido en un String donde las casillas que NO hayan sido accedidas
serán visualizadas con el color por defecto (
*/
package projecte.pkgfinal;
public class Tablero {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //declaración atributos de clase constantes de tipo char para representar los
    //diferentes contenidos que puede almacenar un objeto CASILLA
    private static final char AGUA='a',BARCO='b',TOCADO='t',HUNDIDO='x';
    //declaración atributos de objeto para reprsentar las dimensiones del
    //tablero
    private int dimX, dimY;
    //declaración atributo de objeto array bidimensional que representa al
    //tablero de componentes objeto Casilla
    private Casilla [][] matriz;

    //MÉTODOS
    //MÉTODOS CONSTRUCTORES
    public Tablero() {
        dimX=10;
        dimY=10;
        matriz=new Casilla[dimX][dimY];
        inicializar();
    }
    
    //MÉTODOS FUNCIONALES
    
    //método inicializar
    private void inicializar() {
        //ACCIONES
        //En cada posición del array 2D asigna una casilla con sus propiedades por defecto
        for (int fila=0;fila<dimX;fila++) {
            for (int columna=0;columna<dimY;columna++) {
                matriz[fila][columna]=new Casilla(fila,columna,AGUA,-1);
            }
        }  
    }
    //Método para saber si quedan barcos en un tablero
    public boolean quedanBarcos(){
        //ACCIONES
        //Bucle que va mirando en cada casilla si tiene un barco, si es así devuelve true
        for (int fila=0;fila<dimX;fila++) {
            for (int columna=0;columna<dimY;columna++) {
                if (matriz[fila][columna].getContenido()=='b'){
                return true;
                }
            }
        }  
        //Si no encuentra ningún barco devuelve false
        return false;
    }
    //Método para disparar
    public void Disparo() {
        //DECLARACIONES
        //declaración variables enteras para representar filas y columnas 
        int filaUsuario,columnaUsuario;
        
        //ACCIONES
        //Pregunta donde quiere disparar
        System.out.println("Donde quieres disparar?");
        System.out.print("FILA: ");
        filaUsuario=LT.readInt();
        System.out.print("COLUMNA: ");
        columnaUsuario=LT.readInt();
        //Switch para saber donde ha disparado(barco, agua,...)
        switch(matriz[filaUsuario-1][columnaUsuario-1].getContenido()){
                      //Caso tocado
            case 't': System.out.println("Ya habías disparado aquí");
                      break;
                      //Caso hundido
            case 'x': System.out.println("Ya habías disparado aquí");
                      break;
                      //Caso barco
                      //Cambia el contenido a tocado y el estado a visto
            case 'b': matriz[filaUsuario-1][columnaUsuario-1].setContenido('t');
                      matriz[filaUsuario-1][columnaUsuario-1].setEstado(true);
                      System.out.println("Tocado!");
                      //Mira si también se ha hundido
                      if (barcoHundido(filaUsuario - 1, columnaUsuario - 1)) {
                        System.out.println("Y hundido!");
                        }
                      break;
                      //Caso agua
                      //Cambia el contenido a agua y el estado a visto
            default:  matriz[filaUsuario-1][columnaUsuario-1].setContenido('a');
                      matriz[filaUsuario-1][columnaUsuario-1].setEstado(true);
                      System.out.println("Agua!");
                      break;
        }
    }
    //Método para ssaber los disparos que ha hecho al agua
    public int disparosAgua(){
        //Declaración int para almacenar los disparos
        int disparos=0;
        //Recorrer todo el tablero buscando disparos al agua
        for (int i = 0; i < dimX; i++) {
        for (int j = 0; j < dimY; j++) {
            Casilla casilla = matriz[i][j];
            //Si la casilla es agua y se ha disparado allí, se aumentan los disparos en 1
            if (casilla.getContenido() == 'a' && casilla.getEstado() == true) {
                disparos++;
            }
        }
    }
        return disparos;
    }
    //Método para ssaber los disparos que ha hecho a barcos tocados
    public int disparosTocado(){
        //Declaración int para almacenar los disparos
        int disparos=0;
        //Recorrer todo el tablero buscando disparos a barcos tocados
        for (int i = 0; i < dimX; i++) {
        for (int j = 0; j < dimY; j++) {
            Casilla casilla = matriz[i][j];
            //Si la casilla es tocado se aumentan los disparos en 1
            if (casilla.getContenido() == 't') {
                disparos++;
            }
        }
    }
        return disparos;
    }
    //Método para ssaber los disparos que ha hecho a barcos hundidos
    public int disparosHundido(){
        //Declaración int para almacenar los disparos
        int disparos=0;
        //Recorrer todo el tablero buscando disparos a barcos hundidos
        for (int i = 0; i < dimX; i++) {
        for (int j = 0; j < dimY; j++) {
            Casilla casilla = matriz[i][j];
            //Si la casilla es hundido se aumentan los disparos en 1
            if (casilla.getContenido() == 'x') {
                disparos++;
            }
        }
    }
        return disparos;
    }
    //Método para comprobar si un barco ha sido hundido
    private boolean barcoHundido(int fila, int columna) {
    //Declaraciones
    //Identificar el barco al que pertenece la casilla
    int idBarco = matriz[fila][columna].getIdBarco(); 
    
    //Acciones
    //Recorrer todas las casillas de la matriz para verificar el estado del barco
    for (int i = 0; i < dimX; i++) {
        for (int j = 0; j < dimY; j++) {
            Casilla casilla = matriz[i][j];
            // Si hay alguna casilla no tocada, el barco no está hundido
            if (casilla.getIdBarco() == idBarco && casilla.getContenido() == 'b') {
                return false; 
            }
        }
    }
    //Si todas las casillas del barco están tocadas, el barco está hundido
    //Recorrer todas las casillas de la matriz para cambiar las casillas del barco de 't' a 'x'
    for (int i = 0; i < dimX; i++) {
        for (int j = 0; j < dimY; j++) {
            Casilla casilla = matriz[i][j];
            if (casilla.getIdBarco() == idBarco && casilla.getContenido() == 't') {
                //Marcamos la casilla como hundida
                casilla.setContenido('x'); 
            }
        }
    }

    return true; 
}
    //Método para leer el tablero desde un fichero
public void leerDesdeFichero(String nombreFichero, Tablero tablero) throws Exception {
    //Inicializar el lector de palabras
    LineaFicherosLectura lector = new LineaFicherosLectura(nombreFichero);
    //Variables para controlar las posiciones en la matriz
    int fila = 0,columna = 0;
    //Leer palabras mientras queden en el fichero
    while (lector.quedanLineas()) {
        //Leer una fila
        Linea linea = lector.lectura();
        //Procesar cada carácter de la palabra
        for (int i = 0; i < 10; i++) {
            char caracter = linea.getCaracter(i);
            //Verificar y asignar Casilla según el carácter
            switch (caracter) {
                case '-'://Asignar agua a la casilla
                    matriz[fila][columna] = new Casilla(fila, columna, 'a',-1);
                    break;
                case '0'://Asignar barco a la casilla con su identificador
                    matriz[fila][columna] = new Casilla(fila, columna, 'b',0);
                    break;
                case '1'://Asignar barco a la casilla con su identificador
                    matriz[fila][columna] = new Casilla(fila, columna, 'b',1);
                    break;
                case '2'://Asignar barco a la casilla con su identificador
                    matriz[fila][columna] = new Casilla(fila, columna, 'b',2);
                    break;
                case '3'://Asignar barco a la casilla con su identificador
                    matriz[fila][columna] = new Casilla(fila, columna, 'b',3);
                    break;
                case '4'://Asignar barco a la casilla con su identificador
                    matriz[fila][columna] = new Casilla(fila, columna, 'b',4);
                    break;
            }

            //Incrementar columna
            columna++;
            //Aumentar fila
            if (columna >= dimY) {
                columna = 0;
                fila++;
            }
        }
    }

    //Cerrar el lector de archivo
    lector.cierre();
}
    
    //método toString
    public String toString(boolean tipo) {
        //DECLARACIONES
        //declaración variable String para almacenar el resultado de la conversión
        //a String de un objeto Tablero
        String conversion="   ";
        
        //ACCIIONES
        conversion=conversion+lineaColumnas()+lineaSeparadora()+lineasFilas(tipo);
        //devolución conversion
        return conversion;  
    }
    
    //método lineaColumnas lleva a cabo la generación de un String cuyo contenido
    //representa la linea de enumeración de las columnas de un objeto Tablero
    //con vistas a la visualización
    private String lineaColumnas() {
        String conversion="";
        for (int columna=0;columna<dimY;columna++) {
            if (columna<9) {
                conversion=conversion+" 0"+(columna+1);
            }
            else {
                conversion=conversion+" "+(columna+1);
            }
        }
        conversion=conversion+"\n   ";
        return conversion;
    }
    
    //método lineaSeparadora lleva a cabo la generación de un String cuyo contenido
    //representa una linea separadora con vistas a la visualización de un objeto
    //Tablero
    private String lineaSeparadora() {
        String conversion="";
        for (int columna=0;columna<dimY;columna++) {
            conversion=conversion+"---";
        }
        conversion=conversion+"-\n";
        return conversion;
    }
    
    //método lineasFilas genera un String con las filas correspondientes a un
    //objeto Tablero visualizando las casillas con colores en modo interno o en modo externo
    //según el valor del parámetro booleano dado
    private String lineasFilas(boolean tipo) {
        String conversion="";
        for (int fila=0;fila<dimX;fila++) {
            //concatenación del número de la fila-ésima
            if (fila<9) {
                conversion=conversion+"0"+(fila+1)+" |";
            }
            else {
                conversion=conversion+(fila+1)+" |";
            }
            //concatenación de los contenidos de la fila-ésima con los caracteres 
            //de control correspondientes a los colores con los que se visualizará 
            //las casillas del objeto Tablero de la fila-ésima
            for (int columna=0;columna<dimY;columna++) {
                int color=0;
                switch (matriz[fila][columna].getContenido()) {

                    case AGUA -> color=5;
                    case BARCO -> color=3;
                    case TOCADO -> color=4;
                    case HUNDIDO -> color=2;
                }
                if (tipo) {
                    if (matriz[fila][columna].getEstado()) {

                        conversion=conversion+LT.colorBG(color)+"  "+LT.colorBG(0)+"|";
                    }
                    else {
                        conversion=conversion+LT.colorBG(0)+"  "+LT.colorBG(0)+"|";
                    }
                }
                else {
                    conversion=conversion+LT.colorBG(color)+"  "+LT.colorBG(0)+"|";
                }

            }
            conversion=conversion+"\n   "+lineaSeparadora();
        }
        return conversion;
    }    
}
