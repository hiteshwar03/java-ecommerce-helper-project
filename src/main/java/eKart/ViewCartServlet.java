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

import eKart.entities.Product;
import eKart.entities.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/view-cart")
public class ViewCartServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			try {
//				Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
//				Transaction transaction = session.beginTransaction();
				
	
				   request.getRequestDispatcher("/frontend/cart.jsp").forward(request, response);
			    
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
	}
}
