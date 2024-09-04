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
import eKart.entities.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@WebServlet("/add-category")
public class AddCategoryServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form parameters
		String name = request.getParameter("category_name");
		String desc = request.getParameter("category_desc");

			// store data using hibernate
			try {
	
				Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
				Transaction transaction = session.beginTransaction();
	
				Category category=new Category();
				category.setCategoryTitle(name);
				category.setCategoryDescription(desc);
				
				session.save(category);
	
				transaction.commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
			System.out.println(name+":"+desc);

		// Forward to a confirmation page or send a response
		request.setAttribute("name", name);
		System.out.println("add category successfully");
		request.getRequestDispatcher("/frontend/success.jsp").forward(request, response);
	}
}
