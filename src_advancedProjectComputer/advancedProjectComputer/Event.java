package advancedProjectComputer;

import java.time.LocalDate;
import java.time.LocalTime;



public class Event {
	
	
	private String title ;
	private String description;
	private String location ;
	private LocalDate date ;
	private int availbleTickets =0;
	private LocalTime startTime;
	private LocalTime endTime ;
	
	
	
	
	Event(){
	//	setTitle("intiate events");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	
	
	public int getAvailbleTickets() {
		return availbleTickets;
	}

	public void setAvailbleTickets(int availbleTickets) {
		this.availbleTickets=availbleTickets;
		
	}
	public void bookedTickets() {
		availbleTickets++;
	}
	public void unbookedTickets() {
		availbleTickets++;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
	
