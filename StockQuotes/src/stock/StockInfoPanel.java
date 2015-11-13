// 		EGR327 Project
// 		StockLogic.java
//		Created 11/3/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		11/5/15			ARW				Created new JLabel for volume. Changed Jlabel vert. aligns

package stock;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class StockInfoPanel extends JPanel {
	private JTextField symbolTextField;

	/**
	 * Create the panel.
	 */
	public StockInfoPanel() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblStockTerms = new JLabel("Stock Info");
		lblStockTerms.setBounds(261, 0, 158, 42);
		lblStockTerms.setFont(new Font("Rockwell", Font.PLAIN, 35));
		lblStockTerms.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblStockTerms);
		
		JLabel lblPleaseEnterA = new JLabel("Please enter a stock symbol:");
		lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseEnterA.setBounds(29, 89, 231, 20);
		add(lblPleaseEnterA);
		
		symbolTextField = new JTextField();
		symbolTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbolTextField.setBounds(262, 82, 172, 36);
		add(symbolTextField);
		symbolTextField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 139, 601, 2);
		add(separator);
		
		JLabel lblEps = new JLabel("EPS:");
		lblEps.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEps.setBounds(67, 157, 69, 20);
		add(lblEps);
		
		JLabel lblBid = new JLabel("Bid:");
		lblBid.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBid.setBounds(67, 211, 69, 20);
		add(lblBid);
		
		JLabel lblNewLabel = new JLabel("Ask:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(67, 265, 69, 20);
		add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 193, 601, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 247, 601, 2);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 301, 601, 2);
		add(separator_3);
		
		JLabel lblEPSValue = new JLabel("N/A");
		lblEPSValue.setVerticalAlignment(SwingConstants.TOP);
		lblEPSValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEPSValue.setBounds(151, 153, 110, 38);
		add(lblEPSValue);
		
		JLabel lblBidValue = new JLabel("N/A");
		lblBidValue.setVerticalAlignment(SwingConstants.TOP);
		lblBidValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBidValue.setBounds(151, 207, 110, 38);
		add(lblBidValue);
		
		JLabel lblAskValue = new JLabel("N/A");
		lblAskValue.setVerticalAlignment(SwingConstants.TOP);
		lblAskValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAskValue.setBounds(151, 261, 110, 38);
		add(lblAskValue);
		
		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVolume.setBounds(404, 157, 100, 20);
		add(lblVolume);
		
		JLabel lblVolumeValue = new JLabel("N/A");
		lblVolumeValue.setVerticalAlignment(SwingConstants.TOP);
		lblVolumeValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVolumeValue.setBounds(519, 153, 112, 42);
		add(lblVolumeValue);
		
		JLabel lblChange = new JLabel("Change:");
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChange.setBounds(404, 202, 100, 38);
		add(lblChange);
		
		JLabel lblChangeValue = new JLabel("N/A");
		lblChangeValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChangeValue.setBounds(519, 202, 111, 38);
		add(lblChangeValue);

		JLabel lblDivshare = new JLabel("Div/Share:");
		lblDivshare.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDivshare.setBounds(382, 256, 128, 38);
		add(lblDivshare);
		
		JLabel lblDivshareValue = new JLabel("N/A");
		lblDivshareValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDivshareValue.setBounds(520, 256, 111, 38);
		add(lblDivshareValue);

		
		JButton btnGetInfo = new JButton("Get Info!");
		btnGetInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGetInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Stock stock = new Stock();
				stock.parseQuote(symbolTextField.getText());
				lblEPSValue.setText(stock.getEps().toString());
				lblAskValue.setText(stock.getAsk().toString());
				lblBidValue.setText(stock.getBid().toString());
				lblVolumeValue.setText(stock.getVolumeCharacters());
				lblDivshareValue.setText(stock.getDivShare());
				lblChangeValue.setText(stock.getPercentChange());
				
				if(stock.checkPercentChange())
				{
					lblChangeValue.setForeground(Color.GREEN);
				}
				
				else
					lblChangeValue.setForeground(Color.RED);
					
				
			}
			
		});
		btnGetInfo.setBounds(464, 82, 139, 37);
		add(btnGetInfo);

	}
}
