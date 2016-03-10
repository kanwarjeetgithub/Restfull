package com.home.project;

public class CategoryB implements CategoryInterface{

	
	private String category="B";
	public CategoryB(){
		category="B";
	}
	public float tax() {
		// TODO Auto-generated method stub
		return 0.2f;
	}

	public float caluclatedCost(float cost) {
		// TODO Auto-generated method stub
		return (cost + tax()*cost);
	}
	public String toString()
	{
		return "Category B";
	}
	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}

}
