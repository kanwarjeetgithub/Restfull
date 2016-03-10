package com.home.project;

import java.util.Iterator;
import java.util.List;

public class Bill {
	List<Product> products;
	float totalCostwithoutTax;
	float totalCostAfterTax;
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public float getTotalCostwithoutTax() {
		return totalCostWithoutTax();
	}
	
	public float getTotalCostAfterTax() {
		return totalCostAfterTax();
	}
	
	public float totalCostAfterTax()
	{
		float cost=0f;
		for(Iterator<Product> itr=products.iterator();itr.hasNext();){
			Product product=itr.next();
			cost+=product.costAfterTax();
		}
		return cost;
	}
	public float totalCostWithoutTax()
	{
		float cost=0f;
		for(Iterator<Product> itr=products.iterator();itr.hasNext();){
			Product product=itr.next();
			cost+=product.cost;
		}
		return cost;
	}
	public String toString()
	{
		StringBuilder str= new StringBuilder();
		for(Iterator<Product> itr=products.iterator();itr.hasNext();){
			str.append(itr.next().toString()+"\n");
		}
		str.append("totalCostWithoutTax "+ totalCostWithoutTax()+" totalCostAfterTax "+totalCostAfterTax());
		return str.toString();
	}
	public Bill(){
		
	}
	

}
