package eKart;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import eKart.entities.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form parameters
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		long phone = Long.parseLong(request.getParameter("phone"));
		String addr = request.getParameter("address");
		String usertype = request.getParameter("usertype");
		Date createdOn=new Date();

			// store data using hibernate
			try {
	
	
	//			Configuration cfg=new Configuration().configure().addAnnotatedClass(User.class);
	//			SessionFactory sessionFactory=cfg.buildSessionFactory();
	//			Session session=sessionFactory.openSession();
														//OR
	//			Session session=new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory().openSession();
														//OR
				Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
				
				
				
				Transaction transaction = session.beginTransaction();
	
				User user = new User(name, email, pwd, phone, addr, usertype, createdOn);
					
				session.save(user);
	
				transaction.commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		


		// Forward to a confirmation page or send a response
		request.setAttribute("name", name);
		request.setAttribute("date", createdOn);
		
		request.getRequestDispatcher("/frontend/success.jsp").forward(request, response);
	}
}
