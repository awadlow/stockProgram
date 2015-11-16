// 		EGR327 Project
// 		StockRealTimePanel.java
//		Created 11/12/15	ARW
//		This class is used to show real time stock information
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		11/15/15		ARW				Page now contains labels but the labels are not set yet
//
package stock;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class StockRealTimePanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public StockRealTimePanel() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblRealtimeStockInfo = new JLabel("Real Time Stock Info");
		lblRealtimeStockInfo.setFont(new Font("Rockwell", Font.BOLD, 35));
		lblRealtimeStockInfo.setBounds(171, 0, 361, 75);
		add(lblRealtimeStockInfo);
		
		JLabel label = new JLabel("Please enter a stock symbol:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(25, 91, 231, 20);
		add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(259, 83, 172, 36);
		add(textField);
		
		JButton button = new JButton("Get Info!");
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(456, 83, 139, 37);
		add(button);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 135, 601, 2);
		add(separator);
		
		JLabel label_1 = new JLabel("EPS:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(436, 207, 69, 20);
		add(label_1);
		
		JLabel label_2 = new JLabel("N/A");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setBounds(160, 149, 110, 38);
		add(label_2);
		
		JLabel label_3 = new JLabel("Volume:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_3.setBounds(399, 153, 100, 20);
		add(label_3);
		
		JLabel label_4 = new JLabel("N/A");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_4.setBounds(514, 149, 112, 42);
		add(label_4);
		
		JLabel label_5 = new JLabel("Bid:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_5.setBounds(83, 153, 69, 20);
		add(label_5);
		
		JLabel label_6 = new JLabel("N/A");
		label_6.setVerticalAlignment(SwingConstants.TOP);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_6.setBounds(160, 203, 110, 38);
		add(label_6);
		
		JLabel label_7 = new JLabel("Ask:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_7.setBounds(76, 207, 69, 20);
		add(label_7);
		
		JLabel label_8 = new JLabel("N/A");
		label_8.setVerticalAlignment(SwingConstants.TOP);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_8.setBounds(160, 257, 110, 38);
		add(label_8);
		
		JLabel label_9 = new JLabel("Change:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_9.setBounds(35, 252, 100, 38);
		add(label_9);
		
		JLabel label_10 = new JLabel("N/A");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_10.setBounds(514, 198, 111, 38);
		add(label_10);
		
		JLabel label_11 = new JLabel("Div/Share:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_11.setBounds(377, 252, 128, 38);
		add(label_11);
		
		JLabel label_12 = new JLabel("N/A");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_12.setBounds(515, 252, 111, 38);
		add(label_12);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 189, 601, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(25, 243, 601, 2);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(25, 297, 601, 2);
		add(separator_3);

	}
}
