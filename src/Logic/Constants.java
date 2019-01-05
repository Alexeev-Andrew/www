package Logic;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {

	public static final Dimension size = Toolkit.getDefaultToolkit ().getScreenSize ();
	public static final int HEIGHT_ONE_GAME_PANEL = 72;
	public static final int WIDTH_ONE_GAME_PANEL = 800;
	public static final int HEIGHT_CONTROL_PANEL = 720;
	public static final int WIDTH_CONTROL_PANEL = 1100;
	public static final int HEIGHT_CONTROL_PANEL_TOP = 116;
	
	public static final int HEIGHT_ONE_TEAM_PANEL = 49;
	public static final int WIDTH_ONE_TEAM_PANEL = 400;
	
	enum Level {
		level_beginner,
		level_average,
		level_advanced
	}
	
}
