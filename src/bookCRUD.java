import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookCRUD {

    //Method for adding a book into the database
    public static void addBook(Book book) {

        String sql = "Insert into books(id, title, author, genre) VALUES (?, ?, ?, ?)";

        try{
            Connection connection = databaseUtil.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4,  book.getGenre());
            preparedStatement.executeUpdate();


        }catch(SQLException e) {
            e.printStackTrace();

        }
    }

    //Method for removing a book from the database

    public static void removeBook(int bookId) {

        String sql = "DELETE FROM books where id = ?";

        try{
            Connection connection = databaseUtil.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, bookId);

            preparedStatement.executeUpdate();


        }catch(SQLException e) {

            e.printStackTrace();
        }
    }
    //Method for updating a book in the database

    public static void updateBook(Book book) {
        String sql = "UPDATE books SET Title = ?, Author = ?, Genre = ? WHERE id = ?";

        try{
            Connection connection = databaseUtil.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setInt(4, book.getId());

            preparedStatement.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();

        }
    }
    //Method for a list of all books in the database

    public static List<Book> allBooks() {

        List<Book> books  = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try{

            Connection connection = databaseUtil.getconnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");

                books.add(new Book(id, title, author, genre));

            }

        }catch(SQLException e) {

            e.printStackTrace();

        }
        return books;
    }
}
