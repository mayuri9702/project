import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class signup extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email,pass,qr;
		email=request.getParameter("email");
		pass=request.getParameter("password");
		qr="select email from user where email=? and password=?";
		try
		{
			HttpSession session=request.getSession();
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			pst=con.prepareStatement(qr);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs=pst.executeQuery();
			if(rs.next())
			{
				out.println("<html><head><style>body{background-color:#39A6A3; color:white;} </style></head><body>");
				out.println("<h1>Sign Up Successfully..</h1>");
				out.println("<br><a href='changePassword.jsp'>Change Password</a><br>");
				out.println("<br><a href='signup.html'>Home</a>");
				out.println("</body></html>");
			}
			else
			{
				out.println("<html><head><style>body{background-color:#39A6A3; color:white;} </style></head><body>");
				out.println("<h2><font color='red'>Password Failed..!</font><br>Try Again..</h2>");
				out.println("<br><a href='signup.html'>Home</a>");
				out.println("</body></html>");
			}
			pst.close();
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.close();
	}
}
