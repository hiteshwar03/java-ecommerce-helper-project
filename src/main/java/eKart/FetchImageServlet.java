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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/image")
public class FetchImageServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int id = Integer.parseInt(request.getParameter("id"));
			User user =null;
			// store data using hibernate
			try {
				Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
				Transaction transaction = session.beginTransaction();
	
				
				// Fetch the entity with ID 1
//	            int id = 2;
	            user = session.get(User.class, id);
	            System.out.println(user);
//	            byte[] imageData = user.getImageData();
				transaction.commit();
				
				if (user != null) {

	                response.setContentType(user.getImageType());
	                response.setContentLength(user.getImageData().length);
	                
	             // Write the image data to the response output stream
	                response.getOutputStream().write(user.getImageData());
	                
//	                request.getRequestDispatcher("/frontend/show.jsp").forward(request, response);
	            } else {
	                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Content not found");
	            }
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
	}
}
