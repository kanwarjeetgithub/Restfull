package com.home.project;

public class Product {
	float costAfterTax;
	float tax;
	String name;
	float cost;
	CategoryInterface category;
    public Product(){
    	
    }
    public Product(String name,CategoryInterface category,float cost){
    	this.category = category;
    	this.cost=cost;
    	this.name= name;
    	this.costAfterTax=costAfterTax();
    	this.tax= taxOnProduct();
    }
    

    public float getCostAfterTax() {
		return costAfterTax;
	}
	public void setCostAfterTax(float costAfterTax) {
		this.costAfterTax = costAfterTax;
	}
	
    public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public void setCategory(CategoryInterface category) {
		this.category = category;
	}
	public CategoryInterface getCategory() {
    	return category;
    }	
	public float taxOnProduct(){
		return category.tax();
	}
	public float costAfterTax(){
		return category.caluclatedCost(cost);
	}
	
	public String toString(){
		String product = "Name "+ this.name+" " + category.toString()+" Cost "+cost+ " Tax "+ taxOnProduct()+" Cost After Tax "+ costAfterTax();
		return product;
	}
 
}
