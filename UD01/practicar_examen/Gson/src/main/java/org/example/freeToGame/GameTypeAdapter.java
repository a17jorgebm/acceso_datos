package org.example.freeToGame;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GameTypeAdapter extends TypeAdapter<Game> {
    @Override
    public void write(JsonWriter jsonWriter, Game game) throws IOException {

    }

    @Override
    public Game read(JsonReader jsonReader) throws IOException {
        //Game game=new Game();
        Game game = new GameInstanceCreator().createInstance(Game.class);
        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String key = jsonReader.nextName();
            switch (key){
                case "id" -> game.setId(jsonReader.nextLong());
                case "title" -> game.setTitle(jsonReader.nextString());
                case "game_url" -> game.setUrl(jsonReader.nextString());
                case "description" -> game.setDescripcion(jsonReader.nextString());
                case "genre" -> game.setGenero(jsonReader.nextString());
                //case "platform" -> game.setPlataforma(Plataforma.getPlataformaFromString(jsonReader.nextString()));
                case "release_date" -> saveDate(jsonReader,game);
                case "thumbnail" -> game.setMiniatura(new Image(0l,jsonReader.nextString()));
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();

        return game;
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static void saveDate(JsonReader jsonReader,Game game) throws IOException{
        game.setFecha_realizacion(LocalDate.parse(jsonReader.nextString(),FORMATTER));
    }
}
