package Logic;

public class Question {

	private final int id;
	private String fileName_quest;
	private String fileName_answ;
	
	private int tour;
	private int numberInTour;
	
	Question(int id, String fileName_quest, String fileName_answ, int tour,int numberInTour){
		this.id = id;
		this.fileName_quest = fileName_quest;
		this.fileName_answ = fileName_answ;
		this.tour = tour;
		this.numberInTour = numberInTour;
	}

	public String getFileName_quest() {
		return fileName_quest;
	}

	public void setFileName_quest(String fileName_quest) {
		this.fileName_quest = fileName_quest;
	}

	public String getFileName_answ() {
		return fileName_answ;
	}

	public void setFileName_answ(String fileName_answ) {
		this.fileName_answ = fileName_answ;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public int getId() {
		return id;
	}

	public int getNumberInTour() {
		return numberInTour;
	}

	public void setNumberInTour(int numberInTour) {
		this.numberInTour = numberInTour;
	};
	
	
	
	
}
