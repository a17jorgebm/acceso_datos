package org.example;

import com.google.gson.Gson;
import org.example.proba1.Proba;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Gson gson=new Gson();

        GregorianCalendar g= new GregorianCalendar(2024,GregorianCalendar.OCTOBER,14,8,10);
        Proba proba=new Proba("pepe",40,g.getTime()); //asi esta ben feito e non peta

        //se en vez de Date no obxeto usaramos LocalDate daría erro
        
        String json=gson.toJson(proba);
        System.out.println("json = " + json);
    }
}