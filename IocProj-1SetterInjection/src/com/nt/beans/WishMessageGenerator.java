//target class
package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
       //create date class ref variable
	   private Date date =null;
	   //write setter injection method 
	   public void setDate(Date date){
	   this.date=date;
	   }
	   //create method for generate wish message logic execution
	   public void generateWishMessage(String user) {
		   int hours=0;
		   //get hour of the day
		   hours=date.getHours();
		 //  System.out.println(hours);
		   //write business logic 
		   if(hours<12) {
			   System.out.println("result::good morning"+""+" "+user+"");
		   }
		   else if(hours<16) {
			   System.out.println("result::good afternoon"+""+" "+user+"");
		   }
		   else if(hours<20) {
			   System.out.println("result::good evening"+""+" "+user+"");
		   }
		   else {
			   System.out.println("result::good night"+""+" "+user+"");
		   }
	   }//method
	
		

	}//class


