package com.home.project;

public class CategoryA implements CategoryInterface{

	public CategoryA()
	{
		category="A";
	}
    private String category="A";
	public float tax() {
		// TODO Auto-generated method stub
		return 0.1f;
	}
    
	public float caluclatedCost(float cost) {
		// TODO Auto-generated method stub
		return (cost+cost*tax());
	}

	public String toString()
	{
		return "Category A";
	}

	
	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}

	

}
