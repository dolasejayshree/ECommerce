package com.Ecommerce.miniproject;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RegisterNewUser {
	
	
		public void getCustomerDetailsFromScanner() {
			Scanner sc=new Scanner (System.in);
			System.out.println("Enter Customer Name : ");
			String cname=sc.next();		
			System.out.println("Enter Mobile Number : ");
			String cmobnum=sc.next();	
			System.out.println("Enter Email Address : ");
			String cemail=sc.next();	
			System.out.println("Enter Address : ");
			String cadd=sc.next();	
			
			
			
			RegisterNewUser rs=new RegisterNewUser();
			rs.getCustomerdetails(cname,cmobnum,cemail,cadd);

		}
	

		
		Connection con=null;
		PreparedStatement ps=null;
		
		public void getCustomerdetails(String customer_name,String mobile_number,String email_id,String address)
		{
			try {
				
				ConnectionTest connectiontest=new ConnectionTest();
				con=connectiontest.getConnectionDetails();
				
			    ps=con.prepareStatement("insert into customerdetails(customer_name,mobile_number,email_id,address)values(?,?,?,?)");
			  	ps.setString(1, customer_name);
				ps.setString(2, mobile_number);
				ps.setString(3, email_id);
				ps.setString(4, address);

				
				int i=ps.executeUpdate();
			
			
				if(i == 1) {
					System.out.println("Registration Successfull.");
				}else {
					System.out.println("Registration Not Successfull.");
				}
			
				
			}
			
			catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		
		
	}