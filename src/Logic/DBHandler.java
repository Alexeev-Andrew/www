package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import Logic.Constants.Level;


public class DBHandler {
	
    private static DBHandler instance = null;
    private Connection conn = null;

    private DBHandler()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");//.newInstance();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static DBHandler getInstance() {
        if(instance == null)
        	return instance = new DBHandler();
        return instance;
    }

    public DBHandler connect()
    {
        try {
            Properties p=new Properties();
            p.setProperty("user","root");
            p.setProperty("password","Vaao095037448182");
            p.setProperty("useUnicode","true");
            p.setProperty("characterEncoding","cp1251");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/WWW?", p);
            
            Statement stmt = conn.createStatement();
            stmt.executeQuery("SET NAMES 'cp1251'");
            stmt.executeQuery("SET CHARACTER SET 'cp1251'");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return this;
    }
    
   
    public void updateGame(Game newGame) throws SQLException {

    	String query = "update games set name = ?, city = ?, league = ?, time = ?, place = ? where id = ?";
    	if(conn==null) connect();
        
    	 PreparedStatement preparedStmt = conn.prepareStatement(query);
         preparedStmt.setString(1, newGame.getName());
         preparedStmt.setString(2, newGame.getCity());
         preparedStmt.setString(3, newGame.getLeague());
         preparedStmt.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(newGame.getDate()));
         preparedStmt.setString(5, newGame.getPlace());
         preparedStmt.setString(6, ""+newGame.getId());
         
         preparedStmt.executeUpdate();
         //conn.close();

    }

    public void deleteGame(Game game) throws SQLException {

        String query = "DELETE from games where id = "+ game.getId() +";";
        Statement stmt = null;
        if(conn==null) connect();
        
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
       // conn.close();
    }
    
    
    public Game insertGame(String name,String city, String league, Date date, String place) throws SQLException
    {
       
            if(conn==null) connect();
           
            String query = " insert into games (name, city, league, time, place)" + " values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, city);
            preparedStmt.setString (3, league);
            preparedStmt.setString (4, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
            preparedStmt.setString (5, place);

            preparedStmt.execute();
            ResultSet keys = preparedStmt.getGeneratedKeys();
            keys.next();  
            
            //conn.close();
            
            return new Game(keys.getInt(1),name,city,league,date,place);
        
        
    }
    
    public ArrayList<Game> loadGames() throws ParseException, SQLException
    {
        ArrayList<Game> games = new ArrayList<Game>();
        Statement stmt = null;

        if(conn==null) connect();
        String query = "SELECT * FROM games ORDER BY time";
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next())
        {
            Game gm = new Game(rs.getInt("id"), rs.getString("name"),  rs.getString("city"), rs.getString("league"),  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(rs.getString("time")), rs.getString("place"));
            games.add(gm);
        }

        stmt.close();
        
        return games;
    }

   
    
    /*
    public void loadQuizes()
    {
        Statement stmt = null;

        connect();
        Quiz.quizesList = new ArrayList<Quiz>();
        String query = "SELECT * FROM questions";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Now do something with the ResultSet ....
            //Quiz quiz = new Quiz()
            while (rs.next())
            {
                Quiz quiz = new Quiz(rs.getString("question"), rs.getString("answer"));
                //System.out.println(rs.getString("question") + " : "+ rs.getString("answer"));
                Quiz.addQuiz(quiz);
            }
            stmt.close();
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException(loadQuizes()): " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {

        }
    }
*/
    

    public Team insertTeam(String name,Level level) throws SQLException
    {
    	if(conn==null) connect();
         // the mysql insert statement
         String query = "insert into teams (name, level)" + " values (?, ?)";
         PreparedStatement preparedStmt = conn.prepareStatement(query);
         preparedStmt.setString (1, name);
         preparedStmt.setInt (2, level.ordinal());

         preparedStmt.execute();
         ResultSet keys = preparedStmt.getGeneratedKeys();
         keys.next();  
            
         //conn.close();
            
         return new Team(keys.getInt(1),name,level);
    }
    
    public void updateTeam(Team team) throws SQLException{
        
    	if(conn==null) connect();
        
        String query = "update teams set name = ?, level = ? where id = ?" ;

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, team.getName());
        preparedStmt.setInt(2, team.getLevel().ordinal());
        preparedStmt.setString(3, ""+team.getId());
        
        preparedStmt.executeUpdate();
        
        conn.close();
        
    }
    
    public void deleteTeam(Team team) throws SQLException {

        String query = "DELETE from teams where id = "+ team.getId() +";";
        Statement stmt = null;
        if(conn==null) connect();
        
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
       // conn.close();
    }

    
    public ArrayList<Team> loadTeams(int gameId) throws SQLException
    {
        ArrayList<Team> teams = new ArrayList<Team>();
        Statement stmt = null;

        if(conn==null) connect();
        String query = "SELECT * FROM (rel_game_team inner join teams on teams.id=rel_game_team.id_team) where id_game = "+gameId+" ORDER BY id";
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next())
        {
            Team gm = new Team(rs.getInt("id"), rs.getString("name"),  Level.values()[rs.getInt("level")]);
            teams.add(gm);
        }

        stmt.close();
        
        return teams;
    }
    
    /*
        CHECK IT, IT MAY DOESN'T WORK
     */
    public ArrayList<Team> loadTeams(int gameId, int tour, int group_id ) throws SQLException
    {
        ArrayList<Team> teams = new ArrayList<Team>();
        Statement stmt = null;

        if(conn==null) connect();
        String query = "SELECT * FROM (SELECT id_team FROM groups_of_teams where id_game = "+gameId+" AND tour = "+tour+"AND group_id = "+group_id+") t1 INNER JOIN teams on t1.id_team = teams.id";
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next())
        {
            Team gm = new Team(rs.getInt("id"), rs.getString("name"),  Level.values()[rs.getInt("level")]);
            teams.add(gm);
        }

        stmt.close();
        
        return teams;
    }
    
    
    
    public ArrayList<Question> questions(int id_game,int tour) throws SQLException{
    	ArrayList<Question> questions = new ArrayList<Question>();
    	
    	Statement stmt = null;

        if(conn==null) connect();
        String query = "SELECT * FROM (SELECT id_q FROM rel_question_game WHERE id_g = "+id_game+"AND tour = "+tour+") table1 INNER JOIN questions on table1.id_q = questions.id";
        
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next())
        {
            Question quest = new Question(rs.getInt("id"), rs.getString("question"),  rs.getString("answer"), tour, rs.getInt("number") );
            questions.add(quest);
        }

        stmt.close();
    	
    	return questions;
    }
    
    
    
  
    
    
}