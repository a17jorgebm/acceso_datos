package com.pepinho.programacion.biblioteca.controller;

import com.pepinho.programacion.biblioteca.model.Book;
import com.pepinho.programacion.biblioteca.model.BookDAO;
import com.pepinho.programacion.biblioteca.model.DAO;
import com.pepinho.programacion.biblioteca.controller.IBookController;
import com.pepinho.programacion.biblioteca.view.IBookView;

import java.util.List;

public class BookController implements IBookController {


    private IBookView view;
    private DAO<Book> dao;

    private List<Long> ids;

    private long currentId;

    private static BookController instance;

    public static BookController getInstance(){
        if(instance == null){
            instance = new BookController();
        }
        return instance;
    }

    public void setView(IBookView view){
        this.view = view;
    }

    public void setDao(DAO<Book> dao){
        this.dao = dao;
        ids = dao.getAllIds();
        currentId = ids.size()!=0 ? ids.get(0) : -1;
    }

    private BookController(){

    }


    @Override
    public boolean createBook(String title, String author, String isbn, short year, boolean available, byte[] cover) {
        Book book = new Book(isbn, title, author, year, available,cover);
        dao.save(book);
        return true;
    }

    @Override
    public void getBook(long id) {
        Book book = dao.get(id);
        view.setBookTitle(book.getTitle());
        view.setAuthor(book.getAuthor());
        view.setISBN(book.getIsbn());
        view.setYear(book.getYear());
        view.setAvailable(book.isAvailable());
        view.setCover(book.getCover());
        view.setID(book.getIdBook());

    }

    @Override
    public void updateBook(long idBook, String title, String author, String isbn, short year, boolean available, byte[] cover) {
        Book book = new Book(idBook, isbn, title, author, year, available, cover);
        dao.update(book);
    }

    @Override
    public boolean deleteBook(long id) {
        ids.remove(id);
        return dao.deleteById(id);
    }


    @Override
    public boolean isLastBook(long id) {
        return !ids.isEmpty() && ids.get(ids.size()-1) == id;
    }

    @Override
    public boolean isFirstBook(long id) {
        return !ids.isEmpty() && ids.get(0) == id;
    }

    @Override
    public long getNextId(long id) {
        currentId = ids.get(ids.indexOf(id)+1);
        return currentId;
    }

    @Override
    public long getPreviousId(long id) {
        currentId = ids.get(ids.indexOf(id)-1);
        return currentId;
    }

    @Override
    public long getFirstId() {
        return (!ids.isEmpty()) ? ids.get(0) : -1;
    }
}
