package GUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Logic.Constants;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.SystemColor;

public class CP_teams extends JPanel {

	
	private JPanel columnpanel;
	private JPanel borderlaoutpanel;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	public CP_teams() {
		setBorder(null);
		setBackground(Color.WHITE);
		//16 and 37 - size of outher parts of the JFrame
		setSize(new Dimension(Constants.WIDTH_CONTROL_PANEL-16, Constants.HEIGHT_CONTROL_PANEL - Constants.HEIGHT_CONTROL_PANEL_TOP - 37));
		
		JLabel label = new JLabel("\u041A\u043E\u043C\u0430\u043D\u0434\u044B");
		label.setFont(new Font("Tahoma", Font.ITALIC, 22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("\u0412\u0441\u0435\u0433\u043E: 1");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		
		JButton add_team_btn = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043A\u043E\u043C\u0430\u043D\u0434\u0443");
		add_team_btn.setFont(new Font("Tahoma", Font.ITALIC, 16));
		add_team_btn.setBackground(Color.LIGHT_GRAY);
		add_team_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		add_team_btn.setBorder(new TextBubbleBorder(Color.BLACK,2,16,0));
		
		
		JButton split_into_teams = new JButton("\u0420\u0430\u0437\u0431\u0438\u0442\u044C \u043D\u0430 \u0441\u0431\u043E\u0440\u043D\u044B\u0435");
		split_into_teams.setFont(new Font("Tahoma", Font.ITALIC, 16));
		split_into_teams.setBackground(Color.LIGHT_GRAY);
		split_into_teams.setFont(new Font("Tahoma", Font.BOLD, 14));
		split_into_teams.setBorder(new TextBubbleBorder(Color.BLACK,2,16,0));
		
		JLabel label_2 = new JLabel("\u0421\u0431\u043E\u0440\u043D\u044B\u0435");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 22));
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.menu);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);

		borderlaoutpanel = new JPanel();
		scrollPane.setViewportView(borderlaoutpanel);
		borderlaoutpanel.setLayout(new BorderLayout(0, 0));
	     
		columnpanel = new JPanel();
		borderlaoutpanel.add(columnpanel, BorderLayout.NORTH);
		columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
		addPanelToScroll(new TeamRow(1));
		/*addPanelToScroll(new TeamRow(2));
		addPanelToScroll(new TeamRow(3));
		addPanelToScroll(new TeamRow(4));
		addPanelToScroll(new TeamRow(5));
		addPanelToScroll(new TeamRow(6));
		addPanelToScroll(new TeamRow(7));
		addPanelToScroll(new TeamRow(8));*/
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(176)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(252))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(add_team_btn)
					.addGap(18)
					.addComponent(split_into_teams)
					.addContainerGap(646, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(617, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(181)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(751, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(add_team_btn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(split_into_teams, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(63))
		);
		
		
		
		setLayout(groupLayout);
		
	}
	
	
	protected void addPanelToScroll(TeamRow ps){
		ps.setPreferredSize(new Dimension(Constants.WIDTH_ONE_TEAM_PANEL,Constants.HEIGHT_ONE_TEAM_PANEL));
        columnpanel.add(ps);
        scrollPane.revalidate();
	}
	
	protected void removePanelFromScroll(int i){
        columnpanel.remove(i);
        columnpanel.repaint();
        scrollPane.revalidate();
	}
	
	
	protected void removeAllPanels(){
		columnpanel.removeAll();
		columnpanel.revalidate();
	}
	
}
