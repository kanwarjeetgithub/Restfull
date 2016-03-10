package com.home.project.service;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.project.dao.CategoryDao;
import com.home.project.domain.Category;
import com.home.project.domain.Product;

public class CategoryService {
	@Autowired
    private CategoryDao categoryDao;
	
    private Category category;
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
    
	

	public void saveorUpdateAll(List<Category> categories) 
	 {
		categoryDao.saveorUpdateAll(categories);
	 }

	

	
    public int isCategoryExits(Category category)
    {
    	return categoryDao.isCategoryExits(category);
    }
	

}
