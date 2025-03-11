package com.pepinho.ad.e05baloncesto.basketdao;

public class DaoFactory {
    public Dao<Clasificacion, String> getDao(String tipo) {
        if (tipo.equalsIgnoreCase("file")) {
            return ClasificacionFileDAO.getInstance();
        } else if (tipo.equalsIgnoreCase("json")) {
            return new ClasificacionJSONDAO();
        } else {
            return null;
        }
    }
}
