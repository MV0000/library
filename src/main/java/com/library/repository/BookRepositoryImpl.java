package com.library.repository;

import com.library.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class BookRepositoryImpl implements BookRepository {

//    @Autowired
//    private SessionFactory sessionFactory;

    private EntityManager entityManager;

    @Autowired
    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




//    private List<Book> books = new ArrayList<Book>();

    @Override
    @Transactional
    public void saveBook(Book bookToSave) {

        Session session = entityManager.unwrap(Session.class);
        session.save(bookToSave);

    }

    @Override
    @Transactional
    public List<Book> findAll() {

        Session session = entityManager.unwrap(Session.class);

        Query<Book> query = session.createQuery("from Book", Book.class);

        List<Book> books = query.getResultList();

        return books;
    }

    @Override
    @Transactional

    public List<Book> findBooksByTitle(String bookTitle) {
        return null;
    }

    @Override
    @Transactional

    public List<Book> findBookByAuthor(String bookAuthor) {
        return null;
    }

    @Override
    public Book findBookByBookId(int bookId) {
        return null;
    }

}
