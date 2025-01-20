package org.example.biblioteca.controller;

import org.example.biblioteca.modelo.Book;
import org.example.biblioteca.vista.IBookView;

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

    //public void setDao(DAO<Book> dao);


}
