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
@WebServlet("/EditUserDetails")
public class EditUserDetails  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 PrintWriter out = resp.getWriter();
	     out.println("<html><body>");
		     String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		     String omail=req.getParameter("omail");
		     String nmail=req.getParameter("nmail");
		     String fname=req.getParameter("fname");
		     String lname=req.getParameter("lname");
		     String mob=req.getParameter("mob");
		     String gender=req.getParameter("gender");
		     String pswd=req.getParameter("pswd");
				String query="update pawan.commerence set EMAIL=?,FIRSTNAME=?,LASTNAME=?,MOBILENUMBER=?,GENDER=?,PASSWORD=? where EMAIL=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection(url);
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,nmail);
					ps.setString(2,fname);
					ps.setString(3,lname);
					ps.setString(4,mob);
					ps.setString(5,gender);
					ps.setString(6,pswd);
					ps.setString(7,omail);
					int i=ps.executeUpdate();
					if(i>0)
					{
						out.println("your records updated");
					}
					else
					{
						out.println("invalid old mail");
					}
					out.println("</table></body></html>");
			            ps.close();
			            out.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	}
}
}
