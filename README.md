# Hundir-la-flota

En el trabajo final se han usado una serie de clases para facilitar y conseguir la resolución
del juego de hundir la flota. A continuación se explicarán cada clase y sus métodos internos.
Estas clases son clases modificadas de las que nos proporcionaron desde el profesorado.
Clase línea:
La primera clase es la clase línea que está diseñada para gestionar secuencias de
caracteres como objetos para facilitar operaciones como lectura, modificación y
visualización. A continuación, se detallan los aspectos más relevantes de su
implementación.
Análisis de la Implementación
1. Declaraciones y Atributos:
○ Constantes:
■ FINAL_LINEA define el delimitador de línea (\n).
■ MAXIMO establece el tamaño máximo de caracteres en un objeto
Linea (250).
○ Atributos de objeto:
■ caracteres array de caracteres que representa los caracteres de un
objeto Linea
■ numeroCaracteres guarda la cantidad de caracteres que contiene la
línea.
○ Atributo de clase:
■ caracter se utiliza como una variable para leer caracteres de entrada.
2. Métodos Principales:
○ Constructores:
■ Se inicializa numeroCaracteres a 0 para representar una línea vacía.
○ Métodos Funcionales:
■ quedanLineas: Determina si hay más líneas por leer.
■ lectura: Realiza la lectura de caracteres desde el teclado y los
almacena en el array caracteres. Incluye un reinicio el caracter tras
alcanzar el delimitador.
■ toString: Convierte los caracteres almacenados en un objeto Linea a
una representación de cadena (String), facilitando su visualización.
■ getNumeroCaracteres: Retorna la cantidad de caracteres en la
línea.
■ getCaracter: Recupera un carácter específico según su posición en
la línea.
■ putCaracter: Añade un carácter al final de la línea.
■ addCaracteres: Permite agregar múltiples caracteres provenientes
de un String.
Clase tablero:
Esta implementación de la clase Tablero proporciona una estructura completa y funcional
para un tablero de un juego que simula el juego de hundir la flota. La clase incluye métodos
para inicializar, gestionar y visualizar el estado del tablero y las casillas que lo componen.
1. Atributos:
○ Los valores constantes para los diferentes tipos de contenido de una casilla
(AGUA, BARCO, TOCADO, HUNDIDO).
○ La matriz de casillas permite representar el estado del tablero de forma
estructurada.
○ Dos atributos de objetos que representan las dimensiones del tablero
2. Constructor:
○ Construye un tablero vacío de 10x10
3. Métodos Funcionales:
○ inicializar: Establece cada casilla como agua con un estado no accedido.
○ Disparo: Administra las acciones del jugador cuando dispara a una casilla.
Incluye mensajes de las acciones y muestra el nuevo estado del tablero.
○ Métodos contabilidad de disparos: (disparosAgua, disparosTocado,
disparosHundido): Dan estadísticas de los disparos de un jugador.
○ Comprobación de hundimiento (barcoHundido): Revisa si todas las
casillas de un barco están tocadas y, en caso afirmativo, actualiza su estado
a hundido.
4. Visualización (toString):
○ El método toString permite representar el tablero en dos modos: mostrando
todas las casillas o solo aquellas ya accedidas, con colores específicos para
cada estado.
○ Los métodos auxiliares (lineaColumnas, lineaSeparadora, lineasFilas)
estructuran la representación de manera clara y sencilla.
5. Entrada desde fichero (leerDesdeFichero):
○ Este método permite cargar un tablero desde un archivo.
Clase casilla:
La clase Casilla representa cada una de las posiciones de un tablero en el juego. Cada
casilla tiene información sobre su ubicación en el tablero, su contenido, y si ya ha sido
accedida o no.
1. Ubicación en el tablero:
○ Tiene dos números (fila y columna) que indican dónde está la casilla en el
tablero.
2. Qué hay en la casilla:
○ Un carácter (contenido) que puede ser:
■ 'a' → Agua (la casilla no tiene barco).
■ 'b' → Barco (la casilla tiene parte de un barco).
■ 't' → Tocado (la casilla tiene parte de un barco y ha sido atacada).
■ 'x' → Hundido (el barco al que pertenece la casilla está
completamente destruido).
3. Estado de la casilla:
○ Un valor booleano (estado) que indica si la casilla ya ha sido seleccionada:
■ false → No ha sido seleccionada todavía.
■ true → Ya fue seleccionada.
4. ID del barco:
○ Un número (idBarco) que identifica a qué barco pertenece esta casilla. Esto
es útil para saber si todas las casillas de un barco han sido tocadas o
hundidas.
1. Constructor (crear una casilla):
○ Cuando creas una casilla, defines:
■ Su fila y columna.
■ Su contenido inicial (por ejemplo, 'a' para agua).
■ El ID del barco (puede ser -1 si no pertenece a ningún barco).
○ Por defecto, el estado será false (no seleccionada).
Cambiar o consultar el contenido:
● Puedes usar:
○ setContenido(char dato) → Cambia el contenido de la casilla.
○ getContenido() → Obtiene el contenido actual de la casilla.
Consultar fila y columna:
● getFila() y getColumna() te dicen la posición de la casilla en el tablero.
Saber si ya fue seleccionada:
● getEstado() te dice si la casilla ya fue accedida.
● seleccion() marca la casilla como seleccionada (cambia su estado a true).
Gestionar el barco asociado:
● getIdBarco() obtiene el identificador del barco al que pertenece la casilla.
● setIdBarco(int id) permite asignar o cambiar el ID del barco.
Clase Registro
La clase Registro tiene como objetivo gestionar y almacenar los resultados de las partidas
jugadas en el juego de hundir la flota. Proporciona métodos para representar y guardar los
resultados de las partidas, tanto en solitario como en el modo de uno contra uno.
Análisis de la Implementación
Declaraciones y Atributos:
● Fecha (String): Almacena la fecha en la que se jugó la partida.
● Jugador (Linea): Representa al jugador que participó en la partida mediante un
objeto de la clase Linea.
● Hundidos (int): Guarda el número de barcos hundidos durante la partida.
● Tocados (int): Almacena el número de barcos tocados pero no hundidos.
● Agua (int): Contabiliza los disparos que no impactaron en ninguna parte del barco.
● Ganado (boolean): Un valor booleano que indica si el jugador ganó la partida o no.
Métodos Principales:
Constructores:
● Constructor vacío: Inicializa un objeto Registro sin valores predefinidos.
● Constructor con parámetros: Inicializa un objeto Registro con todos los atributos
definidos (jugador, fecha, hundidos, tocados, agua, ganado).
Métodos Funcionales:
● toStringSolo: Este método convierte los atributos del objeto Registro a una cadena
de texto, proporcionando un formato legible para representar el resultado de una
partida en solitario, siempre gana.
● toString: Este método convierte los atributos del objeto Registro a una cadena de
texto, proporcionando un formato legible para representar el resultado de una partida
en modo 1 contra 1. Dependiendo de si el jugador ganó o perdió, el mensaje será
distinto.
Clase RegistroFicherosLectura
La clase RegistroFicherosLectura tiene como objetivo leer registros desde un archivo. Se
encarga de interpretar y extraer los datos de las partidas guardadas, como el nombre del
jugador, la fecha, el número de barcos hundidos, tocados y la información sobre si ganó o
no.
Análisis de la Implementación
Declaraciones y Atributos:
● FINAL_FICHERO (int): Constante que representa el final de un fichero, utilizado
para verificar el fin de la lectura.
● RETURN (int): Constante que representa el código del carácter de control
"RETURN".
● SALTO_LINEA (int): Constante que representa el código del carácter de control
"SALTO DE LINEA".
● separador (int): Constante que representa el código del carácter que separa los
campos en un registro.
● codigo (int): Atributo de tipo entero que almacena el código del carácter leído desde
el fichero.
● solo (boolean): Booleano para saber si la partida es solitaria.
● fichero (BufferedReader): Objeto que permite la lectura del fichero de texto.
Métodos Principales:
Constructores:
● Constructor RegistroFicherosLectura(String nombre): Inicializa un objeto
RegistroFicherosLectura y establece el enlace lógico con el fichero proporcionado
mediante el uso de un BufferedReader.
Métodos Funcionales:
● quedanRegistros(): Verifica si hay más registros para leer en el fichero. Lee un
carácter y devuelve true si no se ha alcanzado el final del fichero.
● lectura(): Lee y devuelve un objeto Registro con los datos del jugador, fecha, y
estadísticas de la partida. Llama a varios métodos internos para extraer información
como el nombre, los hundidos, tocados, agua y si ganó o no.
● sacarNombre(): Lee el nombre del jugador desde el fichero, hasta encontrar un
separador o el fin de línea.
● sacarFecha(): Lee la fecha de la partida desde el fichero, hasta encontrar un
separador o fin de línea.
● sacarHundido(): Lee el número de barcos hundidos, utilizando el método
leerNumero().
● sacarTocado(): Lee el número de barcos tocados, utilizando el método
leerNumero().
● sacarAgua(): Lee el número de disparos que no impactaron en un barco, utilizando
el método leerNumero().
● leerNumero(): Lee un número completo desde el fichero, detectando el inicio y el
final del mismo.
● sacarGanado(): Lee y determina si el jugador ganó la partida al buscar la palabra
"ganado". Si no, determina que el jugador perdió.
● saltarCampos(): Salta tres campos fijos en el registro (sin leerlos), simplemente
avanzando el puntero del fichero.
● esSolo(): Determina si la partida fue jugada en solitario al verificar si el primer
carácter leído es 'S'.
● getSolo(): Devuelve el valor de solo, indicando si la partida fue solitaria o no.
● cierre(): Cierra el enlace lógico con el fichero, liberando los recursos asociados.
Clase RegistroFicherosEscritura:
Atributos de la clase
1. fichero (BufferedWriter):
○ Es el objeto que se utiliza para establecer un enlace con el fichero y realizar
operaciones de escritura.
2. RETURN (constante):
○ Representa el código del carácter de retorno (\r).
3. SALTO_LINEA (constante):
○ Representa el código del carácter de salto de línea (\n).
Métodos de la clase
1. Constructores
Estos permiten inicializar el enlace con un fichero físico.
● RegistroFicherosEscritura(String nombre)
○ Abre un fichero para escritura.
○ Si el fichero ya existe, se sobrescribe.
● RegistroFicherosEscritura(String nombre, boolean adicion)
○ Abre un fichero para escritura.
○ Si adicion es true, se abre el fichero en modo "añadir" (append), es decir, no
se borra el contenido existente, sino que se escriben datos al final del fichero.
○ Si adicion es false, el comportamiento es como el constructor anterior.
2. Método escritura(Registro registro, boolean esSolo)
○ Escribe los caracteres del objeto registro en el fichero, si es true, se usa to
stringsolo, sino tostring.
3. Método escrituraSaltoDeLinea()
○ Añade un salto de línea al fichero.
○ Escribe el carácter de retorno (\r) seguido del carácter de salto de línea (\n).
4. Método cierre()
○ Cierra el enlace lógico con el fichero.
○ Es importante cerrar el fichero para liberar los recursos del sistema y
asegurarse de que todos los datos se escriban correctamente.
Clase LineaFicherosLectura
Atributos de la clase
1. FINAL_FICHERO (constante):
○ Representa el código especial -1 que indica el final del fichero.
○ Utilizado para saber cuándo se ha terminado la lectura.
2. RETURN (constante):
○ Representa el código del carácter de retorno (\r).
3. SALTO_LINEA (constante):
○ Representa el código del carácter de salto de línea (\n).
4. codigo (entero):
○ Almacena el código del carácter leído actualmente del fichero.
5. fichero (BufferedReader):
○ Es el objeto que establece el enlace lógico con el fichero físico para leer
Métodos de la clase
1. Constructor LineaFicherosLectura(String nombre)
○ Abre un fichero para lectura.
○ Crea un enlace lógico entre el fichero físico y el programa utilizando un objeto
BufferedReader.
● Parámetros:
○ nombre: Nombre o ruta del fichero que se desea abrir.
2. Método quedanLineas()
○ Verifica si hay más caracteres disponibles para leer en el fichero.
○ Utiliza el método read() de BufferedReader para obtener el siguiente carácter.
● Devuelve:
○ true: Si hay más caracteres por leer (no se ha alcanzado FINAL_FICHERO).
○ false: Si se ha llegado al final del fichero.
3. Método lectura()
1. Lee caracteres del fichero y los almacena en un objeto de tipo Linea hasta
encontrar:
■ El final del fichero (FINAL_FICHERO).
■ Un retorno de carro (RETURN).
■ Un salto de línea (SALTO_LINEA).
● Detalles del funcionamiento:
1. Crea un nuevo objeto Linea.
2. Si el atributo codigo es 0, lee el siguiente carácter.
3. Entra en un bucle para leer caracteres uno por uno:
■ Mientras no se alcance el final del fichero ni se encuentre un salto de
línea.
■ Añade cada carácter leído al objeto Linea usando el método
putCaracter().
4. Si se encuentra un RETURN, lee el siguiente carácter (SALTO_LINEA).
5. Devuelve el objeto Línea con los caracteres leídos.
4. Método cierre()
○ Cierra el fichero físico asociado al objeto BufferedReader.
Programa para el uso del juego
1. Declaraciones principales:
● Manejo de fechas con LocalDateTime y formato DateTimeFormatter para incluir un
registro con marcas temporales.
● Creación de objetos de las clases:
○ Linea para gestionar líneas de texto.
○ LineaFicherosEscritura y LineaFicherosLectura para leer y escribir en el
archivo de registro.
○ Tablero para representar el estado del juego de cada jugador.
● Utilización de un generador de números aleatorios (Random) para asignar
configuraciones iniciales de los tableros.
2. Estructura del juego:
El bucle principal controla la selección del modo de juego mediante un menú interactivo
(menu()).
Modos de juego:
● Jugar solo (opción 1):
○ El jugador introduce su nombre.
○ Se genera un tablero aleatorio con barcos.
○ El jugador dispara hasta que todos los barcos han sido hundidos.
○ El registro de la partida se guarda en un archivo.
● Uno contra uno (opción 2):
○ Dos jugadores introducen sus nombres y configuran sus tableros.
○ Alternan turnos para disparar, mostrando el tablero propio y el estado del
rival.
○ Al final, registra el resultado para ambos jugadores en el archivo.
● Consultar registro de partidas (opción 4):
○ Muestra el contenido del archivo de registro línea por línea.
● Salir (opción 5):
○ Finaliza el programa cerrando los archivos de lectura y escritura.
3. Subprogramas y su funcionalidad:
● menu: Muestra el menú y permite al usuario seleccionar una opción que el prefiera.
● disparos: Gestiona el proceso de disparar sobre un tablero y actualiza su estado.
● crearTableros: Genera un tablero a partir de un archivo aleatorio seleccionado
mediante un número aleatorio.
