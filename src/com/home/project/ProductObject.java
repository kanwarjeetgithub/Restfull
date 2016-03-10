package com.home.project;

public class ProductObject {
private String name;
private float cost;
private String category;

public ProductObject()
{
	
}
public ProductObject(String name,float cost,String category)
{
	this.name=name;
	this.cost=cost;
	this.category=category;
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
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
}
