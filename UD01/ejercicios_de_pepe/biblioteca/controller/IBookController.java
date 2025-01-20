package com.pepinho.programacion.biblioteca.controller;

import com.pepinho.programacion.biblioteca.model.Book;
import com.pepinho.programacion.biblioteca.model.BookDAO;
import com.pepinho.programacion.biblioteca.model.DAO;
import com.pepinho.programacion.biblioteca.view.IBookView;

/**
 * Interface for the BookController class.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IBookController {

    public boolean createBook(String title, String author, String isbn, int year, boolean available, byte[] cover);

    public void getBook(int id);

    public void updateBook(String title, String author, String isbn, int year, boolean available, byte[] cover);

    public boolean deleteBook(int id);

    public boolean isLastBook(int id);

    public boolean isFirstBook(int id);

    public int getNextId(int id);

    public int getPreviousId(int id);

    public int getFirstId();

    public void setView(IBookView view);

    public void setDao(DAO<Book> dao);


}
