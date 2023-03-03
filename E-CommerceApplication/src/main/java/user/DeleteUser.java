package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
	 String email=req.getParameter("email");
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		 String query="delete * from pawan.commerence where EMAIL=?";
		 Connection con=DriverManager.getConnection(url);
		 PreparedStatement ps=con.prepareStatement(query);
          ps.setString(1,email);
          ps.executeUpdate();
          out.close();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
}
}
