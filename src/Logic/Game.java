package Logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {	
	
	private final int id;
	private String name;
	private String city;
	private String league;
	private Date date;
	private String place;
	
	
	public Game(int id, String name, String city, String league, Date date, String place){
		this.id = id;
		this.name = name;
		this.city = city;
		this.league = league;
		this.date = date;
		this.place = place;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getId() {
		return id;
	}
	
	
	public String showTime() {
		return new SimpleDateFormat("HH:mm").format(date);
	}
	public String showDate() {
		return new SimpleDateFormat("dd.MM.yyyy").format(date);
	}
	
}
