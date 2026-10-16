/*
PROBLEMA 3
CLASE Casilla
Implementar la clase Casilla teniendo en cuenta que un objeto Casilla
viene representado por los siguientes atributos:
- fila, columna → atributos enteros que representan las coordenadas de
un objeto casilla dentro de un tablero.
- Contenido → atributo carácter que puede tomar uno de los siguientes
valores:
o ‘a’→ el contenido de la casilla es AGUA.
o ‘b’→ el contenido de la casilla es BARCO.
o ‘t’→ el contenido de la casilla es TOCADO.
o ‘x’→ el contenido de la casilla es HUNDIDO.
- Estado → atributo booleano que representa si una casilla ya ha sido
accedida (valor true) o no (valor false).
Los métodos para implementar en la clase Casilla son los siguientes:
1. Un método constructor con tres parámetros, dos enteros que dan
valores a los atributos fila y columna del objeto Array2D, y el tercero
para inicializar el atributo contenido, y por último el atributo estado a
false indicando que dicha casilla no ha sido accedida.
2. Los métodos get’s y set’s de los atributos.
3. Un método selección que ponga a true el atributo estado de un objeto
Casilla.
*/
package projecte.pkgfinal;

public class Casilla {
    //DECLARACIÓN ATRIBUTOS DE LA CLASE
    //declaración atributos de objetos para almacenar la fila, la columna y el
    //identificador de un objeto Casilla
    private int fila, columna,idBarco;
    //declaración atributo de objeto para almacenar el contenido caracter de un
    //objeto Casilla
    private char contenido;
    //declaración atributo de objeto para almacenar el estado de un objeto casilla
    //false --> no visitada - true visitada
    private boolean estado;
    
    
    //MÉTODOS
    //MÉTODOS CONSTRUCTORES
    public Casilla(int dato1, int dato2, char dato3,int dato4) {
        fila=dato1;
        columna=dato2;
        contenido=dato3;
        idBarco = dato4;
        estado=false;
    }
    
    //MÉTODOS FUNCIONALES
    //método que posibilita asignar un caracter como contenido a una casilla
    public void setContenido(char dato) {
        contenido=dato;
    }
    
    //método que posibilita acceder al contenido de un objeto Casilla
    public char getContenido() {
        return contenido;
    }
    
    //método que posibilita acceder a la fila de un objeto Casilla
    public int getFila() {
        return fila;
    }
    
    //método que posibilita acceder a la columna de un objeto Casilla
    public int getColumna() {
        return columna;
    }
    
    //método que posibilita acceder al estado de un objeto Casilla
    public boolean getEstado() {
        return estado;
    }
    
    //método que pòsibilita modificar el estado de un objeto Casilla
    public void setEstado(boolean dato) {
        estado=dato;
    }
    
    //método que posibilita cambiar el estado de un objeto Casilla para que
    //la identifique como casilla que ha sido accedida
    public void seleccion() {
        estado=true;
    }
     //Método para obtener el ID del barco
    public int getIdBarco() {
        return idBarco;
    }

    //Método para establecer el ID del barco
    public void setIdBarco(int id) {
        idBarco = id;
    }
    
}
