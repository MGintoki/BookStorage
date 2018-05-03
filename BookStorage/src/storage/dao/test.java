package storage.dao;

import storage.domain.Book;
import storage.domain.Category;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zzz on 2018/5/1.
 */
public class test {
    public static void main(String[] args) {
        BookDao BookDao = new BookDao();
        ArrayList<Book> books = BookDao.getBookArrayList(2);
        for (Book book:books
             ) {
            System.out.println(book.getBid());
        }
        CatDao catDao = new CatDao();
        ArrayList<Category> categories = catDao.getCatList();
        for(Category category : categories){
            System.out.println(category.getCid() + category.getcDescription() + category.getcName());
        }
    }
}
