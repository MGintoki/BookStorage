package storage.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import storage.domain.Book;
import storage.domain.Category;
import storage.utils.C3P0Utils;

import java.sql.*;
import java.util.ArrayList;


public class BookDao {

    private ArrayList<Book> bookArrayList = new ArrayList<>();

   /* public ArrayList<Book> getBookArrayList(int cid){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://140.143.24.47:3306/goods", "gy", "gy666@888");
            Statement statement = connection.createStatement();
            String sql = "select * from book where cid = " + cid + "";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Book book = new Book();
                book.setBid(resultSet.getInt("bid"));
                book.setCid(resultSet.getInt("bid"));
                book.setAuthor(resultSet.getString("author"));
                book.setName(resultSet.getString("name"));
                book.setDescription(resultSet.getString("description"));
                book.setPrice(resultSet.getDouble("price"));

                bookArrayList.add(book);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return bookArrayList;
    }*/
   public ArrayList<Book> getBookArrayList(int cid) {

       try {
           C3P0Utils c3P0Utils = new C3P0Utils();
           QueryRunner queryRunner = new QueryRunner(c3P0Utils.getDataSource());

           String sql = "select * from book where cid = " + cid + "";
           Object[] params = {};
           bookArrayList = (ArrayList) queryRunner.query(sql, new BeanListHandler<Book>(Book.class), params);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       return bookArrayList;

   }

   public ArrayList<Book> getAllBook(){
       ArrayList<Book> books = new ArrayList<>();
       try {
           C3P0Utils c3P0Utils = new C3P0Utils();
           QueryRunner queryRunner = new QueryRunner(c3P0Utils.getDataSource());

           String sql = "select * from book";
           Object[] params = {};
           books = (ArrayList) queryRunner.query(sql, new BeanListHandler<Book>(Book.class), params);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       return books;
   }
    public void addBook(Book book){
        try {
            C3P0Utils c3P0Utils = new C3P0Utils();
            QueryRunner queryRunner = new QueryRunner(c3P0Utils.getDataSource());

            String sql = "insert into book values(?, ?, ?, ?, ?, ? ,?)";
            PreparedStatement ps  = c3P0Utils.getConnection().prepareStatement(sql);
            ps.setInt(1, book.getBid());
            ps.setInt(2, book.getCid());
            ps.setString(3, book.getName());
            ps.setString(4, book.getAuthor());
            ps.setDouble(5, book.getPrice());
            ps.setString(6, book.getImg());
            ps.setString(7, book.getDescription());

            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

   public Book getBook(int bid){
       Book book = new Book();
       try {
           C3P0Utils c3P0Utils = new C3P0Utils();
           QueryRunner queryRunner = new QueryRunner(c3P0Utils.getDataSource());

           String sql = "select * from book where bid = " + bid + "";
           Object[] params = {};
           book = queryRunner.query(sql, new BeanHandler<Book>(Book.class));
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       return book;
   }

    public static void main(String[] args) {


    }

}
