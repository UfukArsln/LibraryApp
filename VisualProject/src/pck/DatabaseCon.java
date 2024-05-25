package pck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;


public class DatabaseCon {
	
	public Connection getConnected() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/visualdatabase","root","ufuk123");
		
	}
	
    public ArrayList<User> getUsers() throws SQLException{
		
		Statement st = getConnected().createStatement();
		ResultSet rs =  st.executeQuery("select * from users");
		ArrayList<User> users = new ArrayList<User>();
		
		while( rs.next() ) {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setEmail(rs.getString(2));
			user.setName(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setRole(rs.getString(5));
			users.add(user);
			
		}
		return users;
	}
    
    public void saveUser(User u) throws SQLException {
		
		String query = "insert into users (Email,UserName,UserPassword,UserRole) values(?,?,?,?)";
		PreparedStatement ps = getConnected().prepareStatement(query);
		ps.setString(1,u.getEmail() );
		ps.setString(2,u.getName() );
		ps.setString(3,u.getPassword() );
		ps.setString(4,u.getRole() );
		
		ps.executeUpdate();
	}
    
    public ArrayList<Author> getAuthors() throws SQLException{
		
		Statement st = getConnected().createStatement();
		ResultSet rs =  st.executeQuery("select * from authors");
		ArrayList<Author> authors = new ArrayList<Author>();
		
		while( rs.next() ) {
			Author a = new Author();
			a.setAuthorId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setSurname(rs.getString(3));
			authors.add(a);
			
		}
		return authors;
	}
    
    public void saveAuthor(Author a) throws SQLException {
		
 		String query = "insert into authors (AuthorName,AuthorSurname) values(?,?)";
 		PreparedStatement ps = getConnected().prepareStatement(query);
 		ps.setString(1,a.getName() );
 		ps.setString(2,a.getSurname() );
 		ps.executeUpdate();
 	}
    
    public ArrayList<Books> getBooks() throws SQLException{
		
		Statement st = getConnected().createStatement();
		ResultSet rs =  st.executeQuery("select * from books");
		ArrayList<Books> books = new ArrayList<Books>();
		
		while( rs.next() ) {
			Books b = new Books();
			b.setBookId(rs.getInt(1));
			b.setAuthorId(rs.getInt(2));
			b.setTitle(rs.getString(3));
			b.setStatus(rs.getString(4));
			
			books.add(b);
			
		}
		return books;
	}
    
    public void saveBook(Books b) throws SQLException {
		
 		String query = "insert into books (AuthorId,Title,BookStatus) values(?,?,?)";
 		PreparedStatement ps = getConnected().prepareStatement(query);
 		ps.setInt(1,b.getAuthorId());
 		ps.setString(2,b.getTitle());
 		ps.setString(3,b.getStatus());
 		ps.executeUpdate();
 	}
    
    public ArrayList<String> getAuthorName() throws SQLException{
		
		Statement st = getConnected().createStatement();
		ResultSet rs =  st.executeQuery("select name,surname from authors");
		ArrayList<String> comboBox = new ArrayList<String>();

          while(rs.next()){
              String name = rs.getString("name");
              String surname = rs.getString("surname");
              comboBox.add(name+" "+surname);
          }
		return comboBox;
	}
    
    public ArrayList<Books> getUserBooks(int id) throws SQLException{
		
  		Statement st = getConnected().createStatement();
  		ResultSet rs =  st.executeQuery("select BookId from userbooks where UserId = "+id);  		
  		
  		
  		ArrayList<Books> books = new ArrayList<Books>();
  		
  		while( rs.next() ) {
  	       
  			int bookId = rs.getInt("BookId");
  	        
  			Statement st2 = getConnected().createStatement();
  			ResultSet rs2 =  st2.executeQuery("select * from books where BookId = " + bookId);  
  			
  			while (rs2.next()) {
  			Books b = new Books();
  			b.setBookId(rs2.getInt(1));
  			b.setAuthorId(rs2.getInt(2));
  			b.setTitle(rs2.getString(3));
  			b.setStatus(rs2.getString(4));
  			
  			books.add(b);
  			}
  		}
  		return books;
  	}
    
    
    
    
	
	

}
