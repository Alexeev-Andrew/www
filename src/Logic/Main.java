package Logic;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import GUI.MainFrame;

public class Main {

	public static ArrayList<Game> gamesList = new ArrayList<Game>();
	
	public static void main(String[] args) throws IOException, ParseException{
		
		//Desktop.getDesktop().open(new File("C:\\Users\\Public\\Videos\\Sample Videos\\test.wmv"));
		DBHandler db = DBHandler.getInstance();
		try {
			gamesList = db.loadGames();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		
		
		//Game tst = new Game("avada kedavra", "Dnepr", "Students",
			//new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2019-01-03 14:00"),"st. Yarsikova 1");
		
		//db.insertGame(tst);
		//System.out.println(db.loadGames().get(0).getDate());
	}
	
	
	
	public static void addGame(Game game) {
		gamesList.add(game);
    }
   
	public static void deleteGame(int id) {
    	gamesList.remove(id);
    }
}
