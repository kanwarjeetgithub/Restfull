package com.home.project;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="wrapperList") 
public class WrapperList {
private List<ProductObject> productObjects;
public List<ProductObject> getProductObjects() {
	return productObjects;
}

public void setProductObjects(List<ProductObject> productObjects) {
	this.productObjects = productObjects;
}
}
