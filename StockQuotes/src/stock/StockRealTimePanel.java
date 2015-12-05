// 		EGR327 Project
// 		StockRealTimePanel.java
//		Created 11/12/15	ARW
//		This class is used to show real time stock information
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		11/15/15		ARW				Page now contains labels but the labels are not set yet
//		12/5/15			ARW				Set some of the labels (Still needs work)
//

package stock;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StockRealTimePanel extends JPanel {
	private JTextField symbolTextField;

	/**
	 * Create the panel.
	 */
	public StockRealTimePanel() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblRealtimeStockInfo = new JLabel("Real Time Stock Info");
		lblRealtimeStockInfo.setFont(new Font("Rockwell", Font.BOLD, 35));
		lblRealtimeStockInfo.setBounds(147, -16, 361, 75);
		add(lblRealtimeStockInfo);
		
		JLabel label = new JLabel("Please enter a stock symbol:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(25, 91, 231, 20);
		add(label);
		
		symbolTextField = new JTextField();
		symbolTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbolTextField.setColumns(10);
		symbolTextField.setBounds(259, 83, 172, 36);
		add(symbolTextField);
	
	
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 135, 601, 2);
		add(separator);
		
		JLabel lblEps = new JLabel("EPS:");
		lblEps.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEps.setBounds(436, 207, 69, 20);
		add(lblEps);
		
		JLabel lblBidValue = new JLabel("N/A");
		lblBidValue.setVerticalAlignment(SwingConstants.TOP);
		lblBidValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBidValue.setBounds(160, 149, 110, 38);
		add(lblBidValue);
		
		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVolume.setBounds(399, 153, 100, 20);
		add(lblVolume);
		
		JLabel lblVolumeValue = new JLabel("N/A");
		lblVolumeValue.setVerticalAlignment(SwingConstants.TOP);
		lblVolumeValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVolumeValue.setBounds(514, 149, 112, 42);
		add(lblVolumeValue);
		
		JLabel lblBid = new JLabel("Bid:");
		lblBid.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBid.setBounds(83, 153, 69, 20);
		add(lblBid);
		
		JLabel lblAskValue = new JLabel("N/A");
		lblAskValue.setVerticalAlignment(SwingConstants.TOP);
		lblAskValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAskValue.setBounds(160, 203, 110, 38);
		add(lblAskValue);
		
		JLabel lblAsk = new JLabel("Ask:");
		lblAsk.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAsk.setBounds(76, 207, 69, 20);
		add(lblAsk);
		
		JLabel lblChangeValue = new JLabel("N/A");
		lblChangeValue.setVerticalAlignment(SwingConstants.TOP);
		lblChangeValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChangeValue.setBounds(160, 257, 110, 38);
		add(lblChangeValue);
		
		JLabel lblChange = new JLabel("Change:");
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChange.setBounds(35, 252, 100, 38);
		add(lblChange);
		
		JLabel lblEpsValue = new JLabel("N/A");
		lblEpsValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEpsValue.setBounds(514, 198, 111, 38);
		add(lblEpsValue);
		
		JLabel lblDivShare = new JLabel("Div/Share:");
		lblDivShare.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDivShare.setBounds(377, 252, 128, 38);
		add(lblDivShare);
		
		JLabel lblDivShareValue = new JLabel("N/A");
		lblDivShareValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDivShareValue.setBounds(515, 252, 111, 38);
		add(lblDivShareValue);
		
		JLabel lblSymbolNotFound = new JLabel("");
		lblSymbolNotFound.setForeground(Color.RED);
		lblSymbolNotFound.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSymbolNotFound.setBounds(266, 55, 165, 20);
		add(lblSymbolNotFound);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 189, 601, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(25, 243, 601, 2);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(25, 297, 601, 2);
		add(separator_3);
		
		JButton button = new JButton("Get Info!");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stock stock = new Stock();
				if (stock.parseQuote(symbolTextField.getText()) == true)
					{
					symbolTextField.setBackground(Color.WHITE);
					lblSymbolNotFound.setText("");
					lblEpsValue.setText(stock.getEps().toString());
					lblAskValue.setText(stock.getAsk().toString());
					lblBidValue.setText(stock.getBid().toString());
					lblVolumeValue.setText(stock.getVolumeCharacters());
					lblDivShareValue.setText(stock.getDivShare());
					lblChangeValue.setText(stock.getPercentChange());
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(456, 83, 139, 37);
		add(button);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.exitProgram();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(25, 373, 163, 42);
		add(btnExit);
		
		JButton btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.changeCards("StockHome");
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBounds(456, 373, 163, 42);
		add(btnHome);

	}
}
