package com.pepinho.ad.biblioteca.controller;

import com.pepinho.ad.biblioteca.model.Book;
import com.pepinho.ad.biblioteca.model.DAO;
import com.pepinho.ad.biblioteca.view.IBookView;

/**
 * Interface for the BookController class.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IBookController {

    public boolean createBook(String title, String author, String isbn, short year, boolean available, byte[] cover);

    public void getBook(long id);

    public void updateBook(long idBook, String title, String author, String isbn, short year, boolean available, byte[] cover);

    public boolean deleteBook(long id);

    public boolean isLastBook(long id);

    public boolean isFirstBook(long id);

    public long getNextId(long id);

    public long getPreviousId(long id);

    public long getFirstId();

    public void setView(IBookView view);

    public void setDao(DAO<Book> dao);


}
