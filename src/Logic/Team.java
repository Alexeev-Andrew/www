package Logic;

import Logic.Constants.Level;

public class Team {

	private final int id;
	private String name;
	private Constants.Level level;
	private int score;
	
	
	Team(int id, String name, Level level, int score){
		this.id = id;
		this.level = level;
		this.name = name;
		this.score = score;
		
	}
	

	Team(int id, String name, Level level){
		this(id,name,level,0);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Constants.Level getLevel() {
		return level;
	}


	public void setLevel(Constants.Level level) {
		this.level = level;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getId() {
		return id;
	}
	
	
	public int incrementScore(){
		return ++score;
	}
	
	public int decrementScore(){
		return --score;
	}
}
