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

public class ChangePassword extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String oldpsw,newpsw,qr;
		newpsw=request.getParameter("npsw");
		oldpsw=request.getParameter("cpsw");
		qr="update user set password='"+newpsw+"' where password=?";
		try
		{
			Connection con=null;
			PreparedStatement pst=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
			pst=con.prepareStatement(qr);
			pst.setString(1,oldpsw);
			int n=pst.executeUpdate();
			if(n>0)
			{
				out.println("<html><head><style>body{background-color:#39A6A3; color:white;} </style></head><body>");
				out.println("<h1>Password Updated Successfully!!..</h1>");
				out.println("<br><a href='changePassword.jsp'>Home</a>");
				out.println("</body></html>");
			}
			else
			{
				out.println("<html><head><style>body{background-color:#39A6A3; color:white;} </style></head><body>");
				out.println("<h1>Sorry try again...!<h1>");
				out.println("<br><a href='changePassword.jsp'>Home</a>");
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
