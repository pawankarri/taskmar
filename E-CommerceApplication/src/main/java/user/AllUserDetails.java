package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/AllUserDetails")
public class AllUserDetails extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
	    out.println("<html><body>");
	     out.println("<h3>Fetching All Details</h3>");
	     out.println("<table border=1><tr>" + "<td><b>E-MAIL</b></td>" + "<td><b>FIRSTNAME</b></td>"
	             + "<td><b>LASTNAME</b></td>" + "<td><b>MOBILENUMBER</b></td>"
	             + "<td><b>GENDER</b></td>" + "<td><b>PASSWORD</b></td></tr>");
	     String url="jdbc:mysql://localhost:3306?user=root&password=12345";
			String query="select * from pawan.commerence";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url);
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String email=rs.getString(1);
					String fname=rs.getString(2);
					String lname=rs.getString(3);
					String mob=rs.getString(4);
					String gen=rs.getString(5);
					String passwd=rs.getString(6);
					out.println("<tr>" + "<td>" + email + "</td>" + "<td>" + fname + "</td>" + "<td>" + lname + "</td>"
	                        + "<td>" + mob + "</td>" + "<td>" + gen + "</td>" + "<td>" + passwd
	                        + "</td></tr>");
				}
				out.println("</table></body></html>");
				 rs.close();
		            ps.close();
		            out.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
}
	}
}
