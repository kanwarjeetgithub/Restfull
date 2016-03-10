package com.home.project.restful;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.project.Bill;
import com.home.project.Product;
import com.home.project.ProductObject;
import com.home.project.WrapperList;
import com.home.project.domain.Category;
import com.home.project.factory.ProductFactory;
import com.home.project.service.CategoryService;
import com.home.project.service.ProductService;
@RestController
public class BillingRestFulService {
	
    @RequestMapping(value="/billing",method=RequestMethod.POST)
	public ResponseEntity<String> generateBill(@RequestBody WrapperList wrapperList)
	{
    	Bill bill=null;
    	List<ProductObject> productList= wrapperList.getProductObjects();
    	if(productList!=null && productList.size()>0)
		bill=createBill(productList);
		return new ResponseEntity<String>(bill.toString(),HttpStatus.OK);
	}
    
	private  Bill createBill(List<ProductObject> productList) {
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<Product>();
		ProductFactory productFactory = new ProductFactory();
		for(Iterator<ProductObject> itr= productList.iterator();itr.hasNext();)
		{
			ProductObject productObject=itr.next();
			if(productObject.getCategory().equalsIgnoreCase("a")|| productObject.getCategory().equalsIgnoreCase("b")||productObject.getCategory().equalsIgnoreCase("c"))
			{
				Product product= productFactory.getProduct(productObject.getCategory(), productObject.getName(), productObject.getCost());
				products.add(product);
			}
		}
		
		Bill bill = new Bill();
		bill.setProducts(products);
		return bill;
	}
	
	private void addBillToDB(Bill bill){
		ApplicationContext applicationContext= null;
    	try{
    		//File f=new File("D:/gProjects/Billing/src/main/java/resources/SpringContext.xml");
    		applicationContext= new ClassPathXmlApplicationContext("resources/SpringContext.xml");
    	;
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	System.out.println("applicationConext"+applicationContext);
    	CategoryService categoryService = (CategoryService)applicationContext.getBean("categoryService");
    	ProductService productService = (ProductService)applicationContext.getBean("productService");
        List<com.home.project.domain.Product> products = new ArrayList<com.home.project.domain.Product>();
        List<Category> categories= new ArrayList<Category>();
    	//Product product = new Product();
    	for(Iterator<com.home.project.Product> itr=bill.getProducts().iterator();itr.hasNext();)
    	{
    		com.home.project.Product product= itr.next();
    		com.home.project.domain.Product productEntity = new com.home.project.domain.Product();
    		productEntity.setCost(product.getCost());
    		productEntity.setName(product.getName());
    		Category category =new Category();
    		category.setCategory(product.getCategory().getCategory());
    		System.out.println("category"+ product.getCategory().getCategory());
    		category.setTax(product.getCategory().tax());
    		int id=categoryService.isCategoryExits(category);
    		if(id <0){
    		     categories.add(category);
    		}
    		else{
    			category.setId(id);
    		}
    		productEntity.setCategory(category);
    		products.add(productEntity);
    	}
    	if(categories.size()>0)
    		categoryService.saveorUpdateAll(categories);
    	if(products.size()>0)
    		productService.saveorUpdateAll(products);
	}
}
