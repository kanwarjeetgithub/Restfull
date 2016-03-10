package com.home.project;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.home.project.domain.Category;
import com.home.project.domain.Product;
import com.home.project.util.HibernateUtil;


/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txn=session.beginTransaction();
        Category category = new Category();
        category.setCategory("B");
        category.setTax(0.2f);
        
        Product product = new Product();
        product.setCategory(category);
        product.setCost(10f);
        product.setName("product 2");
        session.save(product);
        session.save(category);
        txn.commit();
    }
}
