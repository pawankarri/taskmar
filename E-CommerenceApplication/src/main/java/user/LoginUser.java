package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter();
	    String url="jdbc:mysql://localhost:3306?user=root&password=12345";
	    String query="select * from pawan.commerence where EMAIL=? and PASSWORD=?";
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(query);
			String email=req.getParameter("email");
			String passwd=req.getParameter("psw");
			ps.setString(1,email);
			ps.setString(2,passwd);
			ps.executeUpdate();
			ps.close();
			out.close();
	    }
	    catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
