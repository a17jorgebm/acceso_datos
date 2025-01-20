package org.example.freeToGame;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.nio.file.Path;

public class Image {
    private Long id;
    private String url;
    private byte[] image;

    public Image(Long id, String url) {
        this.id = id;
        this.url = url;
        transFormToByteArray();
    }

    private void transFormToByteArray(){
        try(
                BufferedInputStream inputStreamC = new BufferedInputStream((new URI(url).toURL()).openStream());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ){
            int i;
            while ((i=inputStreamC.read())!=-1){
                byteArrayOutputStream.write(i);
            }
            this.image=byteArrayOutputStream.toByteArray();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (URISyntaxException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveToFile(){
        Path file=Path.of("src/main/java/org/example/freeToGame/imagen.jpg");
        try(
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file.toFile()));
                ){
            outputStream.write(image);
        }catch (IOException e){
            e.getMessage();
        }
    }

    public Long getId() {
        return id;
    }

    public Image setId(Long id) {
        this.id = id;
        return this;
    }

    public byte[] getImage() {
        return image;
    }

    public Image setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Image setUrl(String url) {
        this.url = url;
        return this;
    }
}
