## 1.1 Acceso a ficheros, flujos, serialización

Clases E/S usadas para traballar con ficheiros NON orientados a flujos. Usase a biblioteca java.IO como java.NIO(new io):
* `java.io.File`: usada xa que fai que o codigo vala para calquer plataforma. É unha referencia ao archivo, non esta vinculado ao sistema de archivos.

### JFileChooser
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

### File
separadores:
* java.io.File.`separator`: separador de ruta(`/` en UNIX `\` en WINDOWS)
* java.io.File.`pathSeparator`: o separador da variable PATH da plataforma(`:` en UNIX `;` en WINDOWS)
