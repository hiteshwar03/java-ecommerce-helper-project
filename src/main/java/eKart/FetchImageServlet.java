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

import eKart.entities.Category;
import eKart.entities.Product;
import eKart.entities.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

@WebServlet("/image")
public class FetchImageServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int productid = Integer.parseInt(request.getParameter("id"));
		 Product product = null;
			try {
				Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
				Transaction transaction = session.beginTransaction();
	
				 product = session.get(Product.class, productid); 
				
				transaction.commit();
				
				if (product != null) {

	                response.setContentType(product.getImageType());
	                response.setContentLength(product.getImageData().length);
	                
	             // Write the image data to the response output stream
	                response.getOutputStream().write(product.getImageData());
	                
	            } else {
	                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Content not found");
	            }
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
	}
}
