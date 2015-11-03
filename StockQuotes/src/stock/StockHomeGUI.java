// 		EGR327 Project
// 		StockGUI.java
//		Created 10/22/15	ARW
//		This class is used to display the User Interface for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		10/25/15	Austin Wadlow		Separated Logic and GUI 

package stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StockHomeGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockHomeGUI frame = new StockHomeGUI();
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
	
	Stock stock = new Stock();   //Declare StockLogic Variable for manipulation
	
	public StockHomeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{1, 162, 378, 0};
		gbl_contentPane.rowHeights = new int[]{1, 59, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		JLabel lblStockMarketInfo = new JLabel("Stock Market Info");
		lblStockMarketInfo.setFont(new Font("Stencil", Font.BOLD, 34));
		lblStockMarketInfo.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblStockMarketInfo = new GridBagConstraints();
		gbc_lblStockMarketInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblStockMarketInfo.fill = GridBagConstraints.BOTH;
		gbc_lblStockMarketInfo.gridx = 2;
		gbc_lblStockMarketInfo.gridy = 1;
		contentPane.add(lblStockMarketInfo, gbc_lblStockMarketInfo);
		
		JButton btnFindStockInfo = new JButton("Stock Info");
		GridBagConstraints gbc_btnFindStockInfo = new GridBagConstraints();
		gbc_btnFindStockInfo.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindStockInfo.gridx = 2;
		gbc_btnFindStockInfo.gridy = 3;
		contentPane.add(btnFindStockInfo, gbc_btnFindStockInfo);
		
		JButton btnFindStockTrends = new JButton("Stock Trends");
		GridBagConstraints gbc_btnFindStockTrends = new GridBagConstraints();
		gbc_btnFindStockTrends.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindStockTrends.gridx = 2;
		gbc_btnFindStockTrends.gridy = 4;
		contentPane.add(btnFindStockTrends, gbc_btnFindStockTrends);
		
		JButton btnViewPopularStocks = new JButton("Popular Stocks");
		btnViewPopularStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnViewPopularStocks = new GridBagConstraints();
		gbc_btnViewPopularStocks.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewPopularStocks.gridx = 2;
		gbc_btnViewPopularStocks.gridy = 5;
		contentPane.add(btnViewPopularStocks, gbc_btnViewPopularStocks);
		
		JButton btnStockTerms = new JButton("Stock Terms");
		btnStockTerms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		GridBagConstraints gbc_btnStockTerms = new GridBagConstraints();
		gbc_btnStockTerms.insets = new Insets(0, 0, 5, 0);
		gbc_btnStockTerms.gridx = 2;
		gbc_btnStockTerms.gridy = 6;
		contentPane.add(btnStockTerms, gbc_btnStockTerms);
		
		JButton btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridx = 2;
		gbc_btnExit.gridy = 12;
		contentPane.add(btnExit, gbc_btnExit);
		
	}
}

