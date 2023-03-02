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
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    String email=req.getParameter("email");
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
	String mob=req.getParameter("mob");
	String gen=req.getParameter("gender");
	String passwd=req.getParameter("psw");
    try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
	    String query="insert into pawan.commerence values(?,?,?,?,?,?)";
		Connection con=DriverManager.getConnection(url);
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,email);
		ps.setString(2,fname);
		ps.setString(3,lname);
		ps.setString(4,mob);
		ps.setString(5, gen);
		ps.setString(6,passwd);
		ps.executeUpdate();
		out.println("confirm the datails");
		int i=ps.executeUpdate();
		if(i>0)
		{
			out.println("you are successfully regesitered");
		}
		out.println("<tr>" + "<td>" + email + "</td>" + "<td>" + fname + "</td>" + "<td>" + lname + "</td>"
                + "<td>" + mob + "</td>" + "<td>" + gen + "</td>" + "<td>" + passwd
                + "</td></tr>");
    }
    catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
