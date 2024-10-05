📖 fumada de idea pa ejercicio, implementar un Reader a partir dun InputStream e un BufferedInputStream📖

## Cousas que mirar
Moito mais eficiente que ir xuntando Strings, xa que usa o mesmo obxeto
### Casting de objetos
Cando facemos un casting dun objeto a unha subclase, o unico que estamos facendo é darlle funcionalidades adicionales que poida ter esa subclase, pero o objeto `sigue sendo o mismo` e afectaralle todo o que se faga no objeto da subclase.
Ejemplo:

````java
import java.net.HttpURLConnection;
import java.net.URLConnection;

URLConnection conexion = objetoURL.openConnection();
HttpURLConnection conexionHttp=(HttpURLConnection) conexion;
````
Todo o que se faga no objeto conexionHttp afectaralle ao objeto conexion.
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
Accede aos arquivos de texto `de maneira aleatoria.`

pf suponse que entra pero... preguntar⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️

---
# Flujos de E/S
Un flujo🔀 representa unha fuenta de entrada ou destino de salida, que conten unha lista de elementos de datos representados `secuencialmente`. Esta secuencia de datos non se sabe canto mide e é dividida en `bloques`, os cales poden ser disntintos dependendo do tipo de flujo(bytes individuales, caracteres, cadenas de caracteres). Por ejemplo coas clases `buffer`, podense crear bloques de bytes ou caracteres mais grandes do normal.

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


# Flujos de bytes 0️⃣1️⃣
## InputStream e OutputStream
Todas as clases de flujos de bytes heredan das clases abstractas `InputStream` e `OutputStream`. Se non se usa buffer, por defecto estas clases escriben e leen de 8 en 8 bits, é dicir 1 byte.

````java
File ficheiro=new File("pom.xml");
try(
    FileInputStream input=new FileInputStream(ficheiro);
    FileOutputStream output=new FileOutputStream(ficheiro.getName()+".copia");
){
    int c;
    while((c=input.read())!=-1){
        output.write(c);
    }
}
````
### Read() e Write()
Tanto read como write leen ou escriben un int(representando un byte). Ademais, a ambos se lles pode pasar un `array de bytes que actuará como buffer`, para mellorar o rendimiento:

````java
byte[] buffer=new byte[1024]; //buffer de 1024 bytes
int cantidadBytes; //numero de bytes gardados no buffer polo metodo read()
while((cantidadBytes=input.read(buffer))!=-1){
    /*
    pasaselle:
        - O buffer do que ler os bytes
        - Desde donde empezar a ler no buffer(suele ser 0)
        - Ata que posicion do buffer ler (suele ser o valor que devolve read())
     */
    output.write(buffer,0,cantidadBytes);
}
````

### Explicación metodo read() e os ints
Quero explicar antes de nada porque ambas clases, a hora de ler co metodo `.read()` este devolve un enteiro(_int_).

Un int ten 32bits, osea 4 bytes. Ademais usa a `representación complemento a 2`, a cal usa o primeiro bit para representar se o número é positivo ou negativo. De ahí que un int poida representar:
* Desde: \(-2^{31} = **-2,147,483,648** \)
* Hasta: \(2^{31} - 1 = **2,147,483,647** \)

Elevamos 2 a 31 xa que un dos bits do enteiro usase para o signo, se fora `unsigned` podería representar 2^32 - 1(pq empezamos en 0)= 4,294,967,295 números.

#### Entonces, porque read devolve un int en ambos casos?
No caso dos `streams de bytes`, read() devolve un int simplemente para poder representar o valor -1, que significa que acabou de ler o flujo.
* Neste caso o int conten un valor de byte nos últimos 8 bits

No caso dos `streams de caracteres`, read() devolve un int, a parte de po -1, para poder representar un caracter() UNICODE de 16 bits.
* O int conten un valor de caracter(char) nos últimos 16 bits

## ObjectInputStream e ObjectOutputStream
`ObjectInputStream` lee objetos serializados do flujo de entrada e deserializaos, mentres que `ObjectOutputStream` serializa os objetos e escribeos no flujo de salida.

### Serializable
Para que un objeto poida ser serializado debe implementar a interfaz `Serializable`, ademais todos os objetos que usa tamen a deben de ter.
````java
class ClaseSerializable implements Serializable {}
ClaseSerializable objetoSerializable=new ClaseSerializable();
````
#### UID da clase
Nunha clase que é serializable, se non se pon esto, o uid cambiara cada vez que se compile o programa, facendo que non sea compatible con archivos que teñen obxetos dunha version distinta. Desta maneira sempre terá o indicado.

````java
private static final long serialVersionUID=UIDversionClase;
````

✏️ `Escribir` un obxeto nun ficheiro:
````java
try(
    ObjectOutputStream output = new ObjectOutputStream(FileOutputStream("ficheiro.dat"));
){
    output.writeObject(objetoSerializable);
}catch(IOException e){}
````
📖 `Ler` un obxeto dun ficheiro 

Usase un bucle while infinito, o cal para cando se lanza a extepcion EOFException
````java
try(ObjectInputStream input=newObjectInputStream(new FileInputStream("ficheiro.dat"))){
    try{
        while(true){
            ClaseSerializable objetoLeido=(ClaseSerializable) input.readObject();
        }
    }catch(EOFException){ //cando non haxa mais obxetos, lanza excepcion e parase o bucle
        break;
    }
}catch(IOException e){}
````
### ⚠️ Fallo añadir obxetos a ficheiro existente ⚠️
ObjectOutputStream escribe unha nova cabeceira cada vez que se abre un ficheiro cun novo obxeto desta clase, o cal fai que o arquivo se corrompa se xa existia e se fai un append.

Para solucionar esto, teremos que crear unha clase que extenda de ObjectOutputStream e sobreescribir o metodo `writeStreamHeader`, facendo que non faga nada. Despois a hora de escribir no arquivo, teremos que comprobar se xa existe (usaremos a nova clase creada por nos) ou non
(usaremos a clase normal ObjectOuputStream).

````java
public class AppendObjectOutputStream extends ObjectOutputStream {
    public AppendObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    public void writeStreamHeader() throws IOException {
        //pa que non escribe o header no arquivo, facendo que se corrompa
    }
}
````
Uso:
````java
if (ficheiro.exists()){
    try(
        AppendObjectOutputStream os=new AppendObjectOutputStream(new FileOutputStream(NOME_FICHEIRO,true));
    ){
        os.writeObject(p);
    }catch (IOException e){
        System.out.println("Erro ao escribir o arquivo");
    }
}else {
    try(
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(NOME_FICHEIRO));
    ){
        os.writeObject(p);
        JOptionPane.showMessageDialog(null,"Estudiante gardado correctamente!");
    }catch (IOException e){
        System.out.println("Erro ao escribir o arquivo");
    }
}
````
## URL e flujos
Tamen se pode traballar con URLs e flujos.
1. Crearemos a `URL` a partir dunha `URI`
2. Usamos o metodo `url.openConnection()` para abrir unha `URLConnection`, da cal se pode sacar o InputStream co metodo `.getInputStream()`
3. Neste caso pasamos a URLConnection a un obxeto `HttpURLConnection`, que nos permite traballar con elementos especificos de HTTP.
4. A partir dese objeto podemos coller atributos do head de http, pero NON O InputStream, este sempre o sacaremos do URLConnection.

Gardamos a pagina nun ficheiro mediante InputStream
````java
public static void main(String[] args) throws Exception {
    File ficheiroPagina=new File("web.html");
    
    URL url=(new URI("https://google.es")).toURL();
    URLConnection conexion=url.openConnection(); //de onde sacamos o flujo
    HttpURLConnection con=(HttpURLConnection) conexion;
    
    try(
            InputStream in=conexion.getInputStream();
            FileOutputStream fos=new FileOutputStream(ficheiroPagina);
    ){
        byte[] buffer=new byte[1024];
        int numLeido;
        while((numLeido=in.read(buffer))!=-1){
            fos.write(buffer,0,numLeido);
        }
        System.out.println(con.getContentType());
    }
}
````

Como se ve, o obxeto `HttpURLConection` solo se usa para cousas especificas de HTTP. No caso de que solo quixeramos mirar datos da cabeceira pero non foramos descargar todo o contido da paxina, fariamos o seguinte para aforrar recursos:
````java
URL url = (new URI("https://ejemplo.com/recurso")).toURL();
HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
httpConnection.setRequestMethod("HEAD");  // Usar el método HEAD para obtener solo los headers
httpConnection.connect();
// Obtener el tipo de contenido desde los headers
// String contentType = httpConnection.getHeaderField("Content-Type"); //tamen se pode asi
System.out.println("Content-Type: " + httpConnection.getContentType());
// Cerrar la conexión
httpConnection.disconnect();
````
Indicar que se se pon o request method do objeto HttpURLConnection a "HEAD", esto tamen vai afectar ao objeto URLConnection que lle pasamos, xa que o que fai HttpURLConnection(que é unha subclase de URLConnection) é castear o objeto, polo que apuntan a misma conexion. 

# Flujos de caracteres 🔡
Como xa se comentou, os flujos de caracteres son clases envoltorias dos flujos de bytes que fan moi sinxela a transformación de `byte->caracter`
* Todas as clases de flujo de caracteres heredan de `Reader` e `Writer`
* Usan os flujos de bytes para a E/S física, e os flujos de caracteres encarganse da traducción de byte a caracter
* Traballan con 16 bits en vez de 8, podendo xuntar bytes para formar caracteres mais complexos, como expliquei [aqui](#diferencia-principal-entre-flujos-e-bytes-e-caracteres)

## InputStreamReader e OutputStreamReader
Son flujos puente `byte-a-caracter` de proposito general, colle un InputStream e transformano nun Reader e Writer usable.

Usando o exemplo de arriba da URL, en vez de usar InputStream directamente, poderíase pasar a Reader (ter en conta que de esa maneira solo valería con texto)
````java
try(
    InputStream in=conexion.getInputStream();
    //pasamos o InputStream a Reader e traballamos con caracteres
    InputStreamReader inReader=new InputStreamReader(in);
    FileWriter fos=new FileWriter(ficheiroPagina);
){
    int bits;
    while((bits=inReader.read())!=-1){
        fos.write(bits);
    }
}
````

# Flujos con Buffer
Nos flujos sen buffer, cada petición de lectura/escritura vai `directamente o sistema E/S`, o cal pode resultar `moi ineficiente` (acceso a disco, actividad de red...)

Os buffer son flujos de alto nivel, que encapsulan outros flujos de baixo ou alto nivel para facelos mais eficientes e faciles de usar.

SEMPRE se recomenda usar un buffer cada vez que se traballa con flujos

## Para bytes
Usase `BufferedInputStream` e `BufferedOutputStream`.

Podese traballar con eles sen indicarlle un buffer, xa que usarán un buffer interno, facendo as operacións moito mais eficientes
````java
File ficheroEntrada=new File("pom.xml");
File ficheroSalida=new File("copia.xml");
try(
        BufferedInputStream input=new BufferedInputStream(new FileInputStream(ficheroEntrada));
        BufferedOutputStream output=new BufferedOutputStream(new FileOutputStream(ficheroSalida));
){
    int byteLeido;
    while((byteLeido=input.read())!=-1){
        output.write(byteLeido);
    }
}catch (Exception e){}
````
E tamen se lle pode indicar un buffer manualmente, se queremos ter mais control.
````java
byte[] buffer=new byte[1024];
int byteLeido;
while((byteLeido=input.read(buffer))!=-1){
    output.write(buffer,0,byteLeido);
}
````
## Para caracteres
Usase `BufferedReader` e `BufferedWriter`.

O funcionamento é exactamente igual, solo que no caso de usar un buffer manual, terá que ser de `chars`, xa que é co que traballará
````java
try(
        BufferedReader input=new BufferedReader(new FileReader(ficheroEntrada));
        BufferedWriter output=new BufferedWriter(new FileWriter(ficheroSalida));
){
    char[] buffer=new char[1024];
    int byteLeido;
    while((byteLeido=input.read(buffer))!=-1){
        output.write(buffer,0,byteLeido);
    }
````

# Resumen



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
