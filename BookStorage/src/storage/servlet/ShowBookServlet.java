package storage.servlet;

import storage.dao.BookDao;
import storage.domain.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by zzz on 2018/5/1.
 */
@WebServlet(name = "ShowBookServlet")
public class ShowBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        ArrayList<Book> bookArrayList = bookDao.getBookArrayList(Integer.parseInt(request.getParameter("cid")));
        if(bookArrayList != null){
            PrintWriter pw = response.getWriter();
            pw.write("<ul>");

            for (Book b:bookArrayList
                 ) {
                pw.write("<li class=\"item\"" + "id=" + ("" + b.getBid()) + ">");
                pw.write("<div class=\"info\">");
                pw.write("<img src=\"../image/" + b.getAuthor() +  "\" alt=\"pic\">");
                pw.write("<p class=\"book-name\">" + b.getName() + "</p>");
                pw.write("<p class=\"price\">");
                pw.write("          <a class=\"search_discount\" style=\"text-decoration:none;\">定价：</a>\n" +
                        "          <span class=\"search_pre_price\">¥"+b.getPrice() +"</span></p>");
                pw.write("          <a class=\"search_discount\" style=\"text-decoration:none;\">描述：</a>\n"
                        + "<p class=\"detail\">"+b.getDescription() +"</p>");

                pw.write("</div>");
                pw.write("</li>");
            }
            pw.write("</ul>");
        }

    }
}
