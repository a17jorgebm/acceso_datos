package org.example.boletin_ficheiros.ejer1;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


/*
c) Realiza un programa que lea con un JOptionPane pida una URL y para
posteriormente abrir un JFileChooser para guardarlo en el disco local.
Ayuda: para abrir un flujo de entrada a una URL puede hacerse con el
método openStream() de URL. Ten en cuenta que puede lanzar excepciones.
InputStream in = new URL(FILE_URL).openStream();
 */
public class ApartadoC {
    public static final String EXTENSION_WEBP=".webp";
    public static void main(String[] args) {
        String urlPedida= JOptionPane.showInputDialog("Ingresa a URL:");

        URL url=null;
        URLConnection conexion=null;
        HttpURLConnection header= null;
        String tipoArquivo=null;
        try{
            url=(new URI(urlPedida)).toURL();
            conexion=url.openConnection();
            header=(HttpURLConnection) conexion;
            //muito cuidao con facer esto de abaixo, esto solo se fai se imos ler UNICAMENTE a cabeceira
                //senon despois non nos devolve ningún contido do corpo,
                // para collelo todo usase "GET" (por defecto, por eso non se pon)
            //header.setRequestMethod("HEAD");
            String contentType=header.getContentType().split(";")[0];
            System.out.println(contentType);

            //comprobación manual de que un archivo é de tipo webp, esto é pa practicar simplemente, non hai q facelo
            if (esWebp(url)){
                tipoArquivo=EXTENSION_WEBP;
            }else{
                //se existe extension para o tipo de arquivo imolo incluir no nome do arquivo, senon non
                tipoArquivo=getExtensionFromMimeType(contentType)!=null
                        ? getExtensionFromMimeType(contentType)
                        : "";
            }
        }catch(Exception e){
            System.out.println("Error ao formar a URL: "+e.getMessage());
            System.exit(1);
        }

        //Pidese directorio e nome do arquivo novo
        JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if((fc.showOpenDialog(null)!=JFileChooser.APPROVE_OPTION)){
            System.out.println("Directorio non seleccionado, saindo do programa...");
            System.exit(0);
        }
        File directorio=fc.getSelectedFile();

        String nomeArquivo=JOptionPane.showInputDialog("Introduce o nome do arquivo a gardar:");
        if (nomeArquivo.isBlank()){
            System.out.println("Nome de arquivo baleiro, saindo do programa...");
            System.exit(0);
        }

        //faise o arquivo ca extension adecuada
        File arquivoGardar=new File(directorio,nomeArquivo+""+tipoArquivo);

        //Se todo guay, copiase o contido da url no arquivo
        try(
                BufferedInputStream input=new BufferedInputStream(conexion.getInputStream());
                BufferedOutputStream output=new BufferedOutputStream(new FileOutputStream(arquivoGardar));
        ){
            byte[] buffer=new byte[512];
            int bytesLeidos;
            while((bytesLeidos=input.read(buffer))!=-1){
                output.write(buffer,0,bytesLeidos);
            }
        }catch(Exception e){
            System.out.println("Ocorreu un erro copian os arquivos, pode que non se copiaran correctamente. "+ e.getMessage());
            System.exit(1);
        }
    }

    //dado que el HEAD de http no indica si el archivo va a ser jpeg o webp
    public static boolean esWebp(URL urlConexion) throws IOException {
        /*
        hai que abrir unha conexion nova, porque se se usa a misma cando
        queiramos usala de novo para copiar o arquivo vai dar error por:
            1. Ou porque xa cerramos a conexion co try with resources
            2. Porque xa leemos os 12 primeiros bytes, jodendo a cabeceira do arquivo
         */
        URLConnection conexionFuncion=urlConexion.openConnection();

        /*
        Esto é o que ten que ter a cabeceira dun archivo webp:
            - los primeros 4 bytes (4 chars) necesitan ser "RIFF"
            - despois ten 4 bytes que mostran o tamaño do arquivo, que se saltan
            - os seguintes 4 bytes teñen que ser "WEBP"
         */
        String palabras="RIFFWEBP";
        //pasoos a un array de bytes
        //uso esa codificación xa que garda os caracteres en 1 byte, poderiase usar UTF-8 pero este é mais preciso neste caso, xa que utf-8 pode ter de 8 a 32 bits
        byte[] bytesPalabras=palabras.getBytes(StandardCharsets.ISO_8859_1);
        try(
            InputStream input=conexionFuncion.getInputStream();
        ){
            //solo me fan falta comprobar os primeiros 12 bytes
            byte[] buffer=new byte[12];
            if(input.read(buffer)!=12){ //se xa non ten 12 bytes salo
                return false;
            }
            int indicePalabras=0;
            for (int i=0;i<buffer.length;i++){
                if (i==4){ i+=4; }//pa que se salte os bytes da longitud
                if (buffer[i] != bytesPalabras[indicePalabras++]){ //se algun byte non é o mismo devolve false
                    return false;
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static String getExtensionFromMimeType(String mimeType){
        Map<String, String> mimeTypeToExtension = new HashMap<>();

        mimeTypeToExtension.put("audio/aac", ".aac");
        mimeTypeToExtension.put("application/x-abiword", ".abw");
        mimeTypeToExtension.put("image/apng", ".apng");
        mimeTypeToExtension.put("application/x-freearc", ".arc");
        mimeTypeToExtension.put("image/avif", ".avif");
        mimeTypeToExtension.put("video/x-msvideo", ".avi");
        mimeTypeToExtension.put("application/vnd.amazon.ebook", ".azw");
        mimeTypeToExtension.put("application/octet-stream", ".bin");
        mimeTypeToExtension.put("image/bmp", ".bmp");
        mimeTypeToExtension.put("application/x-bzip", ".bz");
        mimeTypeToExtension.put("application/x-bzip2", ".bz2");
        mimeTypeToExtension.put("application/x-cdf", ".cda");
        mimeTypeToExtension.put("application/x-csh", ".csh");
        mimeTypeToExtension.put("text/css", ".css");
        mimeTypeToExtension.put("text/csv", ".csv");
        mimeTypeToExtension.put("application/msword", ".doc");
        mimeTypeToExtension.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".docx");
        mimeTypeToExtension.put("application/vnd.ms-fontobject", ".eot");
        mimeTypeToExtension.put("application/epub+zip", ".epub");
        mimeTypeToExtension.put("application/gzip", ".gz");
        mimeTypeToExtension.put("image/gif", ".gif");
        mimeTypeToExtension.put("text/html", ".html");
        mimeTypeToExtension.put("image/vnd.microsoft.icon", ".ico");
        mimeTypeToExtension.put("text/calendar", ".ics");
        mimeTypeToExtension.put("application/java-archive", ".jar");
        mimeTypeToExtension.put("image/jpeg", ".jpeg");
        mimeTypeToExtension.put("text/javascript", ".js");
        mimeTypeToExtension.put("application/json", ".json");
        mimeTypeToExtension.put("application/ld+json", ".jsonld");
        mimeTypeToExtension.put("audio/midi", ".midi");
        mimeTypeToExtension.put("audio/x-midi", ".midi");
        mimeTypeToExtension.put("audio/mpeg", ".mp3");
        mimeTypeToExtension.put("video/mp4", ".mp4");
        mimeTypeToExtension.put("video/mpeg", ".mpeg");
        mimeTypeToExtension.put("application/vnd.apple.installer+xml", ".mpkg");
        mimeTypeToExtension.put("application/vnd.oasis.opendocument.presentation", ".odp");
        mimeTypeToExtension.put("application/vnd.oasis.opendocument.spreadsheet", ".ods");
        mimeTypeToExtension.put("application/vnd.oasis.opendocument.text", ".odt");
        mimeTypeToExtension.put("audio/ogg", ".oga");
        mimeTypeToExtension.put("video/ogg", ".ogv");
        mimeTypeToExtension.put("application/ogg", ".ogx");
        mimeTypeToExtension.put("font/otf", ".otf");
        mimeTypeToExtension.put("image/png", ".png");
        mimeTypeToExtension.put("application/pdf", ".pdf");
        mimeTypeToExtension.put("application/x-httpd-php", ".php");
        mimeTypeToExtension.put("application/vnd.ms-powerpoint", ".ppt");
        mimeTypeToExtension.put("application/vnd.openxmlformats-officedocument.presentationml.presentation", ".pptx");
        mimeTypeToExtension.put("application/vnd.rar", ".rar");
        mimeTypeToExtension.put("application/rtf", ".rtf");
        mimeTypeToExtension.put("application/x-sh", ".sh");
        mimeTypeToExtension.put("image/svg+xml", ".svg");
        mimeTypeToExtension.put("application/x-tar", ".tar");
        mimeTypeToExtension.put("image/tiff", ".tiff");
        mimeTypeToExtension.put("video/mp2t", ".ts");
        mimeTypeToExtension.put("font/ttf", ".ttf");
        mimeTypeToExtension.put("text/plain", ".txt");
        mimeTypeToExtension.put("application/vnd.visio", ".vsd");
        mimeTypeToExtension.put("audio/wav", ".wav");
        mimeTypeToExtension.put("audio/webm", ".weba");
        mimeTypeToExtension.put("video/webm", ".webm");
        //mimeTypeToExtension.put("image/webp", ".webp"); //quitase xa que o fago manualmente, non coa cabeceira http
        mimeTypeToExtension.put("font/woff", ".woff");
        mimeTypeToExtension.put("font/woff2", ".woff2");
        mimeTypeToExtension.put("application/xhtml+xml", ".xhtml");
        mimeTypeToExtension.put("application/vnd.ms-excel", ".xls");
        mimeTypeToExtension.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx");
        mimeTypeToExtension.put("application/xml", ".xml");
        mimeTypeToExtension.put("text/xml", ".xml");
        mimeTypeToExtension.put("application/vnd.mozilla.xul+xml", ".xul");
        mimeTypeToExtension.put("application/zip", ".zip");
        mimeTypeToExtension.put("application/x-zip-compressed", ".zip");
        mimeTypeToExtension.put("video/3gpp", ".3gp");
        mimeTypeToExtension.put("audio/3gpp", ".3gp");
        mimeTypeToExtension.put("video/3gpp2", ".3g2");
        mimeTypeToExtension.put("audio/3gpp2", ".3g2");
        mimeTypeToExtension.put("application/x-7z-compressed", ".7z");

        return mimeTypeToExtension.get(mimeType);
    }
}
