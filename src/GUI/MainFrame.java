package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Logic.Constants;
import Logic.Main;

public class MainFrame extends JFrame {


	private JPanel columnpanel;
	private JPanel borderlaoutpanel;
	private JScrollPane scrollPane;
	
	
	private JPanel contentPane;
	private JLabel label_5;
	private JLabel label_4;
	private JLabel label_3;
	private JLabel label_2;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// Задаем размер
		setSize (new Dimension(Constants.WIDTH_ONE_GAME_PANEL+34, 550));
		//setSize (Constants.size);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 scrollPane = new JScrollPane();
	     scrollPane.setBounds(0, 60, Constants.WIDTH_ONE_GAME_PANEL+18, (Constants.HEIGHT_ONE_GAME_PANEL)*5+8 );
	     scrollPane.getVerticalScrollBar().setUnitIncrement(15);
	     getContentPane().add(scrollPane);

	     borderlaoutpanel = new JPanel();
	     scrollPane.setViewportView(borderlaoutpanel);
	     borderlaoutpanel.setLayout(new BorderLayout(0, 0));
	     
	     columnpanel = new JPanel();
	     borderlaoutpanel.add(columnpanel, BorderLayout.NORTH);
	     columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
	     
	     JLabel label = new JLabel("\u0412\u0441\u0435 \u0438\u0433\u0440\u044B");
	     label.setFont(new Font("Microsoft YaHei", Font.ITALIC, 18));
	     label.setBounds(10, 11, 114, 38);
	     contentPane.add(label);
	     
	     label_5 = new JLabel("\u041C\u0435\u0441\u0442\u043E");
	     label_5.setFont(new Font("Arial", Font.ITALIC, 16));
	     label_5.setBounds(660, 11, 57, 38);
	     contentPane.add(label_5);
	     
	     label_4 = new JLabel("\u0412\u0440\u0435\u043C\u044F");
	     label_4.setFont(new Font("Arial", Font.ITALIC, 16));
	     label_4.setBounds(529, 12, 57, 38);
	     contentPane.add(label_4);
	     
	     label_3 = new JLabel("\u0414\u0430\u0442\u0430");
	     label_3.setFont(new Font("Arial", Font.ITALIC, 16));
	     label_3.setBounds(437, 11, 57, 38);
	     contentPane.add(label_3);
	     
	     label_2 = new JLabel("\u041B\u0438\u0433\u0430");
	     label_2.setFont(new Font("Arial", Font.ITALIC, 16));
	     label_2.setBounds(348, 11, 42, 38);
	     contentPane.add(label_2);
	     
	     label_1 = new JLabel("\u0413\u043E\u0440\u043E\u0434");
	     label_1.setFont(new Font("Arial", Font.ITALIC, 16));
	     label_1.setBounds(258, 12, 57, 38);
	     contentPane.add(label_1);
	     
	     JButton button = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0438\u0433\u0440\u0443");
	     button.setBackground(Color.LIGHT_GRAY);
	     button.setFont(new Font("Tahoma", Font.BOLD, 14));
	     button.setBounds(309, 439, 155, 62);
	     button.setBorder(new TextBubbleBorder(Color.BLACK,2,16,0));
	     button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					AddGame add = new AddGame(MainFrame.this);
					add.setVisible(true);
				}
			});
	     contentPane.add(button);
	     
	     //columnpanel.setBackground(Color.gray);
	     if(Main.gamesList.size()==0){
	    	 JPanel pnl1 = new JPanel();
	    	 //pnl1.setPreferredSize(new Dimension(Constants.WIDTH_ONE_GAME_PANEL+14, (Constants.HEIGHT_ONE_GAME_PANEL)*5));
	    	 JLabel l1 = new JLabel("На текущий момент игры отсутствуют");
	    	 l1.setFont(new Font("Arial", Font.ITALIC, 18));
	    	 pnl1.add(l1);
	    	 
	    	 JPanel pnl2 = new JPanel();
	    	 pnl1.setPreferredSize(new Dimension(Constants.WIDTH_ONE_GAME_PANEL+14, (Constants.HEIGHT_ONE_GAME_PANEL)*2));
	      	 
	    	 columnpanel.add(pnl2);
	      	 columnpanel.add(pnl1);
	     }
	    	 
	     
	     for(int i=0;i<Main.gamesList.size();i++)
	    	 addPanelToScroll(new GameRow(Main.gamesList.get(i),this));
	     
	     
	     setLocationRelativeTo(null);
	}
	
	
	protected void addPanelToScroll(GameRow ps){
		ps.setPreferredSize(new Dimension(Constants.WIDTH_ONE_GAME_PANEL,Constants.HEIGHT_ONE_GAME_PANEL));
        columnpanel.add(ps);
        scrollPane.revalidate();
	}
	
	protected void removePanelFromScroll(int i){
        columnpanel.remove(i);
        columnpanel.repaint();
        scrollPane.revalidate();
	}
	
/*	void changePanelFromScroll(int i,String name2,String t2){
        ((gameRow) columnpanel.getComponent(i)).setTel(t2);
        ((gameRow) columnpanel.getComponent(i)).setN(name2);
        columnpanel.repaint();
        scrollPane.revalidate();
	}*/
	
	protected void removeAllPanels(){
		columnpanel.removeAll();
		columnpanel.revalidate();
	}
}
