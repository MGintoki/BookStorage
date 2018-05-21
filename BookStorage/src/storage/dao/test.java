package storage.dao;

import storage.domain.Book;
import storage.domain.Category;
import storage.domain.User;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zzz on 2018/5/1.
 */
public class test {
    public static void main(String[] args) {
       BookDao bookDao = new BookDao();

        ArrayList<Book> books = bookDao.getBookArrayList(1);
        for (Book b :
                books) {
            System.out.println(b.getAuthor());
        }
    }

}
