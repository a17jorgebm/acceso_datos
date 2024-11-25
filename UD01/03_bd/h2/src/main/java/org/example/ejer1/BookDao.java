package org.example.ejer1;

import java.sql.Connection;
import java.util.List;

public class BookDao implements DaoGenerico<Book>{
    private Connection connection;

    public BookDao() throws RuntimeException{
        this.connection=BibliotecaConnectionManager.getInstance().getConnection();
    }

    @Override
    public Book get(long id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public List<Integer> getAllIds() {
        return List.of();
    }

    @Override
    public void updateLOB(Book book, String f) {

    }

    @Override
    public void updateLOBById(long id, String f) {

    }

    @Override
    public void deleteAll() {

    }
}
