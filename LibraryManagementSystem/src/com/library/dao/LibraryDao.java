package com.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.library.model.LibraryManagement;

public class LibraryDao {

	// variable to insert the values into library
	private static String INSERTLIBRARY = "INSERT INTO LIBRARY(BOOKTITLE,AUTHORNAME,QUANTITY,PURCHASEDATE,EDITION,PRICE,NOOFPAGES,PURCHASERNAME,PURCHASERADDRESS,EMAILID,PHONE,ISACTIVE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

	// variable to list the library details
	private static String DISPLAYLIBRARY = "SELECT * FROM LIBRARY";

	// Variable to search the book details by id
	private static String SEARCHBYID = "SELECT * FROM LIBRARY WHERE ISBNNO=?";

	// Variable to search the book details by book name;
	private static String SEARCHBYNAME = "SELECT * FROM LIBRARY WHERE BOOKTITLE=?";

	// variable to delete the book details
	private static String DELETELIBRARY = "UPDATE LIBRARY SET ISACTIVE=FALSE WHERE ISBNNO=?";

	// variable to update the book details
	private static String UPDATELIBRARY = "UPDATE LIBRARY SET BOOKTITLE=?,AUTHORNAME=?,QUANTITY=?,PURCHASEDATE=?,EDITION=?,PRICE=?,NOOFPAGES=?,PURCHASERNAME=?,PURCHASERADDRESS=?,EMAILID=?,PHONE=?,ISACTIVE=? WHERE ISBNNO=?";

	// jdbctemplate object
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// method to insert the values into book details
	public void insertBook(final LibraryManagement library) {
		jdbcTemplate.execute(INSERTLIBRARY,
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(
							PreparedStatement statement) throws SQLException,
							DataAccessException {

						// date format to inserting to the mysql
						SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
						// calling the purchase date
						String purchaseDate = ft.format(library
								.getPurchaseDate());
						// setting the values
						statement.setString(1, library.getBookTitle());
						statement.setString(2, library.getAuthorName());
						statement.setInt(3, library.getQuantity());
						statement.setString(4, purchaseDate);
						statement.setString(5, library.getEdition());
						statement.setInt(6, library.getPrice());
						statement.setInt(7, library.getNoOfpages());
						statement.setString(8, library.getPurchaserName());
						statement.setString(9, library.getPurchaserAddress());
						statement.setString(10, library.getEmailId());
						statement.setString(11, library.getPhone());
						statement.setBoolean(12, library.getIsActive());
						return statement.execute();
					}

				});
	}

	// method to list the all values
	public List<LibraryManagement> listBookDetails() {
		List<LibraryManagement> libraryList = jdbcTemplate.query(
				DISPLAYLIBRARY, new LibraryMapper());
		return libraryList;
	}

	// employee mapper to get the one by one values from database

	public class LibraryMapper implements RowMapper<LibraryManagement> {

		@Override
		public LibraryManagement mapRow(ResultSet resultSet, int rowNumber)
				throws SQLException {
			// object of library management
			LibraryManagement libraryManagement = new LibraryManagement();
			// set the values to the model
			libraryManagement.setIsbnNo(resultSet.getInt("ISBNNO"));
			libraryManagement.setBookTitle(resultSet.getString("BOOKTITLE"));
			libraryManagement.setAuthorName(resultSet.getString("AUTHORNAME"));
			libraryManagement.setQuantity(resultSet.getInt("QUANTITY"));
			libraryManagement
					.setPurchaseDate(resultSet.getDate("PURCHASEDATE"));
			libraryManagement.setEdition(resultSet.getString("EDITION"));
			libraryManagement.setPrice(resultSet.getInt("PRICE"));
			libraryManagement.setNoOfpages(resultSet.getInt("NOOFPAGES"));
			libraryManagement.setPurchaserName(resultSet
					.getString("PURCHASERNAME"));
			libraryManagement.setPurchaserAddress(resultSet
					.getString("PURCHASERADDRESS"));
			libraryManagement.setEmailId(resultSet.getString("EMAILID"));
			libraryManagement.setPhone(resultSet.getString("PHONE"));
			libraryManagement.setIsActive(resultSet.getBoolean("ISACTIVE"));

			return libraryManagement;
		}

	}

	// method to search the book details by id
	public LibraryManagement searchBook(Integer isbnNo) {
		return jdbcTemplate.queryForObject(SEARCHBYID, new Object[] { isbnNo },
				new LibraryMapper());
	}

	// method to search the book details by name
	public LibraryManagement searchBookName(String bookName) {
		return jdbcTemplate.queryForObject(SEARCHBYNAME,
				new Object[] { bookName }, new LibraryMapper());
	}

	//method to delete the book details
	public void deleteBook(final Integer isbnNo) {

		jdbcTemplate.execute(DELETELIBRARY,
				new PreparedStatementCallback<Boolean>() {

					public Boolean doInPreparedStatement(
							PreparedStatement statement) throws SQLException,
							DataAccessException {
		
						statement.setInt(1, isbnNo);
						return statement.execute();

					}
				});

	}

	public void UpdateBookdetails(final LibraryManagement library,
			final Integer isbnNo) {

		jdbcTemplate.execute(UPDATELIBRARY,
				new PreparedStatementCallback<Boolean>() {

					public Boolean doInPreparedStatement(
							PreparedStatement statement) throws SQLException,
							DataAccessException {

						// date format to inserting to the mysql
						SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
						// calling the purchase date
						String purchaseDate = ft.format(library
								.getPurchaseDate());

						statement.setString(1, library.getBookTitle());
						statement.setString(2, library.getAuthorName());
						statement.setInt(3, library.getQuantity());
						statement.setString(4, purchaseDate);
						statement.setString(5, library.getEdition());
						statement.setInt(6, library.getPrice());
						statement.setInt(7, library.getNoOfpages());
						statement.setString(8, library.getPurchaserName());
						statement.setString(9, library.getPurchaserAddress());
						statement.setString(10, library.getEmailId());
						statement.setString(11, library.getPhone());
						statement.setBoolean(12, library.getIsActive());
						statement.setInt(13, isbnNo);
						return statement.execute();

					}
				});

	}

}
