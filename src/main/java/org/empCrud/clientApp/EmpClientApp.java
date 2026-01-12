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
		EmpService es=(EmpService) cn.getBean("empService"); //serice madhlya comp ch nav ahe he
		//yethe apn serice cha ref fetch krto
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
            	 System.out.println("Enter  eid to delete emp");
            	  eid=sc.nextInt();
            	  res=es.deleteEmp(eid);
            	 if(res>0)
            	 {
            		 System.out.println("Emp Delete successfully");
            	 }
            	 else {
            		 System.out.println("Emp not Deleted");
            	 } 
            	 break;
            	 
             case 3:
            	 System.out.println("Enter  eid to update emp");
            	 eid=sc.nextInt();
            	 System.out.println("Enter new  name of emp");
            	  name=sc.nextLine();
            	  sc.nextLine();
             	 System.out.println("Enter new  sal of emp");
            	  sal=sc.nextInt();
            	  e=new Emp();
            	 e.setEid(eid);
            	 e.setName(name);
            	 e.setSal(sal);
            	  res=es.updateEmp(e);
            	 if(res>0)
            	 {
            		 System.out.println("Emp Update successfully");
            		 System.out.println("eid = "+eid+" name ="+name+"sal "+sal);
            	 }
            	 else {
            		 System.out.println("Emp not update");
            	 }
            	 break;
             case 4:
            	 System.out.println("List of Emp below");
            	 List<Emp> l=new ArrayList<Emp>();
            	 l=es.viewEmp();
            	 if(l!=null)
            	 {
            		 l.forEach((e1)->System.out.println(e1.getEid()+"\t"+e1.getName()+"\t"+e1.getSal()));
            	 }
            	 else {
            		 System.out.println("data is not present");
            	 }
            		 break;
             case 5:
            	 System.exit(1);         	 
             }
		} while (ch != 5);
	}

}
