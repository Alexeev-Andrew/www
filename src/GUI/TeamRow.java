package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Logic.Constants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class TeamRow extends JPanel {

	/**
	 * Create the panel.
	 */
	public TeamRow(int number) {
		setBorder(new TextBubbleBorder(Color.cyan,1,16,0));
		setBackground(Color.WHITE);

		setSize(new Dimension(Constants.WIDTH_ONE_TEAM_PANEL, Constants.HEIGHT_ONE_TEAM_PANEL));
		setLayout(null);
		
		JButton button = new JButton("");
		button.setToolTipText("\u0443\u0434\u0430\u043B\u0438\u0442\u044C");
		button.setBackground(new Color(255, 69, 0));
		button.setIcon(new ImageIcon(TeamRow.class.getResource("/res/ic_clear_white_18dp.png")));
		button.setBounds(21, 11, 29, 27);
		button.setBorder(new TextBubbleBorder(Color.BLACK,1,160,0));
		
		add(button);
		
		JButton button_1 = new JButton("");
		button_1.setToolTipText("\u0440\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C\r\n");
		button_1.setIcon(new ImageIcon(TeamRow.class.getResource("/res/ic_mode_edit_white_18dp.png")));
		button_1.setBackground(Color.GREEN);
		button_1.setBounds(60, 11, 29, 27);
		button_1.setBorder(new TextBubbleBorder(Color.BLACK,1,160,0));
		
		
		add(button_1);
		
		JLabel label = new JLabel(""+number);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.ITALIC, 18));
		label.setBounds(110, 11, 29, 27);
		add(label);
		
		JLabel label_1 = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435 \u043A\u043E\u043C\u0430\u043D\u0434\u044B");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(149, 11, 206, 27);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_2.setOpaque(true);
		label_2.setBackground(new Color(255, 255, 0));
		label_2.setBounds(366, 18, 16, 16);
		add(label_2);
		
	}

}
