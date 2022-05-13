package advancedProjectComputer;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Employee extends Person  {
	
	private Account account=new Account();
	Scanner  input = new Scanner(System.in);
	boolean loginFlag = false;
	//for client
	protected char gender ;
	protected String mobile;
	private ArrayList<String> attendedEvent = new ArrayList<String>(); ;
	private ArrayList<String> upcomingEvent = new ArrayList<String>(); ;
	
	
	
	public void setEventsHistory(Event event) {
		LocalTime timeNow =LocalTime.now();
		LocalDate dateNow =LocalDate.now();
		
		if (event.getStartTime().compareTo(timeNow)<=0 &&event.getDate().compareTo(dateNow)<=0) {
			this.attendedEvent.add(event.getTitle());
		}
		else {
			this.upcomingEvent.add(event.getTitle());
		}
		
	}
	public void setUpcomingEvent(Event event)
		 {
			 upcomingEvent.add(event.getTitle());
		 }
	public void setAttendeEvent(Event event)
	 {
		 attendedEvent.add(event.getTitle());
	 }
	public void setGender(char gender){
		this.gender=gender;
		
		}
	public void setMobile(String mobile)
		{
		this.mobile=mobile;
		}
	public char getGender()
	{
		 return gender;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void removedEvent(Event event) {
		upcomingEvent.remove(event.getTitle());
	}

	
	public Account getAccount() {
		
			return account;
		
	}

	public void registerAccount(String name,String userName,String password,String mobile,char G) {

		account.setUserName(userName);
		account.setPassword(password);
		setName(name);
		setMobile(mobile);
		setGender(G);
		System.out.println("You've registerd successfully !!");
	}

	public void signInAccount(String userName,String password) {

		if(account.getUserName().equals(userName) && account.getPassword().equals(password))
		{
			System.out.println("You've logged in successfully !!");
			loginFlag=true;
		}
		else {
			System.out.println("wrong user name or password plese try again");
			
		}
	}
	
	public void signOutAccount() {
		if(loginFlag==true)
			{loginFlag=false;
			System.out.println("you have signed out");
			}
		else{System.out.println("you are not signed in");}
		
	}
	
	public void bookEvent(Event e1) {

		if(loginFlag==true) {
			
			if(e1.getAvailbleTickets()>0) {
				
			
			e1.bookedTickets();
			setUpcomingEvent(e1);;
			System.out.println("you have booked a ticket for  the event");
			
			}
			else {
				 System.out.println("not enough available Tickets");
				
			}
		}
		else {
			System.out.println(" you are not signed in");
		}
	}

	public void unbookEvent(Event e1) {

         if(loginFlag==true) {
      
					e1.unbookedTickets();
					removedEvent(e1);
					System.out.println(" event has been unbooked");
			
         }
		
		else {
			System.out.println(" you are not signed in");
		}
	}
	
	public void searchEventByTitle(String title,ArrayList<Event>events) {
		
		if(loginFlag==true) {	
			for(int i=0;i<events.size();i++) {
				
				if(events.get(i).getTitle().contains(title)) {
					System.out.println(" found event " + events.get(i).getTitle());
					
				}
			}
			
			
			}
			else {
				System.out.println("you are not signed in");
				
			}
	}

	public void viewEventDetails(String title,ArrayList<Event>events) {
		if(loginFlag==true) {
			int index=-1;
			for(int i=0;i<events.size();i++) {
				
				if(events.get(i).getTitle().equals(title)) {
					
					index=i;
					break;
				}
			}
			if(index==-1) {
				System.out.println("event not found");
			}
			
			
			else {
			
		System.out.println("event title " + events.get(index).getTitle() );
		System.out.println("event location " + events.get(index).getLocation() );
		System.out.println("event Start time " + events.get(index).getStartTime() );
		System.out.println("event end time  " + events.get(index).getEndTime() );
		System.out.println("event date " + events.get(index).getDate() );
			}
			
		}
		else {
			System.out.println("you are not signed in");
			
		}
		
	}
	
	public Event findEvent(String eventName,ArrayList<Event>events) {
		
		if(loginFlag==true) {	
			for(int i=0;i<events.size();i++) {
				
				if(events.get(i).getTitle().equals(eventName)) {
					
					return events.get(i);
				}
			}
			
			
			}
			else {
				System.out.println("you are not signed in");
				return null;
			}
		
		return null;
		
	}
	
	
	public void showProfile() {
		getAccount().getUserName();
		getName();
		getMobile();
		getGender();
	
	}
	
}





