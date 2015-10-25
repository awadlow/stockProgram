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


public class StockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	
	StockLogic stock = new StockLogic();   //Declare StockLogic Variable for manipulation
	
	public StockGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblStockFinder = new JLabel("Stock Finder");
		lblStockFinder.setFont(new Font("Algerian", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStockFinder = new GridBagConstraints();
		gbc_lblStockFinder.insets = new Insets(0, 0, 5, 5);
		gbc_lblStockFinder.gridx = 9;
		gbc_lblStockFinder.gridy = 0;
		contentPane.add(lblStockFinder, gbc_lblStockFinder);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 9;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblStockinfo = new JLabel("StockInfo");
		GridBagConstraints gbc_lblStockinfo = new GridBagConstraints();
		gbc_lblStockinfo.insets = new Insets(0, 0, 0, 5);
		gbc_lblStockinfo.gridx = 9;
		gbc_lblStockinfo.gridy = 12;
		contentPane.add(lblStockinfo, gbc_lblStockinfo);
		
		JButton btnFindStock = new JButton("Find Stock!");
		btnFindStock.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblStockinfo.setText(stock.getStockQuote(textField.getText()));	
			}
		});
		GridBagConstraints gbc_btnFindStock = new GridBagConstraints();
		gbc_btnFindStock.insets = new Insets(0, 0, 5, 5);
		gbc_btnFindStock.gridx = 9;
		gbc_btnFindStock.gridy = 11;
		contentPane.add(btnFindStock, gbc_btnFindStock);
		
	}

}
