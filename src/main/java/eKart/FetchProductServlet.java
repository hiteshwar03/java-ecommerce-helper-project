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
import org.hibernate.query.Query;

import eKart.entities.Category;
import eKart.entities.Product;
import eKart.entities.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/fetch-product")
public class FetchProductServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		     String category =request.getParameter("id");
		     List<Product> products=null;;
		     
		    
			try {
				Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
				Transaction transaction = session.beginTransaction();
				if(category.equals("all")) {
					 products = session.createQuery("from Product", Product.class).list();
			    	 
				}
				else {
					int catid=Integer.parseInt(category);
					Query<Product> query = session.createQuery("from Product as p where p.category.categoryId=:id", Product.class);
					query.setParameter("id", catid);
					products=query.list();
				}
				
				List<Category> categories = session.createQuery("from Category", Category.class).list();
				
				transaction.commit();

				request.setAttribute("products", products);
				request.setAttribute("categories", categories);
				request.getRequestDispatcher("/frontend/home.jsp").forward(request, response);
			   
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
	}
}
