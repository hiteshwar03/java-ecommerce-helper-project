package eKart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import eKart.entities.Category;

public class CategoryDao {

	Session session;
	Transaction transaction;
	public CategoryDao() {
		session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		transaction = session.beginTransaction();
	}
	

	public void saveCategory() {
		
	}
	
	public List<Category> getCategories(){

		List<Category> list = session.createQuery("from Category", Category.class).list();
		
		transaction.commit();
		return list;
		   
	}
}
