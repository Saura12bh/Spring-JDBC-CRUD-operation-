package org.empCrud.clientApp;

import org.empCrud.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

import org.empCrud.config.DbConfig;
import org.empCrud.model.*;

public class EmpClientApp {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		AnnotationConfigApplicationContext cn=new AnnotationConfigApplicationContext(DbConfig.class);
		EmpService es=(EmpService) cn.getBean("empService");
		int ch;
		do {
            System.out.println("\n--- EMP CRUD MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. View Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

             ch = sc.nextInt();
             sc.nextLine();
             switch(ch)
             {
             case 1:
            	 System.out.println("Enter name  eid sal");
            	 String name=sc.nextLine();
            	 int eid=sc.nextInt();
            	 int sal=sc.nextInt();
            	 Emp e=new Emp();
            	 e.setEid(eid);
            	 e.setName(name);
            	 e.setSal(sal);
            	 int res=es.addEmp(e);
            	 if(res>0)
            	 {
            		 System.out.println("Emp add successfully");
            	 }
            	 else {
            		 System.out.println("Emp not added");

            	 }
            	 break;
            	 
             case 2:
            	 break;
             }
		} while (ch != 5);
	}

}
