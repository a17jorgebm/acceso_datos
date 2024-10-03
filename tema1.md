📖 fumada de idea pa ejercicio, implementar un Reader a partir dun InputStream e un BufferedInputStream📖

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
Un flujo🔀 representa unha fuenta de entrada ou destino de salida, que conten unha lista de elementos de datos representados secuencialmente. Esta secuencia de datos non se sabe canto mide e é dividida en `bloques`, os cales poden ser disntintos dependendo do tipo de flujo(bytes individuales, caracteres, cadenas de caracteres). Por ejemplo coas clases `buffer`, podense crear bloques de bytes ou caracteres mais grandes do normal.

A **fuente de entrada** pode ser de moitos tipos:
* arquivos de disco: `FileReader`,`FileInputStream` 
* dispositivos: `System.in`
* outros programas
* Strings: `StringReader`
* arrays en memoria: `ByteArrayInputStream`

A fonte de **salida** terá os seus correspondentes, solo cambiando

E poden representar distintos **tipos de datos**:
* **BYTES**: `FileInputStream`
* **Datos primitivos**: `DataInputStream` 
* **Caracteres**: `FileReader`
* **Objetos**: `ObjectInputStream`  

## ❗❗Diferencia principal entre flujos e bytes e caracteres
Os flujos de caracteres, internamente, traballan con flujos de bytes.

1. A maior diferencia é a cantidade de bits que leen:
   * Os de byte leen `8 bits`(1 Byte)
   * Mentras que os de carácteres leen `16 bits`, o necesario para representar caracteres(un char) en UTF-16 (que é co que traballa java).
2. Ademais, Reader pode convertir bytes a caracteres automaticamente según a codificación de caracteres da fuente de datos(un arquivo por ejemplo). Como sabe que codificación usar? Gracias a clase `InputStreamReader`. Por defecto, lee en UTF-16, pero podeselle indicar a codificación como parámetro (cousa que non se pode facer con FileReader, xa que sempre usará UTF-8).

En utf-8 os caracteres poden ocupar de 8 bits ata 32 bits. Reader lee de 16 en 16, polo que para ler os que ocupan mais de esto, pode xuntar varios bloques de 16 bits para completalo. 
Como se sabe canto ocupará? Mediante os primeiros bits do primeiro byte do caracter, os cales indican a propia codificación do caracter, e por tanto, o tamaño que ocupará. Exemplo:

Supongamos que tienes un archivo UTF-8 con la siguiente secuencia de bytes:

`48 6F 6C 61 20 C3 B1 20 F0 9F 98 8A
`

Esto representa la cadena "Hola ñ 😊". El InputStreamReader hará lo siguiente:

    Lee 48 (01001000 en binario), detecta que es un carácter ASCII (1 byte), lo interpreta como H.
    Lee 6F (01101111), que es también ASCII, lo interpreta como o.
    Lee 6C, que es ASCII, lo interpreta como l.
    Lee 61, que es ASCII, lo interpreta como a.
    Lee C3, detecta que es el inicio de un carácter de 2 bytes porque comienza con 110xxxxx.
    Lee el siguiente byte, B1, completa el carácter UTF-8 y lo interpreta como ñ.
    Lee F0, detecta que es el inicio de un carácter de 4 bytes (porque comienza con 11110xxx).
    Lee los siguientes tres bytes (9F 98 8A), y lo interpreta como el emoji 😊.


## Flujos de bytes
Todas as clases de flujos de bytes heredan das clases abstractas `InputStream` e `OutputStream`. Se non se usa buffer, por defecto estas clases escriben e leen de 8 en 8 bits, é dicir 1 byte.

### InputStream



## Explicación metodo read() e os ints
Quero explicar antes de nada porque ambas clases, a hora de ler co metodo `.read()` este devolve un enteiro(_int_).

Un int ten 32bits, osea 4 bytes. Ademais usa a `representación complemento a 2`, a cal usa o primeiro bit para representar se o número é positivo ou negativo. De ahí que un int poida representar:
* Desde: \(-2^{31} = **-2,147,483,648** \)
* Hasta: \(2^{31} - 1 = **2,147,483,647** \)

Elevamos 2 a 31 xa que un dos bits do enteiro usase para o signo, se fora `unsigned` podería representar 2^32 - 1(pq empezamos en 0)= 4,294,967,295 números.

### Entonces, porque read devolve un int en ambos casos?
No caso dos `streams de bytes`, read() devolve un int simplemente para poder representar o valor -1, que significa que acabou de ler o flujo.
* Neste caso o int conten un valor de byte nos últimos 8 bits

No caso dos `streams de caracteres`, read() devolve un int, a parte de po -1, para poder representar un caracter() UNICODE de 16 bits.
* O int conten un valor de caracter(char) nos últimos 16 bits




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

