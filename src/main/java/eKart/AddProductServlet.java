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

import eKart.entities.Category;
import eKart.entities.Product;
import eKart.entities.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@WebServlet("/add-product")
@MultipartConfig 
public class AddProductServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form parameters
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		int price = Integer.parseInt(request.getParameter("price"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		int  qty = Integer.parseInt(request.getParameter("qty"));
		String category_id = request.getParameter("category_id");
		
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
				
				Category category=session.get(Category.class, category_id);
	
				Product product=new Product(name, desc, price, discount, qty, category, imageName, imageData, imageType);
	
				session.save(product);
	
				transaction.commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			 response.getWriter().write("No image uploaded");
		}


		// Forward to a confirmation page or send a response
//		request.setAttribute("product", product);
		
		request.getRequestDispatcher("/frontend/success.jsp").forward(request, response);
	}
}
