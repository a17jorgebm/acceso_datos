package com.pepinho.ad.chistes.model;

import java.io.Writer;

public interface IChisteDAO {

    String getRandomJokeAsString();
    String getJokeAsString(String categoria, String[] tipo, String[] banderas);
    String getJokeAsString(String categoria, String[] tipo, String[] banderas, String idioma);

    Chiste getRandomJoke();
    Chiste getJoke(String categoria, String[] tipo, String[] banderas);
    Chiste getJoke(String categoria, String[] tipo, String[] banderas, String idioma);


    void saveJokeAsJson(Chiste chiste, Writer writer);

}
