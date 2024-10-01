## Cousas que mirar
### StringBuilder
```
StringBuilder sb= new StringBuilder();
sb.append("ola son un string");
sb.toString();
```

# 1.1 Acceso a ficheros, flujos, serialización

Clases E/S usadas para traballar con ficheiros NON orientados a flujos. Usase a biblioteca java.IO como java.NIO(new io):
* `java.io.File`: usada xa que fai que o codigo vala para calquer plataforma. É unha referencia ao archivo, non esta vinculado ao sistema de archivos.

## JFileChooser
Para escoller de forma gráfica un arquivo, podendo poñer filtros e asi tamen.

```
File arquivo=null;
        JFileChooser fc=new JFileChooser();
        if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            arquivo=fc.getSelectedFile();
        }
        if (arquivo!=null){
            System.out.println(arquivo.getAbsolutePath());
        }
```

## File
separadores:
* java.io.File.`separator`: separador de ruta(`/` en UNIX `\` en WINDOWS)
* java.io.File.`pathSeparator`: o separador da variable PATH da plataforma(`:` en UNIX `;` en WINDOWS)

...completar cos apuntes❗❗❗

## RandomAccessFile
completar con apuntes

## Serializacion
### UID da clase
Nunha clase que é serializable, se non se pon esto, o uid cambiara cada vez que se compile o programa, facendo que non sea compatible con archivos que teñen obxetos dunha version distinta. Desta maneira sempre terá o indicado.
```java
private static final long serialVersionUID=UIDversionClase;
```
### ObjectInputStream e ObjectOutputStream
Serven para gardar obxetos.

O problema que teñen é que a versión do obxeto non pode cambiar, senon daría erro. Ademais solo serven para leer en java e linguaxes derivadas.

Completar, xa fixen mil ejers

## URLS
Usar URI e convertir en URL

## Clase Scanner
Repasar a presentacion flujos de entrada e salida

!! Mirar o String.format()

!! Mirar expresions regulares

## Clase console
````java
Console consola=System.console();
//comprobamos que o programa se tea executando desde consola, 
// non dende un emulador de consola por ejemplo o IDE
if(con != null){
    
        }
````

## Buffers
PrintWriter ou BufferedWriter:
* PrintWriter ten metodos mais utiles e usa buffer internamente
* BufferedWriter o que ten é que podes indicar o tamaño do buffer

## COUSAS INTERESANTES BOLETIN
### ejer6
Rpresentacion endianness, littleengine

programa XhD para ver e modificar bytes de un bmp

ejer 6 boletin- pasar os bytes que estan en little endian a entero...doble...

numeros binarios negativos - complemento a 2
    o operador &


no ejercicio 6 usa a mascara para que non arrastre o signo

### ejer5
cousas utiles: hashcode e equals,comparable

modelo dao
    con modelo, interfaz dao e implementación da interfaz, e o modeloFactory se me veño arriba


# Java NIO.2
É un `sustituto de Java IO` que da muitas caracteristicas novas e melloras de rendimiento.

Ainda que se sigue usando IO, recomendase usar NIO.

## Interfaz Path
Como pasar de File a Path e viceversa:
````java
import java.io.File;

Path path = File.to
````

# Patrons de deseño
Son estratexias

## Patron DAO
data access object

fai os metodos CRUD (create, read, update, delete)
## Patron MVC
Modelo vista controlador

