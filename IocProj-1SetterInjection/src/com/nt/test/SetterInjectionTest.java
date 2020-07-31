//client application
package com.nt.test;

import java.util.Scanner;

import org.springframework.aop.aspectj.annotation.BeanFactoryAspectInstanceFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		Resource rs=null;
		BeanFactory factory=null;
		Object obj=null;
		WishMessageGenerator wmg=null;
		Scanner sc=null;
		String name=null;
	    sc=new Scanner(System.in);
		System.out.println("enter your name");
		name=sc.nextLine();
		//get resourse to identify xml file
		 rs=new FileSystemResource("src/com/nt/cfgs/ApplicationContext.xml");
		//create spring ioc container object
		 factory=new XmlBeanFactory(rs);
		 System.out.println(factory.getClass());
		 System.out.println(factory.hashCode());
		 //get dependent class object
		 obj=factory.getBean("wmg");
		 //type caste the object
		 wmg=(WishMessageGenerator)obj;
		 //call business logic method on Wishmessagegenerator
		 wmg.generateWishMessage(name);
	}

}
