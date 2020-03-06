package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.dao.LibraryDao;
import com.library.model.LibraryManagement;

@CrossOrigin
@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryDao libraryDao;
	private LibraryManagement library;

	// insert method
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public void insertBook(@RequestBody LibraryManagement library) {
		libraryDao.insertBook(library);
	}

	// method to list the all book details
	@RequestMapping(value = "/bookdetails", method = RequestMethod.GET)
	public List bookList() {
		List list = libraryDao.listBookDetails();
		return list;

	}

	// search the book details by id
	@RequestMapping(value = "/bookid/{isbnNo}", method = RequestMethod.GET)
	public LibraryManagement getBook(@PathVariable("isbnNo") Integer isbnNo) {
		System.out.println("Search librarybooks by id");
		return library = libraryDao.searchBook(isbnNo);

	}

	// search the book details by name
	@RequestMapping(value = "/bookname/{bookTitle}", method = RequestMethod.GET)
	public LibraryManagement getBookName(
			@PathVariable("bookTitle") String bookName) {
		System.out.println("Search librarybooks by name");
		return library = libraryDao.searchBookName(bookName);

	}

	// update values
	@RequestMapping(value = "/bookupdate/{isbnNo}", method = RequestMethod.PUT)
	public void updateBook(@RequestBody LibraryManagement library,
			@PathVariable("isbnNo") Integer isbnNo) {
		System.out.println("update values");

		libraryDao.UpdateBookdetails(library, isbnNo);

	}

	// delete bookdetails
	@RequestMapping(value = "/bookdelete/{isbnNo}", method = RequestMethod.PUT)
	public void deleteBook(@PathVariable("isbnNo") Integer isbnNo) {
		System.out.println("delete values");

		libraryDao.deleteBook(isbnNo);

	}

}
