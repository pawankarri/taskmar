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
@WebServlet("/RegesiterUser")
public class RegesiterUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

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
				
				int i=ps.executeUpdate();
				if(i>0)
				{
					
					
					out.println("<html><body><br>");
					out.println("Click here to Login with your credentials  "+"<br>");
					out.println("<a href=\"Login.html\">LOGIN</a>"+" <br>");
					out.println("you are successfully regesitered with following details"+"<br>");
					out.println("<div>");
				   out.println("<table border=1><tr>" + "<td><b>E-MAIL</b></td>" + "<td><b>FIRSTNAME</b></td>"
				             + "<td><b>LASTNAME</b></td>" + "<td><b>MOBILENUMBER</b></td>"
				             + "<td><b>GENDER</b></td>" + "<td><b>PASSWORD</b></td></tr>");
					out.println("<tr>" + "<td>" + email + "</td>" + "<td>" + fname + "</td>" + "<td>" + lname + "</td>"
			                + "<td>" + mob + "</td>" + "<td>" + gen + "</td>" + "<td>" + passwd
			                + "</td></tr>");
					out.println("</div>");
					
				}
				
				
				
				out.println("</body></html>");
		    }
		    
		    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}

}
