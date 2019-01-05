package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AddTeam extends JFrame {

	private JPanel contentPane;
	
	private JTextField nameTF;

	private int selected_level = 1;

	public static void main(String[] args){
		(new AddTeam(1)).setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public AddTeam(int number) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 279);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043A\u043E\u043C\u0430\u043D\u0434\u0443");
		label.setFont(new Font("Tahoma", Font.ITALIC, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(48, 11, 176, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u041D\u043E\u043C\u0435\u0440");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(36, 70, 64, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(36, 106, 64, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u0423\u0440\u043E\u0432\u0435\u043D\u044C");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(36, 142, 64, 25);
		contentPane.add(label_3);
		
		nameTF = new JTextField();
		nameTF.setForeground(new Color(0, 0, 128));
		nameTF.setHorizontalAlignment(SwingConstants.CENTER);
		//textField.setText("\u0422\u0435\u0441\u0442\u043E\u0432\u0430\u044F \u0438\u0433\u0440\u0430 1");
		nameTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTF.setBounds(111, 106, 146, 25);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		
		JButton button = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		button.setBackground(SystemColor.menu);
		button.setBounds(88, 183, 97, 35);
		button.setBorder(new TextBubbleBorder(Color.RED,2,16,0));
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddTeam.this.dispose();
			}
		});
		
		contentPane.add(button);
		
		JLabel label_4 = new JLabel(""+number);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(149, 70, 47, 25);
		contentPane.add(label_4);
		
		JLabel greenLvl = new JLabel("");
		JLabel yelowLvl = new JLabel("");
		JLabel redLvl = new JLabel("");
		
		greenLvl.setOpaque(true);
		greenLvl.setForeground(Color.GREEN);
		//greenLvl.setBorder(new LineBorder(new Color(0, 0, 0)));
		greenLvl.setBackground(Color.GREEN);
		greenLvl.setBounds(121, 149, 19, 18);
		greenLvl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				greenLvl.setBorder(new LineBorder(new Color(0, 0, 0)));
				yelowLvl.setBorder(null);
				redLvl.setBorder(null);
				selected_level = 0;
			}
		});
		contentPane.add(greenLvl);
		
		
		yelowLvl.setOpaque(true);
		yelowLvl.setBorder(new LineBorder(new Color(0, 0, 0)));
		yelowLvl.setBackground(Color.YELLOW);
		yelowLvl.setBounds(166, 149, 19, 18);
		yelowLvl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				yelowLvl.setBorder(new LineBorder(new Color(0, 0, 0)));
				greenLvl.setBorder(null);
				redLvl.setBorder(null);
				selected_level = 1;
			}
		});
		contentPane.add(yelowLvl);
		
		
		redLvl.setOpaque(true);
		//redLvl.setBorder(new LineBorder(new Color(0, 0, 0)));
		redLvl.setBackground(Color.RED);
		redLvl.setBounds(209, 149, 19, 18);
		redLvl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				redLvl.setBorder(new LineBorder(new Color(0, 0, 0)));
				greenLvl.setBorder(null);
				yelowLvl.setBorder(null);
				selected_level = 2;
			}
		});
		contentPane.add(redLvl);
		
		setLocationRelativeTo(null);
	}
	
}
