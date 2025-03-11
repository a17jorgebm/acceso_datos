package com.pepinho.ad.e05baloncesto.basketdao;

public class ClasificacionDAOFactoy {

    public static Dao<Clasificacion, String> getClasificacionDAO(String tipo) {
        if (tipo.equalsIgnoreCase("file")) {
            return ClasificacionFileDAO.getInstance();
        } else {
            return null;
        }
    }

}
