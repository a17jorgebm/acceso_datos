package com.pepinho.ad.e05baloncesto.dao;

import java.util.List;

public class AlumnoDao implements Dao<Alumno, String> {

//    private List<Alumno> alumnos = List.of(
//            new Alumno("Pepe", "pepecalo@gmail.com", 23),
//            new Alumno("Xan", "xan@gmail.com", 22),
//            new Alumno("Ana", "ana@gmail.com", 21));

    // Lista de 10 alumnos con nombres de filósofos del siglo XX y datos de email ficticios
    // https://es.wikipedia.org/wiki/Anexo:Fil%C3%B3sofos_del_siglo_XX

     private List<Alumno> alumnos = List.of(
             new Alumno("Hannah Arendt", "hannaharendt@gmail.com", 23),
                new Alumno("Simone de Beauvoir", "simone@gmail.com", 22),
                new Alumno("Albert Camus", "albertcamus@gmail.com", 21),
                new Alumno("Noam Chomsky", "noamchomsky@gmail.com", 20),
                new Alumno("Michel Foucault", "michelfocault@live.com", 19),
                new Alumno("Martin Heidegger", "elserylanada@live.com", 18),
                new Alumno("Jean-Paul Sartre", "existo@gmail.com", 17),
                new Alumno("Simone Weil", "simone@live.com", 16));



    @Override
    public Alumno get(String id) {
        return alumnos.stream().filter(a -> a.getNome().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Alumno> getAll() {
        return alumnos;
    }

    @Override
    public void save(Alumno obxecto) {
        alumnos.add(obxecto);
    }

    @Override
    public void delete(Alumno obx) {
        alumnos.remove(obx);

    }

    @Override
    public void update(Alumno obx) {
        Alumno a = get(obx.getNome());
        if (a != null) {
            a.setEmail(obx.getEmail());
            a.setIdade(obx.getIdade());
        }
    }
}
