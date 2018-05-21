package storage.servlet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import storage.dao.UserDao;
import storage.domain.User;
import storage.utils.C3P0Utils;
import storage.utils.DataSourceUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz on 2018/4/30.
 */
@WebServlet(name = "LoginServlet" , urlPatterns = "/LoginServlet")
/**
 * 用来检测用户账户是否正确，暂时判断账户名密码相等为正确
 * 之后版本应当连接数据库进行检测
 */
public class LoginServlet extends HttpServlet {
//    private static final  long serialVersionUID = 1l;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserDao userDao = new UserDao();
        List<User> list = userDao.getUser();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        PrintWriter printWriter = response.getWriter();
        request.getSession().setAttribute("loginState", "failed");

        for (User user :
             list) {
            System.out.println("用户:" + user.getUserName() + "  " + user.getPassword());
            if (user.getUserName().equals(userName)) {
                if (user.getPassword().equals(password)) {
                    request.getSession().setAttribute("User", user);
                    request.getSession().setAttribute("LoginState", "success");
                    System.out.println(request.getSession().getAttribute("LoginState"));
                    System.out.println("1");
                    response.sendRedirect("index.jsp");
                    return;

                } else {
                   printWriter.write("<p>密码错误<p>");
                    System.out.println("2");
                    return;
                }

            }
        }
        request.setAttribute("msg", "non-user");
        printWriter.write("<p>没有此用户<p>");
            System.out.println("3");

    }

    //    public void init(){
//        int count = 0;
//        this.getServletContext().setAttribute("count", count);
//
//    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String loginState = "false";
//        String targetUrl = "jsp/loginFailed.jsp";
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("<p>12412</p>");
//        printWriter.write("<h1>12412</h1>");
//        HttpSession httpSession = request.getSession();
//        if(userName == null || userName == ""){
//            loginState = "emptyUserName";
//          httpSession.setAttribute("loginState",loginState);
//        }else if(password == null || password == ""){
//            loginState = "emptyPassword";
//            httpSession.setAttribute("loginState", loginState);
//        }else{
//
//            UserDao userDao = new UserDao();
//            ArrayList<User> userArrayList = userDao.getUserArrayList();
//            for (User user:userArrayList
//                 ) {
//                if(user.getUserName().equals(userName)){
//                    if(user.getPassword().equals(password)){
//                        loginState = "success";
//                        httpSession.setAttribute("loginState", loginState);
//
//                    }else{
//                        loginState = "wrongPassword";
//                        httpSession.setAttribute("loginState", loginState);
//                    }
//                    return;
//                }
//            }
//            loginState = "non-user";
//            httpSession.setAttribute("loginState", loginState);
//        }
//        try{
//            C3P0Utils c3P0Utils = new C3P0Utils();
//            Connection connection = c3P0Utils.getConnection();
//            String sql = "select name,password from user where name = ?";
//            ServletContext application = this.getServletContext();
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, userName);
//            ResultSet resultSet = statement.executeQuery(sql);
//
//
//            if(!resultSet.next()){
//                System.out.println("zz");
//                request.setAttribute("loginState", loginState);
//                response.getWriter().write("<h1>Sorry, we don't have this user<h1>");
//
//            }
//            else{
//                System.out.println("zz1");
//                String passwordInDB = resultSet.getString("password");
//                if(passwordInDB == password){
//                    int count = (int)application.getAttribute("count");
//                    count++;
//                    application.setAttribute("count", count);
//                    response.getWriter().write("<h1>welcome,你是第" + count + "位<h1>");
//                    HttpSession httpSession = request.getSession();
//                    httpSession.setAttribute("name", userName);
//                }
//                else{
//                    System.out.println("zz2");
//                    request.setAttribute("loginState", loginState);
//                    printWriter.write("<h1>Sorry, wrong password<h1>");
//                }
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//        }catch (Exception e){
//
//        }
//        if (userName == password){
//            System.out.println("zzz");
//        }
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
