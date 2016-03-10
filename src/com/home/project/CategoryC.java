package com.home.project;

public class CategoryC implements CategoryInterface{

	private String category="C";
	public CategoryC()
	{
		this.category="C";
	}
	public float tax() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float caluclatedCost(float cost) {
		// TODO Auto-generated method stub
		return cost;
	}
	public String toString()
	{
		return "Category C";
	}
	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}

}
