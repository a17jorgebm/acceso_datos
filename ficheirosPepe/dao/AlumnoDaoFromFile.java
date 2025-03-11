package com.pepinho.ad.e05baloncesto.dao;

import java.io.*;
import java.util.List;

public class AlumnoDaoFromFile implements Dao<Alumno, String> {


    private File file;

    public AlumnoDaoFromFile(String file) {
        this.file = new File(file);
    }

    @Override
    public Alumno get(String id) {
        Alumno al = null;
        // leer el fichero y buscar el alumno con nombre id

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                al = (Alumno) ois.readObject();
                if (al.getNome().equals(id)) {
                    return al;
                }
            }
        } catch (EOFException e) {
            // fin de fichero
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return al;
    }

    @Override
    public List<Alumno> getAll() {
        return List.of();
    }

    @Override
    public void save(Alumno obxecto) {

    }

    @Override
    public void delete(Alumno obx) {

    }

    @Override
    public void update(Alumno obx) {

    }
}
