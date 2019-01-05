package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Logic.Constants;
import Logic.DBHandler;
import Logic.Game;
import Logic.Main;

public class GameRow extends JPanel {

	protected JLabel lblGameName;
	protected JLabel lblSomeCity;
	protected JLabel lblLeague;
	protected JLabel lblDate;
	protected JLabel lblTime;
	protected JLabel lblPlace;
	
	protected MainFrame mf;
	/**
	 * Create the panel.
	 */
	public GameRow(Game game, MainFrame mf) {
		this.mf = mf;
		
		setBackground(Color.WHITE);
		setLayout(null);
		this.setSize(Constants.WIDTH_ONE_GAME_PANEL,Constants.HEIGHT_ONE_GAME_PANEL);
		
		this.setBorder(new TextBubbleBorder(Color.LIGHT_GRAY,2,16,0));
		
		JButton button = new JButton("");
		button.setToolTipText("\u0443\u0434\u0430\u043B\u0438\u0442\u044C");
		button.setForeground(Color.BLACK);
		button.setBackground(Color.ORANGE);
		button.setIcon(new ImageIcon(GameRow.class.getResource("/res/ic_clear_black_18dp.png")));
		button.setBounds(10, 21, 29, 27);
		button.setBorder(new TextBubbleBorder(Color.LIGHT_GRAY,2,160,0));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DBHandler.getInstance().deleteGame(game);
				} catch (SQLException e1) {
					  System.err.println(e1.getMessage());
					  return;
				}
				mf.removePanelFromScroll(Main.gamesList.indexOf(game));
				Main.gamesList.remove(game);
			}
		});
		
		add(button);
		
		JButton button_1 = new JButton("");
		button_1.setToolTipText("\u0440\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C\r\n");
		button_1.setIcon(new ImageIcon(GameRow.class.getResource("/res/ic_mode_edit_black_18dp.png")));
		button_1.setBackground(Color.GREEN);
		button_1.setBounds(44, 21, 29, 27);
		button_1.setBorder(new TextBubbleBorder(Color.LIGHT_GRAY,2,160,0));
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeGameInfo cgi = new ChangeGameInfo(game,GameRow.this);
				cgi.setVisible(true);
			}
		});
		add(button_1);
		
		lblSomeCity = new JLabel(game.getCity());
		lblSomeCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblSomeCity.setBounds(236, 21, 85, 27);
		add(lblSomeCity);
		
		lblGameName = new JLabel(game.getName());
		lblGameName.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameName.setBounds(83, 21, 143, 27);
		add(lblGameName);
		
		lblLeague = new JLabel(game.getLeague());
		lblLeague.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeague.setBounds(331, 21, 72, 27);
		add(lblLeague);
		
		lblDate = new JLabel(game.showDate());
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(409, 21, 103, 27);
		add(lblDate);
		
		lblTime = new JLabel(game.showTime());
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(522, 21, 56, 27);
		add(lblTime);
		
		lblPlace = new JLabel(game.getPlace());
		lblPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlace.setBounds(593, 21, 197, 27);
		add(lblPlace);

	}
	
	protected void update(Game gr) {
		
		lblGameName.setText(gr.getName());
		lblSomeCity.setText(gr.getCity());
		lblLeague.setText(gr.getLeague());
		lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(gr.getDate()));
		lblTime.setText(new SimpleDateFormat("HH:mm").format(gr.getDate()));
		lblPlace.setText(gr.getPlace());
	}
}
