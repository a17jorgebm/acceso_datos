package com.pepinho.programacion.biblioteca.view;

import com.pepinho.programacion.biblioteca.controller.IBookController;

public class BookViewCutre implements IBookView {

    private IBookController controller;

    public BookViewCutre(IBookController controller){
        this.controller = controller;
        this.controller.setView(this);

        this.controller.getBook(controller.getFirstId());
    }

    @Override
    public void setBookTitle(String title) {
        System.out.println("title = " + title);
    }

    @Override
    public void setAuthor(String author) {
        System.out.println("author = " + author);
    }

    @Override
    public void setISBN(String isbn) {
        System.out.println("isbn = " + isbn);
    }

    @Override
    public void setYear(int year) {
        System.out.println("year = " + year);
    }

    @Override
    public void setAvailable(boolean available) {
        System.out.println("available = " + available);
    }

    @Override
    public void setCover(byte[] cover) {
//        System.out.println("cover = " + cover);
    }

    @Override
    public void setID(long id) {
        System.out.println("id = " + id);
    }

    @Override
    public void setVisible(boolean visible) {
        System.out.println("visible = " + visible);
    }
}
