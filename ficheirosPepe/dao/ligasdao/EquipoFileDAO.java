package com.pepinho.ad.e05baloncesto.basketdao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EquipoFileDAO implements Dao<Equipo, String> {

//    public static final String RUTA = "e:\\";


    private static EquipoFileDAO instance;

    public static EquipoFileDAO getInstance(String path) {
        if (instance == null) {
            synchronized (EquipoFileDAO.class) {
                if (instance == null) {
                    instance = new EquipoFileDAO(path);
                }
            }
        }
        return instance;
    }

    // Los lee de un fichero binario con ObjectInputStream
    // y los guarda en un fichero binario con ObjectOutputStream.
    private final Path path;

//    private EquipoFileDAO(Path path) {
//        this.path = path;
//    }

    private EquipoFileDAO(String path) {
        this.path = Paths.get(path);
    }

//    private EquipoFileDAO() {
//        path = Paths.get(RUTA);
//    }


    /**
     * Devuelve el equipo con el nombre indicado.
     * Si no existe, devuelve null.
     * En esta implementación se lee el fichero de equipos y se devuelve el equipo con el nombre indicado si lo encuentra.
     *
     * @param id nombre del equipo
     * @return equipo con el nombre indicado
     */
    @Override
    public Equipo get(String id) {

        /*
         * Lectura del fichero de equipos, si el equipo está en el fichero, lo devuelve.
         * Si no está, devuelve null.
         */
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(path.toFile())
        ))) {
            // Bucle infinito, que termina con EOFException. No es la mejor forma de terminar la lectura.
            // Otro método sería leer el fichero hasta que no haya más datos:
            // while (ois.available() > 0) { ... }
            while (true) {
                Object o = ois.readObject();
                if (o instanceof Equipo equipo) {
                    if (equipo.getNome().equals(id)) {
                        return equipo;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro non atopado: " + e.getMessage());
        } catch (EOFException e) {
            // fin de fichero, es la mejor forma de terminar la lectura
            System.out.println("Equipo non atopado: " + id + " " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e);
        }
        return null;
    }

    @Override
    public List<Equipo> getAll() {

        List<Equipo> equipos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(path.toFile())
        ))) {
            /*
             * Bucle infinito, que termina con EOFException.
             * No es la mejor forma de terminar la lectura.
             * Otro método sería leer el fichero hasta que no haya más datos:
             * while (ois.available() > 0) { ... }
             */
            while (true) {
                Object o = ois.readObject();
                if (o instanceof Equipo equipo) {
                    equipos.add(equipo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro non atopado");

        } catch (EOFException e) {
            // fin de fichero
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e);
        }

        return equipos;
    }

    @Override
    public boolean save(Equipo obxecto) {

        /*
            Comprobamos si el equipo ya está guardado.
         */
        if (get(obxecto.getNome()) != null) {
//            System.out.println("Equipo xa gardado: " + obxecto);
            return false;
        }

        /*
         * Guardar el equipo en el fichero de equipos.
         * Si el fichero no existe, lo crea.
         * Si el fichero existe, añade el equipo al final.
         */
        boolean append = Files.exists(path);
        try (FileOutputStream fos = new FileOutputStream(path.toFile(), append);
             ObjectOutputStream oos = append ? new EquipoOutputStream(fos) : new ObjectOutputStream(fos)) {
            oos.writeObject(obxecto);
//            System.out.println("Equipo gardado: " + obxecto);
        } catch (IOException e) {
            System.out.println("Erro de Entrada/Saída");
            return false;
        }
        return true;
    }


    @Override
    public boolean delete(Equipo obx) {

        /*
         * Otra opción sería poniendo el objeto a null en el fichero.
         * findAndReplace(obx.getNome(), null);
         */

        /*
         * 1. Leer todos los equipos
         * 2. Guardar todos los equipos menos el que se quiere borrar
         *
         */
        List<Equipo> equipos = getAll();
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(path.toFile())
        ))) {
            for (Equipo equipo : equipos) {
                if (!equipo.equals(obx)) {
                    oos.writeObject(equipo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro non atopado");
            return false;
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAll() {
        try {
            Files.delete(path);
            return true;
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        Equipo equipo = get(id);
        if (equipo == null) {
            return false;
        }
        return delete(equipo);
    }

    @Override
    public void update(Equipo obx) {

        /*
         * 1. Leer todos los equipos
         * 2. Guardar todos los equipos menos el que se quiere actualizar
         * 3. Guardar el equipo actualizado
         *
         */
        findAndReplace(obx.getNome(), obx);

    }

    /**
     * Este método de utilidad busca un equipo por nombre y lo reemplaza por otro equipo.
     * Se puede usar para actualizar un equipo o para borrado con null.
     * @param nome nombre del equipo a buscar
     * @param equipoA equipo que reemplaza al equipo encontrado
     */
    public void findAndReplace(String nome, Equipo equipoA) {
        List<Equipo> equipos = getAll();
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(path.toFile())
        ))) {
            for (Equipo equipo : equipos) {
                oos.writeObject(equipo.getNome().equals(nome) ? equipoA : equipo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro non atopado");
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }
}
