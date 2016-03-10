package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.project.Bill;
import com.home.project.domain.Category;
import com.home.project.domain.Product;
import com.home.project.factory.ProductFactory;
import com.home.project.service.CategoryService;
import com.home.project.service.ProductService;


/**
 * Hello world!
 *
 */
public class App 
{
	
    /**
     * @param args
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException
    {
        Bill bill=createBill();
        //Session session = HibernateUtil.getSessionFactory().openSession();
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
        List<Product> products = new ArrayList<Product>();
        List<Category> categories= new ArrayList<Category>();
    	//Product product = new Product();
    	for(Iterator<com.home.project.Product> itr=bill.getProducts().iterator();itr.hasNext();)
    	{
    		com.home.project.Product product= itr.next();
    		Product productEntity = new Product();
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

	private static Bill createBill() {
		// TODO Auto-generated method stub
		List<com.home.project.Product> products=new ArrayList<com.home.project.Product>();
		com.home.project.factory.ProductFactory productFactory = new ProductFactory();
		com.home.project.Product product1= productFactory.getProduct("a", "Product 1", 10f);
		com.home.project.Product product2= productFactory.getProduct("b", "Product 2", 20f);
		com.home.project.Product product3= productFactory.getProduct("c", "Product 3", 30f);
		com.home.project.Product product4= productFactory.getProduct("a", "Product 4", 30f);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		Bill bill = new Bill();
		bill.setProducts(products);
		return bill;
	}
}
