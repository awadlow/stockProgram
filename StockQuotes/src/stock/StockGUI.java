// 		EGR327 Project
// 		StockGUI.java
//		Created 10/22/15	ARW
//		This class is used to display the User Interface for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		10/25/15	    ARW			Separated Logic and GUI 
//		11/3/15		    ARW			Changed to use cardlayout
//		11/12/15		ARW			Added real time panel to cardlayout			
//
package stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class StockGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockGUI frame = new StockGUI();
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
	public StockGUI(){
		setResizable(false);
		setBounds(new Rectangle(0, 23, 675, 480));
		setPreferredSize(new Dimension(675, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 675, 480);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		StockHomePanel home = new StockHomePanel();
		StockTermsPanel terms = new StockTermsPanel();
		StockInfoPanel info = new StockInfoPanel();
		StockRealTimePanel realTime = new StockRealTimePanel();
		
		contentPane.add(home, "StockHome");
		contentPane.add(terms, "StockTerms");
		contentPane.add(info, "StockInfo");
		contentPane.add(realTime, "StockRealTime");
		
		CardLayout cl = (CardLayout)(contentPane.getLayout());
		cl.show(contentPane, "StockHome");
		
	}
	

		
	


	public void changeCards(String changeJFrame){ //Function used to navigate to different panels

		if (changeJFrame == "StockHome")
		{
			CardLayout cl = (CardLayout)(contentPane.getLayout());
			cl.show(contentPane, "StockHome");
		}
		
		if (changeJFrame == "StockTerms")
		{
			CardLayout cl = (CardLayout)(contentPane.getLayout());
			cl.show(contentPane, "StockTerms");
		}
		
		if (changeJFrame == "StockInfo")
		{
			CardLayout cl = (CardLayout)(contentPane.getLayout());
			cl.show(contentPane, "StockInfo");
		}

		if (changeJFrame == "StockRealTime")
		{
			CardLayout cl = (CardLayout)(contentPane.getLayout());
			cl.show(contentPane, "StockRealTime");
		}


	}

}
