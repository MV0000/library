package com.library.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="Book")
@ToString
@EqualsAndHashCode
public class Book {

    @Id
    @Column(name="bookId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "bookTitle", nullable = false)
    private String bookTitle;

    @Column(name = "bookAuthor", nullable = false)
    private String bookAuthor;

    @Column(name = "releaseDate", nullable = false)
    private int releaseDate;


    public Book() {
    }

    public Book(String bookTitle, String bookAuthor, int releaseDate) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.releaseDate = releaseDate;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getReleaseDate() {
        return releaseDate;
    }
}
