package eKart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form parameters
		String username = request.getParameter("username");
		String email = request.getParameter("email");

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
			

			User user = new User();
			user.setUsername(username);
			user.setEmail(email);

			session.save(user);

			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// For simplicity, just print the data to the console
		System.out.println("Username: " + username);
		System.out.println("Email: " + email);

		// Forward to a confirmation page or send a response
		request.setAttribute("username", username);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}
}
