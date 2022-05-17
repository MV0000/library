package com.library.repository;

import com.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Book> findAll() {

        String jpql = "SELECT c FROM Book c";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveBook(Book bookToSave) {

        entityManager.persist(bookToSave);

    }

    @Override
    @Transactional
    public Book findBookByBookId(int bookId) {
        return entityManager.find(Book.class, bookId);
    }

    @Override
    public void deleteById(int bookId) {
        Book book = entityManager.find(Book.class, bookId);
        entityManager.remove(book);
    }

    @Override
    public List<Book> findBooksByTitle(String bookTitle) {

        String jpql = "SELECT c FROM Book c where bookTitle = :bookTitle";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        query.setParameter("bookTitle", bookTitle);
        return query.getResultList();
    }

    @Override
    public List<Book> findBooksByAuthor(String bookAuthor) {

        String jpql = "SELECT c FROM Book c where bookAuthor = :bookAuthor";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        query.setParameter(bookAuthor, bookAuthor);
        return query.getResultList();
    }


}
