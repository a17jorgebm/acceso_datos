## Cousas que mirar
Moito mais eficiente que ir xuntando Strings, xa que usa o mesmo obxeto
### StringBuilder
```java
StringBuilder sb= new StringBuilder();
sb.append("ola son un string");
sb.toString();
```
### JFileChooser
Para escoller de forma gráfica un arquivo, podendo poñer filtros e asi tamen.

Metodo `setFileSelectionMode()` para indicar o tipo de arquivos que se poderán seleccionar:
* JFileChooser.`DIRECTORIES_ONLY`
* JFileChooser.`FILES_ONLY`
```java
File arquivo=null;
        JFileChooser fc=new JFileChooser();
        if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            arquivo=fc.getSelectedFile();
        }
        if (arquivo!=null){
            System.out.println(arquivo.getAbsolutePath());
        }
```

### JOptionPane
Para por exemplo meter por interfaz un texto
````java
String urlString=JOptionPane.showInputDialog("Introduce a url");
````


# 1.1 Acceso a ficheros, flujos, serialización
# File
Unha instancia desta clase representa a ruta a un directorio ou arquivo, pero non conten ningún dato de este(podería non existir)

Non pode ler nin escribir datos nun arquivo, pero usase para `pasar como referencia a outras clases` de flujos.

Que fallos ten? Os cales corrige nio.file
* Moitos metodos non lanzan excepcions
* Pouco soporte de metadatos(propietario, permisos...)
* Nada compatible con enlaces simbólicos
* Algúns metodos escalaban mal, como listFiles()
## Constructores
Ten 4 distintos:

````java
new File(String ruta); //coa ruta (o mais usado)
new File(File pai, String rutaFilla);
new File(String rutaPai, String rutaFilla);
new File(URI uri);
````
## Metodos mais usados
````java
import java.io.File;

//con ruta relativa ou absoluta
File f = new File("/home/ficheiro.xml"); //creamos obxeto
f.exists(); //saber se existe ou non
f.delete(); //devolve true se guay, se é directorio ten q tar vacío
f.renameTo(File archivoNomeDistinto); //cambia o nome ao do arquivo pasado
f.getAbsolutePath(); //devolve o nome absoluto
f.mkdir(); //crea o directorio
    f.mkdirs(); //creao e a todos os directorios pais
f.getParent(); //ruta absoluta DO DIRECTORIO no q ta, solo funciona se se creou con ruta absoluta
f.getName(); //da o nome
f.isDirectory() ou .isFile(); //devolve se é directorio ou ficheiro
f.lastModified(); //numero de ms desde 1970
    Date ultModLegible=new Date(f.lastModified()); //forma legible

File[] contido=ficheiro.listFiles();
````
## Separadores:
Necesarios para facer apps multiplataforma:
* java.io.File.`separator`: separador de ruta(`/` en UNIX `\` en WINDOWS)
* java.io.File.`pathSeparator`: o separador da variable PATH da plataforma(`:` en UNIX `;` en WINDOWS)


# RandomAccessFile
pf suponse que entra pero... preguntar⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️


# Flujos de E/S
Traballase con flujos de bytes ou flujos de caracteres(que a sua vez traballan con flujos de bytes);

## Explicación metodo read() e os ints
Quero explicar antes de nada porque ambas clases, a hora de ler co metodo `.read()` este devolve un enteiro(_int_).

Un int ten 32bits, osea 4 bytes. Ademais usa a `representación complemento a 2`, a cal usa o primeiro bit para representar se o número é positivo ou negativo. De ahí que un int poida representar:
* Desde: \(-2^{31} = **-2,147,483,648** \)
* Hasta: \(2^{31} - 1 = **2,147,483,647** \)

Elevamos 2 a 31 xa que un dos bits do enteiro usase para o signo, se fora `unsigned` podería representar 2^32 - 1(pq empezamos en 0)= 4,294,967,295 números.

### Entonces, porque read devolve un int en ambos casos?
No caso dos `streams de bytes`, read() devolve un int simplemente para poder representar o valor -1, que significa que acabou de ler o flujo.
* Neste caso o int conten un valor de byte nos últimos 8 bits

No caso dos `streams de caracteres`, read() devolve un int, a parte de po -1, para poder representar un caracter UNICODE de 16 bits.
* O int conten un valor de caracter nos últimos 16 bits
* 



# Serializacion
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

