package advancedProjectComputer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;




public class TicketReservationSystem {
	
	
	Scanner  input = new Scanner(System.in);
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	ArrayList<Admin> admines = new ArrayList<Admin>();
	
	
	
	
	ArrayList<Event> events = new ArrayList<Event>();
	
	
	public void intiateData() {
		
		Admin dummyAdmin1=new Admin();
		
		Employee dummyEmployee1=new Employee();
		
		employees.add(dummyEmployee1);
		dummyEmployee1.registerAccount("dummy1", "dummy1","dummy1","01011111111",'M');
		
		employees.add(dummyEmployee1);

		dummyAdmin1.registerAccount("dummy1", "dummy1");
		
		admines.add(dummyAdmin1);		
		Event event1 = new Event();
		event1.setTitle("spiderman");
		event1.setLocation("vox cinema");
		event1.setDate(LocalDate.of(2022, 8, 9));
		event1.setStartTime(LocalTime.of(10,30 ));
		event1.setEndTime(LocalTime.of(11,30 ));
		event1.setDescription("bad moviee");
		event1.setAvailbleTickets(30);
		events.add(event1);
		
		
       Event event2 = new Event();	
       event2.setTitle("spiderwoman");
       event2.setLocation("vox cinema");
       event2.setDate(LocalDate.of(2022, 7, 9));
       event2.setStartTime(LocalTime.of(10,30 ));
       event2.setEndTime(LocalTime.of(11,30 ));
       event2.setDescription("good moviee");
       event2.setAvailbleTickets(30);
		events.add( event2);
			
	}
	
	public Admin letAdminSignin() {
		
		System.out.println("please insert your username : " );
		Admin currentAdmin= new Admin();
		
		String userName = input.next();
		System.out.println("please insert your password : " );

		  String password = input.next();
		boolean accountExist=false;
		for (int i = 0; i < admines.size(); i++) {
			
	      if(admines.get(i).getAccount().getUserName() .equals(userName)&&admines.get(i).getAccount().getPassword().equals(password)) {
	    	  
	    	  accountExist = true;
	    	  currentAdmin= admines.get(i);
	    	 
	    	
	    	  currentAdmin.signInAccount(userName,password);
	    	  return currentAdmin;
	      }
	    }
		
		if(!accountExist)
			System.out.println("Account not exist ");
		return null;
	}
	
	public void letAdminSignout(Admin currentAdmin) {
		
		currentAdmin.signOutAccount();
		
	}
	
	

	public void letAdminControlEvent(Admin currentAdmin) {
		
		
		
		System.out.println("Please insert the one of the following numbers" );
		System.out.println("1: Add event");
		System.out.println("2: Edit event");
		System.out.println("3: Delete event");
		
	switch(input.nextInt()) {	
	
	case 1:{
		
		events.add(currentAdmin.addEvent());
		break;
	}
		
	case 2:{
		System.out.println("Please insert the event  you wish to edit");
		String catTypeString = input.next();
		for (int i = 0; i < events.size(); i++) {
		
			if(events.get(i).getTitle().equals(catTypeString)) {
	    	  
	    	  currentAdmin.editEvent(events.get(i));
	    	  break;  
	      }
	      
	
	
    }break;
   }
	case 3:{
		System.out.println("Please insert the event  you wish to delete");
		String catString=input.next();
		for (int i = 0; i < events.size(); i++) {
			
		      if(events.get(i).getTitle() .equals(catString)) {
		    	  
		    	  currentAdmin.deleteEvent(events.get(i), events);
		    	  break;  
		      }
		
	}
	break;
	}
	
	default:
		System.out.println("Invalid input");
		
	}
	
}
		
	
	
	public Employee letEmployeeStart() {
		
		
       System.out.println("Do you Already have an Account (Y/N) : ");
		
		char checkChar2=input.next().charAt(0);
		if(checkChar2=='Y') {
			

			System.out.println("please insert your username : " );
			Employee currentEmployee= new Employee();
			
			String userName = input.next();
			System.out.println("please insert your password : " );

			  String password = input.next();
			boolean accountExist=false;
			for (int i = 0; i <employees.size(); i++) {
				
		      if(employees.get(i).getAccount().getUserName().equals(userName)&&employees.get(i).getAccount().getPassword().equals(password)) {
		    	  
		    	  accountExist = true;
		    	  currentEmployee= employees.get(i);
		    	  currentEmployee.signInAccount(userName,password);
		    	  
		    	  return currentEmployee;
		      }
		    }
			
			if(!accountExist)
				System.out.println("Account not exist ");
			return null;
			
			
		}
		else if (checkChar2=='N') {
			
			System.out.println("creating a new account ");
			
			System.out.println("plese insert your name");
			String name=input.nextLine();
			System.out.println("insert your user name ");
			String userName =input.next();
			System.out.println("insert your password ");
			String password =input.next();
			System.out.println("insert your mobile number ");
			String mobile =input.next();
			System.out.println("insert your Gender (M/F) ");
			char g =input.next().charAt(0);
			Employee newEmployee= new Employee();
			newEmployee.registerAccount(name,userName, password,mobile,g);
			employees.add(newEmployee);
			
			Employee currentEmployee= new Employee();
			
			System.out.println(" now please sign in ");
			
			System.out.println(" please insert your user name ");
			 userName = input.next();
			System.out.println("please insert your password : " );

			  password = input.next();
			boolean accountExist=false;
			for (int i = 0; i <employees.size(); i++) {
				
		      if(employees.get(i).getAccount().getUserName() .equals(userName)&&employees.get(i).getAccount().getPassword().equals(password)) {
		    	  
		    	  accountExist = true;
		    	  currentEmployee= employees.get(i);
		    	  currentEmployee.signInAccount(userName,password);
		    	  return currentEmployee;
		      }
		    }
			
			if(!accountExist)
				System.out.println("Account not exist ");
			return null;
		}
		
		else {
			
			System.out.println("wrong choise  ");
			return null;
		}
		
	}
	

	public void letEmployeeControlEvent(Employee currentEmployee) {
		
		
		
		System.out.println("Please insert the one of the following numbers" );
		
		System.out.println("1: search event by name ");
		System.out.println("2: view event details ");
		
		
		
		switch (input.nextInt()) {
		case 1: {
			
			System.out.println("insert the name of the event ");
			
			currentEmployee.searchEventByTitle( input.next(), events);
			
			break;
		}
		
		case 2: {
			
			System.out.println("insert the name of the event ");
			
			currentEmployee.viewEventDetails(input.next(),events);	
			
			break;
			
		}
		
		case 3: {
			
			System.out.println("please insert name of the client you want to book for him then name of event :");
			currentEmployee.bookEvent(currentEmployee.findEvent(input.next(), events));
			break;
		}
		
		case 4: {

			System.out.println("please insert name of the client you want to unbook for him  and the event:");
			currentEmployee.unbookEvent(currentEmployee.findEvent(input.next(), events));
			break;
		}
		default:
			
			System.out.println("wrong choise  ");
		}
		
	}
	
	public void letEmployeeSignout(Employee currentEmployee) {
		
		currentEmployee.signOutAccount();
		
	}





	

}

