package com.home.project.service;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.project.dao.ProductDao;
import com.home.project.domain.Category;
import com.home.project.domain.Product;

public class ProductService {
    private Product product;
    private Category category;
    private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
   @Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void saveorUpdateAll(List<Product> products) 
	 {
		productDao.saveorUpdateAll(products);
	 }

	public List<Object> getAllEntities() {
		// TODO Auto-generated method stub
		return productDao.getProductList();
	}
	

}
