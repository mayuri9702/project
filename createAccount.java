import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class createAccount extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String nm,email,pass,qr;
		nm=request.getParameter("name");
		email=request.getParameter("email");
		pass=request.getParameter("password");
		qr="insert into user values(?,?,?)";
		try
		{
			Connection con=null;
			PreparedStatement pst=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			pst=con.prepareStatement(qr);
			pst.setString(1, nm);
			pst.setString(2, email);
			pst.setString(3, pass);
			int n=pst.executeUpdate();
			if(n>0)
			{
				out.println("<html><head><style>body{background-color:#39A6A3; color:white;} </style></head><body>");
				out.println("<h1>Account Created successfully!!..</h1>");
				out.println("<br><a href='createAccount.html'>Home</a>");
				out.println("</body></html>");
			}
			else
			{
				out.println("<html><head><style>body{background-color:#39A6A3; color:white;} </style></head><body>");
				out.println("<h1>Sorry try again...!<h1>");
				out.println("<br><a href='createAccount.html'>Home</a>");
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
