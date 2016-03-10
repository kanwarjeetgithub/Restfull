package com.home.project.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.project.domain.Category;
import com.home.project.util.HibernateUtil;

public class CategoryDao {
	private SessionFactory sessionFactory;
	private Session session;
	
  public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	public void setSession(Session session) {
		this.session = session;
	}
public SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}
   
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

public void createCategory(Category category)
  {
	  getSession().createCriteria(Category.class).add(Restrictions.eq("category", category.getCategory()));
	  getSession().saveOrUpdate(category);
  }
 public void deleteCategory(Category category){
	 getSession().delete(category);
 }
 public void updateCategory(Category category){
	 getSession().saveOrUpdate(category);
 }
 public Category findCategory(int id){
	  return (Category)getSession().get(Category.class, id);
 }
 public List<Object> getCategoryList(){
	 return getSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 }
 public int isCategoryExits(Category category)
 {
	 int id= -1;
	 Transaction txn=getSession().beginTransaction();
	 Criteria criteria =getSession().createCriteria(Category.class);
	 criteria.add(Restrictions.eq("category", category.getCategory()));
	 List<Category> categoryList= criteria.list();
	 txn.commit();
	 if(categoryList.size()>=1)
	 {
		 id = categoryList.get(0).getId();
	 }
	 return id;
 }
 
 public void saveorUpdateAll(List<Category> categories) 
 {
	 Transaction txn= getSession().beginTransaction();
	 for(Iterator<Category> itr=categories.iterator();itr.hasNext();)
	 {
		 getSession().saveOrUpdate(itr.next());
	 }
	 txn.commit();
	 
 }
}
