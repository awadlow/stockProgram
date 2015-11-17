// 		EGR327 Project
// 		StockTermsPanel.java
//		Created 11/3/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//

package stock;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSlider;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class StockTermsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StockTermsPanel() {
		setBackground(SystemColor.activeCaption);
		setForeground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblStockTerms = new JLabel("Stock Terms");
		lblStockTerms.setFont(new Font("Rockwell", Font.BOLD, 35));
		lblStockTerms.setBounds(251, 0, 235, 77);
		add(lblStockTerms);
		
		JLabel lblNewLabel = new JLabel("EPS - (earnings per share) The amount a company makes per each share it has.");
		lblNewLabel.setBounds(34, 79, 600, 20);
		add(lblNewLabel);

	}
}
