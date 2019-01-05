package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Logic.DBHandler;
import Logic.Game;
import Logic.Main;

public class AddGame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField cityTF;
	private JTextField leagueTF;
	private JTextField dateTF;
	private JTextField timeTF;
	private JTextField placeTF;


	/**
	 * Create the frame.
	 */
	public AddGame(MainFrame mf) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 375);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0438\u0433\u0440\u0443");
		label.setFont(new Font("Tahoma", Font.ITALIC, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(75, 11, 137, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(36, 70, 64, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u0413\u043E\u0440\u043E\u0434");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(36, 106, 64, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u041B\u0438\u0433\u0430");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(36, 142, 64, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u0414\u0430\u0442\u0430");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(36, 178, 64, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u0412\u0440\u0435\u043C\u044F");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(36, 214, 64, 25);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u041C\u0435\u0441\u0442\u043E");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(36, 250, 64, 25);
		contentPane.add(label_6);
		
		nameTF = new JTextField();
		nameTF.setForeground(new Color(0, 0, 128));
		nameTF.setHorizontalAlignment(SwingConstants.CENTER);
		//textField.setText("\u0422\u0435\u0441\u0442\u043E\u0432\u0430\u044F \u0438\u0433\u0440\u0430 1");
		nameTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTF.setBounds(111, 72, 143, 25);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		cityTF = new JTextField();
		//textField_1.setText("\u041A\u0438\u0435\u0432");
		cityTF.setHorizontalAlignment(SwingConstants.CENTER);
		cityTF.setForeground(new Color(0, 0, 128));
		cityTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cityTF.setColumns(10);
		cityTF.setBounds(110, 108, 143, 25);
		contentPane.add(cityTF);
		
		leagueTF = new JTextField();
		//textField_2.setText("\u041B\u0438\u0433\u0430 1");
		leagueTF.setHorizontalAlignment(SwingConstants.CENTER);
		leagueTF.setForeground(new Color(0, 0, 128));
		leagueTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		leagueTF.setColumns(10);
		leagueTF.setBounds(111, 142, 143, 25);
		contentPane.add(leagueTF);
		
		dateTF = new JTextField();
		//textField_3.setText("20.12.2018");
		dateTF.setHorizontalAlignment(SwingConstants.CENTER);
		dateTF.setForeground(new Color(0, 0, 128));
		dateTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateTF.setColumns(10);
		dateTF.setBounds(111, 178, 143, 25);
		contentPane.add(dateTF);
		
		timeTF = new JTextField();
		//textField_4.setText("19:00");
		timeTF.setHorizontalAlignment(SwingConstants.CENTER);
		timeTF.setForeground(new Color(0, 0, 128));
		timeTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timeTF.setColumns(10);
		timeTF.setBounds(110, 218, 143, 25);
		contentPane.add(timeTF);
		
		placeTF = new JTextField();
		//textField_5.setText("\u0423\u043B. \u0425\u0440\u0435\u0449\u0430\u0442\u0438\u043A, 14");
		placeTF.setHorizontalAlignment(SwingConstants.CENTER);
		placeTF.setForeground(new Color(0, 0, 128));
		placeTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		placeTF.setColumns(10);
		placeTF.setBounds(111, 254, 143, 25);
		contentPane.add(placeTF);
		
		JButton button = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		button.setBackground(Color.ORANGE);
		button.setBounds(87, 290, 97, 35);
		button.setBorder(new TextBubbleBorder(Color.RED,2,16,0));
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!checkData())
					return;
				if(Main.gamesList.size()==0)
					mf.removeAllPanels();
				
				Game gm;
				try {
					gm = DBHandler.getInstance().insertGame(nameTF.getText(),cityTF.getText(),leagueTF.getText(),new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(dateTF.getText()+" "+timeTF.getText()),placeTF.getText());
				} catch (ParseException e1) {
					AddGame.this.dateTF.setText("");
					AddGame.this.timeTF.setText("");
					return;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					return;
				}
				
				Main.gamesList.add(gm);
				mf.addPanelToScroll(new GameRow(gm,mf));
				
				AddGame.this.dispose();
			}
		});
		
		contentPane.add(button);
		
		setLocationRelativeTo(null);
	}
	
	
	private boolean checkData(){
		if(nameTF.getText().trim() == "" || cityTF.getText().trim() == "" || placeTF.getText().trim() == "" ||
				leagueTF.getText().trim() == "") 
			return false;
		
		return true;
	}
}
