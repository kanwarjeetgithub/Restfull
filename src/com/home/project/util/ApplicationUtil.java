package com.home.project.util;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationUtil {
private static ApplicationContext applicationContext = buildApplicationContext();
private static ApplicationContext buildApplicationContext() 
{
	ApplicationContext applicationContext= null;
	try{
		//File f=new File("D:/gProjects/Billing/src/main/java/resources/SpringContext.xml");
		applicationContext= new FileSystemXmlApplicationContext("SpringContext.xml");
	;
	}catch(Exception e)
	{
		System.out.println(e);
	}
	return applicationContext;
}
public static ApplicationContext getApplicationContext()
{
	return applicationContext;
}

}
