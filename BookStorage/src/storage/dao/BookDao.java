package storage.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import storage.domain.Book;
import storage.domain.Category;
import storage.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by zzz on 2018/5/1.
 */
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


}
