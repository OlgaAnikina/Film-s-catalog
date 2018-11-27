package model;

import java.util.List;

public class IdGenerator {
    private DataAdapter parser;

    public IdGenerator(DataAdapter parser) {
        this.parser = parser;
    }

    int getId(){
        List<Film> films = parser.getFilms();
        return Integer.parseInt(films.stream().max(Film::compareTo).orElse(null).getId()) + 1;
    }
}
