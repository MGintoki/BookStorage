package storage.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import storage.domain.Category;
import storage.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;



public class CatDao {

    private ArrayList<Category> categoryArrayList = new ArrayList<>();

    public ArrayList<Category> getCatList(){
        try{
            C3P0Utils c3P0Utils = new C3P0Utils();

            QueryRunner queryRunner = new QueryRunner(c3P0Utils.getDataSource());
            String sql = "select * from category";
            Object[] params = {};


            categoryArrayList = (ArrayList<Category>) queryRunner.query(sql, new BeanListHandler<Category>(Category.class));


        }catch (Exception e){
            throw new RuntimeException(e);
        }


        return categoryArrayList;
    }
   /*public ArrayList<Category> getCatList(){

       try{
            Class.forName("com.mysql.jdbc.Driver");
           Connection connection = DriverManager.getConnection("jdbc:mysql://140.143.24.47:3306/goods", "gy", "gy666@888");
           String sql = "select * from Category";
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);
           while(resultSet.next()){
               Category category = new Category();
               category.setCid(resultSet.getInt("cid"));
               category.setcName(resultSet.getString("cName"));
               category.setcDescription(resultSet.getString("cDescription"));
               categoryArrayList.add(category);
           }
           resultSet.close();
           statement.close();
           connection.close();

       }catch (Exception e){
           throw new RuntimeException(e);
       }
       return categoryArrayList;
   }*/
}
