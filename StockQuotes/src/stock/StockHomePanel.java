// 		EGR327 Project
// 		StockHomePanel.java
//		Created 11/3/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		11/12/15		ARW				Added functions to check the time when using real time info
package stock;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockHomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StockHomePanel() {
		setBackground(SystemColor.activeCaption);
		
		
		JButton btnStockInfo = new JButton("Stock Info");
		btnStockInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.changeCards("StockInfo");
			}
		});
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblStockInfo = new JLabel("Stock Helper");
		lblStockInfo.setBackground(SystemColor.activeCaption);
		lblStockInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockInfo.setFont(new Font("Rockwell", Font.BOLD, 40));
		add(lblStockInfo);
		btnStockInfo.setBackground(SystemColor.activeCaptionBorder);
		btnStockInfo.setFont(new Font("Rockwell", Font.PLAIN, 25));
		add(btnStockInfo);
		
		JButton btnStockTerms = new JButton("Stock Terms");
		
		btnStockTerms.addMouseListener(new MouseAdapter() {
			@Override										
			public void mouseClicked(MouseEvent e) {  		//When clicked it will navigate to stock terms
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.changeCards("StockTerms");
			}
		});
		
		JButton btnCompareEps = new JButton("Compare EPS");
		btnCompareEps.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.changeCards("StockCompareEps");
			
			}
		});
		btnCompareEps.setBackground(SystemColor.activeCaptionBorder);
		btnCompareEps.setFont(new Font("Rockwell", Font.PLAIN, 25));
		add(btnCompareEps);
		
		JButton btnStockRealTime = new JButton("Stock Real Time");
		btnStockRealTime.setBackground(SystemColor.activeCaptionBorder);
		btnStockRealTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock stock = new Stock();
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				
				if(stock.isTradingHours())
				{
					SGUI.changeCards("StockRealTime");
				}
			}
		});
		btnStockRealTime.setFont(new Font("Rockwell", Font.PLAIN, 25));
		add(btnStockRealTime);
		
		btnStockTerms.setBackground(SystemColor.activeCaptionBorder);
		btnStockTerms.setFont(new Font("Rockwell", Font.PLAIN, 25));
		add(btnStockTerms);
		
		JButton btnExit = new JButton("CLOSE");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.exitProgram();
			}
		});
		btnExit.setBackground(SystemColor.activeCaptionBorder);
		btnExit.setFont(new Font("Rockwell", Font.PLAIN, 25));
		add(btnExit);

	}

}
