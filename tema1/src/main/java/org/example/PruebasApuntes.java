package org.example;

import java.io.File;
import java.util.Date;

public class PruebasApuntes {
    public static void main(String[] args) {
        File f=new File("pom.xml");
        File f2=new File(f.getAbsolutePath());
        if (f.exists()) {
            long lastM=f.lastModified();
            Date legible=new Date(lastM);
            f.getParent();
            System.out.println(f2.getParent());
            f.listFiles();
        }
    }
}
