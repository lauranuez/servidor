#Ejercicicio 1
##1.- Especificación de un componente (Covid19Manager.java,<<interfaz>>) que tiene las
##siguientes operaciones:
##● Crear una persona en el sistema. De cada persona sabemos: identificador,
##nombre y apellidos, fecha de nacimiento (o edad) y una valoración del nivel de
##salud de la persona (A, B, C, D) siendo ‘A’ el nivel de enfermedad menos
##avanzada y D el nivel de enfermedad más avanzada. La consecuencia de esta
##operación es que se crea un nuevo usuario en el sistema
##● Extraer una muestra sobre una persona y enviarla a un laboratorio. De cada
##muestra sabemos: un identificador que lo identifica unívocamente, un
##identificador del clínico que ha extraído la muestra, un identificador de la persona
##y la fecha de extracción y el identificador del laboratorio a enviar.. El resultado de
##esta acción es el envío a un laboratorio que se ha especificado.
##● Procesar una muestra por parte de un laboratorio. Las muestras se almacenan a
##la espera de ser procesadas y se procesan por orden de llegada. Una vez
##procesada la muestra se genera un informe asociado a esa muestra:
##positivo/negativo y un comentario
##● Listado de muestras de un usuario procesadas (en el que se puede mostrar el
##resultado y comentario)
##● OPCIONAL: Crear un Laboratorio. De cada laboratorio sabemos: identificador,
##nombre. La consecuencia de esta operación es que el número de laboratorios se
##incrementará en una unidad. En caso de no implementarse esta operación se
##puede popular la estructura de laboratorios con laboratorios precargados.
##2.- Implementación de una Fachada (patrón de diseño) que implemente el interfaz
##definido previamente (Covid19ManagerImpl.java, clase Java).
##2.1 Elección de las estructuras de datos.
##● El contenedor de usuarios debe implementarse como un diccionario
##(<clave, valor>).
##● El contenedor de laboratorios será un vector de Java (Array).
##● Contenedor que se utilizará para las muestras pendientes de procesarse
##en un laboratorio. ¿Qué estructura de datos proponéis?
##● Contenedor de las muestras de un usuario: lista encadenada de
##muestras.
##2.2 La fachada deberá implementarse como un Singleton.
##2.3 Todos los métodos deberán tener una TRAZA (a nivel de INFO) de LOG4J
##que muestre el valor de los parámetros al inicio de los métodos y al final.
##También debe contemplarse trazas de otros niveles (ERROR o FATAL)
##3.- Implementación de un test (JUNIT) sobre el componente (Covid19Manager) con los
##siguientes puntos:
##- método setUp que inicializa la estructura de datos y crea un juego de pruebas
##inicial.
##- método tearDown que libera los recursos. Tened en cuenta que al tratarse de
##un singleton, debéis ofrecer una operación para inicializar/limpiar las estructuras de
##datos
##- método de test para crear un nuevo usuario
##- método de test para procesar una muestra

#Ejercicio 2
Listado de usuarios ordenado alfabéticamente Añadir un usuario Modificar un usuario Consultar el número de usuarios que hay en el sistema Consultar información de un usuario (identificador, nombre, apellidos) Añadir un objeto sobre un usuario Consultar los objetos de un usuario (orden de inserción) Consultar el número de objetos de un usuario SE PIDE:

PARTE I: 6 puntos

1.- Especificación del componente que implementará las operaciones descritas anteriormente: (GameManager.java , interfaz Java)

2.- Implementación de una Fachada (patrón de diseño) que implemente el interfaz definido previamente (GameManagerImpl.java, clase Java).

2.1 Elección de las estructuras de datos: HashMap para usuarios y una implementación de List para los objetos de un usuario

2.3 La fachada deberá implementarse como un Singleton.

2.4 Todos los métodos deberán tener una TRAZA (a nivel de INFO) de LOG4J que muestre el valor de los parámetros al inicio de los métodos y al final. También debe contemplarse trazas de otros niveles (ERROR o FATAL)

3.- Implementación de un test (JUNIT) sobre el componente desarrollado con los siguientes puntos:

método setUp que inicializa la estructura de datos

método tearDown que libera los recursos. Tened en cuenta que un singleton obliga a liberar los recursos de manera explícita (por ejemplo método clear()) .

método de test para añadir un usuario en el sistema y verificar el número de usuarios.

método de test para añadir un objeto asociado a un usuario y verificar el número de objetos asociados a un usuario

PARTE II: 4 puntos 1.- Implementar un servicio REST que permita realizar las siguientes operaciones:

• lista de usuarios

• añadir un usuario

• modificar un usuario

• consultar la información de un usuario

• consultar los objetos de un usuario

• añadir un objeto sobre un usuario

NOTA: El servicio debe utilizar el componente construido en el punto anterior (GameManager)

2.- Validar con swagger el funcionamiento de la REST API repositorio debe existir un fichero readme.md que describa el/los proyecto/s
