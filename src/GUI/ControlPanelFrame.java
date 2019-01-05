package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.Constants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ControlPanelFrame extends JFrame {

	private JPanel contentPane;
	private JButton eventBtn;
	private JButton scenarioBtn;
	private JButton teamBtn;
	private JButton scoreBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanelFrame frame = new ControlPanelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControlPanelFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Constants.WIDTH_CONTROL_PANEL,Constants.HEIGHT_CONTROL_PANEL);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, Constants.WIDTH_CONTROL_PANEL, Constants.HEIGHT_CONTROL_PANEL_TOP);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JButton button = new JButton("\u041D\u0430 \u0433\u043B\u0430\u0432\u043D\u0443\u044E");
		button.setBackground(SystemColor.text);
		button.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		button.setBorder(new TextBubbleBorder(Color.BLACK,2,16,0));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(40)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(906, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(4, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435 \u0438\u0433\u0440\u044B");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		
		eventBtn = new JButton("\u0418\u0432\u0435\u043D\u0442");
		eventBtn.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		eventBtn.setBorder(new TextBubbleBorder(Color.BLACK,2,16,0));
		eventBtn.setBackground(Color.WHITE);
		eventBtn.addActionListener(al);
		
		scenarioBtn = new JButton("\u0421\u0446\u0435\u043D\u0430\u0440\u0438\u0439");
		scenarioBtn.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		scenarioBtn.setBorder(new TextBubbleBorder(Color.BLACK,2,16,0));
		scenarioBtn.setBackground(Color.WHITE);
		scenarioBtn.addActionListener(al);
		
		teamBtn = new JButton("\u041A\u043E\u043C\u0430\u043D\u0434\u044B");
		teamBtn.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		teamBtn.setBorder(new TextBubbleBorder(Color.BLACK,2,16,0));
		teamBtn.setBackground(Color.WHITE);
		teamBtn.addActionListener(al);
		
		scoreBtn = new JButton("\u041F\u043E\u0434\u0441\u0447\u0435\u0442");
		scoreBtn.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		scoreBtn.setBorder(new TextBubbleBorder(Color.BLACK,2,16,0));
		scoreBtn.setBackground(Color.WHITE);
		scoreBtn.addActionListener(al);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
					.addComponent(eventBtn, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scenarioBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(teamBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scoreBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(eventBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(scenarioBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(teamBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(scoreBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel body_panel = new JPanel();
		body_panel.setBackground(Color.WHITE);
		body_panel.setBounds(0, 115, 1084, 567);
		body_panel.setLayout(null);
		
		body_panel.add(new CP_teams());
		
		contentPane.add(body_panel);
		
		
		setLocationRelativeTo(null);
	}
	
	ActionListener al = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			eventBtn.setBackground(Color.WHITE);
			scenarioBtn.setBackground(Color.WHITE);
			teamBtn.setBackground(Color.WHITE);
			scoreBtn.setBackground(Color.WHITE);
			
			((JButton) e.getSource()).setBackground(Color.LIGHT_GRAY);;
		}
	};
}
