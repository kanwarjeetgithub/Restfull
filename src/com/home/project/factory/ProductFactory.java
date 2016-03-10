package com.home.project.factory;

import com.home.project.CategoryA;
import com.home.project.CategoryB;
import com.home.project.CategoryC;
import com.home.project.Product;

public class ProductFactory {
  public Product getProduct(String category,String name,float cost){
	  if(category.equalsIgnoreCase("A"))
	  {
		  return new Product(name,new CategoryA(),cost);
	  }
	  if(category.equalsIgnoreCase("B"))
	  {
		  return new Product(name,new CategoryB(),cost);
	  }
	  if(category.equalsIgnoreCase("C"))
	  {
		  return new Product(name,new CategoryC(),cost);
	  }
	 return null;
  }
}
