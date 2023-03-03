package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			RequestDispatcher rd=req.getRequestDispatcher("");  
	        rd.include(req,resp);
		}
		else
		{
			out.print("Sorry username or password error");  
	        RequestDispatcher rd=req.getRequestDispatcher("Login.html");  
	        rd.include(req,resp); 
		}
		ps.close();
		out.close();
    }
    catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
