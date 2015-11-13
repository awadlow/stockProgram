// 		EGR327 Project
// 		StockLogic.java
//		Created 11/3/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//
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
		btnCompareEps.setBackground(SystemColor.activeCaptionBorder);
		btnCompareEps.setFont(new Font("Rockwell", Font.PLAIN, 25));
		add(btnCompareEps);
		
		btnStockTerms.setBackground(SystemColor.activeCaptionBorder);
		btnStockTerms.setFont(new Font("Rockwell", Font.PLAIN, 25));
		add(btnStockTerms);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(SystemColor.activeCaptionBorder);
		btnExit.setFont(new Font("Rockwell", Font.PLAIN, 25));
		add(btnExit);

	}

}
