package com.home.project.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.project.domain.Category;
import com.home.project.domain.Product;
import com.home.project.util.HibernateUtil;

public class ProductDao {
	private SessionFactory sessionFactory;
	private Session session;
	
  public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	public void setSession(Session session) {
		this.session = sessionFactory.getCurrentSession();
	}
public SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}
  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

public void createProduct(Product Product)
  {
	  getSession().saveOrUpdate(Product);
  }
 public void deleteProduct(Product Product){
	 getSession().delete(Product);
 }
 public void updateProduct(Product Product){
	 getSession().saveOrUpdate(Product);
 }
 public Object findProduct(int id){
	 return getSession().get(Product.class, id);
 }
 public List<Object> getProductList(){
	 return getSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 }
 public void saveorUpdateAll(List<Product> products) 
 {
	 Transaction txn= getSession().beginTransaction();
	 for(Iterator<Product> itr=products.iterator();itr.hasNext();)
	 {
		 getSession().saveOrUpdate(itr.next());
	 }
	 txn.commit();
	 
 }
}
