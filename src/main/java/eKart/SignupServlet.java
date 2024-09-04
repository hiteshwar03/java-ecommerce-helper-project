package eKart;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import eKart.entities.User;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/signup")
@MultipartConfig 
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
		Part filePart = request.getPart("image");

		String imageType = "image/jpeg"; // Default MIME type
		if (filePart != null) {
            String imageName = filePart.getSubmittedFileName();
            imageType = filePart.getContentType(); // Get the MIME type of the uploaded file
            
            InputStream imageInputStream = filePart.getInputStream();
            byte[] imageData = imageInputStream.readAllBytes(); // Convert InputStream to byte array
            
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
	
				User user = new User(name, email, pwd, phone, addr, usertype, usertype, imageName, imageData, imageType);
	//			user.setUsername(username);
	//			user.setEmail(email);
	
				session.save(user);
	
				transaction.commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			 response.getWriter().write("No image uploaded");
		}


		// Forward to a confirmation page or send a response
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("/frontend/success.jsp").forward(request, response);
	}
}
