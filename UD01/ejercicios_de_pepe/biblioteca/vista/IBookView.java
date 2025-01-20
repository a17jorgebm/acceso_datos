package com.pepinho.programacion.biblioteca.view;

public interface IBookView {

    public void setBookTitle(String title);

    public void setAuthor(String author);

    public void setISBN(String isbn);

    public void setYear(int year);

    public void setAvailable(boolean available);

    public void setCover(byte[] cover);

    public void setID(int id);

    public void setVisible(boolean visible);


}
