package com.library.repository;


import com.library.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setBookId(rs.getInt("bookId"));
		book.setBookTitle(rs.getString("title"));
		book.setBookAuthor(rs.getString("author"));
		book.setReleaseDate(rs.getInt("releaseDate"));
		return book;
	}

}